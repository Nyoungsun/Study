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
<title>Sign up</title>
<link rel="stylesheet" href="../css/logoStyle.css">
<style type="text/css">
@font-face {
	font-family: 'Pretendard-Regular';
	src:
		url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff')
		format('woff');
	font-weight: 400;
	font-style: normal;
}

body {
	color: #1B2021;
	font-family: Pretendard-Regular;
}

h1 {
	margin-top: 300px;
	text-align: center;
}

input[type="button"] {
	margin: auto;
	display: block; 
	cursor : pointer;
	background: #1B2021;
	font-size: 20px;
	color: #fff;
	border: solid 1px;
	font-family: Pretendard-Regular;
	padding: 10px;
	width: 12.5%;
	cursor: pointer;
}

input[type="button"]:hover {
	background: #fff;
	color: #1B2021;
	transition: all 0.3s ease;
}
</style>
</head>
<body>
	<div class="wrap" onclick="location.href='../index.jsp'">
		<div class="menu">LET'S HAVE SOME FUN THIS MOMENT</div>
		<div class="container">
			<div class="menu-mask">LET'S HAVE SOME FUN THIS MOMENT</div>
		</div>
	</div>
	<%
	if (count == 0) {
	%>
	<h1>회원가입 실패</h1>
	<br>
	<input type='button' value='다시 회원가입하기' onclick='history.go(-1)'>
	<%
	} else {
	%>
	<h1>회원가입 성공</h1>
	<input type='button' value='로그인'
		onClick="location.href='./loginForm.jsp'">
	<%
	}
	%>

	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/gsap/3.5.1/gsap.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
	<script>
	const container = document.querySelector(".container");

	document.body.addEventListener("mousemove", e => {
	  const x = e.clientX;
	  const y = e.clientY - 35;
	  gsap.to(container, {
	    y: y
	  });
	  gsap.to(".menu-mask", {
	    y: -y
	  });
	});
	</script>

</body>
</html>








