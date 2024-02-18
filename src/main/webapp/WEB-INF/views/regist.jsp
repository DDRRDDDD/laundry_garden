<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style/regist.css">
</head>
<c:import url="header.jsp"/>
<body>
<section class="regist">
    <h1>회원가입</h1>
    <form method="POST" id="authentication">
        <input type="text" id="clientEmail" placeholder="이메일"><br>
        <div id="email-error"></div><br>
        <input type="password" id="clientPassword" placeholder="비밀번호"><br>
        <div id="password-error"></div><br>
        <input type="text" id="clientName" placeholder="이름"><br>
        <div id="name-error"></div><br>
        <input type="text" id="clientPhone" placeholder="전화번호"><br>
        <div id="phone-error"></div><br>
        <input type="text" id="clientAddress" placeholder="주소"><br>
        <div id="address-error"></div><br>
        <div id="registration-error"></div><br>
        <input type="button" onclick="registration()" value="회원가입">
    </form>
</section>
<script src="script/client.js"></script>
</body>
<c:import url="footer.jsp"/>
</html>
