<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="label.title" /></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <c:url value="/newuser" var="regUrl"/>
    <form action="${regUrl}" method="POST">
        <h3><spring:message code="messages.registration" /></h3>

            <input class="form-control form-group" type="login" name="login" value="${login}" placeholder=<spring:message code="messages.addlogin" />>
            <input class="form-control form-group" type="password" name="password" placeholder=<spring:message code="messages.addpassword" />>
            <input class="form-control form-group" type="email" name="email" placeholder=<spring:message code="messages.addemail" />>
            <input class="form-control form-group" type="phone" name="phone" placeholder=<spring:message code="messages.addphone" />>
            <input class="form-control form-group" type="adress" name="address" placeholder=<spring:message code="messages.addaddress" />>
            <input type="submit" class="btn btn-primary" value=<spring:message code="messages.add" />>
            <c:if test="${exists ne null}">
            <p>User already exists!</p>
            </c:if>
    </form>
</div>
</body>
</html>
