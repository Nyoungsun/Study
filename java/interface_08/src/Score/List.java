package Score;

import java.util.ArrayList;

public class List implements Score {
    @Override
    public void execute(ArrayList<ScoreDTO> scoreDTOS) {

        System.out.printf("%s %6s %5s %5s %5s %5s %6s\n",
                "번호", "이름", "국어", "영어", "수학", "총점", "평균");

//        for (int i = 0; i < scoreDTOS.size(); i++) { // ArrayList의 크기: size()
////            System.out.println(scoreDTOS.get(i)); // 주소값:
//            System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%f\t\n",
//                    scoreDTOS.get(i).getNumber(),
//                    scoreDTOS.get(i).getName(),
//                    scoreDTOS.get(i).getKor(),
//                    scoreDTOS.get(i).getEng(),
//                    scoreDTOS.get(i).getMath(),
//                    scoreDTOS.get(i).getTotal(),
//                    scoreDTOS.get(i).getAvg());
//        }

        for (ScoreDTO dto : scoreDTOS) {
            System.out.printf("%3d %6s %6d %6d %6d %7d %8.2f\n",
                    dto.getNumber(),
                    dto.getName(),
                    dto.getKor(),
                    dto.getEng(),
                    dto.getMath(),
                    dto.getTotal(),
                    dto.getAvg());
        }

//        for (ScoreDTO dto : scoreDTOS) {
//            System.out.print(dto);// toString()이 생략되어있어 @클래스명16진수로 출력될 수 있게 함 -> override하여 format 변경
//        }
    }
}