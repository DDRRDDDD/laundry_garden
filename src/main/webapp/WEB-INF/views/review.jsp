<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>리뷰</title>
    <link rel="stylesheet" href="../style/review.css">
</head>
<c:import url="header.jsp"/>
<body>
<section>
    <div class="info-banner"></div>
    <div class="subject"> 리 뷰 게 시 판 </div>
    <div class="container">
        <table>
            <thead>
            <tr>
                <th>no</th>
                <th>제목</th>
                <th>글쓴이</th>
                <th>작성일</th>
                <th>조회수</th>
            </tr>
            </thead>
            <tbody id="contents-container">
            <c:forEach items="${list }" var="list">
                <tr>
                    <td>${list.boardSeq}</td>
                    <td><a href="readReview?boardSeq=${list.boardSeq}">${list.boardTitle}</a></td>
                    <td>${list.name}</td>
                    <td>${list.boardRegDate.toString().split(" ")[0]}</td>
                    <td>${list.boardViewCount}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div id="page-box">
            <c:forEach var="page" begin="${startPage}" end="${endPage}">
                <c:choose>
                    <c:when test="${page != nowPage}">
                        <c:url var="listUrl" value="list">
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
            <form action="<c:url value='list'/>" method="get">
                <select name="category" class="category">
                    <option value="1">제목</option>
                    <option value="2">내용</option>
                    <option value="3">제목 + 내용</option>
                    <option value="4">작성자</option>
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
