<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ReadReview</title>
</head>
<c:import url="header.jsp"/>
<link rel="stylesheet" href="../style/readReview.css">
<c:set var="clientCode" value="${sessionScope.loginClient.clientCode}"/>
<body>
    <section>
        <div class="info-banner"></div>
        <div class="subject">리뷰 읽기</div>
        <form>
            <input type="hidden" id="clientCode" value="${clientCode}">
        <div class="container">
            <div id="contents-container"></div>
            <div id="button-box">
            <div><input type="button" value="뒤로가기" onclick="location.href='list'"></div>
            </div>
        </div>
        </form>
    </section>
</body>
<c:import url="footer.jsp"/>
<script src="../script/readReview.js"></script>
<script src="../script/deleteReview.js"></script>
</html>
