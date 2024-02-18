<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ModifyNotice</title>
</head>
<c:import url="header.jsp"/>
<link rel="stylesheet" href="../style/modifyNotice.css">
<c:set var="clientCode" value="${sessionScope.loginClient.clientCode}"/>
<body>
<section>
    <div class="info-banner"></div>
    <div class="subject">공지사항 수정</div>
    <form>
        <input type="hidden" value="${clientCode}" id="clientCode">
        <div id="contents-container">
            <div class="title-box"><input type="text" id="title" class="title" placeholder="제목"></div>
            <div class="contents-box"><textarea id="contents" placeholder="내용" class="contents"></textarea></div>
            <div class="modButton"><input type="button" value="작성하기" onclick="updateNotice()"></div>
        </div>
    </form>
</section>
</body>
<script src="../script/modifyNotice.js"></script>
<c:import url="footer.jsp"/>
</html>
