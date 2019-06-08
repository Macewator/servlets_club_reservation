<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" rel="stylesheet">
    <title>Club Artizona</title>
</head>
<body>
<jsp:include page="fragmetns/header.jsp"/>
<div class="container">
    <div class="jumbotron home-jumbo">
        <div class="container text-center text-white jumbo-container">
            <h1 class="display-3">Club ARIZONA</h1>
        </div>
    </div>
    <div class="text-justify text-center">
        <p>
            Witamy w super luksusowym kubie dla mega vipów.<br>
            Tu pijemy tylko Jim Bean z lodem.
        </p>
    </div>
</div>
<jsp:include page="fragmetns/footer.jsp"/>
</body>
</html>
