package io;

import java.io.*;

public class DataStream {
    public static void main(String[] args) throws IOException { // IOException이 FileNotFoundException의 부모
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("result.txt"));
//        FileOutputStream fileOutputStream = new FileOutputStream("result.txt");
//        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        dataOutputStream.writeUTF("아임헝그리");
        dataOutputStream.writeInt(5);
        dataOutputStream.writeDouble(4.5);
        dataOutputStream.close(); // 반드시 close

//        FileInputStream fileInputStream = new FileInputStream("result.txt");
//        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("result.txt"));
        String data = dataInputStream.readUTF();
        int dataInt = dataInputStream.readInt();
        double dataDouble = dataInputStream.readDouble();

        System.out.println(data);
        System.out.println(dataInt);
        System.out.println(dataDouble);
        dataInputStream.close();
    }
}