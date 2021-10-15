<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="label.title" /></title>
    <ul>
    </ul>
<%--    <title>Testing</title>--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<%--<div><spring:message code="label.title" /></div>--%>
<div class="container">
    <div>

<li class="nav-item dropdown">
<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false" >
<spring:message code="message.language"/>
    </a>
    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
    <li onclick="changeLang('en')"><a class="dropdown-item" href="#"><spring:message code="message.ru"/></a></li>
    <li onclick="changeLang('uk')"><a class="dropdown-item" href="#"><spring:message code="message.ua"/></a></li>
        </ul>
        </li>

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/login?lang=en">English</a>
        &nbsp;|&nbsp;
<%--        <p><a href="/register"><input class="btn btn-primary" value="Sign up"></a></p>--%>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/login?lang=ru">Русский</a>
        &nbsp;|&nbsp;
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/login?lang=ua">Українська</a>
    </div>

    <c:url value="/j_spring_security_check" var="loginUrl"/>
    <h3><spring:message code="message.login" /></h3>
    <form action="${loginUrl}" method="POST">
        <input class="form-control form-group" type="text" name="j_login" placeholder="Login">
        <input class="form-control form-group" type="password" name="j_password" placeholder="Password">
        <input type="submit" class="btn btn-primary" value="Log in">
        <ul>
        </ul>
        <p><a href="/register"><input class="btn btn-primary" value="Sign up"></a></p>
        <c:if test="${param.error ne null}">
            <p>Wrong login or password!</p>
        </c:if>

        <c:if test="${param.logout ne null}">
            <p>Chao!</p>
        </c:if>
    </form>
</div>
</body>
</html>
