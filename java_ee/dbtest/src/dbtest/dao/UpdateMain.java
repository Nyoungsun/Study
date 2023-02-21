package dbtest.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateMain {
    private PreparedStatement preparedStatement;
    private Connection connection;
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String user = "c##java";
    private String password = "oracle";

    public UpdateMain() { // driver
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

    public void update() throws IOException, SQLException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("검색할 이름 입력: ");
        String name = bufferedReader.readLine();

        String sql = "update dbtest set age = age + 1, height = height + 1 where name like ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "%" + name + "%");

        int count = preparedStatement.executeUpdate(); // 행 개수 반환
        System.out.println(count + "개의 행이 업데이트되었습니다.");

        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws SQLException, IOException {
        UpdateMain updateMain = new UpdateMain();
        updateMain.update();
    }
}

/*

 */