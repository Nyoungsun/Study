<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign in</title>
<link rel="stylesheet" href="../css/loginStyle.css">
</head>
<body>

<div class="wrap" onclick="location.href='../index.jsp'">
		<div class="menu">LET'S HAVE SOME FUN THIS MOMENT</div>
		<div class="container">
			<div class="menu-mask">LET'S HAVE SOME FUN THIS MOMENT</div>
		</div>
	</div>
	
	<form name="loginform" method="post" action="login.jsp">
		<table cellpadding="7">
			<tr>
				<th>ID</th>
				<td><input type="text" id="login_id" name="login_id"
					placeholder="아이디 입력">
					<div id=id_check></div></td>
				</td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" id="login_pw" name="login_pw"
					placeholder="비밀번호 입력">
					<div id=pw_check></div></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="로그인" onClick="check_login()">
			</tr>
		</table>
	</form>
	<script>
	<!-- type="text/javascript" 생략가능 -->
		const form = document.loginform;

		function check_login() {
			document.getElementById("id_check").innerText = ""
			document.getElementById("pw_check").innerText = ""

			if (form.login_id.value == "") {
				document.getElementById("id_check").innerText = "아이디를 입력하세요."
				document.getElementById("login_id").focus();
			} else if (form.login_pw.value == "") {
				document.getElementById("pw_check").innerText = "비밀번호를 입력하세요."
				document.getElementById("login_pw").focus();
			} else {
				form.submit();
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