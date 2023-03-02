package guestbook.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestBookDTO;
import guestbook.dao.GuestBookDAO;


@WebServlet("/GuestbookSearchServlet")
public class GuestbookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터
		request.setCharacterEncoding("UTF-8");
		
		String seq = request.getParameter("seq");
		
		//DB
		GuestBookDAO guestBookDAO = GuestBookDAO.getInstance(); //싱글톤 패턴
		GuestBookDTO guestBookDTO = guestBookDAO.guestbookRead(seq);
		
		//응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>"
				+ "<head>"
				+ "<title>글목록</title>"
				+ "<style>"
				+ ".prewrap {"
				+ "white-space:pre-wrap;"
				+ "}"
				+ "</style>"
				+ "</head>"
				+ "<boby>");
		if(guestBookDTO == null) {
			out.println("<h3>글이 없습니다.</h3>");
		} 
		else {
		out.println("<table border='1' cellpadding='5' cellspacing='0'>");
		out.println("<tr>"
				+ "<th>작성자</th>"
				+ "<td width='100'>" + guestBookDTO.getName() + "</td>"
				+ "<th>작성일</th>"
				+ "<td>" + guestBookDTO.getLogtime() + "</td>"
				+ "</tr>");
		out.println("<tr>"
				+ "<th>이메일</th>"
				+ "<td colspan = '3'>" + guestBookDTO.getEmail() + "</td>"
				+ "</tr>");
		out.println("<tr>"
				+ "<th>홈페이지</th>"
				+ "<td colspan = '3'>" + guestBookDTO.getHomepage() + "</td>"
				+ "</tr>");
		out.println("<tr>"
				+ "<th>제목</th>"
				+ "<td colspan = '3'>" + guestBookDTO.getSubject() + "</td>"
				+ "</tr>");
		out.println("<tr>"
				+ "<td colspan = '4' width='200' height='200'>"
				+ "<div class='prewrap' style=\"overflow-y:scroll; width:100%; height:100%;\">"
				+ guestBookDTO.getContent() // 역슬래쉬 더블 쿼트 두번
				+ "</div>"
				+ "</td>"
				+ "</tr>");
		}
		out.println("</table>"
				+ "</boby>"
				+ "</html>");
	}
}
