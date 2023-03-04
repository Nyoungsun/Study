<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");

String login_id = request.getParameter("login_id").trim();
String login_pw = request.getParameter("login_pw").trim();

MemberDAO memberDAO = MemberDAO.getInstance();
MemberDTO dto = memberDAO.memberRead(login_id, login_pw);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="http://192.168.0.32:8080/memberJSP/member/updateForm.jsp">

	<%
	if (dto == null || !(dto.getId().equals(login_id)) || !(dto.getPw().equals(login_pw))) {
	%>
	<h3>로그인 실패</h3>
	<%
	} else {
	%>
	<h3>로그인 성공</h3>
	<%=dto.getName()%>님 로그인
	<%
	}
	%>
	<input type="hidden" name ="update_id" value="<%=login_id%>">
	<input type="hidden" name ="update_pw" value="<%=login_pw%>">
	<input type="submit" value="회원정보수정">
	</form>
</body>
</html>