package collection;

import java.util.ArrayList;

public class PersonMain {

    public ArrayList<PersonDTO> init() {
        PersonDTO personDTO = new PersonDTO("홍길동", 15);
        PersonDTO personDTO2 = new PersonDTO("렁뎡더", 22);
        PersonDTO personDTO3 = new PersonDTO("러어동", 40);

        ArrayList<PersonDTO> arrayList = new ArrayList<>();
        arrayList.add(personDTO);
        arrayList.add(personDTO2);
        arrayList.add(personDTO3);

        return arrayList;
    }

    public static void main(String[] args) {
        PersonMain personMain = new PersonMain();
        for (PersonDTO personDTOs : personMain.init()) {
            System.out.println(personDTOs.getName() + ", " + personDTOs.getAge());
        }
//        for (int i = 0; i < personMain.init().size(); i++) {
//            System.out.println(personMain.init().get(i).getName() + ", " + personMain.init().get(i).getAge());
//        }
//        for (PersonDTO personDTOs : personMain.init()) {
//            System.out.println(personDTOs);
//        }
    }
}
