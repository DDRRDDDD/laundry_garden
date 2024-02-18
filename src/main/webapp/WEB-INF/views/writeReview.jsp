<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WriteReview</title>
</head>
<c:import url="header.jsp"/>
<link rel="stylesheet" href="../style/writeReview.css">
<body>
<c:set var="clientCode" value="${sessionScope.loginClient.clientCode}"/>
<section>
    <div class="info-banner"></div>
    <div class="subject">리뷰 작성</div>
    <form>
        <div class="review-container">
            <input type="hidden" value="${clientCode}" id="clientCode">
            <div class="title-box"><input type="text" class="title" id="title" placeholder="제목" ></div>
            <div class="img-box"><div>img upload</div><input type="hidden" id="test" role="uploadcare-uploader" name="my_file_input" /></div>
            <div class="contents-box"><textarea class="contents" id="contents" placeholder="내용" ></textarea></div>
            <input type="hidden" id="imgUrl">
            <div><input type="button" class="button" value="작성하기" onclick="writeReview()"></div>
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
<c:import url="footer.jsp"/>
<script src="../script/writeReview.js"></script>
</html>
