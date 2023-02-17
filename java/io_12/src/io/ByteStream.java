package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream {
    public static void main(String[] args) {

        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("data.txt"));
            int data;
            while ((data = bufferedInputStream.read()) != -1) {
                System.out.println(data);
            }
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
