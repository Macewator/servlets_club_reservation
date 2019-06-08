<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" rel="stylesheet">
    <title>Profil Użytkownika</title>
</head>
<body>
<jsp:include page="fragmetns/header.jsp"/>
<div class="container">
    <div class="card col-6 offset-3" style="width:500px">
        <img class="card-img-bottom" src="${pageContext.request.contextPath}/resources/img/club.jpg" alt="Card image">
        <div class="card-body">
            <h4 class="card-title">Twoje konto</h4>
            <div class="card-text">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/profile?edit=disable&delete=enable">Anuluj
                    rezerwacje</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/profile?edit=enable&delete=disable">Edytuj
                    konto</a>
                <c:if test="${requestScope.edit eq 'enable'}">
                    <jsp:include page="fragmetns/editmenu.jsp"/>
                </c:if>
                <c:if test="${requestScope.delete eq 'enable'}">
                    <jsp:include page="fragmetns/deletereserv.jsp"/>
                </c:if>
            </div>
            <div>
                <h4>Twoje dane:</h4>
                <c:out value="${sessionScope.user}"/>
                <div>
                    <h4>Twoje rezerwacje</h4>
                    <c:forEach var="reserv" items="${requestScope.reservations}">
                        <li>Data: <fmt:formatDate value="${reserv.date}" pattern="yyyy-MM-dd HH:mm"/>, <c:out
                                value="${reserv}"/></li>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="fragmetns/footer.jsp"/>
</body>
</html>
