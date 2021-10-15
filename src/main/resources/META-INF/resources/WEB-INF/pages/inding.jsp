<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="label.title" /></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<c:forEach var="test" items="${tests.content}">
    <div>
        Subject <c:out value="${test.subject}"/>
        Quaestion1: <c:out value="${test.question1}"/>
        Quaestion2: <c:out value="${test.question2}"/>
        Quaestion3: <c:out value="${test.question3}"/>
        Mark: <c:out value="${test.studentMark.toString()}"/>
        Customer: <c:out value="${test.customer.getLogin()}"/>
    </div>
</c:forEach>
</body>
</html>