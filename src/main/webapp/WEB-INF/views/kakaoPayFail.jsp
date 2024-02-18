<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>결제 실패</title>
</head>
<c:import url="header.jsp" />
<body>
  <section>
    <div class="info-banner"></div>
    <div class="subject">결제 실패</div>
    <div class="payment-fail-container">
      <p>카카오페이 결제가 실패[취소]하였습니다.</p><br/>
      <p>잠시후에 다시 시도해주세요..</p><br/>
      <input type="button" onclick="location.href='/myOrderList'" value="확인">
    </div>
  </section>
</body>
<script type="text/javascript" src="script/paymentFail.js"></script>
<c:import url="footer.jsp" />
</html>
