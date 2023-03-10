package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import board.bean.BoardDTO;

public class BoardDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private DataSource dataSource;
	
	// Context.xml에서 Connection Pool 설정했으므로 
    // 직접 JDBC 연동 X
	
	private static BoardDAO boardDAO = new BoardDAO();

	public static BoardDAO getInstance() {
		return boardDAO;
	}

	public BoardDAO() { 
		try {
			Context context = new InitialContext(); // 인터페이스이므로 직접 접근 불가
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); //서버가 톰캣일 경우 'java:comp/env/' 필수
			// Object를 반환하므로 캐스팅 필요
		} catch (NamingException e) {
			e.printStackTrace();
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

	public int boardWrite(Map<String, String> map) {

		int count = 0;

		String sql = "insert into board(seq, id, name, email, subject, content, ref)"
				+ "values(seq_board.nextval, ?, ?, ?, ? ,? ,seq_board.currval)";
		try {
			connection = dataSource.getConnection();
			
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
	
	public ArrayList<BoardDTO> boardList(Map<String, Integer> map) {
		

		ArrayList<BoardDTO> list = new ArrayList<>();
		String sql = "select * from "
					+ "(select rownum rn, A.* "
					+ "from (select * from board order by ref desc, step asc) A) "
					+ "where rn between ? and ?";
		try {
			connection = dataSource.getConnection();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, map.get("start"));
			preparedStatement.setInt(2, map.get("end"));
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
	
	public BoardDTO boardList(int seq) {
		
		BoardDTO dto = null;

		try {
			connection = dataSource.getConnection();
			
			String sql = "select * from board where seq = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, seq);
			
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				dto = new BoardDTO();
				dto.setSubject(resultSet.getString("subject"));
				dto.setContent(resultSet.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BoardDAO.close(connection, preparedStatement, resultSet);
		}
		return dto;
	}
	
	public int totalArticle() {

		int totalArticle = 0;
		String sql = "select count(*)total from board";

		try {
			connection = dataSource.getConnection();
			
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			resultSet.next();
			totalArticle = resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BoardDAO.close(connection, preparedStatement, resultSet);
		}
		return totalArticle;
	}
}
