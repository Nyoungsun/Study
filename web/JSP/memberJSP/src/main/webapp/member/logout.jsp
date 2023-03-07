<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	/*
	쿠키 (특정 쿠키만 선택해서 얻을 수 없으므로 모든 쿠키를 가져옴)
	Cookie[] cookie = request.getCookies();
	if(cookie != null) {
		for(int i=0; i<cookie.length; i++){
			if(cookie[i].getName().equals("name")){
				cookie[i].setMaxAge(0);
				response.addCookie(cookie[i]);
			}
			
			if(cookie[i].getName().equals("id")){
				cookie[i].setMaxAge(0);
				response.addCookie(cookie[i]);
			}
		}
	}
	*/
	session.removeAttribute("name");
	session.removeAttribute("id");
	%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
<h3> 로그아웃</h3>
</body>
</html>