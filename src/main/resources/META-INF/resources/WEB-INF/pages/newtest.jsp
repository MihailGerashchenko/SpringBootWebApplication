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
<%--<div>--%>
<%--    ${subject};--%>
<%--</div>--%>
<div class="container">
    <c:url value="/createtest" var="regUrl"/>
    <form action="${regUrl}" method="POST">
        <h3>Test</h3>
        <input class="form-control form-group" type="text" name="subject" value="${subject}" placeholder=<spring:message code="messages.subject" />>
        <input class="form-control form-group" type="text" name="question1" placeholder=<spring:message code="messages.question1" />>
        <input class="form-control form-group" type="text" name="question2" placeholder=<spring:message code="messages.question2" />>
        <input class="form-control form-group" type="text" name="question3" placeholder=<spring:message code="messages.question3" />>
        <input class="form-control form-group" type="time" name="time" placeholder=<spring:message code="messages.testtime" />>
        <input class="form-control form-group" type="text" name="studentMark" placeholder=<spring:message code="messages.studentMark" />>
        <input type="submit" class="btn btn-primary" value="Add">

<%--        <c:if test="${exists ne null}">--%>

<%--            <p>User already exists!</p>--%>
<%--        </c:if>--%>
    </form>
</div>
</body>
</html>