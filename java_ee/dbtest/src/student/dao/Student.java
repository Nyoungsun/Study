package student.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Student {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String user = "c##java", password = "oracle";
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    public Student() throws ClassNotFoundException { // driver
        Class.forName(driver); // pull query name -> package name까지
    }

    public void connection() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
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
                break;
            } else if (num == 1) {
                insert();
            } else if (num == 2) {
                select();
            } else if (num == 3) {
                delete();
            }
        }
    }

    public void insert() throws IOException, SQLException {
        connection();

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

        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public void select() throws IOException, SQLException {
        connection();

        System.out.println("****************");
        System.out.println("1. 이름 검색(1개 글자가 포함된 이름 모두 검색)");
        System.out.println("2. 전체 검색");
        System.out.println("3. 이전메뉴");
        System.out.println("****************");
        System.out.print("번호 선택: ");
        int num = Integer.parseInt(bufferedReader.readLine());
        System.out.println();

        String sql;

        if (num == 3) {
            return;
        } else if (num == 1) {
            System.out.print("검색할 이름 입력: ");
            String name = bufferedReader.readLine();
            sql = "select * from info where name like ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");
        } else if (num == 2) {
            sql = "select * from info";
            preparedStatement = connection.prepareStatement(sql);
        }
        resultSet = preparedStatement.executeQuery(); // 테이블처럼 결과 반환

        while (resultSet.next()) {
            System.out.print("이름: " + resultSet.getString("NAME") + "\t");
            if (resultSet.getInt("CODE") == 1) {
                System.out.println("학번: " + resultSet.getString("VALUE"));
            } else if (resultSet.getInt("CODE") == 2) {
                System.out.println("과목: " + resultSet.getString("VALUE"));
            } else {
                System.out.println("부서: " + resultSet.getString("VALUE"));
            }
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }
    }

    public void delete() throws IOException, SQLException {
        connection();

        System.out.print("삭제를 원하는 이름 정확히 입력: ");
        String name = bufferedReader.readLine();

        String sql = "delete from info where name = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);

        int count = preparedStatement.executeUpdate(); // 행 개수 반환
        System.out.println(count + "개의 행이 삭제되었습니다.\n");

        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Student student = new Student();
        student.connection();
        student.menu();
    }
}
