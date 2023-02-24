package com.calc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int x = Integer.parseInt(request.getParameter("x")); // name 옵션 값을 가져옴
		int y = Integer.parseInt(request.getParameter("y"));
		
		// response
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>\n"
				+ "<body>\n"
				+ "<h3>");
		out.println(x + " + " + y + " = " + (x + y) + "<br>");
		out.println(x + " - " + y + " = " + (x - y) + "<br>");
		out.println(x + " * " + y + " = " + (x * y) + "<br>");
		out.println(x + " / " + y + " = " + ((double) x / y) + "<br>\n<br>");
		out.println("<input type='button' value='뒤로' onclick = 'history.go(-1)'> &nbsp" 
				+ "<input type='button' value='새롭게' onclick = location.href='http://localhost:8080/testServlet/calc/input.html'> &nbsp"
				+ "<input type='button' value='연령제한' onclick = location.href='http://localhost:8080/testServlet/param.html'>");
		out.println("</body>\n"
				+ "</html>\n"
				+ "</h3>");

	}

}
