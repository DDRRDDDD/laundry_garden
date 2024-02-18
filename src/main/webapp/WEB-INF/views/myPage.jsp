<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>마이페이지</title>
    <link rel="stylesheet" href="style/myPage.css">
</head>
<c:import url="header.jsp"/>
<body>
<c:set var="client" value="${sessionScope.loginClient}"/>
<section class="mypage-container">
    <div class="info-banner"></div>
    <div class="subject">마이 페이지</div>
    <div class="default-settings">
        <div class="introduction">
            <div class="client-info">
                <h1>${client.clientName}님</h1>
                <p class="client-email">이메일 : ${client.clientEmail}</p>
                <p class="client-address">주소 : ${client.clientAddress}</p>
                <p class="client-phone">전화번호 : ${client.clientPhone}</p>
            </div>
            <div class="client-func">
                <div class="push-settings">
                    <ion-icon name="notifications-outline" class="bell"></ion-icon>
                    <input type="checkbox" id="toggle" value="${client.clientCode}"
                           <c:if test="${not empty isAllowedPush}">checked</c:if> hidden>
                    <label for="toggle" class="toggleSwitch">
                        <span class="toggleButton"></span>
                    </label>
                </div>
                <div class="client-button">
                    <button onclick="location.href='/myOrderList'">세탁 조회</button>
                    <button onclick="location.href='/logout'">로그아웃</button>
                </div>
            </div>
        </div>

    </div>
</section>
</body>
<script type="text/javascript" src="script/client.js"></script>
<script type="module" src="script/myPage.js"></script>
<c:import url="footer.jsp"/>
</html>