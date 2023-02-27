package member.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

@WebServlet("/WriteServlet")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 데이터
		request.setCharacterEncoding("UTF-8"); // post method인 경우에만
		
		MemberDTO memberDTO = new MemberDTO();

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String email_1 = request.getParameter("email_1");
		String email_2 = request.getParameter("email_2");
		String tell_1 = request.getParameter("tell_1");
		String tell_2 = request.getParameter("tell_2");
		String tell_3 = request.getParameter("tell_3");
		String post = request.getParameter("post");
		String addr_1 = request.getParameter("addr_1");
		String addr_2 = request.getParameter("addr_2");
		
		memberDTO.setName(name);
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		memberDTO.setGender(gender);
		memberDTO.setEmail_1(email_1);
		memberDTO.setEmail_2(email_2);
		memberDTO.setTell_1(tell_1);
		memberDTO.setTell_2(tell_2);
		memberDTO.setTell_3(tell_3);
		memberDTO.setPost(post);
		memberDTO.setAddr_1(addr_1);
		memberDTO.setAddr_2(addr_2);
		
		// DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		int count = (int) memberDAO.memberWrite(memberDTO);

		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>" + "<body>");
		if (count == 0) {
			out.println("<h3>회원가입 실패</h3>");
		} else {
			out.println("<h3>회원가입 성공</h3>");
		}
		out.println("</body>" + "</html>");
	}
}
