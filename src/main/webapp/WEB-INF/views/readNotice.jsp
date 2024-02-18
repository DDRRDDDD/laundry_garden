<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ReadNotice</title>
</head>
<c:import url="header.jsp"/>
<link rel="stylesheet" href="../style/readNotice.css">
<c:set var="clientCode" value="${sessionScope.loginClient.clientCode}"/>
<body>
    <section>
        <div class="info-banner"></div>
        <div class="subject">공지사항 읽기</div>
        <form>
        <input type="hidden" id="clientCode" value="${clientCode}">
        <div class="container">
            <div id="contents-container"></div>
            <div id="button-box">
            <div><input type="button" value="뒤로가기" onclick="location.href='noticeList'"></div>
            </div>
        </div>
        </form>
    </section>
</body>
<c:import url="footer.jsp"/>
<script src="../script/readNotice.js"></script>
<script src="../script/deleteNotice.js"></script>
</html>
