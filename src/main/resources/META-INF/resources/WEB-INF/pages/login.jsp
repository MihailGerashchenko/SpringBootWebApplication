<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Testing</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <c:url value="/j_spring_security_check" var="loginUrl"/>
    <h3>Log in</h3>
    <form action="${loginUrl}" method="POST">
        <input class="form-control form-group" type="text" name="j_login" placeholder="Login">
        <input class="form-control form-group" type="password" name="j_password" placeholder="Password">
        <input type="submit" class="btn btn-primary" value="Add">
        <ul>
        </ul>
        <p><a href="/register"><input class="btn btn-primary" value="Sign up new user"></a></p>
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
