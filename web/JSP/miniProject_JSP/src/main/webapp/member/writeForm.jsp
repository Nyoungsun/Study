<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Sign up</title>
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
	
	<form name="writeForm" method="post" action="./write.jsp">
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" style="width: 100px;"
					placeholder="이름 입력">
					<div class="check" id="checkNameDiv"></div>
				</td>
			</tr>
			<tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" style="width: 150px;"
					placeholder="아이디 입력" onkeydown="inputId()">
					<input type="button" value="중복확인" onClick="checkId()">
					<div class="check" id="checkIdDiv"></div> 
					<input type="hidden" name="idCheck" value="0"></td>
			</tr>
			<tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw">
					<div class="check" id="checkPwDiv"></div></td>
			</tr>
			<tr>
				<th>재확인</th>
				<td><input type="password" name="pw_check">
				<div class="check" id="checkRePwDiv"></div></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><input type="radio" name="gender" id="man" value="0">
					<label for="man">남자</label> &nbsp; 
					<input type="radio" name="gender" id="woman" value="1"> 
					<label for="woman">여자</label>
					<div class="check" id="checkGenderDiv" ></div>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email1" style="width: 100px;">
					@ <input type="text" name="email2" style="width: 90px;"> 
					<select name="mail_select" style="width: 110px;" onChange="select()">
						<option value="self" selected>직접입력</option>
						<option value="naver.com">naver.com</option>
						<option value="gmail.com">gmail.com</option>
						<option value="nate.com">nate.com</option>
				</select>
				<div class="check" id="checkEmailDiv"></div></td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td><select name="tel1" style="width: 80px;">
						<option value="010" selected>010</option>
						<option value="011">011</option>
						<option value="019">019</option>
						<option value="070">070</option>
				</select> 
				- <input type="text" name="tel2" style="width: 70px;"> 
				- <input type="text" name="tel3" style="width: 70px;">
			      <div class="check" id="checktelDiv"></div></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="zipcode" id="d_zipcode"
					placeholder="우편번호" size="5" readonly> 
					<input type="button" value="우편번호검색" onClick="search()"><br>
					<input type="text" name="addr1" id="d_addr1" style="width: 350px;"
					placeholder="주소" readonly><br> 
					<input type="text" name="addr2" id="d_addr2" style="width: 350px;" 
					placeholder="상세주소">
					<div class="check"  id="checkaddrDiv"></div>
				</td>
			</tr>
			</table>
			<br>
			<div id="btnDiv">
			<input type="button" value="회원가입" onClick="check()"> 
			<input type="reset" value="다시작성">
			</div>

	</form>
	<script src="../js/member.js"></script>
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
	
</body>
</html>