package io;

import java.io.*;

public class DataStream {
    public static void main(String[] args) throws IOException { // IOException이 FileNotFoundException의 부모
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("result.txt"));
//        FileOutputStream fileOutputStream = new FileOutputStream("result.txt");
//        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        dataOutputStream.writeUTF("홍길동");
        dataOutputStream.writeInt(5);
        dataOutputStream.writeDouble(4.5);
        dataOutputStream.close(); // 반드시 close

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }
}