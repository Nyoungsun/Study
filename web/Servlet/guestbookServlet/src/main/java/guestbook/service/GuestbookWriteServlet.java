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


@WebServlet("/GuestbookWriteServlet")
public class GuestbookWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//데이터
		request.setCharacterEncoding("UTF-8"); // 한글
		
		GuestBookDTO guestBookDTO = new GuestBookDTO();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String homepage = request.getParameter("homepage");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		guestBookDTO.setName(name);
		guestBookDTO.setEmail(email);
		guestBookDTO.setHomepage(homepage);
		guestBookDTO.setSubject(subject);
		guestBookDTO.setContent(content);
		
		//DB
		GuestBookDAO guestBookDAO =  GuestBookDAO.getInstance();
		guestBookDAO.guestbookWrite(guestBookDTO);
		
		//응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>" + "<body>");
		out.println("<h3>작성 완료</h3>");
		out.println("<input type='button' value='글검색' onClick=location.href='http://192.168.0.32:8080/guestbookServlet/guestbook/guestbookSearch.html'>");
		out.println("<input type='button' value='글목록' onCicnk=location.href='http://192.168.0.32:8080/guestbookServlet/GuestbookListServlet>");
		out.println("</body>" + "</html>");
		
	}

}
