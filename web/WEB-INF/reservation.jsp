<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" rel="stylesheet">
    <title>Rezerwacje</title>
</head>
<body>
<jsp:include page="fragmetns/header.jsp"/>
<div class="container">
    <div>
        <h5>Rezerwacje Pana/Pani</h5>
        <br>
        <h4><c:out value="${sessionScope.user.firstname}"/> <c:out value="${sessionScope.user.lastname}"/></h4>
    </div>
    <div class="container text-justify text-center">
        <h3>Formularz rezerwacji</h3>
        <div>
            <form action="reservation" method="post">
                <div class="form-group">
                    <label for="date">Data:</label>
                    <input type="date" name="date" placeholder="Data" class="form-control" id="date">
                </div>
                <div class="form-group">
                    <label for="time">Godzina:</label>
                    <input type="time" name="time" placeholder="Godzina" class="form-control" id="time">
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="reservtypeA" name="reservationType"
                           value="premium">
                    <label class="form-check-label" for="reservtypeA">premium</label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="reservtypeB" name="reservationType"
                           value="standart">
                    <label class="form-check-label" for="reservtypeB">standart</label>
                </div>
                <button type="submit" class="btn btn-primary">Zarejestruj</button>
            </form>
        </div>
    </div>
</div>
<jsp:include page="fragmetns/footer.jsp"/>
</body>
</html>
