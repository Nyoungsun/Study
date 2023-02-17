package member;

import java.util.ArrayList;
import java.util.List;

public class Print implements Member {
    @Override
    public void execute(List<MemberDTO> memberDTOs) {
        System.out.println("이름\t\t나이\t\tPhone\t\tAddress");
        for (MemberDTO data : memberDTOs) {
            System.out.println(data);
        }
//        for (MemberDTO data : memberDTOs) {
//            System.out.printf("%s\t%d\t\t%s\t%s\n",
//                    data.getName(),
//                    data.getAge(),
//                    data.getPhone(),
//                    data.getAddress());
//            System.out.println();
//        }

    }
}
