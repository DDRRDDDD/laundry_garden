<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<c:import url="header.jsp" />
<body>
<input type="hidden" id="orderCode" name="orderCode" value="${param.orderCode}">
  <section>
    <div class="info-banner"></div>
    <div class="subject">주문 상세</div>
    <div class="orderdetail-container">
      <table id="orderdetail-table">
        <thead>
        <th class="order-num">No</th>
        <th class="order-category">대분류</th>
        <th class="order-subclassification">소분류</th>
        <th class="order-price">가격</th>
        <th class="order-amount">수량</th>
        <th class="order-subtotal">소계</th>
        </thead>
        <tbody id="orderdetails">
        </tbody>
      </table>
      <div id="total-price"></div>
      <form method="post" action="/kapay" id="payment">
      </form>
    </div>
  </section>
</body>
<script type="text/javascript" src="script/mylaundryorderDetail.js"></script>
<c:import url="footer.jsp" />
</html>
