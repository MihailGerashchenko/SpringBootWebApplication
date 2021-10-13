<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Testing</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"
            integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">


<%--    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--    <%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--    <html>--%>
<%--    <head>--%>
<%--        <title>Testing</title>--%>
<%--        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">--%>
<%--        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>--%>
<%--    </head>--%>
<%--    <body>--%>
<%--    <div class="container">--%>
<%--        <h1>The administrator's page</h1>--%>

<%--        &lt;%&ndash;    <p>Click to go back: <a href="/">back</a></p>&ndash;%&gt;--%>
<%--        <p><a type="submit" class="btn btn-primary" href="/">Turn back</a></p>--%>
<%--        <c:url value="/logout" var="logoutUrl" />--%>
<%--        <p><a type="submit" class="btn btn-primary" a href="${logoutUrl}">Logout</a></p>--%>





    <h1>The administrator's page</h1>

        <p><a type="submit" class="btn btn-primary" href="/">Turn back</a></p>

        <c:url value="/logout" var="logoutUrl" />
        <p><a type="submit" class="btn btn-primary" a href="${logoutUrl}">Logout</a></p>

    <button type="button" id="add_user">Add</button>
    <button type="button" id="delete_user">Delete</button>

    <table border="1">
        <c:forEach items="${users}" var="user">
            <tr>
                <td><input type="checkbox" name="toDelete" value="${user.id}" id="check_${user.id}"></td>
                <td><c:out value="${user.login}"/></td>
                <td><c:out value="${user.role}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>

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
