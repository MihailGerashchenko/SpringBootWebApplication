<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 20.10.2021
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<c:forEach var="p" items="${page}">
    <h3><c:out value="${p}"/></h3>
</c:forEach>

<div class="mt-3">
    <ul class="pagination">
        <li class="page-item disabled">
            <a class="page-link" href="#" tabindex="-1">Страницы</a>
        </li>
        <c:forEach var="p" items="${page}">
            <li class="page-item active">
                <a class="page-link" href="#" tabindex="-1">${p}</a>
            </li>
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1">...</a>
            </li>
            <li class="page-item">
                <a class="page-link" href="${url}?page=${p - 1}&size=${page.getSize()}" tabindex="-1">${p}</a>
            </li>
        </c:forEach>
    </ul>

<%--    <ul class="pagination">--%>
<%--        <li class="page-item disabled">--%>
<%--            <a class="page-link" href="#" tabindex="-1">Элементов на странице</a>--%>
<%--        </li>--%>
<%--        <#list [5, 10, 25, 50] as c>--%>
<%--        <#if c == page.getSize()>--%>
<%--        <li class="page-item active">--%>
<%--            <a class="page-link" href="#" tabindex="-1">${c}</a>--%>
<%--        </li>--%>
<%--        <#else>--%>
<%--        <li class="page-item">--%>
<%--            <a class="page-link" href="${url}?page=${page.getNumber()}&size=${c}" tabindex="-1">${c}</a>--%>
<%--        </li>--%>
<%--    </--%>
<%--    #if>--%>
<%--</--%>
<%--#list>--%>
<%--</ul>--%>
</div>
</body>
</html>
