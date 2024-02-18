<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>내 주문</title>
</head>
<c:import url="header.jsp"/>
<body>
<c:set var="client" value="${sessionScope.loginClient}"/>
<section>
    <div class="info-banner"></div>
    <div class="mylaundryorder-container">
        <div class="subject">내 주문</div>
        <table class="order-table" id="laundry-table">
            <thead class="table-header">
            <th class="order-code">주문 번호</th>
            <th class="order-status">주문 상태</th>
            <th class="order-order-date">주문일자</th>
            <th class="order-payment-date">결제일</th>
            <th class="order-collection-date">수거일[수거예정일]</th>
            <th class="order-delivery-date">배송일[배송예정일]</th>
            <th class="order-detail">주문상세</th>
            <th class="order-review">&nbsp;&nbsp;리뷰&nbsp;&nbsp;</th>
            </thead>
            <tbody id="myorders">
            <c:forEach items="${list}" var="list">
                <c:choose>
                    <c:when test="${not list.orderReviewIsWritten && list.orderstatusCategoryKind eq '배송 완료'}">
                        <tr>
                            <td>${list.orderCode}</td>
                            <td>${list.orderstatusCategoryKind}</td>
                            <td>${list.orderOrderDate.toString().substring(0,16)}</td>
                            <td>${list.orderPaymentDate.toString().substring(0,16)}</td>
                            <td>${list.orderCollectionDate.toString().substring(0,10)}</td>
                            <td>${list.orderDeliveryDate.toString().substring(0,10)}</td>
                            <td><input type="button" value="주문상세" onclick="location.href='mylaundryorderDetail?orderCode=${list.orderCode}'"></td>
                            <td><input type="button" value="리뷰작성" onclick="location.href='writeReview?orderCode=${list.orderCode}'"></td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td>${list.orderCode}</td>
                            <td>${list.orderstatusCategoryKind}</td>
                            <td>${list.orderOrderDate.toString().substring(0,16)}</td>
                            <td>${list.orderPaymentDate.toString().substring(0,16)}</td>
                            <td>${list.orderCollectionDate.toString().substring(0,10)}</td>
                            <td>${list.orderDeliveryDate.toString().substring(0,10)}</td>
                            <td><input type="button" value="주문상세" onclick="location.href='mylaundryorderDetail?orderCode=${list.orderCode}'"></td>
                            <td></td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            </tbody>
        </table>
        <div id="order-page-box">
            <c:forEach var="page" begin="${startPage}" end="${endPage}">
                <c:choose>
                    <c:when test="${page != nowPage}">
                        <c:url var="listUrl" value="myOrderList">
                            <c:param name="page" value="${page - 1}"/>
                        </c:url>
                        <a href="${listUrl}" style="font-size: 20px">
                            <c:out value="${page}"/>
                        </a>
                    </c:when>
                    <c:otherwise>
                        <strong style="color: red; font-size: 20px;">
                            <c:out value="${page}"/>
                        </strong>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
    </div>
</section>
</body>
<%--<script type="text/javascript" src="script/mylaundryOrder.js"></script>--%>
<c:import url="footer.jsp"/>
</html>
