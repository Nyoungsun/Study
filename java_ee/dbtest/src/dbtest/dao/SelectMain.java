package dbtest.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;

public class SelectMain {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet; // 테이블 형태로 데이터를 가져온다.
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String user = "c##java";
    private String password = "oracle";

    public SelectMain() { // driver
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

    public void select() throws IOException, SQLException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String sql = "select * from dbtest";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery(); // 테이블처럼 결과 반환

        while (resultSet.next()) {
            System.out.print(resultSet.getString("name") + "\t"
                    + resultSet.getInt("age") + "\t"
                    + resultSet.getDouble("Height") + "\t"
                    + resultSet.getString("logtime") + "\n");
        }
        if (resultSet != null) {
            resultSet.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws SQLException, IOException {
        SelectMain selectMainMain = new SelectMain();
        selectMainMain.select();
    }
}

/*

 */