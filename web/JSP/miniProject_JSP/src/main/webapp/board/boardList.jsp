<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
int pg = Integer.parseInt(request.getParameter("pg"));

int end = pg * 5;
int start = end - 4;

BoardDAO boardDAO = BoardDAO.getInstance();
ArrayList<BoardDTO> list = boardDAO.boardList(start, end);

int total = boardDAO.total();
int pag = (total + 1) / 4; 

/*
         start  end
pg = 1     1     5
pg = 2     6     10
pg = 3     11    15
*/

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
<style>
body {
	background-image: url("../img/cry.jpg");
	background-repeat: no-repeat;
	background-position: right top;
}
.subject:link {
	color: black;
	text-decoration: none;
}

.subject:visited {
	color: black;
	text-decoration: none;
}

.subject:hover {
	color: green;
	text-decoration: underline;
}

.subject:active {
	color: salmon;
}

#paging {
text-decoration: none;
color: black;
border: 1px solid;
width: 20px;
height: 20px;
float:left;
margin-left:5px;
text-align: center;
padding: 2px;
}

#currentPaging {
text-decoration: none;
color: salmon;
border: 1px solid;
width: 20px;
height: 20px;
float:left;
margin-left:5px;
text-align: center;
padding: 2px;
}

#center{
display: table;
margin-left: auto;
margin-right: auto;
}

</style>
<!-- id: #, class: . -->
</head>
<body>
<img src="../img/duck.png" width='50' height='50' onclick="location.href='../index.jsp'" style="cursor: pointer;">
	<div id= 'center'>
	<%if (list != null) {%>
	<table border="1" cellpadding="5" cellspacing="0" frame="hsides" rules="rows">
			<tr>
			<th>글번호</th>
			<th width="200">제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th width="100">작성일</th>
			</tr>
		<%for (BoardDTO boardDTO : list) {%>
			<tr>
			<td align="center"><%=boardDTO.getSeq() %></td>
			<td><a class="subject" href=""><%=boardDTO.getSubject() %></a></td>
			<td align="center"><%=boardDTO.getName() %></td>
			<td align="center"><%=boardDTO.getHit() %></td>
			<td align="center"><%=new SimpleDateFormat("yyyy.MM.dd.").format(boardDTO.getLogtime()) %></td>
			</tr>
		<%}%>
		</table>
		<hr style='border:0px;'>
	<%} %>
	<%for (int i = 1; i <= pag; i++) { %>
		<%if(i == pg) {%>
		<div><a id='currentPaging' href='./boardList.jsp?pg=<%=i%>'><%=i %></a></div>
		<%}else { %>
		<div><a id='paging' href='./boardList.jsp?pg=<%=i%>'><%=i %></a></div>
		<%} %>
	<%}%>
</body>
</html>














