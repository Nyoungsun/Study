package member;

import java.io.Serializable;

public class MemberDTO implements Serializable {
    private String name, phone, address;

    private int age;

    public MemberDTO(String name, int age, String phone, String address) {
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

