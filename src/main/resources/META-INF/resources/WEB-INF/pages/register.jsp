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
    <c:url value="/newuser" var="regUrl"/>

    <form action="${regUrl}" method="POST">
        <h3>Registration</h3>
<%--        <div class="mb-3">--%>
<%--            <label for="exampleInputLogin" class="form-label">Login</label>--%>
<%--            <input type="login" name="login" class="form-control" value="${login}" id="exampleInputLogin"--%>
<%--                   aria-describedby="emailHelp">--%>
<%--            <div id="emailHelp" class="form-text">Confidential information</div>--%>
            <%--                </div>--%>
            <%--                <div class="mb-3">--%>
            <%--                    <label for="exampleInputPassword1" class="form-label">Password</label>--%>
            <%--                    <input type="password" name="password" class="form-control" id="exampleInputPassword1" aria-describedby="emailHelp1">--%>
            <%--                    <div id="emailHelp1" class="form-text">Confidential information</div>--%>
            <%--                </div>--%>
            <%--                <div class="mb-3">--%>
            <%--                    <label for="exampleInputEmail" class="form-label">Email</label>--%>
            <%--                    <input type="email" name="email" class="form-control" id="exampleInputEmail" aria-describedby="emailHelp2">--%>
            <%--                    <div id="emailHelp2" class="form-text">Confidential information</div>--%>
            <%--                </div>--%>
            <%--                <div class="mb-3">--%>
            <%--                    <label for="exampleInputPhone" class="form-label">Phone</label>--%>
            <%--                    <input type="phone" name="phone" class="form-control" id="exampleInputPhone" aria-describedby="emailHelp3">--%>
            <%--                    <div id="emailHelp3" class="form-text">Confidential information</div>--%>
            <%--                </div>--%>
            <%--                <div class="mb-3">--%>
            <%--                    <label for="exampleInputAdress" class="form-label">Address</label>--%>
            <%--                    <input type="adress" name="address" class="form-control" id="exampleInputAdress" aria-describedby="emailHelp4">--%>
            <%--                    <div id="emailHelp4" class="form-text">Confidential information</div>--%>
            <%--                </div>--%>
            <input class="form-control form-group" type="login" name="login" value="${login}" placeholder="Login">
            <input class="form-control form-group" type="password" name="password" placeholder="Password">
            <input class="form-control form-group" type="email" name="email" placeholder="Email">
            <input class="form-control form-group" type="phone" name="phone" placeholder="Phone">
            <input class="form-control form-group" type="adress" name="address" placeholder="Adress">
            <input type="submit" class="btn btn-primary" value="Add">
            <%--                <input type="submit" />--%>
            <%--                    <button type="submit" class="btn btn-primary">Submit</button>--%>


            <c:if test="${exists ne null}">
            <p>User already exists!</p>
            </c:if>
    </form>
</div>
</body>
</html>
