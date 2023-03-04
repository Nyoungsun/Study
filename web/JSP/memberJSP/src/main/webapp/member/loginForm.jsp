<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
        div {
            font-size: 10px;
            color: red;
            font-weight: bold;
        }
    </style>
</head>

<body>
<h1>로그인</h1>
<br>
<form name="loginform" method="post" action="http://192.168.0.32:8080/memberJSP/member/login.jsp">
	<table border="1" cellpadding="7" cellspacing="0">
		<tr>
			<th>로그인</th>
			<td><input type="text" id="login_id" name="login_id"
				placeholder="아이디 입력">
				<div id = id_check></div>
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" id="login_pw" name="login_pw"
				placeholder="비밀번호 입력">
				<div id = pw_check></div>
			</td>
		</tr>
		<tr>
			<td colspan ="2" align="center">
			<input type="button" value="로그인" onClick = "check_login()"> 
			<input type="button" value="회원가입" onClick = "location.href='http://192.168.0.32:8080/memberServlet/member/writeForm.html'">
			</td>
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
		}
		else if (form.login_pw.value == "") {
			document.getElementById("pw_check").innerText = "비밀번호를 입력하세요."
		}
		else {
			form.submit();
		}
	}
	</script> 
</body>
</html>