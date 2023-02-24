package com.hello;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet { // HttpServlet을 상속받아야 서블릿 수행 가능
	private static final long serialVersionUID = 1L;

	public void init() {
		System.out.println("init");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("get");
		response.setContentType("text/html;charset=UTF-8");

//		PrintWriter out = new PrintWriter(new FileWriter("result.txt"));
//		out.println("<HTML>");

		PrintWriter out = response.getWriter();
		out.println(
				"<html>\n" +
				"<body>\n" + 
				"Hello\n" +
				"<br>\n" + 
				"안녕하세요\n" +
				"</body>\n" + 
				"</html>");
	}

	public void destroy() {
		System.out.println("destroy");

	}
}
