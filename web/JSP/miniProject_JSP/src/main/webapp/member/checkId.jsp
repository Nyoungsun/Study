<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");

MemberDAO memberDAO = MemberDAO.getInstance();
boolean existId = memberDAO.isexistId(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중복체크</title>
</head>
<body>
	<%
	if (existId) {
	%>
	<form action="checkId.jsp">
		<%=id %> 사용불가 <br><br> 아이디 다시 입력 <br> 
		<input type="text" name="id">&nbsp;<input type="submit" value="중복체크">
	</form>
	<%
	} else {
	%>
	<%=id %> 사용가능
	<input type="button" value="사용하기" onclick="checkIdClose('<%=id%>')">
	<%
	}
	%>
	
	<script type="text/javascript">
	function checkIdClose(id) {
		opener.writeForm.idCheck.value= "1";
		opener.writeForm.id.value = id;
		window.close();
		opener.writeForm.pw.focus();
	}</script>
</body>
</html>