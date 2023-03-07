<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String name = (String) session.getAttribute("name");
String id = (String) session.getAttribute("id");
String email = (String) session.getAttribute("email");

request.setCharacterEncoding("UTF-8");
String subject = request.getParameter("subject");
String content = request.getParameter("content");

BoardDTO boardDTO = new BoardDTO();
boardDTO.setName(name);
boardDTO.setId(id);
boardDTO.setEmail(email);
boardDTO.setSubject(subject);
boardDTO.setContent(content);

BoardDAO boardDAO = BoardDAO.getInstance();
int count = boardDAO.boardWrite(boardDTO);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
</body>
<script>
	if (!<%=count%>== 0) {
		window.onload = function() {
			alert("작성되었습니다.");
			location.href = '../index.jsp';
		}
	}
</script>
</html>