<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign in</title>

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
	<h1>
		로그인에 실패하였습니다. <br> 다시 로그인해주세요.
	</h1>
	<input type='button' value='다시 로그인' onclick='history.go(-1)'>
</body>
</html>