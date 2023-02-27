package com.param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// data
		String name = request.getParameter("name"); // name 옵션 값을 가져옴
		int age = Integer.parseInt(request.getParameter("age"));
		// response
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(
				"<html>\n" + 
				"<body>\n");
		out.println("나의 이름은" + name + "이고 " + age + "살 이므로");
		if (age >= 20) {
			out.println("청소년입니다.");
		} else {
			out.println("성인입니다.");
		}
		out.println(
				"</body>\n" +
				"</html>");
	}
}
