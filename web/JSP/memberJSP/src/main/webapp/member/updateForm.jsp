<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("UTF-8");


String update_id = request.getParameter("update_id").trim();
String update_pw = request.getParameter("update_pw").trim();

//DB
MemberDAO memberDAO = MemberDAO.getInstance();
MemberDTO dto = memberDAO.memberRead(update_id, update_pw);

%>
<!DOCTYPE html>
<html>
<head>
    <title>signUp</title>
    <style type="text/css">
        div {
            font-size: 20px;
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<meta charset="UTF-8">
<body>
<h1>회원정보수정</h1>
<br>
    <form name="writeForm" method="post" action="http://192.168.0.32:8080/memberJSP/member/update.jsp">
        <table border="1" cellspacing="0" cellpadding="5">
            <tr>
                <th>이름</th> <!--table header-->
                <td><input type="text" name="name" style="width: 70px;" value="<%=dto.getName() %>"></td>
            </tr>
            <tr>
            <tr>
                <th>아이디</th> 
                <td><input type="text" name="id" style="width: 150px;" readonly value="<%=update_id %>" ></td>
            </tr>
            <tr>
             <tr>
                <th>비밀번호</th> 
                <td><input type="password" name="pw" style="width: 200px;" value="<%=update_pw %>" ></td>
            </tr>
            <tr>
                <th>재확인</th> 
                <td><input type="password" name="pw_check" style="width: 200px;" value="<%=update_pw %>" ></td>
            </tr>
            <tr>
                <th>성별</th>
                <td>
                    <input type="radio" name="gender" value = "0" id = "man" <%="0".equals(dto.getGender())?"checked":"" %> >
                    <label for="man">남자</label>
                    &nbsp;
                    <input type="radio" name="gender" value = "1" id = "woman" <%="1".equals(dto.getGender())?"checked":"" %> >
                    <label for="woman">여자</label>
                </td>
            </tr>
            <tr>
                <th>이메일</th>
                <td>
                <input type="text" name="email1" style="width: 100px;" value="<%=dto.getEmail1()%>" >
                 @ 
                <input type="text" name="email2" style="width: 90px;" value="<%=dto.getEmail2() %>" > 
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
                        <option value="010" <%="010".equals(dto.getTel1())?"selected":"" %>>010</option>
                        <option value="011" <%="011".equals(dto.getTel1())?"selected":"" %>>011</option>
                        <option value="019" <%="019".equals(dto.getTel1())?"selected":"" %>>019</option>
                        <option value="070" <%="070".equals(dto.getTel1())?"selected":"" %>>070</option>
                    </select>
                    -
                    <input type="text" name="tel2" style="width: 70px;" value="<%=dto.getTel2() %>">
                    -
                    <input type="text" name="tel3" style="width: 70px;" value="<%=dto.getTel3() %>">
                </td>
            </tr>
            <tr>
                <th>주소</th> 
                <td>
                <input type="text" name="zipcode" id="d_zipcode" value="<%=dto.getPost() %>"  size="5" readonly>
                <input type="button" value="우편번호검색" onClick="search()">
                <br>
                <input type="text" name="addr1" id="d_addr1" style="width: 350px;" value="<%=dto.getAddr1() %>"  readonly>
                <br>
                <input type="text" name="addr2" id="d_addr2" style="width: 350px;" value="<%=dto.getAddr2() %>">
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

</body>
</html>