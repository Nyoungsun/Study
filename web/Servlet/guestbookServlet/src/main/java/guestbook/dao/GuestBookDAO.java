package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import guestbook.bean.GuestBookDTO;
import guestbook.dao.GuestBookDAO;

public class GuestBookDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##java";
	private String password = "oracle";

	private static GuestBookDAO guestBookDAO = new GuestBookDAO();

	public static GuestBookDAO getInstance() {
		return guestBookDAO;
	}

	public GuestBookDAO() { // driver
		try {
			Class.forName(driver); // pull query name -> package name까지
			System.out.println("jdbc driver load");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
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
	
	private static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultset) {
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

	public void guestbookWrite(GuestBookDTO guestBookDTO) {
		getConnection();

		int count = 0;

		String sql = "insert into guestbook values(seq_guestbook.nextval, ?, ?, ?, ?, ?, sysdate)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, guestBookDTO.getName());
			preparedStatement.setString(2, guestBookDTO.getEmail());
			preparedStatement.setString(3, guestBookDTO.getHomepage());
			preparedStatement.setString(4, guestBookDTO.getSubject());
			preparedStatement.setString(5, guestBookDTO.getContent());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			GuestBookDAO.close(connection, preparedStatement);
		}

	}
}