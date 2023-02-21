package member;

import java.io.Serializable;

public class MemberDTO implements Serializable{ // Comparable 주의점: Comparable을 사용하지 않았을 때 만든 파일을
                                                // Comparable을 사용한 뒤, 파일을 읽어들이면 VersionException이 발생하므로 Comparable을 사용한 후
                                                // 파일을 재생성하여 그 파일을 사용해야한다.
    private String name, phone, address;

    private int age;

    public MemberDTO(String name, int age, String phone, String address) { // 1명의 데이터
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name + "\t" + age + "\t\t" + phone + "\t" + address;
    }
}

