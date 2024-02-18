<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<html>
<head>
  <link rel="shortcut icon" href="#">
  <title>세정원</title>
</head>
<link rel="stylesheet" href="style/index.css">
<body>
  <c:set var="loginClient" value="${sessionScope.loginClient}"/>
  <header>
    <h1 onclick="location.href='/admin'">세정원</h1>
    <nav>
      <ul>
        <li><a id="management-link" onclick="location.href='/orders?page=0&clientCode=&orderCode=&collectDate=&categoryCode='">주문관리</a></li>
        <li onclick="location.href='/list'">리뷰</li>
        <li onclick="location.href='/noticeList'">공지사항</li>
        <li><ion-icon name="person" onclick="" role="img" class="md hydrated"></ion-icon></li>
        ${loginClient.clientName}
      </ul>
    </nav>
  </header>
<script src="script/client.js"></script>
</body>
</html>
