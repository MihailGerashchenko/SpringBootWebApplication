<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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

    <h1><spring:message code="messages.yourlogin" /> ${login}, <spring:message code="messages.role" /></h1>
    <c:forEach var="s" items="${roles}">
        <h3><c:out value="${s}"/></h3>
    </c:forEach>

    <c:if test="${admin}">
        <c:url value="/admin" var="adminUrl"/>
        <p><a input type="submit" class="btn btn-primary" href="${adminUrl}"><spring:message code="messages.adminpagebutton" /></a></p>
    </c:if>

    <c:url value="/update" var="updateUrl"/>
    <form action="${updateUrl}" method="POST">
        <input class="form-control form-group" type="text" name="email" value="${email}" placeholder=<spring:message code="messages.addemail" />>
        <input class="form-control form-group" type="text" name="phone" value="${phone}" placeholder=<spring:message code="messages.addphone" />>
        <input class="form-control form-group" type="text" name="address" value="${address}" placeholder=<spring:message code="messages.addaddress" />>
        <input type="submit" class="btn btn-primary" value=<spring:message code="messages.update" />>
    </form>
    <c:url value="/logout" var="logoutUrl"/>
    <p><a input type="submit" class="btn btn-primary" href="${logoutUrl}"><spring:message code="messages.logoutbutton" /></a></p>
</div>
<h1><spring:message code="messages.choosetest" /></h1>
<c:forEach var="test" items="${tests.content}">
    <div class="list-group">


        <a href="#" class="list-group-item list-group-item-action">
            <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1"><spring:message code="messages.subject" /> <c:out value="${test.subject}"/></h5>
                <small><spring:message code="messages.testduration" /></small>
            </div>
            <p class="mb-1">
                <spring:message code="messages.question1" /> <c:out value="${test.question1}"/>
                <spring:message code="messages.question2" /> <c:out value="${test.question2}"/>
                <spring:message code="messages.question3" /> <c:out value="${test.question3}"/>
                <spring:message code="messages.time" /> <c:out value="${test.time}"/>
                <spring:message code="messages.degree" /> <c:out value="${test.degree.toString()}"/>
                <spring:message code="messages.customer" /> <c:out value="${test.customer.getLogin()}"/></p>
            <small><spring:message code="messages.testrequirements" /></small>
        </a>
    </div>
</c:forEach>
</body>
</html>