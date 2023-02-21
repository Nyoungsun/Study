package member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Phone implements Member {

    String phone;

    @Override
    public void execute(List<MemberDTO> memberDTOs) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Phone: ");
        phone = bufferedReader.readLine().replace("-", "");

        int toggle = 0;
        for (MemberDTO data : memberDTOs) {
            if (phone.equals(data.getPhone())) {
                toggle = 1;
                System.out.printf("%s\t\t%s\t\t%s\t\t%s\n", "이름", "나이", "Phone", "Address");
                System.out.println(data);
            }
        }
        if (toggle == 0) {
            System.out.println("회원정보가 없거나 핸드폰 번호가 틀렸습니다.");
        }
    }
}
