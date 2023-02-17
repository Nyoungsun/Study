package member;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort implements Member {
    @Override
    public void execute(List<MemberDTO> memberDTOs) {
        Comparator<MemberDTO> comparator = new Comparator<MemberDTO>() {
            @Override
            public int compare(MemberDTO dto1, MemberDTO dto2) {
                return dto1.getName().compareTo(dto2.getName());
            }
        };
        Collections.sort(memberDTOs, comparator);
    }
}
