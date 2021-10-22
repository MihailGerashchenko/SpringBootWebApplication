<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="label.title"/></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">

    <h1><spring:message code="messages.yourlogin"/> ${login}, <spring:message code="messages.role"/></h1>
    <c:forEach var="s" items="${roles}">
        <h3><c:out value="${s}"/></h3>
    </c:forEach>

    <c:if test="${admin}">
        <c:url value="/admin" var="adminUrl"/>
        <p><a input type="submit" class="btn btn-primary" href="${adminUrl}"><spring:message
                code="messages.adminpagebutton"/></a></p>
    </c:if>

    <c:url value="/update" var="updateUrl"/>
    <form action="${updateUrl}" method="POST">
        <input class="form-control form-group" type="text" name="email" value="${email}" placeholder=<spring:message
                code="messages.addemail"/>>
        <input class="form-control form-group" type="text" name="phone" value="${phone}" placeholder=<spring:message
                code="messages.addphone"/>>
        <input class="form-control form-group" type="text" name="address" value="${address}" placeholder=<spring:message
                code="messages.addaddress"/>>
        <input type="submit" class="btn btn-primary" value=<spring:message code="messages.update"/>>
    </form>
    <c:url value="/logout" var="logoutUrl"/>
    <p><a input type="submit" class="btn btn-primary" href="${logoutUrl}"><spring:message
            code="messages.logoutbutton"/></a></p>
</div>

<%--<div align="center">--%>
<%--    <nav aria-label="Page navigation">--%>
<%--        <ul class="pagination">--%>
<%--            <c:forEach var="i" begin="1" end="${pages}">--%>
<%--                <li><a href="/?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>--%>
<%--            </c:forEach>--%>
<%--        </ul>--%>
<%--    </nav>--%>
<%--</div>--%>

<div class="container-fluid" style="margin: 3px auto">

    <div class="container">
        <div style="height: auto; margin:auto 3%;text-align:center">
            <nav class="navbar navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand"><spring:message code="messages.searchbysubject"/></a>
                    <form method="get" action="/" class="d-flex">
                        <input class="form-control me-2" type="text" placeholder="Search" aria-label="Search" name="filter" value="${filter}">
                        <button class="btn btn-outline-success" type="submit"><spring:message code="messages.buttonsearch"/></button>
                    </form>
                </div>
            </nav>
            <table class="table table-striped table-bordered table-hover">
<%--                <colgroup>--%>
<%--                    <col span="1" style="width: 5%;">--%>
<%--                    <col span="1">--%>
<%--                    <col span="1" style="width: 10%;">--%>
<%--                </colgroup>--%>
                <thead>
                <tr>
                    <th><spring:message code="messages.subject"/> </th>
                    <th><spring:message code="messages.question1"/></th>
                    <th><spring:message code="messages.question2"/></th>
                    <th><spring:message code="messages.question3"/> </th>
                    <th><spring:message code="messages.time"/></th>
                    <th><spring:message code="messages.degree"/></th>
                    <th><spring:message code="messages.customer"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="test" items="${tests}">
                    <tr>
                        <td><c:out value="${test.subject}"/></td>
                        <td><c:out value="${test.question1}"/></td>
                        <td><c:out value="${test.question2}"/></td>
                        <td><c:out value="${test.question3}"/></td>
                        <td><c:out value="${test.time}"/></td>
                        <td><c:out value="${test.degree.toString()}"/></td>
                        <td><c:out value="${test.customer.getLogin()}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
<%--    <nav aria-label="Page navigation example">--%>
<%--        <ul class="pagination">--%>
<%--            <li class="page-item"><a class="page-link" href="#">Previous</a></li>--%>
<%--            <li class="page-item"><a class="page-link" href="#">1</a></li>--%>
<%--            <li class="page-item"><a class="page-link" href="#">2</a></li>--%>
<%--            <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
<%--            <li class="page-item"><a class="page-link" href="#">Next</a></li>--%>
<%--        </ul>--%>
<%--    </nav>--%>
            </table>
        </div>
    </div>
</div>

<%--<h1><spring:message code="messages.choosetest"/></h1>--%>
<%--<c:forEach var="test" items="${tests}">--%>
<%--    <div class="list-group">--%>
<%--        <a href="#" class="list-group-item list-group-item-action">--%>
<%--            <div class="d-flex w-100 justify-content-between">--%>
<%--                <h5 class="mb-1"><spring:message code="messages.subject"/> <c:out value="${test.subject}"/></h5>--%>
<%--                <small><spring:message code="messages.testduration"/></small>--%>
<%--            </div>--%>
<%--            <p class="mb-1">--%>
<%--                <spring:message code="messages.question1"/> <c:out value="${test.question1}"/>--%>
<%--                <spring:message code="messages.question2"/> <c:out value="${test.question2}"/>--%>
<%--                <spring:message code="messages.question3"/> <c:out value="${test.question3}"/>--%>
<%--                <spring:message code="messages.time"/> <c:out value="${test.time}"/>--%>
<%--                <spring:message code="messages.degree"/> <c:out value="${test.degree.toString()}"/>--%>
<%--                <spring:message code="messages.customer"/> <c:out value="${test.customer.getLogin()}"/></p>--%>
<%--            <small><spring:message code="messages.testrequirements"/></small>--%>
<%--        </a>--%>
<%--    </div>--%>
<%--</c:forEach>--%>


</body>
</html>