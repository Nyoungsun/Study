package collection;

import java.util.*;

public class PersonSort {
    public static void main(String[] args) {
        String[] array = {"d", "f", "e", "a", "c", "b", "af", "ab"};

        System.out.print("정렬 전: ");
        for (String data : array) {
            System.out.print(data);
        }
        System.out.println();

        Arrays.sort(array);
        System.out.print("정렬 후: ");
        for (String data : array) {
            System.out.print(data);
        }
        System.out.println();
        System.out.println();

        PersonDTO personDTO = new PersonDTO("홍길동", 25);
        PersonDTO personDTO2 = new PersonDTO("김길동", 40);
        PersonDTO personDTO3 = new PersonDTO("박길동", 35);

        ArrayList<PersonDTO> arrayList = new ArrayList<>();
        arrayList.add(personDTO);
        arrayList.add(personDTO2);
        arrayList.add(personDTO3);

        System.out.println("정렬 전: ");
        for (PersonDTO data : arrayList) {
            System.out.println(data);
        }
        System.out.println();

        Collections.sort(arrayList);
        System.out.println("나이 오름차순: ");
        for (PersonDTO data : arrayList) {
            System.out.println(data);
        }
        System.out.println();

        Comparator<PersonDTO> comparator = new Comparator<>() { // Generic 지정
            @Override
            public int compare(PersonDTO dto1, PersonDTO dto2) {
                return dto2.getName().compareTo(dto1.getName()); // 내림차순
//                dto1.getName().compareTo(dto2.getName()) * -1; // 내림차순
//                dto1.getName().compareTo(dto2.getName()); // 오름차순
            }
        };

        Collections.sort(arrayList, comparator); // 위에서 구현한 comparator를 기준으로 정렬
        System.out.println("이름 내림차순: ");
        for (PersonDTO data : arrayList) {
            System.out.println(data);
        }
        System.out.println();

        // Comparator, Comparable 인터페이스: 객체 정렬
        // A < B: -1, A == B: 0, A > B: 1


    }
}
