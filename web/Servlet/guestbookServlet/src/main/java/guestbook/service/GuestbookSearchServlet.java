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
		request.setCharacterEncoding("UTF-8");
		
		String seq = request.getParameter("seq");
		
		GuestBookDAO guestBookDAO = GuestBookDAO.getInstance();
		GuestBookDTO dto = guestBookDAO.guestbookRead(seq);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>글목록</title></head><boby>");
		out.println("<table border='1' cellpadding='5' cellspacing='0'>");
		out.println("<tr>"
				+ "<th>작성자</th>"
				+ "<td width='80'>" + dto.getName() + "</td>"
				+ "<th>작성일</th>"
				+ "<td>" + dto.getLogtime() + "</td>"
				+ "</tr>");
		out.println("<tr>"
				+ "<th>이메일</th>"
				+ "<td colspan = '3'>" + dto.getEmail() + "</td>"
				+ "</tr>");
		out.println("<tr>"
				+ "<th>홈페이지</th>"
				+ "<td colspan = '3'>" + dto.getHomepage() + "</td>"
				+ "</tr>");
		out.println("<tr>"
				+ "<th>제목</th>"
				+ "<td colspan = '3'>" + dto.getSubject() + "</td>"
				+ "</tr>");
		out.println("<tr>"
				+ "<td colspan = '4' width='200' height='200'>"
				+ "<div style=\"overflow-y:scroll; width:100%; height:100%;\">" + dto.getContent() // 역슬래쉬 더블 쿼트 두번
				+ "</div></td></tr>");
		out.println("</table></boby></html>");
	}

}
