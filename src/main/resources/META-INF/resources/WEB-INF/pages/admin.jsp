<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title><spring:message code="label.title"/></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"
            integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1><spring:message code="messages.adminpage"/></h1>
    <ul>
    </ul>
</div>
<div class="container-fluid" style="margin: 3px auto">
    <div class="container">
        <nav class="navbar navbar-light bg-light">
            <div class="container-fluid">
                <a class="navbar-brand"><spring:message code="messages.searchbylogin"/></a>
                <form method="get" action="/admin" class="d-flex">
                    <input class="form-control me-2" type="text" placeholder="Search" aria-label="Search"
                           name="filter" value="${filter}">
                    <button class="btn btn-outline-success" type="submit"><spring:message
                            code="messages.buttonsearch"/></button>
                </form>
            </div>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <c:forEach var="i" begin="1" end="${users.getTotalPages()}">
                        <li><a href="/admin?page=<c:out value="${i - 1}"/>&size=${itemPerPage}"><c:out
                                value="${i}"/></a></li>
                    </c:forEach>
                </ul>
            </nav>
        </nav>
        <div style="height: auto; margin:auto 3%;text-align:center">
            <table class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th><spring:message code="messages.customerjust"/></th>
                    <th><spring:message code="messages.addemail"/></th>
                    <th><spring:message code="messages.addphone"/></th>
                    <th><spring:message code="messages.addaddress"/></th>
                    <th><spring:message code="messages.rolejust"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${customer.content}" var="user">
                    <tr>
                        <th scope="row"><input type="checkbox" name="toDelete" value="${user.id}" id="check_${user.id}">
                        </th>
                        <td><c:out value="${user.login}"/></td>
                        <td><c:out value="${user.email}"/></td>
                        <td><c:out value="${user.phone}"/></td>
                        <td><c:out value="${user.address}"/></td>
                        <td><c:out value="${user.role}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <button type="button" class="btn btn-primary" id="add_user"><spring:message code="messages.add"/></button>
            <button type="button" class="btn btn-primary" id="delete_user"><spring:message
                    code="messages.delete"/></button>
            <ul>
            </ul>
            <p><a type="submit" class="btn btn-primary" href="/"><spring:message code="messages.turnback"/></a></p>
            <c:url value="/logout" var="logoutUrl"/>
            <p><a type="submit" class="btn btn-primary" a href="${logoutUrl}"><spring:message
                    code="messages.logoutbutton"/></a></p>
            <p><a href="/createtest"><input class="btn btn-primary" value=<spring:message
                    code="messages.buttontestcreate"/>></a></p>
        </div>
    </div>
</div>
<script>
    $('#add_user').click(function () {
        window.location.href = "/register";
    });
    $('#delete_user').click(function () {
        var data = {'toDelete': []};
        $(":checked").each(function () {
            data['toDelete'].push($(this).val());
        });
        $.post("/delete", data, function (data, status) {
            window.location.reload();
        });
    });
</script>
</body>
</html>
