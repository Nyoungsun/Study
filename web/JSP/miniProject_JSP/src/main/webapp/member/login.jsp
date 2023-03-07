<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("login_id").trim();
String pw = request.getParameter("login_pw").trim();

MemberDAO memberDAO = MemberDAO.getInstance();

MemberDTO dto = memberDAO.memberRead(id);
String name = dto.getName();
String email = dto.getEmail1() + "@" + dto.getEmail2();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<%
	if (dto == null || !(dto.getId().equals(id)) || !(dto.getPw().equals(pw))) {
		response.sendRedirect("loginFail.jsp");
	} else {
		//세션
		session.setAttribute("name", name);
		session.setAttribute("id", id);
		session.setAttribute("email", email);
		
		//페이지 이동
		response.sendRedirect("loginOk.jsp");
	}
	%>
</body>
</html>