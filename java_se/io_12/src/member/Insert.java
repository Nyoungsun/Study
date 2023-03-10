package member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Insert implements Member {
    String name, phone, address;
    int age;

    @Override
    public void execute(List<MemberDTO> memberDTOs) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("이름: ");
        name = bufferedReader.readLine();
        System.out.print("나이: ");
        age = Integer.parseInt(bufferedReader.readLine());
        System.out.print("Phone: ");
        phone = bufferedReader.readLine().replace("-", "");
        System.out.print("주소: ");
        address = bufferedReader.readLine();

        MemberDTO memberDTO = new MemberDTO(name, age, phone, address);
        memberDTOs.add(memberDTO);

        System.out.println("\n입력 완료\n");
    }
}