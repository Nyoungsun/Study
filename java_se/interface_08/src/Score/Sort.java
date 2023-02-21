package Score;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Sort implements Score {

    @Override
    public void execute(ArrayList<ScoreDTO> scoreDTOs) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("*******************");
            System.out.println(" 1. 총점으로 내림차순");
            System.out.println(" 2. 이름으로 오름차순");
            System.out.println(" 3. 이전 메뉴");
            System.out.println("*******************");
            System.out.print("SELECT NUMBER: ");
            int number = scanner.nextInt();

            Comparator<ScoreDTO> comparator;

            if (number == 3) {
                System.out.println();
                return;
            } else if (number == 1) { // 총점으로 내림차순
                comparator = new Comparator<>() {
                    @Override
                    public int compare(ScoreDTO dto1, ScoreDTO dto2) {
                        if (dto1.getTotal() > dto2.getTotal()) {
                            return -1;
                        } else if (dto1.getTotal() < dto2.getTotal()) {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                };
            } else if (number == 2) { // 이름으로 오름차순
                comparator = new Comparator<>() {
                    @Override
                    public int compare(ScoreDTO dto1, ScoreDTO dto2) {
                        return dto1.getName().compareTo(dto2.getName());
                    }
                };
            } else {
                System.out.println("다시 입력하세요.");
                System.out.println();
                continue;
            }
            Collections.sort(scoreDTOs, comparator);

            List list = new List();
            list.execute(scoreDTOs);
        }
    }
}
