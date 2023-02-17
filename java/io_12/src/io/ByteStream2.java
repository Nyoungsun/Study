package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream2 {
    public static void main(String[] args) {
        try {
            File file = new File("data.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));

            int size = (int) file.length();
            System.out.println("파일 크기: " + size);

            byte[] bytes = new byte[size];
            bufferedInputStream.read(bytes, 0, size); // bytes 0번째 부터 size만큼 값 읽어들임
            System.out.println(new String(bytes)); // byte -> String
            bufferedInputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
