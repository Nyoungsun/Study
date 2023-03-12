<%@ page import="member.bean.MemberDTO"%>
<%@ page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String id = (String) session.getAttribute("id");
String pw = request.getParameter("pw");
boolean exist = false;

if (pw != null) {
	MemberDAO memberDAO = MemberDAO.getInstance();
	exist = memberDAO.isexistPw(id, pw); 
}

if (exist) {
	response.sendRedirect("delete.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Withdrawal</title>
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
	font-size: 20px;
}

form {
	margin-top: 300px;
	text-align: center;
}

input[type="password"] {
	color: #1B2021;
	font-size: 20px;
	padding: 10px;
	font-family: Pretendard-Regular;
	border: 1px solid #e0e0e0;
	color: #1B2021;
	margin-left: 10px;
}

input[type="button"] {
	margin: auto;
	cursor: pointer;
	background: #1B2021;
	font-size: 20px;
	color: #fff;
	border: solid 1px;
	font-family: Pretendard-Regular;
	padding: 10px;
	cursor: pointer;
}

input[type="button"]:hover {
	background: #fff;
	color: #1B2021;
	transition: all 0.3s ease;
}

 #check_pw {
	color: red;
	font-size: 14px;
	margin-top: 3px;

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

	<form name="deleteForm" method="post" action="./delete.jsp">
		<div style="text-align: center;">
			비밀번호: <input type="password" id="pw" name="pw">
			 <input type="button" value="입력" onClick="check()">
			 <div id="check_pw">
				<%
				if (pw != null && !exist) {
				%>
				비밀번호가 맞지 않습니다.
				<%
				}
				%>
			</div>
		</div>
	</form>
	<script>
	function check() {
		document.getElementById("check_pw").value == "";

		if (document.getElementById("pw").value == "") {
			document.getElementById("check_pw").innerText = "비밀번호를 입력하세요.";
		} else {
			document.deleteForm.submit();
		}
	}
	</script>

	<script src='https://cdnjs.cloudflare.com/ajax/libs/gsap/3.5.1/gsap.min.js'></script>
	<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>
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
