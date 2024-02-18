<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<html>
<head>
</head>
<link rel="stylesheet" href="style/popup.css">
<body>
    <c:forEach items="${status}" var="status">
    <button value="${status.orderstatusCategoryCode}" onclick="changeStatus(${param.orderCode}, ${param.clientCode})">${status.orderstatusCategoryKind}</button>
    </c:forEach>
</body>
<script src="script/admin.js"></script>
</html>
