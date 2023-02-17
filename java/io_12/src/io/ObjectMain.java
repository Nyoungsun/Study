package io;

import org.w3c.dom.ls.LSOutput;

import java.io.*;

public class ObjectMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 객체로 묶어서 전달 -> 객체는 파일로 전송이 안됨 -> 객체를 Byte[]로 변환 하여 전송 = 객체 직렬화 Serializable
        PersonDTO personDTO = new PersonDTO("홍길동", 18, 185.2);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Person.txt"));
        objectOutputStream.writeObject(personDTO); // 객체를 Object 형으로 전달
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Person.txt"));
        PersonDTO data = (PersonDTO) objectInputStream.readObject();
        System.out.println(data.getName());
        System.out.println(data.getAge());
        System.out.println(data.getHeight());
    }
}
