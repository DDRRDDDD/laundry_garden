<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Notice</title>
    <link rel="stylesheet" href="../style/notice.css">
</head>
<c:import url="header.jsp"/>
<body>
<section>
    <div class="info-banner"></div>
    <div class="subject"> 공 지 사 항 </div>
    <div class="container">
        <table>
            <thead>
            <tr>
                <th>no</th>
                <th>제목</th>
                <th>작성일</th>
                <th>조회수</th>
            </tr>
            </thead>
            <tbody id="contents-container">
            <c:forEach items="${list }" var="list">
                <tr>
                    <td>${list.boardSeq}</td>
                    <td><a href="readNotice?boardSeq=${list.boardSeq}">${list.boardTitle}</a></td>
                    <td>${list.boardRegDate.toString().split(" ")[0]}</td>
                    <td>${list.boardViewCount}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:if test="${sessionScope.loginClient.clientCode eq 9999}">
            <input type="button" value="공지사항 작성" onclick="location.href='writeNotice'">
        </c:if>
        <div id="page-box">
            <c:forEach var="page" begin="${startPage}" end="${endPage}">
                <c:choose>
                    <c:when test="${page != nowPage}">
                        <c:url var="listUrl" value="noticeList">
                            <c:param name="page" value="${page - 1}"/>
                            <c:param name="searchKeyword" value="${param.searchKeyword}"/>
                            <c:param name="category" value="${param.category}"/>
                        </c:url>
                        <a href="${listUrl}">
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
        <div class="search">
            <form action="<c:url value='noticeList'/>" method="get">
                <select name="category" class="category">
                    <option value="1">제목</option>
                    <option value="2">내용</option>
                    <option value="3">제목 + 내용</option>
                </select>
                <input type="text" name="searchKeyword">
                <button type="submit">검색</button>
            </form>
        </div>
    </div>
</section>
</body>
<c:import url="footer.jsp"/>
</html>
