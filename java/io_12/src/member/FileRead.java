package member;

import java.io.*;
import java.util.List;

public class FileRead implements Member {
    @Override
    public void execute(List<MemberDTO> memberDTOs) throws IOException {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("member.txt"));

            System.out.println("이름\t\t나이\t\tPhone\t\tAddress");
            int i;
            for (i = 0; i < memberDTOs.size(); i++) {
                MemberDTO data = (MemberDTO) objectInputStream.readObject();
                System.out.printf("%s\t%d\t\t%s\t%s\n",
                        data.getName(),
                        data.getAge(),
                        data.getPhone(),
                        data.getAddress());
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}