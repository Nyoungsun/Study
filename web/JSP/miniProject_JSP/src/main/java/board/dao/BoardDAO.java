package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import board.bean.BoardDTO;

public class BoardDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##java";
	private String password = "oracle";

	private static BoardDAO boardDAO = new BoardDAO();

	public static BoardDAO getInstance() {
		return boardDAO;
	}

	public BoardDAO() { 
		try {
			Class.forName(driver); 
			System.out.println("jdbc driver load");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	private static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultset) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			} // !=null, 제대로 실행되었으면
			if (connection != null) {
				connection.close();
			}
			if (resultset != null) {
				resultset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void close(Connection connection, PreparedStatement preparedStatement) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			} // !=null, 제대로 실행되었으면
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void getConnection() {
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("connection");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int boardWrite(Map<String, String> map) {
		getConnection();

		int count = 0;

		String sql = "insert into board(seq, id, name, email, subject, content, ref)"
				+ "values(seq_board.nextval, ?, ?, ?, ? ,? ,seq_board.currval)";
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, map.get("name"));
			preparedStatement.setString(2, map.get("id"));
			preparedStatement.setString(3, map.get("email"));
			preparedStatement.setString(4, map.get("subject"));
			preparedStatement.setString(5, map.get("content"));

			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BoardDAO.close(connection, preparedStatement);
		}
		return count;
	}
	
	public ArrayList<BoardDTO> boardList(int start, int end) {
		getConnection();

		ArrayList<BoardDTO> list = new ArrayList<>();
		String sql = "select * from"
					+"(select rownum rn, A.*"
					+ "from (select * from board order by ref desc, step asc) A)"
					+ "where rn between ? and ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, start);
			preparedStatement.setInt(2, end);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setSeq(resultSet.getInt("seq"));
				boardDTO.setId(resultSet.getString("id"));
				boardDTO.setName(resultSet.getString("name"));
				boardDTO.setEmail(resultSet.getString("email"));
				boardDTO.setSubject(resultSet.getString("subject"));
				boardDTO.setContent(resultSet.getString("content"));
				
				boardDTO.setRef(resultSet.getString("ref"));
				boardDTO.setLev(resultSet.getString("lev"));
				boardDTO.setStep(resultSet.getString("step"));
				boardDTO.setPseq(resultSet.getString("pseq"));
				boardDTO.setReply(resultSet.getString("reply"));
				
				boardDTO.setHit(resultSet.getString("hit"));
				boardDTO.setLogtime(resultSet.getDate("logtime"));
				list.add(boardDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} finally {
			BoardDAO.close(connection, preparedStatement, resultSet);
		}
		return list;
	}
	
	public int total() {
		getConnection();

		int total = 0;
		String sql = "select count(*)total from board";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			resultSet.next();
			total = resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BoardDAO.close(connection, preparedStatement, resultSet);
		}
		return total;
	}
}
