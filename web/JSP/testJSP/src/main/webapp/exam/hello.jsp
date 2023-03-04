<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <!-- 디렉티브 -->
    
<!-- Java -->
<%! //선언문 - 전역 
int age = 25;
String name = "홍길동"; 
%>

<% //스크립트릿 - 지역
age++;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>
<body>
<!-- Hello JSP --> 
<br>
<%-- 동도로동동 --%>
<br>
<%--  나의 이름은 <%=name %>입니다. --%>
<% out.println("나의 이름은 " + name + "입니다."); %>
<!-- 나는 <%=age %>살 입니다. --> <!-- 브라우저에선 안보이지만 내부에서 수행됨 -->
<br>
</body>
</html>