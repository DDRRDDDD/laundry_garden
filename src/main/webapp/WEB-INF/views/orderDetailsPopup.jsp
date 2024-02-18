<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<html>
<head>
</head>
<link rel="stylesheet" href="style/popup.css">
<body>
<section>
    <div class="orderdetail-container">
        <table id="orderdetail-table">
            <thead>
            <th class="order-category">대분류</th>
            <th class="order-subclassification">소분류</th>
            <th class="order-price">가격</th>
            <th class="order-amount">수량</th>
            <th class="order-subtotal">소계</th>
            </thead>
            <tbody id="orderdetails">
            <c:forEach var="laundry" items="${orderDetalis}">
                <tr>
                    <td>${laundry.itemCategoryKind}</td>
                    <td>${laundry.itemName}</td>
                    <td>${laundry.itemPrice}원</td>
                    <td>${laundry.orderDetailsAmount}</td>
                    <td>${laundry.subtotal}원</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div id="total-price"></div>
        <form method="post" action="/kapay" id="payment">
        </form>
    </div>
</section>
</body>
<script src="script/admin.js"></script>
</html>
