package member;

import java.io.IOException;
import java.util.ArrayList;

public interface Member {
    void execute(ArrayList<MemberDTO> memberDTOs) throws IOException;
}
