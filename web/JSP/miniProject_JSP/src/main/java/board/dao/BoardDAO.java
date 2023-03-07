package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.bean.BoardDTO;
import member.bean.MemberDTO;

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

	public int boardWrite(BoardDTO boardDTO) {
		getConnection();

		int count = 0;

		String sql = "insert into board(seq, id, name, email, subject, content, ref)"
				+ "values(seq_board.nextval, ?, ?, ?, ? ,? ,0)";
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, boardDTO.getId());
			preparedStatement.setString(2, boardDTO.getName());
			preparedStatement.setString(3, boardDTO.getEmail());
			preparedStatement.setString(4, boardDTO.getSubject());
			preparedStatement.setString(5, boardDTO.getContent());

			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BoardDAO.close(connection, preparedStatement);
		}
		return count;
	}
}
