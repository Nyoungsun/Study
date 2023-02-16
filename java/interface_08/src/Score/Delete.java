package Score;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Delete implements Score {

    @Override
    public void execute(ArrayList<ScoreDTO> scoreDTOs) { // 주소를 전달받음
        Scanner scanner = new Scanner(System.in);

        System.out.print("이름 입력: ");
        String name = scanner.next();

        int count = 0;
        Iterator<ScoreDTO> iterator = scoreDTOs.iterator();
        while (iterator.hasNext()) {
            ScoreDTO scoreDTO = iterator.next(); // 항목을 꺼내 버퍼에 임시 저장, scoreDTO에 넣고 다음 인덱스로 이동
            if (scoreDTO.getName().equals(name)) {
                iterator.remove(); // 버퍼에 보관된 내용을 지움(iterator.next()가 반환하는 항목을 지움)
                count++;
            }
        }

//        int i;
//        for (i = 0; i < scoreDTOs.size(); i++) {
//            if (name.equals(scoreDTOs.get(i).getName())) {
//                scoreDTOs.remove(i);
//                i -= 1;
//                count++;
//            }
//        }

        if (count == 0) { // 또는 i == scoreDTO.size()도 가능
            System.out.println("회원 정보가 없습니다.");
            System.out.println();
        } else {
            System.out.println(count + "건 삭제");
        }
    }
}
