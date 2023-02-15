package Score;

import java.util.ArrayList;
import java.util.Scanner;

public class Update implements Score {
    int number, changeKor, changeEng, changeMath;
    String changeName;

    @Override
    public void execute(ArrayList<ScoreDTO> scoreDTOs) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("번호 입력: ");
        number = scanner.nextInt();

        for (int i = 0; i < scoreDTOs.size(); i++) {
            if (number != scoreDTOs.get(i).getNumber()) {
                System.out.println("없는 번호입니다.");
                System.out.println();
            } else {
                List list = new List();
                list.execute(scoreDTOs);

                System.out.print("수정할 이름 입력: ");
                changeName = scanner.next();
                System.out.print("수정할 국어 입력: ");
                changeKor = scanner.nextInt();
                System.out.print("수정할 영어 입력: ");
                changeEng = scanner.nextInt();
                System.out.print("수정할 수학 입력: ");
                changeMath = scanner.nextInt();

                scoreDTOs.get(i).setName(changeName);
                scoreDTOs.get(i).setKor(changeKor);
                scoreDTOs.get(i).setEng(changeEng);
                scoreDTOs.get(i).setMath(changeMath);
                scoreDTOs.get(i).calc();

                System.out.println();
                System.out.println("수정 완료");
                System.out.println();
            }
        }
    }
}

