<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
<title>게시판</title>
</head>
<style>
div {
color:red;
font-weight: bold;
font-size: 12px;
}</style>
<body>
	<form name="boardWriteForm" method="post" action="boardWrite.jsp">
		<img src="../img/duck.png" width='50' height='50' onclick="location.href='../index.jsp'" style="cursor: pointer;">
		<h3>글쓰기</h3>
		<table border="1" cellpadding="5" cellspacing="0">
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" size="45">
					<div id="subjectCheck"></div>
					</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" cols="50" rows="15"></textarea>
					<div id="contentCheck"></div>
					</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" name="write" value="글쓰기" onClick="check()"> 
				<input type="reset" name="write" value="다시작성"></td>
			</tr>
		</table>
	</form>
</body>
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