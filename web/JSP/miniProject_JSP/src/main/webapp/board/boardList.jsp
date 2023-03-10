<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.apache.coyote.http2.Http2AsyncUpgradeHandler"%>
<%@page import="board.bean.BoardPaging"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String id = (String) session.getAttribute("id");

int pg = Integer.parseInt(request.getParameter("pg"));

int end = pg * 5;
int start = end - 4;

Map<String, Integer> map = new HashMap<String, Integer>(); //제너릭에는 클래스타입으로
map.put("start", start);
map.put("end", end);

BoardDAO boardDAO = BoardDAO.getInstance();
ArrayList<BoardDTO> list = boardDAO.boardList(map);

int totalArticle = boardDAO.totalArticle();

BoardPaging boardPaging = new BoardPaging();

boardPaging.setCurrentPage(pg);
boardPaging.setPageBlock(3);
boardPaging.setPageSize(5);
boardPaging.setTotalArticle(totalArticle);
boardPaging.makePaging();

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
	margin: 5px;
	padding: 5px;
	cursor: pointer;
}

#currentPaging {
	text-decoration: none;
	color: salmon;
	border: 1px solid; margin : 5px;
	padding: 5px;
	cursor: pointer;
	margin: 5px;
}

table {
	margin-left: auto;
	margin-right: auto;
}

#pageButton {
	text-align: center;
	margin-top: 20px;
}

</style>
<!-- id: #, class: . -->
</head>
<body>
	<img src="../img/duck.png" width='50' height='50'
		onclick="location.href='../index.jsp'" style="cursor: pointer;">
	
	<table border="1" cellpadding="5" cellspacing="0" frame="hsides" rules="rows">
		<tr>
			<th>글번호</th>
			<th width="250">제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th width="100">작성일</th>
		</tr>
		<%
		if (list != null) {
		%>
		<%
		for (BoardDTO boardDTO : list) {
		%>
		<tr>
			<td align="center"><%=boardDTO.getSeq()%></td>
			<td style="word-break:break-all">
			<a class="subject"
				style="cursor: pointer;"
				onclick="sessionCheck(<%=id%>, <%=boardDTO.getSeq()%>)"><%=boardDTO.getSubject()%></a></td>
			<td align="center"><%=boardDTO.getName()%></td>
			<td align="center"><%=boardDTO.getHit()%></td>
			<td align="center"><%=new SimpleDateFormat("yyyy.MM.dd.").format(boardDTO.getLogtime())%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	%>
	<div id="pageButton">
		<%=boardPaging.getPagingHTML()%>
	</div>
	<script>
		function boardPaging(pg) {
			location.href = "boardList.jsp?pg=" + pg;
		}

		function sessionCheck(id, seq) {
			if (id == null) {
				alert("먼저 로그인하세요.");
			} else {
				location.href="./boardView.jsp?seq=" + seq;
			}
			
		}
	</script>
</body>

</html>












