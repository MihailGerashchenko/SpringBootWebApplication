<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Tests</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css">
</head>
<body>
<header th:insert="blocks/header :: header"></header>


<div class="container mt-5">
    <!--/*@thymesVar id="list" type="java"*/-->
    <div th:each="el : ${list}" class="alert alert-info mt-2">
        
    </div>

</div>
</body>
</html>

<%--<spring:message code="messages.question1" /> <c:out value="${test.question1}"/>--%>
<%--<spring:message code="messages.question2" /> <c:out value="${test.question2}"/>--%>
<%--<spring:message code="messages.question3" /> <c:out value="${test.question3}"/>--%>
<%--<spring:message code="messages.time" /> <c:out value="${test.time}"/>--%>
<%--<spring:message code="messages.degree" /> <c:out value="${test.degree.toString()}"/>--%>
<%--<spring:message code="messages.customer" /> <c:out value="${test.customer.getLogin()}"/></p>--%>