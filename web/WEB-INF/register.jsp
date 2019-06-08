<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" rel="stylesheet">
    <title>Rejestracja</title>
</head>
<body>
<jsp:include page="fragmetns/header.jsp"/>
<div class="container text-justify text-center">
    <h3>Rejestracja użytkownika</h3>
    <div>
        <form action="register" method="post">
            <div class="form-group">
                <label for="username">Nazwa użytkownika:</label>
                <input name="username" type="text" placeholder="Nazwa użytkownika" class="form-control" id="username">
            </div>
            <div class="form-group">
                <label for="firstname">Imię:</label>
                <input name="firstname" type="text" placeholder="Imię" class="form-control" id="firstname">
            </div>
            <div class="form-group">
                <label for="lastname">Nazwisko:</label>
                <input name="lastname" type="text" placeholder="Nazwisko" class="form-control" id="lastname">
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input name="email" type="text" placeholder="Email" class="form-control" id="email">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input name="password" type="password" placeholder="Hasło" class="form-control" id="password">
            </div>
            <button type="submit" class="btn btn-primary">Zarejestruj</button>
        </form>
    </div>
</div>
<jsp:include page="fragmetns/footer.jsp"/>
</body>
</html>
