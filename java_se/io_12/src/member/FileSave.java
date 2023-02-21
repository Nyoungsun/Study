package member;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileSave implements Member {
    @Override
    public void execute(List<MemberDTO> memberDTOs) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Member.txt"));

        for (MemberDTO data : memberDTOs) {
            objectOutputStream.writeObject(data);
        }
        objectOutputStream.close();
        System.out.println("저장 완료");
    }
}
