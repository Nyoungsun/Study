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
div {
	color: red;
	font-weight: bold;
	font-size: 12px;
}
</style>
<body>
		<img src="../img/duck.png" width='50' height='50'
			onclick="location.href='../index.jsp'" style="cursor: pointer;">
		<h3>글</h3>
		<table border="1" cellpadding="5" cellspacing="0">
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" size="45" value=<%=subject%> readonly>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" cols="50" rows="15" readonly ><%=content%></textarea>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" name="write" value="목록"
				onclick="location.href='./boardList.jsp?pg=1'"> 
			</tr>
		</table>
	</form>
</body>
</html>