<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" rel="stylesheet">
    <title>Potwierdzenie</title>
</head>
<body>
<c:choose>
    <c:when test="${not empty requestScope.reservID}">
        <div>
            <h3>Rezerwacja usunięta pomyślnie</h3>
        </div>
    </c:when>
    <c:otherwise>
        <div>
            <h3>Rezerwacja dodana pomyślnie</h3>
            <div>
                Data: <c:out value="${requestScope.date}"/>
                Typ: <c:out value="${requestScope.reservType}"/>
            </div>
        </div>
    </c:otherwise>
</c:choose>
<a href="${pageContext.request.contextPath}">Wróć do strony głównej</a>
</body>
</html>
