package member;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class FileRead implements Member {
    @Override
    public void execute(List<MemberDTO> memberDTOs) throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("member.txt"));
        try {
            System.out.println("이름\t\t나이\t\tPhone\t\tAddress");

            for (int i = 0; i < memberDTOs.size(); i++) {
                MemberDTO data = (MemberDTO) objectInputStream.readObject();
                System.out.printf("%s\t%d\t\t%s\t%s\n",
                        data.getName(),
                        data.getAge(),
                        data.getPhone(),
                        data.getAddress());
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}