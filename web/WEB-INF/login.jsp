<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" rel="stylesheet">
    <title>Login</title>
</head>
<body>
<jsp:include page="fragmetns/header.jsp"/>
<div class="container text-justify text-center">
    <h3>Logowanie</h3>
    <div>
        <form action="j_security_check" method="post">
            <div class="form-group">
                <label for="login">Login:</label>
                <input type="text" class="form-control" id="login" name="j_username">
            </div>
            <div class="form-group">
                <label for="pwd">Password:</label>
                <input type="password" class="form-control" id="pwd" name="j_password">
            </div>
            <button type="submit" class="btn btn-primary">Zaloguj</button>
        </form>
    </div>
</div>
<jsp:include page="fragmetns/footer.jsp"/>
</body>
</html>
