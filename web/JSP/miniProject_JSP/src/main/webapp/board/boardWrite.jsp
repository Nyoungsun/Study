<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="board.bean.BoardDTO"%>
<%@ page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
String name = (String) session.getAttribute("name");
String id = (String) session.getAttribute("id");
String email = (String) session.getAttribute("email");

request.setCharacterEncoding("UTF-8");
String subject = request.getParameter("subject");
String content = request.getParameter("content");

Map<String, String> map = new HashMap<>();
map.put("name", name);
map.put("id", id);
map.put("email", email);
map.put("subject", subject);
map.put("content", content);

BoardDAO boardDAO = BoardDAO.getInstance();
int count = boardDAO.boardWrite(map);
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
	if (<%=count%> != 0) {
		window.onload = function() {
			alert("작성되었습니다.");
			location.href = './boardList.jsp?pg=1';
		}
	}
</script>
</html>