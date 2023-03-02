package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			if (resultset != null) {
				resultset.close();
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

	public GuestBookDTO guestbookRead(String seq) {
		getConnection();

		GuestBookDTO guestBookDTO = null;
		String sql = "select * from guestbook where seq = ?";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(seq));

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				guestBookDTO = new GuestBookDTO();
				guestBookDTO.setName(resultSet.getString("name"));
				guestBookDTO.setLogtime(resultSet.getString("logtime"));
				guestBookDTO.setEmail(resultSet.getString("email"));
				guestBookDTO.setSubject(resultSet.getString("subject"));
				guestBookDTO.setContent(resultSet.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			GuestBookDAO.close(connection, preparedStatement, resultSet);
		}
		return guestBookDTO;

	}

	public ArrayList<GuestBookDTO> guestbookList(int start, int end) {
		getConnection();

		ArrayList<GuestBookDTO> list = new ArrayList<>();
		String sql = "SELECT * FROM(SELECT ROWNUM RN, AA.*"
					+ "FROM (SELECT * FROM GUESTBOOK ORDER BY SEQ DESC) AA)"
					+ "WHERE RN BETWEEN ? AND ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, start);
			preparedStatement.setInt(2, end);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				GuestBookDTO guestBookDTO = new GuestBookDTO();
				guestBookDTO.setName(resultSet.getString("name"));
				guestBookDTO.setLogtime(resultSet.getString("logtime"));
				guestBookDTO.setEmail(resultSet.getString("email"));
				guestBookDTO.setHomepage(resultSet.getString("homepage"));
				guestBookDTO.setSubject(resultSet.getString("subject"));
				guestBookDTO.setContent(resultSet.getString("content"));
				list.add(guestBookDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} finally {
			GuestBookDAO.close(connection, preparedStatement, resultSet);
		}
		return list;
	}

	public int total() {
		getConnection();

		int total = 0;
		String sql = "select count(*)total from guestbook";

		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			resultSet.next();
			total = resultSet.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			GuestBookDAO.close(connection, preparedStatement, resultSet);
		}
		return total;
	}
}
