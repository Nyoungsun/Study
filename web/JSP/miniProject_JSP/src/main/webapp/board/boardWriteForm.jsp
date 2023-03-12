<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String name = (String) session.getAttribute("name");
String id = (String) session.getAttribute("id");
String email = (String) session.getAttribute("email");

session.setAttribute("name", name);
session.setAttribute("id", id);
session.setAttribute("email", email);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Writing</title>
<link rel="stylesheet" href="../css/logoStyle.css">
<link rel="stylesheet" href="../css/boardWriteStyle.css">
</head>
<body>

	<div class="wrap" onclick="location.href='../index.jsp'">
		<div class="menu">LET'S HAVE SOME FUN THIS MOMENT</div>
		<div class="container">
			<div class="menu-mask">LET'S HAVE SOME FUN THIS MOMENT</div>
		</div>
	</div>

	<form name="boardWriteForm" method="post" action="boardWrite.jsp">
		<table cellpadding="5" cellspacing="0">
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" size="45">
					<div id="subjectCheck"></div></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" cols="50" rows="15"></textarea>
					<div id="contentCheck"></div></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button"
					name="write" value="글쓰기" onClick="check()"> <input
					type="reset" name="write" value="다시작성"></td>
			</tr>
		</table>
	</form>
</body>

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

<script>
	function check() {
		document.getElementById("subjectCheck").innerText = "";
		document.getElementById("contentCheck").innerText = "";

		if (document.boardWriteForm.subject.value == "") {
			document.getElementById("subjectCheck").innerText = "제목을 입력하세요.";
			document.boardWriteForm.subject.focus();
		} else if (document.boardWriteForm.content.value == "") {
			document.getElementById("contentCheck").innerText = "내용을 입력하세요.";
			document.boardWriteForm.content.focus();
		} else {
			document.boardWriteForm.submit();
		}
	}
</script>
</html>