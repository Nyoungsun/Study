package member;

import java.util.ArrayList;

public class Print implements Member {
    @Override
    public void execute(ArrayList<MemberDTO> memberDTOs) {
        System.out.printf("%s\t\t%s\t\t%s\t\t%s\n", "이름", "나이", "Phone", "Address");
//        for (MemberDTO data : memberDTOs) {
//            System.out.printf("%s\t%d\t\t%s\t%s\n",
//                    data.getName(),
//                    data.getAge(),
//                    data.getPhone(),
//                    data.getAddress());
//            System.out.println();
//        }
        for (MemberDTO data : memberDTOs) {
            System.out.println(data);
        }
    }
}
