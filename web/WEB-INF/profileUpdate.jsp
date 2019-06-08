<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" rel="stylesheet">
    <title>Aktualizacja profilu</title>
</head>
<body>
<jsp:include page="fragmetns/header.jsp"/>
<h3>Aktualizacja profilu</h3>
<div>
    <form action="profile" method="post">
        <c:choose>
            <c:when test="${fn:length(pageContext.request.getParameterValues('option')) eq 2}">
                <input type="text" name="newEmail" placeholder="Nowy email"><br>
                <input type="password" name="newPassword" placeholder="Nowe hasło">
            </c:when>
            <c:when test="${pageContext.request.getParameterValues('option')[0] eq 'email'}">
                <input type="text" name="newEmail" placeholder="Nowy email">
            </c:when>
            <c:when test="${pageContext.request.getParameterValues('option')[0] eq 'password'}">
                <input type="password" name="newPassword" placeholder="Nowe hasło">
            </c:when>
        </c:choose>
        <br>
        <input class="btn btn-success" type="submit" value="Potwierdź zmiane danych">
    </form>
</div>
<jsp:include page="fragmetns/footer.jsp"/>
</body>
</html>
