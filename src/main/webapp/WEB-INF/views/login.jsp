<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style/login.css">
</head>
<c:import url="header.jsp"/>
<body>
<section class="login">
    <div class="container">
        <div class="info-banner"></div>
        <div class="subject"> 로그인 </div>
        <form id="authentication">
            <input type="text" id="clientEmail" placeholder="이메일"><br>
            <input type="password" id="clientPassword" placeholder="비밀번호"><br>
            <div id="login-error"></div>
            <input type="button" onclick="generalLogin()" value="로그인"><br>
            <input type="button" onclick="kakaoLogin()"><br>
            <input type="button" onclick="location.href='/regist'" value="회원가입">
        </form>
    </div>
</section>
<script src="script/client.js"></script>
</body>
<c:import url="footer.jsp"/>
</html>