package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String color = request.getParameter("color"); 
		String[] hobby = request.getParameterValues("hobby");
		String[] subject = request.getParameterValues("subject");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("<ul>");

		out.println("<li> 이름: " + name +"</li>");

		out.println("<li>");
		out.println("성별: ");
		if (gender.equals("0")) {
			out.println("남자");
		}

		else {
			out.println("여자");
		}
		out.println("</li>");

		out.println("<li>");
		out.println("색깔: ");
		switch (color) {
		case "red":
			out.println("<span style='color:red'>빨강</span>");
			break;
		case "green":
			out.println("<span style='color:green'>초록</span>");
			break;
		case "blue":
			out.println("<span style='color:blue'>파랑</span>");
			break;
		case "magenta":
			out.println("<span style='color:magenta'>보라</span>");
			break;
		case "cyan":
			out.println("<span style='color:cyan'>하늘</span>");
			break;
		}
		out.println("</li>");

		out.println("<li>");
		out.println("취미: ");
		for (String hobby_data : hobby) {
			out.println(hobby_data);
		}
		out.println("</li>");

		out.println("<li>");
		out.println("과목: ");
		for (String subject_data : subject) {
			out.println(subject_data);
		}
		out.println("</li>");

		out.println("</ul>");

		out.println("</body>");
		out.println("</html>");

	}

	public void destroy() {
	}

}