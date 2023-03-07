<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
	<%
	String name = (String) session.getAttribute("name");
	String id = (String) session.getAttribute("id");
	
	/*
	쿠키 (특정 쿠키만 선택해서 얻을 수 없으므로 모든 쿠키를 가져옴)
	Cookie[] cookie = request.getCookies();
	if(cookie != null) {
		for(int i=0; i<cookie.length; i++){
			String cookieName = cookie[i].getName();
			String cookieValue = cookie[i].getValue();
			
			System.out.println("쿠키명: " + cookieName + ", 값:" + cookieValue);
			
			if(cookieName.equals("name")) {
				name = cookieValue;
			}
			if(cookieName.equals("id")) {
				id = cookieValue;
			}
		}
		System.out.println();
	}
	*/
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<h3>로그인 성공</h3>
	<%=name %>님 로그인
	<input type="button" value="로그아웃" onClick="location.href='http://192.168.0.32:8080/memberJSP/member/logout.jsp'">
	<input type="button" value="회원정보수정" onClick="location.href='http://192.168.0.32:8080/memberJSP/member/updateForm.jsp'">
	<input type="button" value="회원탈퇴" onClick="location.href='http://192.168.0.32:8080/memberJSP/member/deleteForm.jsp'">
</body>
</html>