<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
int seq = Integer.parseInt(request.getParameter("seq"));

BoardDAO boardDAO = BoardDAO.getInstance();
BoardDTO dto = boardDAO.boardList(seq);

String subject = dto.getSubject();
String content = dto.getContent();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="../css/logoStyle.css">
<link rel="stylesheet" href="../css/boardViewStyle.css">

</head>
<body>
	<div class="wrap" onclick="location.href='../index.jsp'">
		<div class="menu">LET'S HAVE SOME FUN THIS MOMENT</div>
		<div class="container">
			<div class="menu-mask">LET'S HAVE SOME FUN THIS MOMENT</div>
		</div>
	</div>

	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th>제목</th>
			<td width='400' style="word-break: break-all"><%=subject%></td>
		</tr>
		<tr>
			<th>내용</th>
			<td height='200'>
				<div id='prewrap'
					style="word-break: break-all; overflow-y: scroll; width: 100%; height: 100%;"><%=content%>
				</div>
			</td>
		</tr>
	</table>
	<div id="center">
	<input type="button" name="write" value="목록" onclick='history.go(-1)'>
	</div>

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