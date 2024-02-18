<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>주문하기</title>
</head>
<c:import url="header.jsp"/>
<link rel="stylesheet" href="style/infoBanner.css">
<link rel="stylesheet" href="style/order.css">
<body>
<c:set var="client" value="${sessionScope.loginClient}"/>
<input type="hidden" id="client-code" name="client-code" value="${sessionScope.loginClient.clientCode}">
<input type="hidden" id="client-address" name="client-address" value="${sessionScope.loginClient.clientAddress}">
<section id="order-section">
    <div class="info-banner"></div>
    <div class="container">
        <div class="subject"> 세탁 신청 </div>
        <div class="order-container">
            <form id="order-box">
            </form>
        </div>
        <div id="receipt-box">
        </div>
    </div>
</section>
</body>
<script type="text/javascript" src="script/order.js"></script>
<c:import url="footer.jsp"/>
</html>