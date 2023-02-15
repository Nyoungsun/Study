package Score;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Sort implements Score {
    int number;

    @Override
    public void execute(ArrayList<ScoreDTO> scoreDTOS) {
        Scanner scanner = new Scanner(System.in);
        List list = new List();

        System.out.println("****************");
        System.out.println(" 1. 총점으로 내림차순");
        System.out.println(" 2. 이름으로 오름차순");
        System.out.println(" 3. 이전 메뉴");
        System.out.println("****************");
        System.out.print("SELECT NUMBER: ");
        number = scanner.nextInt();

        if (number == 1) {
            Collections.sort(scoreDTOS);
            list.execute(scoreDTOS);
        } else if (number == 2) {
            Comparator<ScoreDTO> comparator = new Comparator<>() {
                @Override
                public int compare(ScoreDTO dto1, ScoreDTO dto2) {
                    return dto1.getName().compareTo(dto2.getName());
                }
            };
            Collections.sort(scoreDTOS, comparator);
            list.execute(scoreDTOS);
        }
    }
}
