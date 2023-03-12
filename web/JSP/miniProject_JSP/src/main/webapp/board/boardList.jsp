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
<title>Board</title>
<link rel="stylesheet" href="../css/boardListStyle.css">
<link rel="stylesheet" href="../css/logoStyle.css">
<style>


</style>
<!-- id: #, class: . -->
</head>
<body>

<div class="wrap" onclick="location.href='../index.jsp'">
		<div class="menu">LET'S HAVE SOME FUN THIS MOMENT</div>
		<div class="container">
			<div class="menu-mask">LET'S HAVE SOME FUN THIS MOMENT</div>
		</div>
	</div>
	
	<table border="1" cellpadding="5" cellspacing="0" frame="hsides" rules="rows">
		<tr>
			<th>글번호</th>
			<th width="1000">제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		<%
		if (list != null) {
		%>
		<%
		for (BoardDTO boardDTO : list) {
		%>
		<tr>
			<td class = "center"><%=boardDTO.getSeq()%></td>
			<td>
			<a onclick="sessionCheck(<%=id%>, <%=boardDTO.getSeq()%>)">
			   <%=boardDTO.getSubject()%></a></td>
			<td class = "center"><%=boardDTO.getName()%></td>
			<td class = "center"><%=boardDTO.getHit()%></td>
			<td class = "center"><%=new SimpleDateFormat("yyyy.MM.dd.").format(boardDTO.getLogtime())%></td>
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
				location.href="../index.jsp"
			} else {
				location.href="./boardView.jsp?seq=" + seq;
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












