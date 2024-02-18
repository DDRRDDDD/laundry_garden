<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<html>
<head>
</head>
<link rel="stylesheet" href="../style/popup.css">
<body>
    <div id="cafe" data-value="${param.cafeCode}">
        <ul class="tabnav">
            <li><a href="#clothes">의류</a></li>
            <li><a href="#bedding">침구</a></li>
            <li><a href="#shoes">신발</a></li>
            <li><a href="#living">리빙</a></li>
            <li><a href="#stroller">유모차</a></li>
            <li><a href="#car-seat">카시트</a></li>
            <li><a href="#leather">가죽/모피</a></li>
        </ul>
    </div>
    <table class="tabcontent">
        <tr>
            <td>분류</td>
            <td>가격</td>
            <td>개수</td>
        </tr>
        <c:forEach var="laundry" items="${items}">
        <tr class="items" id="${laundry.itemCategoryCode}">
            <input id="itemCode" type="hidden" value="${laundry.itemCode}">
            <input id="price" type="hidden" value="${laundry.itemPrice}">
            <td>${laundry.itemName}</td>
            <td>${laundry.itemPrice}원</td>
            <td><input id="amount" type="number" value="0"></td>
        </tr>
        </c:forEach>
    </table>
    <input type="button" onclick="setOrderDetail(${param.orderCode})" value="세탁물 등록">
</body>
<script src="../script/admin.js"></script>
</html>
