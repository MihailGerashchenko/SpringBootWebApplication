<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="label.title"/></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <c:url value="/newuser" var="regUrl"/>
    <form action="${regUrl}" method="POST">
        <h3><spring:message code="messages.registration"/></h3>
        <input class="form-control form-group" type="login" name="login" value="${login}" required placeholder=
        <spring:message code="messages.addlogin"/>>
        <small id="passwordHelpBlock" class="form-text text-muted">
            <spring:message code="messages.passwordRequirement"/>
        </small>
        <input class="form-control form-group" type="password" name="password" aria-describedby="passwordHelpBlock"
               required placeholder=<spring:message
                code="messages.addpassword"/>>
        <input class="form-control form-group" type="email" name="email" required placeholder=<spring:message
                code="messages.addemail"/>>
        <small id="passwordHelp" class="form-text text-muted">
            <spring:message code="messages.phoneFormat"/>
        </small>
        <input class="form-control form-group" type="phone" id="phone" name="phone" required
               aria-describedby="passwordHelp"
               pattern="?<=(^|\n)(38)?)(039|067|068|096|097|098|050|066|095|099|063|093)\d{7}(?=\r?\n|$" required
               placeholder=<spring:message code="messages.addphone"/>>
        <input class="form-control form-group" type="adress" name="address" required placeholder=<spring:message
                code="messages.addaddress"/>>
        <input type="submit" class="btn btn-primary" value=<spring:message code="messages.add"/>>
        <c:if test="${exists ne null}">
            <p>User already exists!</p>
        </c:if>
    </form>
</div>
</body>
</html>
