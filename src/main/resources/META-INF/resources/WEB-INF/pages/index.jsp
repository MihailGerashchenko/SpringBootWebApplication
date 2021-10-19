<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="label.title"/></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"></script>
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


<%--&lt;%&ndash;<div class="list-group">&ndash;%&gt;--%>
<%--&lt;%&ndash;    <a href="#" class="list-group-item list-group-item-action">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <div class="d-flex w-100 justify-content-between">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <h5 class="mb-1"><spring:message code="messages.subject" /> <c:out value="${test.subject}"/></h5>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <small><spring:message code="messages.testduration" /></small>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <p class="mb-1">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <spring:message code="messages.question1" /> <c:out value="${test.question1}"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <spring:message code="messages.question2" /> <c:out value="${test.question2}"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <spring:message code="messages.question3" /> <c:out value="${test.question3}"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <spring:message code="messages.time" /> <c:out value="${test.time}"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <spring:message code="messages.degree" /> <c:out value="${test.degree.toString()}"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <spring:message code="messages.customer" /> <c:out value="${test.customer.getLogin()}"/></p>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <small><spring:message code="messages.testrequirements" /></small>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </a>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>

<%--<h1><spring:message code="messages.choosetest" /></h1>--%>
<%--<table class="table">--%>
<%--&lt;%&ndash;    <thead>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <c:forEach var="test" items="${tests}">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;            <th scope="row">${test.getId}</th>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><spring:message code="messages.subject" /> <c:out value="${test.subject}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <small><spring:message code="messages.testduration" /></small>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><spring:message code="messages.question1" /> <c:out value="${test.question1}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><spring:message code="messages.question1" /> <c:out value="${test.question2}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><spring:message code="messages.question1" /> <c:out value="${test.question3}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><spring:message code="messages.question1" /> <c:out value="${test.time}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><spring:message code="messages.question1" /> <c:out value="${test.degree.toString()}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <td><spring:message code="messages.question1" /> <c:out value="${test.customer.getLogin()}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </c:forEach>&ndash;%&gt;--%>
<%--    </thead>--%>
<%--&lt;%&ndash;    <tbody>&ndash;%&gt;--%>
<%--    --%>


<%--&lt;%&ndash;    <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <th scope="row">${test.getId}</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <td><spring:message code="messages.subject" /> <c:out value="${test.subject}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <small><spring:message code="messages.testduration" /></small>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <td><spring:message code="messages.question1" /> <c:out value="${test.question1}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <td><spring:message code="messages.question1" /> <c:out value="${test.question2}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <td><spring:message code="messages.question1" /> <c:out value="${test.question3}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <td><spring:message code="messages.question1" /> <c:out value="${test.time}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <td><spring:message code="messages.question1" /> <c:out value="${test.degree.toString()}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <td><spring:message code="messages.question1" /> <c:out value="${test.customer.getLogin()}"/></td>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <th scope="row">2</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <td>Jacob</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <td>Thornton</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <td>@fat</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <th scope="row">3</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <td colspan="2">Larry the Bird</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <td>@twitter</td>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </tr>&ndash;%&gt;--%>
<%--    </tbody>--%>
<%--</table>--%>
<%--<form method="post" action="filter">--%>
<%--<input type="text" name="filter">--%>
<%--    <button type="submit">Filter subject</button>--%>
<%--</form>--%>
<%--<nav class="navbar navbar-light bg-light">--%>
<%--    <div class="container-fluid">--%>
<%--        <a class="navbar-brand">Search by subject</a>--%>
<%--        <form method="post" action="filter" class="d-flex">--%>
<%--            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="filter">--%>
<%--            <button class="btn btn-outline-success" type="submit">Search</button>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</nav>--%>


<div class="container-fluid" style="margin: 3px auto">
    <div class="container">
        <div style="height: auto; margin:auto 3%;text-align:center">
            <nav class="navbar navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand">Search by subject</a>
                    <form method="post" action="filter" class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="filter">
                        <button class="btn btn-outline-success" type="submit">Search</button>
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
                        <td><c:out value="${test.question1}"/>td>
                        <td><c:out value="${test.question2}"/></td>
                        <td><c:out value="${test.question3}"/></td>
                        <td><c:out value="${test.time}"/></td>
                        <td><c:out value="${test.degree.toString()}"/></td>
                        <td><c:out value="${test.customer.getLogin()}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>
    </nav>
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