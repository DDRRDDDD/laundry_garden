<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ModifyReview</title>
</head>
<c:import url="header.jsp"/>
<link rel="stylesheet" href="../style/modifyReview.css">
<c:set var="clientCode" value="${sessionScope.loginClient.clientCode}"/>
<body>
    <section class="modReviewSection">
        <div class="info-banner"></div>
        <div class="subject">리뷰 수정</div>
        <form>
            <input type="hidden" value="${clientCode}" id="clientCode">
            <div id="contents-container">
                <div class="title-box"><input type="text" class="title" id="title" placeholder="제목"></div>
                <div class="contents-box"><textarea id="contents" class="contents" placeholder="내용"></textarea></div>
                <input type="hidden" id="imgUrl">
                <div id="imgBox"><img id="img" class="img" onerror="this.style.display='none'" alt='' ></div>
                <div class="img-box"><input type="button" class="button" value="이미지삭제" onclick="deleteImg()"><input type="hidden" id="test" role="uploadcare-uploader" name="my_file_input" /></div>
                <div class="modButton" ><input type="button" class="button" value="수정하기" onclick="updateReview()"></div>
            </div>
        </form>
    </section>
    <script>
        UPLOADCARE_PUBLIC_KEY = '033ed8294e3f01202754';
    </script>
    <script src="https://ucarecdn.com/libs/widget/3.x/uploadcare.full.min.js"></script>
    <script>
        let singleWidget = uploadcare.SingleWidget('[role=uploadcare-uploader]');
        singleWidget.onUploadComplete(function (info){
            document.getElementById('imgUrl').value = info.cdnUrl;
        });
    </script>
</body>
<script src="../script/modifyReview.js"></script>
<c:import url="footer.jsp"/>
</html>
