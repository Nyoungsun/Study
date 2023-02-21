package constructor;

import java.util.Scanner;

public class MemberService {
    private MemberDTO[] memberDTOs = new MemberDTO[5]; //배열 생성
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("*************");
            System.out.println("1. 가입");
            System.out.println("2. 출력");
            System.out.println("3. 수정");
            System.out.println("4. 탈퇴");
            System.out.println("5. 끝내기");
            System.out.println("*************");
            System.out.print("번호: ");

            int input = scanner.nextInt();
            if (input == 5) {
                break;
            } else if (input == 1) {
                insert();
            } else if (input == 2) {
                list();
            } else if (input == 3) {
                update();
            } else if (input == 4) {
                delete();
            } else {
                System.out.println("다시 입력하세요.");
            }
        }
    } // menu()


    public void insert() {
        int i;
        for (i = 0; i < memberDTOs.length; i++) {
            if (memberDTOs[i] == null) {
                break; // 데이터 입력
            }
        }

        if (i == memberDTOs.length) { // i = 5이면 memberDTOs에 null 값이 없다는 뜻
            System.out.println("5명 정원초과입니다.");
            return;
        }
        System.out.print("이름 입력: ");
        String name = scanner.next();
        System.out.print("나이 입력: ");
        int age = scanner.nextInt();
        System.out.print("핸드폰 입력: ");
        String phone = scanner.next();
        System.out.print("주소 입력: ");
        String address = scanner.next();

        for (i = 0; i < memberDTOs.length; i++) {
            if (memberDTOs[i] == null) {
                memberDTOs[i] = new MemberDTO(name, age, phone, address); // 객체 생성, 객체에는 값이 아니라 주소가 들어있어서 참조됨
                break;
            }
        }
        System.out.println("\n1 row created");
    } // insert()

    public void list() {
        System.out.println("이름\t\t나이\t\t주소\t\tPhone");
        for (MemberDTO data : memberDTOs) {
            if (data != null) {
                System.out.printf("%s\t\t%d\t\t%s\t\t%s",
                        data.getName(),
                        data.getAge(),
                        data.getAddress(),
                        data.getPhone());

                System.out.println();
            }
        }
    } // list()

    public void update() {
        list();
        System.out.print("Phone 입력 :");
        String phone = scanner.next();

        int i;
        for (i = 0; i < memberDTOs.length; i++) {
            if (phone.equals(memberDTOs[i].getPhone()) && memberDTOs[i] != null) {
                System.out.print("변경할 이름 입력: ");
                String name_change = scanner.next();
                memberDTOs[i].setName(name_change);

                System.out.print("변경할 Phone 입력: ");
                String phone_change = scanner.next();
                memberDTOs[i].setPhone(phone_change);

                System.out.print("변경할 주소 입력: ");
                String address_change = scanner.next();
                memberDTOs[i].setAddress(address_change);

                System.out.println("1 row(s) updated");
                list();

                break;
            }
        } //for i
        if (i == memberDTOs.length) { // i == memberDTOs.length이면 배열의 모든 공간에 동일한 전화번호 없음
            System.out.println("일치하는 회원이 없습니다.");
        }
    } //update

    public void delete() {
        System.out.print("Phone 입력: ");
        String phone = scanner.next();

        int i;
        for (i = 0; i < memberDTOs.length; i++) {
            if (phone.equals(memberDTOs[i].getPhone()) && memberDTOs[i] != null) {
                memberDTOs[i] = null;

                System.out.println("1 row(s) deleted");
                list();

                break;
            }
        }
        if (i == memberDTOs.length) {
            System.out.println("일치하는 회원이 없습니다.");
        }
    }
}
