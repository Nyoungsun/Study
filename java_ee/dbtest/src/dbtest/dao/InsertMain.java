package dbtest.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class InsertMain {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String user = "c##java";
    private String password = "oracle";

    public InsertMain() { // driver
        try {
            Class.forName(driver); // pull query name -> package name까지
            System.out.println("jdbc driver load");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        connection();
    }

    public void connection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("connection");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("이름 입력: ");
        String name = bufferedReader.readLine();
        System.out.print("나이 입력: ");
        int age = Integer.parseInt(bufferedReader.readLine());
        System.out.print("키 입력: ");
        double height = Double.parseDouble(bufferedReader.readLine());
        try {
            String sql = "insert into dbtest values (?, ?, ?, sysdate)"; // 웹 보안
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setDouble(3, height);

            int count = preparedStatement.executeUpdate(); // 행 개수 반환
            System.out.println(count + "개의 행이 삽입되었습니다.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InsertMain insertMain = new InsertMain();
        insertMain.insert();
    }
}