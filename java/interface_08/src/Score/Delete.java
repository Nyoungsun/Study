package Score;

import java.util.ArrayList;
import java.util.Scanner;

public class Delete implements Score {
    String name;

    @Override
    public void execute(ArrayList<ScoreDTO> scoreDTOS) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("이름 입력: ");
        name = scanner.next();

        int i;
        for (i = 0; i < scoreDTOS.size(); i++) {
            if (name.equals(scoreDTOS.get(i).getName())) {
                scoreDTOS.remove(i);
                System.out.println("삭제 완료");
            }
        }
        if (i == scoreDTOS.size()) {
            System.out.println("회원 정보가 없습니다.");
        }
    }
}
