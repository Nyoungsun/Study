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

		String name = request.getParameter("name").trim();
		String id = request.getParameter("id").trim();
		String pw = request.getParameter("pw").trim();
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1").trim();
		String email2 = request.getParameter("email2").trim();
		String tell1 = request.getParameter("tell1");
		String tell2 = request.getParameter("tell2").trim();
		String tell3 = request.getParameter("tell3").trim();
		String zipcode = request.getParameter("zipcode");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		memberDTO.setName(name);
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		memberDTO.setGender(gender);
		memberDTO.setEmail1(email1);
		memberDTO.setEmail2(email2);
		memberDTO.setTell1(tell1);
		memberDTO.setTell2(tell2);
		memberDTO.setTell3(tell3);
		memberDTO.setPost(zipcode);
		memberDTO.setAddr1(addr1);
		memberDTO.setAddr2(addr2);
		
		// DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		int count = (int) memberDAO.memberWrite(memberDTO);

		// 응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>" + "<body>");
		if (count == 0) {
			out.println("<h3>회원가입 실패</h3>");
			out.println("<input type='button' value='뒤로' onclick='history.go(-1)'>");
		} else {
			out.println("<h3>회원가입 성공</h3>");
			out.println("<input type='button' value='로그인' onclick=location.href='http://192.168.0.32:8080/memberServlet/member/login.html'>");
		}
		out.println("</body>" + "</html>");
	}
}
