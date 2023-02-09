package constructor;

import java.util.*;

public class MemberService_T {
    private MemberDTO[] ar = new MemberDTO[2]; // Object Arr
    // -> 객체 생성이 아닌 배열 생성이므로 객체 생성 절차 필요
    // MemberDTO가 아닌 다른 객체 생성 불가

    public MemberService_T() {
        System.out.println("Default Constructor");
    }

    Scanner scan = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println();
            System.out.println("*************");
            System.out.println("   1. 가입");
            System.out.println("   2. 출력");
            System.out.println("   3. 수정");
            System.out.println("   4. 탈퇴");
            System.out.println("   5. 끝내기");
            System.out.println("*************");
            System.out.print("  번호 :");
            int number = scan.nextInt();

            if (number == 5) {
                break;
            }
            if (number == 1) insertArticle();
            else if (number == 2) list();
            else if (number == 3) update();
            else if (number == 4) delete();

        } // while()
    } // menu()


    public void insertArticle() { // method는 public
        int i;
        for (i = 0; i < ar.length; i++) {
            if (ar[i] == null) {
                break;
            }
        }

        if (i == ar.length) {
            System.out.println(ar.length + "명의 정원이 다 찼습니다.");
            return; // return: 해당 method 탈출
        }
        // i==ar.length: null값을 찾지 못했음
        // insertArticle()로 돌아감


        System.out.println("----------------------");
        System.out.print("이름 입력 : ");
        String name = scan.next();
        System.out.print("나이 입력 : ");
        int age = scan.nextInt();
        System.out.print("핸드폰 입력 : ");
        String phone = scan.next();
        System.out.print("주소 입력 : ");
        String address = scan.next();

        for (i = 0; i < ar.length; i++) {
            if (ar[i] == null) {
                ar[i] = new MemberDTO(name, age, phone, address);
                break;
            }
        } // for

        System.out.println("\n1 row created");

    } // insertArticle


    public void list() {
        System.out.println("이름\t나이\t핸드폰\t주소");
        for (MemberDTO dto : ar) {
            if (dto != null) { // dto.name: private variable에 접근X
                // nullPointexcepiton 방지
                System.out.println(dto.getName() + "\t"
                        + dto.getAge() + "\t"
                        + dto.getPhone() + "\t"
                        + dto.getAddress());
            } // if
        } // for
    } // list


    public void update() {
        int i;

        System.out.print("핸드폰 번호 입력: ");
        String phone = scan.next();

        for (i = 0; i < ar.length; i++) {
            if (ar[i] != null) {
                if (ar[i].getPhone().equals(phone)) {
                    System.out.println(ar[i].getName() + "\t"
                            + ar[i].getAge() + "\t"
                            + ar[i].getPhone() + "\t"
                            + ar[i].getAddress());

                    System.out.println();
                    System.out.print("\n수정 할 이름 입력 : ");
                    String name = scan.next();
                    System.out.print("수정 할 핸드폰 입력 : ");
                    phone = scan.next();
                    System.out.print("수정 할 주소 입력 : ");
                    String address = scan.next();

                    ar[i].setName(name);
                    ar[i].setPhone(phone);
                    ar[i].setAddress(address);

                    System.out.println("1 row(s) updated");

                    break;
                } // if_getPhone

            } // if_null

        } // for

        if (i == ar.length) {
            System.out.println("찾는 회원이 없습니다.");
        }

    } // update


    public void delete() {
        System.out.print("핸드폰 번호 입력: ");
        String phone = scan.next();

        int i;
        for (i = 0; i < ar.length; i++) {
            if (ar[i] != null) {
                if (phone.equals(ar[i].getPhone())) {
                    ar[i] = null;

                    System.out.println("1 row(s) deleted");

                    break;
                } // if_getPhone

            } // if_null

        } // for

        if (i == ar.length) {
            System.out.println("찾는 회원이 없습니다.");
        }

    } // delete

}