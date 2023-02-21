package collection;

public class PersonDTO implements Comparable<PersonDTO> { // PersonDTO 객체 타입을 정렬하기 위해
    private String name;
    private int age;

    public PersonDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return getName() + "," + getAge();
    }

    @Override
    public int compareTo(PersonDTO personDTO) {
        // age를 기준으로 오름차순
        if (this.age < personDTO.age) {
            return -1;
        } else if (this.age > personDTO.age) {
            return 1;
        } else {
            return 0;
        }
    }
}
