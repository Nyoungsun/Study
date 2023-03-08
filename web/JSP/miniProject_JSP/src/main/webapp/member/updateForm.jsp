<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("UTF-8");

//세션으로부터 ID값 얻어와라
String id = (String)session.getAttribute("id");

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
    <title>회원정보수정</title>
    <style type="text/css">
        div {
            font-size: 20px;
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<meta charset="UTF-8">
<!-- <body onload="load()" -->
<body>
<h1>회원정보수정</h1>
<br>
    <form name="writeForm" method="post" action="http://192.168.0.32:8080/miniProject_JSP/member/update.jsp">
        <table border="1" cellspacing="0" cellpadding="5">
            <tr>
                <th>이름</th> <!--table header-->
                <td><input type="text" name="name" style="width: 70px;" value="<%=name %>"></td>
            </tr>
            <tr>
            <tr>
                <th>아이디</th> 
                <td><input type="text" name="id" style="width: 150px;" readonly value="<%=id %>" ></td>
            </tr>
            <tr>
             <tr>
                <th>비밀번호</th> 
                <td><input type="password" name="pw" style="width: 200px;" value="<%=pw %>" ></td>
            </tr>
            <tr>
                <th>재확인</th> 
                <td><input type="password" name="pw_check" style="width: 200px;" value="<%=pw %>" ></td>
            </tr>
            <tr>
                <th>성별</th>
                <td>
                    <input type="radio" name="gender" value = "0" id = "man" <%="0".equals(gender)?"checked":"" %> >
                    <label for="man">남자</label>
                    &nbsp;
                    <input type="radio" name="gender" value = "1" id = "woman" <%="1".equals(gender)?"checked":"" %> >
                    <label for="woman">여자</label>
                </td>
            </tr>
            <tr>
                <th>이메일</th>
                <td>
                <input type="text" name="email1" style="width: 100px;" value="<%=email1%>" >
                 @ 
                <input type="text" name="email2" style="width: 90px;" value="<%=email2%>" > 
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
                        <option value="010" <%="010".equals(tel1)?"selected":"" %>>010</option>
                        <option value="011" <%="011".equals(tel1)?"selected":"" %>>011</option>
                        <option value="019" <%="019".equals(tel1)?"selected":"" %>>019</option>
                        <option value="070" <%="070".equals(tel1)?"selected":"" %>>070</option>
                    </select>
                    -
                    <input type="text" name="tel2" style="width: 70px;" value="<%=tel2 %>">
                    -
                    <input type="text" name="tel3" style="width: 70px;" value="<%=tel3 %>">
                </td>
            </tr>
            <tr>
                <th>주소</th> 
                <td>
                <input type="text" name="zipcode" id="d_zipcode" value="<%=zipcode %>"  size="5" readonly>
                <input type="button" value="우편번호검색" onClick="search()">
                <br>
                <input type="text" name="addr1" id="d_addr1" style="width: 350px;" value="<%=addr1 %>" readonly>
                <br>
                <input type="text" name="addr2" id="d_addr2" style="width: 350px;" value="<%=addr2 %>">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="수정완료" onClick="check()">
                    <input type="reset" value="다시작성">
                </td>
            </tr>
        </table>
        <br>
        <div id="alert"></div>
    </form>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> <!-- 항상 먼저 선언되어야함 -->
    <script src="../js/member.js"></script> 
    
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