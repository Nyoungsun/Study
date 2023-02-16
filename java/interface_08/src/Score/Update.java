package Score;

import java.util.ArrayList;
import java.util.Scanner;

public class Update implements Score {

    @Override
    public void execute(ArrayList<ScoreDTO> scoreDTOs) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("번호 입력: ");
        int number = scanner.nextInt();

//        for (int i=0; i < scoreDTOs.size(); i++){
//            if (number != scoreDTOs.get(i).getNumber()){
//
//            }
//        }
        int toggle = 0;
        for (ScoreDTO data : scoreDTOs) {
            if (number == data.getNumber()) {
                toggle = 1;

                System.out.println(data);

                System.out.print("수정할 이름 입력: ");
                String changeName = scanner.next();
                System.out.print("수정할 국어 입력: ");
                int changeKor = scanner.nextInt();
                System.out.print("수정할 영어 입력: ");
                int changeEng = scanner.nextInt();
                System.out.print("수정할 수학 입력: ");
                int changeMath = scanner.nextInt();

                data.setName(changeName);
                data.setKor(changeKor);
                data.setEng(changeEng);
                data.setMath(changeMath);
                data.calc();
//                scoreDTOs.get(i).setName(changeName);
//                scoreDTOs.get(i).setKor(changeKor);
//                scoreDTOs.get(i).setEng(changeEng);
//                scoreDTOs.get(i).setMath(changeMath);
//                scoreDTOs.get(i).calc();

                System.out.println();
                System.out.println("수정 완료");
                System.out.println();
            }
        }
        if (toggle == 0) {
            System.out.println("없는 번호입니다.");
        }
    }
}
