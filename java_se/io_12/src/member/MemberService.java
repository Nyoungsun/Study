package member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MemberService {

    public void menu() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<MemberDTO> memberDTOs = new ArrayList<>();
        Member member;
        int menu;

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println(" 1. 등록");
            System.out.println(" 2. 출력");
            System.out.println(" 3. 핸드폰 검색");
            System.out.println(" 4. 이름 오름차순");
            System.out.println(" 5. 파일 저장");
            System.out.println(" 6. 파일 읽기");
            System.out.println(" 7. 종료");
            System.out.println("================");
            System.out.print("SELECT NUMBER: ");
            menu = Integer.parseInt(bufferedReader.readLine());
            System.out.println();
            if (menu == 7) {
                System.out.println("종료합니다.");
                break;
            } else if (menu == 1) {
                member = new Insert();
            } else if (menu == 2) {
                member = new Print();
            } else if (menu == 3) {
                member = new Phone();
            } else if (menu == 4) {
                member = new Sort();
            } else if (menu == 5) {
                member = new FileSave();
            } else if (menu == 6) {
                member = new FileRead();
            } else {
                System.out.println("다시 입력하세요");
                continue;
            }
            member.execute(memberDTOs);
        } //while
    }
}
