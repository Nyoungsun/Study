
package member;

import java.io.*;
import java.util.List;

public class FileRead implements Member {
    @Override
    public void execute(List<MemberDTO> memberDTOs) throws IOException {
        memberDTOs.clear(); // 리스트 값 모두 삭제

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("member.txt"));
            while (true) {
                MemberDTO data = (MemberDTO) objectInputStream.readObject();
                memberDTOs.add(data); // 읽어온 데이터 다시 저장
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EOFException e) { // End Of File.
            System.out.println("읽기 완료");
        }
    }
}
