<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title><spring:message code="label.title" /></title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"
            integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1><spring:message code="messages.adminpage" /></h1>

<%--    <table border="1">--%>
<%--        <c:forEach items="${users}" var="user">--%>
<%--            <tr>--%>
<%--                <td><input type="checkbox" name="toDelete" value="${user.id}" id="check_${user.id}"></td>--%>
<%--                <td><c:out value="${user.login}"/></td>--%>
<%--                <td><c:out value="${user.role}"/></td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
</div>


<table class="table table-hover">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col"><spring:message code="messages.customerjust" /></th>
        <th scope="col"><spring:message code="messages.rolejust" /></th>
    </tr>
    </thead>
    <tbody>
<%--    <td><input type="checkbox" name="toDelete" value="${user.id}" id="check_${user.id}"></td>--%>
    <c:forEach items="${users}" var="user">
               <tr>
                   <th scope="row"><input type="checkbox" name="toDelete" value="${user.id}" id="check_${user.id}"></th>
        <td><c:out value="${user.login}"/></td>
        <td><c:out value="${user.role}"/></td>
    </tr>
    </c:forEach>
    </tbody>
</table>

<button type="button" class="btn btn-primary" id="add_user"><spring:message code="messages.add" /></button>
<button type="button" class="btn btn-primary" id="delete_user"><spring:message code="messages.delete" /></button>
<ul>

</ul>
<p><a type="submit" class="btn btn-primary" href="/"><spring:message code="messages.turnback" /></a></p>
<c:url value="/logout" var="logoutUrl" />
<p><a type="submit" class="btn btn-primary" a href="${logoutUrl}"><spring:message code="messages.logoutbutton" /></a></p>
<p><a href="/createtest"><input class="btn btn-primary" value=<spring:message code="messages.signup" />></a></p>

<%--<c:forEach var="test" items="${tests.content}">--%>
<%--    <div>--%>
<%--        Subject <c:out value="${test.subject}"/>--%>
<%--        Quaestion1: <c:out value="${test.question1}"/>--%>
<%--        Quaestion2: <c:out value="${test.question2}"/>--%>
<%--        Quaestion3: <c:out value="${test.question3}"/>--%>
<%--        Mark: <c:out value="${test.studentMark.toString()}"/>--%>
<%--        Customer: <c:out value="${test.customer.getLogin()}"/>--%>
<%--    </div>--%>
<%--</c:forEach>--%>



<script>
    $('#add_user').click(function(){
        window.location.href = "/register";
    });

    $('#delete_user').click(function(){
        var data = { 'toDelete' : []};
        $(":checked").each(function() {
            data['toDelete'].push($(this).val());
        });
        $.post("/delete", data, function(data, status) {
            window.location.reload();
        });
    });
</script>

</body>
</html>
