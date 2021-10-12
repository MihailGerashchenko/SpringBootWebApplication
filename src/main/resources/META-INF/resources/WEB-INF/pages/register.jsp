<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Testing</title>
</head>
<body>

<div align="center">
    <c:url value="/newuser" var="regUrl"/>

    <form action="${regUrl}" method="POST">
                <div class="mb-3">
                    <label for="exampleInputLogin" class="form-label">Login</label>
                    <input type="login" name="login" class="form-control" value="${login}" id="exampleInputLogin"
                           aria-describedby="emailHelp">
                    <div id="emailHelp" class="form-text">Confidential information</div>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" name="password" class="form-control" id="exampleInputPassword1" aria-describedby="emailHelp1">
                    <div id="emailHelp1" class="form-text">Confidential information</div>
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail" class="form-label">Email</label>
                    <input type="email" name="email" class="form-control" id="exampleInputEmail" aria-describedby="emailHelp2">
                    <div id="emailHelp2" class="form-text">Confidential information</div>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPhone" class="form-label">Phone</label>
                    <input type="phone" name="phone" class="form-control" id="exampleInputPhone" aria-describedby="emailHelp3">
                    <div id="emailHelp3" class="form-text">Confidential information</div>
                </div>
                <div class="mb-3">
                    <label for="exampleInputAdress" class="form-label">Addess</label>
                    <input type="adress" name="address" class="form-control" id="exampleInputAdress" aria-describedby="emailHelp4">
                    <div id="emailHelp4" class="form-text">Confidential information</div>
                </div>
<%--                <input type="submit" />--%>
                    <button type="submit" class="btn btn-primary">Submit</button>

<%--        Login:<br/><input type="text" name="login" value="${login}"><br/>--%>
<%--</div>--%>
<%--<div class="mb-3">--%>
<%--    <label for="exampleInputPassword1" class="form-label">Password</label>--%>
<%--    <input type="password" name="password" class="form-control" id="exampleInputPassword1">--%>
<%--</div>--%>
<%--&lt;%&ndash;Password:<br/><input type="password" name="password"><br/>&ndash;%&gt;--%>
<%--E-mail:<br/><input type="text" name="email"><br/>--%>
<%--Phone:<br/><input type="text" name="phone"><br/>--%>
<%--Address:<br/><input type="text" name="address"><br/>--%>
<%--<input type="submit"/>--%>

<c:if test="${exists ne null}">
    <p>User already exists!</p>
</c:if>
</form>
</div>
</body>
</html>
