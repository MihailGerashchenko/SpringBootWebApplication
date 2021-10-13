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
            <h3><c:out value="${s}" /></h3>
        </c:forEach>

        <c:if test="${admin}">
            <c:url value="/admin" var="adminUrl" />
            <p><a type="submit" class="btn btn-primary" href="${adminUrl}">The administrator's page</a></p>
        </c:if>

        <c:url value="/update" var="updateUrl" />
        <form action="${updateUrl}" method="POST">
<%--            E-mail:<br/><input type="text" name="email" value="${email}" /><br/>--%>
<%--            Phone:<br/><input type="text" name="phone" value="${phone}" /><br/>--%>
<%--            Address:<br/><input type="text" name="phone" value="${address}" /><br/>--%>
            <input class="form-control form-group" type="text" name="email" value="${email}" placeholder="Email">
            <input class="form-control form-group" type="text" name="phone" value="${phone}" placeholder="Phone">
            <input class="form-control form-group" type="text" name="address" value="${address}" placeholder="Address">
<%--            <input type="submit" value="Update" />--%>
            <input type="submit" class="btn btn-primary" value=Update>
        </form>

        <c:url value="/logout" var="logoutUrl" />
        <p><a type="submit" class="btn btn-primary" href="${logoutUrl}">LOGOUT</a></p>
    </div>
</body>
</html>
