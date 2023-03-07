<%@ page import="java.io.PrintWriter"%>
<%@ page import="member.dao.MemberDAO"%>
<%@ page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");
MemberDTO memberDTO = new MemberDTO();

String name = request.getParameter("name").trim();
String id = request.getParameter("id").trim();
String pw = request.getParameter("pw").trim();
String gender = request.getParameter("gender");
String email1 = request.getParameter("email1").trim();
String email2 = request.getParameter("email2").trim();
String tel1 = request.getParameter("tel1");
String tel2 = request.getParameter("tel2").trim();
String tel3 = request.getParameter("tel3").trim();
String zipcode = request.getParameter("zipcode");
String addr1 = request.getParameter("addr1");
String addr2 = request.getParameter("addr2");

memberDTO.setName(name);
memberDTO.setId(id);
memberDTO.setPw(pw);
memberDTO.setGender(gender);
memberDTO.setEmail1(email1);
memberDTO.setEmail2(email2);
memberDTO.setTel1(tel1);
memberDTO.setTel2(tel2);
memberDTO.setTel3(tel3);
memberDTO.setPost(zipcode);
memberDTO.setAddr1(addr1);
memberDTO.setAddr2(addr2);

// DB
MemberDAO memberDAO = MemberDAO.getInstance();
int count = (int) memberDAO.memberWrite(memberDTO);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
</head>
<body>
	<%
	if (count == 0) {
	%>
	<h3>회원가입 실패</h3>
	<br>
	<input type='button' value='뒤로' onclick='history.go(-1)'>
	<%
	} else {
	%>
	<h3>회원가입 성공</h3>
	<input type='button' value='로그인' onClick="location.href='http://192.168.0.32:8080/memberJSP/member/loginForm.jsp'">
	<%
	}
	%>

</body>
</html>








