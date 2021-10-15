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
    <h1>Your login is: ${login}, your role is:</h1>
    <c:forEach var="s" items="${roles}">
        <h3><c:out value="${s}"/></h3>
    </c:forEach>

    <c:if test="${admin}">
        <c:url value="/admin" var="adminUrl"/>
        <p><a href="${adminUrl}">Click</a> for admin page</p>
    </c:if>
    <c:url value="/update" var="updateUrl"/>
    <form action="${updateUrl}" method="POST">
        <input class="form-control form-group" type="text" name="email" value="${email}" placeholder="Email">
        <input class="form-control form-group" type="text" name="phone" value="${phone}" placeholder="Phone">
        <input class="form-control form-group" type="text" name="address" value="${address}" placeholder="Address">
        <input type="submit" class="btn btn-primary" value="Update">
    </form>

    <c:url value="/logout" var="logoutUrl"/>
    <p><a input type="submit" class="btn btn-primary" href="${logoutUrl}">Logout</a></p>
</div>
<h1>Choose your test according to the subject and follow the requirements</h1>
<c:forEach var="test" items="${tests.content}">
    <div class="list-group">
        <a href="#" class="list-group-item list-group-item-action">
            <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1">Subject <c:out value="${test.subject}"/></h5>
                <small>Duration is one hour</small>
            </div>
            <p class="mb-1">
                Quaestion1: <c:out value="${test.question1}"/>
                Quaestion2: <c:out value="${test.question2}"/>
                Quaestion3: <c:out value="${test.question3}"/>
                StudentMark: <c:out value="${test.studentMark.toString()}"/>
                Customer: <c:out value="${test.customer.getLogin()}"/></p>
            <small>Each test has one or more correct answers. The sequence of your answers is the relation between right answers and general numbers of questions.</small>
        </a>
    </div>
</c:forEach>
</body>
</html>