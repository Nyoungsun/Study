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
	
	private static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultset) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			} // !=null, 제대로 실행되었으면
			if (connection != null) {
				connection.close();
			}
			if(resultset != null) {
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
			preparedStatement.setString(5, memberDTO.getEmail1());
			preparedStatement.setString(6, memberDTO.getEmail2());
			preparedStatement.setString(7, memberDTO.getTel1());
			preparedStatement.setString(8, memberDTO.getTel2());
			preparedStatement.setString(9, memberDTO.getTel3());
			preparedStatement.setString(10, memberDTO.getPost());
			preparedStatement.setString(11, memberDTO.getAddr1());
			preparedStatement.setString(12, memberDTO.getAddr2());

			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAO.close(connection, preparedStatement);
		}
		return count;
	}

	public MemberDTO memberRead(String id, String pw) {
		getConnection();
		
		MemberDTO dto = null;

		try {
			String sql = "select * from member where id = ? and pwd = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, pw);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				dto = new MemberDTO();
				dto.setId(resultSet.getString("id"));
				dto.setPw(resultSet.getString("pwd"));
				dto.setName(resultSet.getString("name"));
				dto.setGender(resultSet.getString("gender"));
				dto.setEmail1(resultSet.getString("email1"));
				dto.setEmail2(resultSet.getString("email2"));
				dto.setPost(resultSet.getString("zipcode"));
				dto.setAddr1(resultSet.getString("addr1"));
				dto.setAddr2(resultSet.getString("addr2"));
				dto.setTel1(resultSet.getString("tel1"));
				dto.setTel2(resultSet.getString("tel2"));
				dto.setTel3(resultSet.getString("tel3"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAO.close(connection, preparedStatement, resultSet);
		}
		return dto;

	}
}
