package Score;

import java.util.ArrayList;

public class List implements Score {
    @Override
    public void execute(ArrayList<ScoreDTO> scoreDTOS) {

        System.out.printf("%s\t\t%s\t\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\n",
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

//        for (ScoreDTO data : scoreDTOS) {
//            System.out.printf("%3d %6s %6d %6d %6d %7d %8.2f\n",
//                    data.getNumber(),
//                    data.getName(),
//                    data.getKor(),
//                    data.getEng(),
//                    data.getMath(),
//                    data.getTotal(),
//                    data.getAvg());
//        }

        for (ScoreDTO dto : scoreDTOS) {
            System.out.println(dto);// toString()이 생략되어있어 @클래스명16진수로 출력될 수 있게 함 -> toString()을 override하여 format 변경
        }
        System.out.println();
    }
}
