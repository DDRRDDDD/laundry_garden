<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WriteNotice</title>
</head>
<c:import url="header.jsp"/>
<link rel="stylesheet" href="../style/writeNotice.css">
<body>
<c:set var="clientCode" value="${sessionScope.loginClient.clientCode}"/>
<section>
    <div class="info-banner"></div>
    <div class="subject">공지사항 작성</div>
    <form>
        <div class="notice-container">
            <input type="hidden" value="${clientCode}" id="clientCode">
            <div class="title-box"><input type="text" class="title" id="title" placeholder="제목"></div>
            <div class="contents-box"><textarea id="contents" class="contents" placeholder="내용"></textarea></div>
            <div><input type="button" value="작성하기" onclick="writeNotice()"></div>
        </div>
    </form>
</section>
</body>
<c:import url="footer.jsp"/>
<script src="../script/writeNotice.js"></script>
</html>
