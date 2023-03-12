<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8");

String id = (String) session.getAttribute("id");

//DB
MemberDAO memberDAO = MemberDAO.getInstance();
MemberDTO dto = memberDAO.memberRead(id);

String name = dto.getName();
String pw = dto.getPw();
String gender = dto.getGender();
String email1 = dto.getEmail1();
String email2 = dto.getEmail2();
String tel1 = dto.getTel1();
String tel2 = dto.getTel2();
String tel3 = dto.getTel3();
String zipcode = dto.getPost();
String addr1 = dto.getAddr1();
String addr2 = dto.getAddr2();
%>

<!DOCTYPE html>
<html>
<head>
<title>Edit</title>
<link rel="stylesheet" href="../css/writeStyle.css">
</head>
<meta charset="UTF-8">
<body>
	<div class="wrap" onclick="location.href='../index.jsp'">
		<div class="menu">LET'S HAVE SOME FUN THIS MOMENT</div>
		<div class="container">
			<div class="menu-mask">LET'S HAVE SOME FUN THIS MOMENT</div>
		</div>
	</div>
	<br>
	
	<form name="writeForm" method="post" action="./update.jsp">
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" style="width: 100px;"
					value="<%=name%>">
					<div class="check" id="checkNameDiv"></div></td>
			</tr>
			<tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" style="width: 150px;" readonly
					value="<%=id%>">
					<div class="check" id="checkIdDiv"></div></td>
			</tr>
			<tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" style="width: 200px;"
					value="<%=pw%>">
					<div class="check" id="checkPwDiv"></div></td>
			</tr>
			<tr>
				<th>재확인</th>
				<td><input type="password" name="pw_check"
					style="width: 200px;" value="<%=pw%>">
					<div class="check" id="checkRePwDiv"></div></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><input type="radio" name="gender" value="0" id="man"
					<%="0".equals(gender) ? "checked" : ""%>> 
					<label for="man">남자</label>
					&nbsp; <input type="radio" name="gender" value="1" id="woman"
					<%="1".equals(gender) ? "checked" : ""%>> 
					<label for="woman">여자</label>
					<div class="check" id="checkGenderDiv" ></div></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email1" style="width: 100px;" value="<%=email1%>"> 
					@ 
					<input type="text" name="email2" style="width: 90px;" value="<%=email2%>">
					<select name="mail_select" style="width: 100px;" onChange="select()">
						<option value="self" selected>직접입력</option>
						<option value="naver.com">naver.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="nate.com">nate.com</option>
				</select>
				<div class="check" id="checkEmailDiv"></div></td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td><select name="tel1" style="width: 60px;">
						<option value="010" <%="010".equals(tel1) ? "selected" : ""%>>010</option>
						<option value="011" <%="011".equals(tel1) ? "selected" : ""%>>011</option>
						<option value="019" <%="019".equals(tel1) ? "selected" : ""%>>019</option>
						<option value="070" <%="070".equals(tel1) ? "selected" : ""%>>070</option>
				</select> - <input type="text" name="tel2" style="width: 70px;" value="<%=tel2%>">
						  - <input type="text" name="tel3" style="width: 70px;" value="<%=tel3%>">
						  <div class="check" id="checktelDiv"></div></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="zipcode" id="d_zipcode"
					value="<%=zipcode%>" size="5" readonly> 
					<input type="button" value="우편번호검색" onClick="search()"><br>
					<input type="text" name="addr1" id="d_addr1" style="width: 350px;"
					value="<%=addr1%>" readonly><br> 
					<input type="text" name="addr2" id="d_addr2" style="width: 350px;" value="<%=addr2%>">
					<div class="check"  id="checkaddrDiv"></div>
				</td>
			</tr>
		</table>
		<br>
		<div id="btnDiv">
			<input type="button" value="수정하기" onClick="check()">
			<input type="reset" value="다시작성">
		</div>
	</form>

    <script src="../js/memberUpdate.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

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

	<%--  
    <script>
    function load(){
    	document.writeForm.gender[<%=gender%>].checked = true;
    	document.writeForm.tel1.value = '<%=tel1%>';
    }
    </script>
    --%>
</body>
</html>