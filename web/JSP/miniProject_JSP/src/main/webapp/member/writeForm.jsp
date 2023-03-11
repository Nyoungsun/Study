<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>signUp</title>
    <style type="text/css">
        div {
            font-size: 20px;
            color: red;
            font-weight: bold;
            text-align: center;"
        }
        
        table {
        margin-left: auto;
        margin-right: auto;
}
    </style>
</head>
<meta charset="UTF-8">
<body>
<img src="../img/duck.png" width='50' height='50' onclick="location.href='../index.jsp'" style="cursor: pointer;">
<h1 align="center">회원가입</h1>
<br>
    <form name="writeForm" method="post" action="http://192.168.0.32:8080/miniProject_JSP/member/write.jsp">
        <table border="1" cellspacing="0" cellpadding="5">
            <tr>
                <th>이름</th> <!--table header-->
                <td><input type="text" name="name" style="width: 70px;" placeholder="이름 입력"></td>
            </tr>
            <tr>
            <tr>
                <th>아이디</th> 
                <td><input type="text" name="id" style="width: 150px;" placeholder="아이디 입력" onkeydown="inputId()">
                	<input type="button" value="중복확인" onClick="checkId()"> 
                	<input type="hidden" name="idCheck" value="0"></td>
                	
            </tr>
            <tr>
             <tr>
                <th>비밀번호</th> 
                <td><input type="password" name="pw" style="width: 200px;" ></td>
            </tr>
            <tr>
                <th>재확인</th> 
                <td><input type="password" name="pw_check" style="width: 200px;"></td>
            </tr>
            <tr>
                <th>성별</th>
                <td>
                    <input type="radio" name="gender" id = "man" value="0">
                    <label for="man">남자</label>
                    &nbsp;
                    <input type="radio" name="gender" id = "woman" value="1">
                    <label for="woman">여자</label>
                </td>
            </tr>
            <tr>
                <th>이메일</th>
                <td>
                <input type="text" name="email1" style="width: 100px;">
                 @ 
                <input type="text" name="email2" style="width: 90px;"> 
                    <select name="mail_select" style="width: 100px;" onChange="select()">
                        <option value="self" selected>직접입력</option>
                        <option value="naver.com">naver.com</option>
                        <option value="gmail.com">gmail.com</option>
                        <option value="nate.com">nate.com</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>휴대폰</th>
                <td> 
                    <select name="tel1" style="width: 60px;">
                        <option value="010" selected>010</option>
                        <option value="011">011</option>
                        <option value="019">019</option>
                        <option value="070">070</option>
                    </select>
                    -
                    <input type="text" name="tel2" style="width: 70px;">
                    -
                    <input type="text" name="tel3" style="width: 70px;">
                </td>
            </tr>
            <tr>
                <th>주소</th> 
                <td>
                <input type="text" name="zipcode" id="d_zipcode" placeholder="우편번호" size="5" readonly>
                <input type="button" value="우편번호검색" onClick="search()">
                <br>
                <input type="text" name="addr1" id="d_addr1" style="width: 350px;" placeholder="주소" readonly>
                <br>
                <input type="text" name="addr2" id="d_addr2" style="width: 350px;" placeholder="상세주소">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="회원가입" onClick="check()">
                    <input type="reset" value="다시작성">
                </td>
            </tr>
        </table>
        <br>
        <div id="alert"></div>
    </form>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> <!-- 항상 먼저 선언되어야함 -->
    <script src="../js/member.js"></script> 
    <script>
    
    function checkId(){
    	if(document.writeForm.id.value == "") {
    		document.getElementById("alert").innerHTML = "<font color='red'>먼저 아이디를 입력하세요.</font>";
    	} else {
    		var url = "checkId.jsp?id=" + document.writeForm.id.value;
    		window.open(url, "checkId", "width=300 height=150 left=900 top=200"); //같은 이름은 하나만 열린다
    	}
    }
    
    function inputId(){
    	document.writeForm.idCheck.value="0";
    }
    </script>

</body>
</html>