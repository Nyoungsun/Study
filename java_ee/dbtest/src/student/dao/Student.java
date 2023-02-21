package student.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Student {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String user = "c##java", password = "oracle";

    public Student() { // driver
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

    public void menu() throws IOException, SQLException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("****************");
            System.out.println("관리");
            System.out.println("****************");
            System.out.println("1. 입력");
            System.out.println("2. 검색");
            System.out.println("3. 삭제");
            System.out.println("4. 종료");
            System.out.println("****************");
            System.out.print("번호 선택: ");
            int num = Integer.parseInt(bufferedReader.readLine());
            System.out.println();

            if (num == 4) {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
                break;
            } else if (num == 1) {
                insert();
            }
        }
    }

    public void insert() throws IOException, SQLException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String value = null;

        System.out.println("****************");
        System.out.println("1. 학생");
        System.out.println("2. 교수");
        System.out.println("3. 관리자");
        System.out.println("4. 이전메뉴");
        System.out.println("****************");
        System.out.print("번호 선택: ");
        int num = Integer.parseInt(bufferedReader.readLine());
        System.out.println();

        System.out.print("이름 입력: ");
        String name = bufferedReader.readLine();
        if (num == 4) {
            return;
        } else if (num == 1) {
            System.out.print("학번 입력: ");
            value = bufferedReader.readLine();
        } else if (num == 2) {
            System.out.print("과목 입력: ");
            value = bufferedReader.readLine();
        } else if (num == 3) {
            System.out.print("부서 입력: ");
            value = bufferedReader.readLine();
        }

        String sql = "insert into info values (?, ?, ?)"; // 웹 보안
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, value);
        preparedStatement.setInt(3, num);

        int count = preparedStatement.executeUpdate(); // 행 개수 반환
        System.out.println(count + "개의 행이 삽입되었습니다.\n");
    }

    public static void main(String[] args) throws IOException, SQLException {
        Student student = new Student();
        student.menu();
    }
}
