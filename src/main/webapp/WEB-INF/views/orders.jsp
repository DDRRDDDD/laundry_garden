<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<link rel="stylesheet" href="style/admin.css">
<c:import url="headerAdmin.jsp"/>
<body>
    <section class="admin">
        <form id="search-detail" action="<c:url value='orders'/>" method="get">
            주문번호<input id="orderCode" name="orderCode" type="number" value="${param.orderCode}">
            고객코드<input id="clientCode" name="clientCode" type="number" value="${param.clientCode}">
            수거일 <input id="collectDate" name="collectDate" type="date" value="${param.collectDate}">
            상태 <select id="order-status" name="categoryCode">
                    <option value="" <c:if test="${param.categoryCode == ''}"> selected = "selected"</c:if>>주문상태</option>
                    <option value="1" <c:if test="${param.categoryCode == '1'}"> selected = "selected"</c:if>>수거 전</option>
                    <option value="2" <c:if test="${param.categoryCode == '2'}"> selected = "selected"</c:if>>수거완료</option>
                    <option value="3" <c:if test="${param.categoryCode == '3'}"> selected = "selected"</c:if>>결제대기</option>
                    <option value="4" <c:if test="${param.categoryCode == '4'}"> selected = "selected"</c:if>>결제완료</option>
                    <option value="5" <c:if test="${param.categoryCode == '5'}"> selected = "selected"</c:if>>세탁 중</option>
                    <option value="6" <c:if test="${param.categoryCode == '6'}"> selected = "selected"</c:if>>세탁완료</option>
                    <option value="7" <c:if test="${param.categoryCode == '7'}"> selected = "selected"</c:if>>배송 중</option>
                    <option value="8" <c:if test="${param.categoryCode == '8'}"> selected = "selected"</c:if>>배송완료</option>
                </select>
            <input type="submit" value="상세검색">
        </form>
        <table id="order-table">
            <tr>
                <td>주문번호</td>
                <td>고객 코드</td>
                <td>수거일</td>
                <td>배송일</td>
                <td>상태</td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <c:forEach items="${order}" var="order" >
            <tr class="orders">
                <td>${order.orderCode}</td>
                <td>${order.clientCode}</td>
                <td>${order.orderCollectionDate.toString().split(" ")[0]}</td>
                <td>${order.orderDeliveryDate.toString().split(" ")[0]}</td>
                <td>${order.orderstatusCategoryKind}</td>
                <td><input type="button" onclick="selorderstatus(${order.orderCode}, ${order.clientCode})" value="상태선택"></td>
                <td><input type="button" onclick="categorizeLaundry(${order.orderCode})" value="세탁분류"></td>
                <td><input type="button" onclick="orderDatails(${order.orderCode})" value="주문상세"></td>
            </tr>
            </c:forEach>
        </table>
        <div id="page-box">
            <c:forEach var="page" begin="${startPage}" end="${endPage}">
                <c:choose>
                    <c:when test="${page != nowPage}">
                        <c:url var="orderUrl" value="orders">
                            <c:param name="page" value="${page-1}"/>
                            <c:param name="clientCode" value="${param.clientCode}"/>
                            <c:param name="orderCode" value="${param.orderCode}"/>
                            <c:param name="collectDate" value="${param.collectDate}"/>
                            <c:param name="categoryCode" value="${param.categoryCode}"/>
                        </c:url>
                        <a href="${orderUrl}">
                            <c:out value="${page}"/>
                        </a>
                    </c:when>
                    <c:otherwise>
                        <strong style="color: red">
                            <c:out value="${page}"/>
                        </strong>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
    </section>
</body>
<script src="../script/admin.js"></script>
<c:import url="footer.jsp"/>
</html>
