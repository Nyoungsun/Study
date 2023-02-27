package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.bean.MemberDTO;

public class MemberDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##java";
	private String password = "oracle";

	private static MemberDAO memberDAO = new MemberDAO();

	public static MemberDAO getInstance() {
		return memberDAO;
	}

	public MemberDAO() { // driver
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

	public void getConnection() {
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("connection");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int memberWrite(MemberDTO memberDTO) {
		getConnection();

		int count = 0;

		String sql = "insert into member values(?, ?, ?, ? ,? ,? ,? ,? ,? ,? ,? ,?, sysdate) ";
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, memberDTO.getName());
			preparedStatement.setString(2, memberDTO.getId());
			preparedStatement.setString(3, memberDTO.getPw());
			preparedStatement.setString(4, memberDTO.getGender());
			preparedStatement.setString(5, memberDTO.getEmail_1());
			preparedStatement.setString(6, memberDTO.getEmail_2());
			preparedStatement.setString(7, memberDTO.getTell_1());
			preparedStatement.setString(8, memberDTO.getTell_2());
			preparedStatement.setString(9, memberDTO.getTell_3());
			preparedStatement.setString(10, memberDTO.getPost());
			preparedStatement.setString(11, memberDTO.getAddr_1());
			preparedStatement.setString(12, memberDTO.getAddr_2());

			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAO.close(connection, preparedStatement);
		}
		return count;
	}

	public MemberDTO memberRead(String login_id, String login_pw) {
		getConnection();
		
		MemberDTO dto = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			String sql = "select id, pwd from member where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, login_id);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				dto = new MemberDTO();
				dto.setId(resultSet.getString("id"));
				dto.setPw(resultSet.getString("pwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MemberDAO.close(connection, preparedStatement);
		}
		return dto;

	}
}
