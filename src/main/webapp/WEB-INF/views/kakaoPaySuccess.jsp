<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>결제 성공</title>
</head>
<c:import url="header.jsp" />
<body>
<%--<c:set var="payment-info" value="${requestScope.info}" />--%>
<input type="hidden" id="orderCode" name="orderCode" value="${info.partner_order_id}">
<section>
    <div class="info-banner"></div>
    <div class="subject">주문 결제 완료</div>
    <div id="payment-div">
        <%--    <p>${payment-info.approved_at}</p>--%>
        <div id="payment-form" class="payment-success-container">
            <p>주문번호 : &nbsp;${info.partner_order_id}&nbsp;</p><br/>
            <p>상품명 : &nbsp;${info.item_name}&nbsp;</p><br/>
            <p>상품수량 : &nbsp;${info.quantity}&nbsp;</p><br/>
            <p>결제금액 : &nbsp;${info.amount.total}원&nbsp;</p><br/>
            <p>결제방법 : &nbsp;${info.payment_method_type}&nbsp;</p><br/>
            <input type="button" onclick="location.href='/myOrderList'" value="확인">
        </div>
    </div>
</section>
</body>
<script type="text/javascript" src="script/paymentSuccess.js"></script>
<c:import url="footer.jsp" />
</html>
