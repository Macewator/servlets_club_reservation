<%--
  Created by IntelliJ IDEA.
  User: Krzysiek
  Date: 18.04.2019
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">Club Arizona</a>
    <div class="col-6 offset-5">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}">Strona główna</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/reservation">Zarezerwuj</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/register">Rejestracja</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/profile?edit=disable&delete=disable">Moje Konto</a>
            </li>
            <li class="nav-item">
                <c:choose>
                    <c:when test="${not empty sessionScope.user}">
                        <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                    </c:when>
                    <c:otherwise>
                        <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>
    </div>
</nav>
