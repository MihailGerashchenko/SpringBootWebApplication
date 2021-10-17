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
        <h3>Registration</h3>
            <input class="form-control form-group" type="login" name="login" value="${login}" placeholder="Login">
            <input class="form-control form-group" type="password" name="password" placeholder="Password">
            <input class="form-control form-group" type="email" name="email" placeholder="Email">
            <input class="form-control form-group" type="phone" name="phone" placeholder="Phone">
            <input class="form-control form-group" type="adress" name="address" placeholder="Address">
            <input type="submit" class="btn btn-primary" value="Add">
            <c:if test="${exists ne null}">
            <p>User already exists!</p>
            </c:if>
    </form>
</div>
</body>
</html>
