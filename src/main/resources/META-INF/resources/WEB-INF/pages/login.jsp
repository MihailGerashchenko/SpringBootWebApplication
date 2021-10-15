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

<%--<li class="nav-item dropdown">--%>
<%--<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false" >--%>
<%--<spring:message code="message.language"/>--%>
<%--    </a>--%>
<%--    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">--%>
<%--    <li onclick="changeLang('en')"><a class="dropdown-item" href="#"><spring:message code="message.ru"/></a></li>--%>
<%--    <li onclick="changeLang('uk')"><a class="dropdown-item" href="#"><spring:message code="message.ua"/></a></li>--%>
<%--        </ul>--%>
<%--        </li>--%>
<%--    <div class="d-flex">--%>
<%--        <div class="dropdown me-1">--%>
<%--            <button type="button" class="btn btn-secondary dropdown-toggle" id="dropdownMenuOffset" data-bs-toggle="dropdown" aria-expanded="false" data-bs-offset="10,20">--%>
<%--                Offset--%>
<%--            </button>--%>
<%--            <ul class="dropdown-menu" aria-labelledby="dropdownMenuOffset">--%>
<%--                <li><a class="dropdown-item" href="#">Action</a></li>--%>
<%--                <li><a class="dropdown-item" href="#">Another action</a></li>--%>
<%--                <li><a class="dropdown-item" href="#">Something else here</a></li>--%>
<%--            </ul>--%>
<%--        </div>--%>

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/login?lang=en">English</a>
        &nbsp;|&nbsp;
<%--        <p><a href="/register"><input class="btn btn-primary" value="Sign up"></a></p>--%>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/login?lang=ru">Русский</a>
        &nbsp;|&nbsp;
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/login?lang=ua">Українська</a>
    </div>

    <c:url value="/j_spring_security_check" var="loginUrl"/>
    <h3><spring:message code="messages.login1" /></h3>
    <form action="${loginUrl}" method="POST">
        <input class="form-control form-group" type="text" name="j_login" placeholder=<spring:message code="messages.login" />>
        <input class="form-control form-group" type="password" name="j_password" placeholder=<spring:message code="messages.password" />>
        <input type="submit" class="btn btn-primary" value=<spring:message code="messages.in" />>
        <ul>
        </ul>
        <p><a href="/register"><input class="btn btn-primary" value=<spring:message code="messages.signup" />></a></p>
        <c:if test="${param.error ne null}">


            <p><spring:message code="message.wrong.data" /></p>
        </c:if>

        <c:if test="${param.logout ne null}">

            <p><spring:message code="messages.logout" /></p>
        </c:if>
    </form>
</div>
</body>
</html>
