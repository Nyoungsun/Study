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
</head>
<style>

#prewrap {
white-space:pre-wrap;
}

</style>
<body>
		<img src="../img/duck.png" width='50' height='50'
			onclick="location.href='../index.jsp'" style="cursor: pointer;">
		<h3>글</h3>
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>제목</th>
				<td width='400' style="word-break:break-all"><%=subject%></td>
			</tr>
			<tr>
				<th>내용</th>
				<td height='200'>
				<div id='prewrap' style="word-break:break-all; overflow-y:scroll; width:100%; height:100%;"><%=content%>
				</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" name="write" value="목록" onclick='history.go(-1)'> 
			</tr>
		</table>
</body>
</html>