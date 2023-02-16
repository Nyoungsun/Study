package Score;

import java.util.ArrayList;
import java.util.Scanner;

public class Insert implements Score {

    @Override
    public void execute(ArrayList<ScoreDTO> scoreDTOs) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("번호 입력: ");
        int number = scanner.nextInt();
        System.out.print("이름 입력: ");
        String name = scanner.next();
        System.out.print("국어 입력: ");
        int kor = scanner.nextInt();
        System.out.print("영어 입력: ");
        int eng = scanner.nextInt();
        System.out.print("수학 입력: ");
        int math = scanner.nextInt();

        ScoreDTO scoreDTO = new ScoreDTO(number, name, kor, eng, math); // 생성할 때 마다 다른 주소로 생성하여 참조
        scoreDTO.calc();

        scoreDTOs.add(scoreDTO); // 주소를 저장

        System.out.println();
        System.out.println("입력 완료");
        System.out.println();
    }
}
