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
    <c:url value="/createtest" var="regUrl"/>
    <form action="${regUrl}" method="POST">
        <h3><spring:message code="messages.testcreation"/></h3>
        <input class="form-control form-group" type="text" name="subject" value="${subject}" required placeholder=
        <spring:message
                code="messages.subject"/>>
        <input class="form-control form-group" type="text" name="question1" required placeholder=<spring:message
                code="messages.questionone"/>>
        <input class="form-control form-group" type="text" name="question2" required placeholder=<spring:message
                code="messages.questiontwo"/>>
        <input class="form-control form-group" type="text" name="question3" required placeholder=<spring:message
                code="messages.questionthre"/>>
        <input class="form-control form-group" type="time" name="time" required placeholder=<spring:message
                code="messages.testtime"/>>
        <input class="form-control form-group" type="text" id="degree" name="degree" aria-describedby="passwordHelp"
               pattern="[ABCD]" required placeholder="<spring:message code="messages.degree"/>">
        <input type="submit" class="btn btn-primary" value=<spring:message code="messages.buttontestcreate"/>>
    </form>
</div>
</body>
</html>