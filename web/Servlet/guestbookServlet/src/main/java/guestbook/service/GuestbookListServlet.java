package guestbook.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestBookDTO;
import guestbook.dao.GuestBookDAO;

@WebServlet("/GuestbookListServlet")
public class GuestbookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//페이징
		/*
		 		  start  end
		 pg = 1     1     2
		 pg = 2     3     4
		 pg = 3     5     6
		 */
		
		int end = pg * 2;
		int start = end - 1;
		
		//DB
		GuestBookDAO guestBookDAO = GuestBookDAO.getInstance();
		ArrayList<GuestBookDTO> list = guestBookDAO.guestbookList(start, end);
		
		//총글수
		int total = guestBookDAO.total();
		
		//총페이지
		int page = (total + 1) / 2; 
		
		//응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+ "<head>"
				+ "<title>글목록</title>");
		
		out.println("<style>"
				+ ".prewrap {"
				+ "white-space:pre-wrap;"
				+ "}"
				
				+ "#paging {"
				+ "text-decoration: none;"
				+ "color: black;"
				+ "border: 1px solid;"
				+ "width: 20px;"
				+ "height: 20px;"
				+ "float:left;"
				+ "margin-left:5px;"
				+ "text-align: center;"
				+ "padding: 2px;"
				+ "}"
				
				+ "#currentPaging {"
				+ "text-decoration: none;"
				+ "border: 1px solid;"
				+ "width: 20px;"
				+ "height: 20px;"
				+ "float:left;"
				+ "margin-left:5px;"
				+ "text-align: center;"
				+ "padding: 2px;"
				+ "color: salmon;"
				+ "}"
				
				+ "</style>"
				+ "</head>"
				+ "<boby>");
		if(list != null) {
			for(GuestBookDTO guestBookDTO : list) {
				
				out.println("<table border='1' cellpadding='5' cellspacing='0'>");
				
				out.println("<tr>"
						+ "<th>작성자</th>"
						+ "<td width='150'>" + guestBookDTO.getName() + "</td>"
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
						+ "</tr>"
						+ "</table>"
						+ "<hr style='border:solid 1px blue; width:460; text-align:left; margin-left:0;'>");
			}
			for (int i = 1; i <= page; i++) {
				if(i == pg) {
					out.println("<div><a id='currentPaging' href='http://192.168.0.32:8080/guestbookServlet/GuestbookListServlet?pg=" + i + "'>" + i + "</a></div>");
				}
				else {
					out.println("<div><a id='paging' href='http://192.168.0.32:8080/guestbookServlet/GuestbookListServlet?pg=" + i + "'>" + i + "</a></div>");
				}
			}
			out.println("<br>");
		}
		out.println("</boby>"
				+ "</html>");
	}

}
