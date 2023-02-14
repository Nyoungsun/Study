package Score;

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreService {
    private ArrayList<ScoreDTO> scoreDTOs = new ArrayList<ScoreDTO>();  // priavate ScoreDTO scoreDTO = new ScoreDTO[user];

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        Score score;
        int num;

        while (true) {
            System.out.println("===== MENU =====");
            System.out.println(" 1. 입력");
            System.out.println(" 2. 출력");
            System.out.println(" 3. 수정");
            System.out.println(" 4. 삭제");
            System.out.println(" 5. 정렬");
            System.out.println(" 6. 종료");
            System.out.println("================");
            System.out.print("SELECT NUMBER: ");
            num = scanner.nextInt();
            System.out.println();

            if (num == 6) {
                System.out.println("종료합니다.");
                break;
            } else if (num == 1) {
                score = new Insert();           // super : sub
//                Insert insert = new Insert(); // 1 : 1
//                insert.execute();
            } else if (num == 2) {
                score = new List();
            } else if (num == 3) {
                score = new Update();
            } else if (num == 4) {
                score = new Delete();
            } else if (num == 5) {
                score = new Sort();
            } else {
                System.out.println("다시 입력하세요");
                System.out.println();
                continue;
            }
            score.execute(scoreDTOs);
        } //while
    }
}

