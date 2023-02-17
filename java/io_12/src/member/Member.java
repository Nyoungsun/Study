package member;

import java.io.IOException;
import java.util.List;

public interface Member {
    void execute(List<MemberDTO> memberDTOs) throws IOException;
}

// 추상 클래스로 만들게 되면 다른 클래스 1개만 상속받을 수 있음
// 그러므로 인터페이스로 한다.
