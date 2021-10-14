<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Testing</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
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

    <div class="container">
        <h3>List of alloweded Tests </h3>

        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul id="groupList" class="nav navbar-nav">
                        <li><button type="button" id="add_contact" class="btn btn-default navbar-btn">Add Contact</button></li>
                        <li><button type="button" id="add_group" class="btn btn-default navbar-btn">Add Group</button></li>
                        <li><button type="button" id="delete_contact" class="btn btn-default navbar-btn">Delete Contact</button></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Groups <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/">Default</a></li>
                                <c:forEach items="${tests}" var="test">
                                    <li><a href="/test/${test.id}">${test.name}</a></li>
                                </c:forEach>
                            </ul>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left" role="search" action="/search" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" name="pattern" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

        <table class="table table-striped">
            <thead>
            <tr>
                <td></td>
                <td><b>Subject</b></td>
                <td><b>Question1</b></td>
                <td><b>Question2</b></td>
                <td><b>question3</b></td>
                <td><b>StudentMark</b></td>
                <td><b>Student</b></td>

            </tr>
            </thead>
            <c:forEach items="${tests}" var="test">
                <tr>
                    <td><input type="checkbox" name="toDelete[]" value="${test.id}" id="checkbox_${test.id}"/></td>
                    <td>${test.subject}</td>
                    <td>${test.question1}</td>
                    <td>${test.question2}</td>
                    <td>${test.question3}</td>
                    <td>${test.studentMark}</td>
                    <td>${test.customer}</td>
                    <c:choose>
                        <c:when test="${test.customer ne null}">
                            <td>${test.customer.name}</td>
                        </c:when>
                        <c:otherwise>
                            <td>Default</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
        </table>

        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:forEach var="i" begin="1" end="${pages}">
                    <li><a href="/?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                </c:forEach>
            </ul>
        </nav>
    </div>

    <script>
        // $('.dropdown-toggle').dropdown();
        //
        // $('#add_test').click(function(){
        //     window.location.href='/contact_add_page';
        // });
        //
        // $('#add_group').click(function(){
        //     window.location.href='/group_add_page';
        // });
        //
        // $('#delete_test').click(function(){
        //     var data = { 'toDelete[]' : []};
        //     $(":checked").each(function() {
        //         data['toDelete[]'].push($(this).val());
        //     });
        //     $.post("/contact/delete", data, function(data, status) {
        //         window.location.reload();
        //     });
        // });
    </script>
</body>
</html>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Prog.kiev.ua</title>--%>
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">--%>
<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>--%>
<%--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>--%>
<%--</head>--%>

<%--<body>--%>
<%--<div class="container">--%>
<%--    <h3><img height="50" width="55" />"/><a href="/">List of alloweded Tests </a></h3>--%>

<%--    <nav class="navbar navbar-default">--%>
<%--        <div class="container-fluid">--%>
<%--            <!-- Collect the nav links, forms, and other content for toggling -->--%>
<%--            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">--%>
<%--                <ul id="groupList" class="nav navbar-nav">--%>
<%--                    <li><button type="button" id="add_contact" class="btn btn-default navbar-btn">Add Contact</button></li>--%>
<%--                    <li><button type="button" id="add_group" class="btn btn-default navbar-btn">Add Group</button></li>--%>
<%--                    <li><button type="button" id="delete_contact" class="btn btn-default navbar-btn">Delete Contact</button></li>--%>
<%--                    <li class="dropdown">--%>
<%--                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Groups <span class="caret"></span></a>--%>
<%--                        <ul class="dropdown-menu">--%>
<%--                            <li><a href="/">Default</a></li>--%>
<%--                            <c:forEach items="${groups}" var="group">--%>
<%--                                <li><a href="/group/${group.id}">${group.name}</a></li>--%>
<%--                            </c:forEach>--%>
<%--                        </ul>--%>
<%--                    </li>--%>
<%--                </ul>--%>
<%--                <form class="navbar-form navbar-left" role="search" action="/search" method="post">--%>
<%--                    <div class="form-group">--%>
<%--                        <input type="text" class="form-control" name="pattern" placeholder="Search">--%>
<%--                    </div>--%>
<%--                    <button type="submit" class="btn btn-default">Submit</button>--%>
<%--                </form>--%>
<%--            </div><!-- /.navbar-collapse -->--%>
<%--        </div><!-- /.container-fluid -->--%>
<%--    </nav>--%>

<%--    <table class="table table-striped">--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <td></td>--%>
<%--            <td><b>Name</b></td>--%>
<%--            <td><b>Surname</b></td>--%>
<%--            <td><b>Phone</b></td>--%>
<%--            <td><b>E-mail</b></td>--%>
<%--            <td><b>Group</b></td>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <c:forEach items="${contacts}" var="contact">--%>
<%--            <tr>--%>
<%--                <td><input type="checkbox" name="toDelete[]" value="${contact.id}" id="checkbox_${contact.id}"/></td>--%>
<%--                <td>${contact.name}</td>--%>
<%--                <td>${contact.surname}</td>--%>
<%--                <td>${contact.phone}</td>--%>
<%--                <td>${contact.email}</td>--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${contact.group ne null}">--%>
<%--                        <td>${contact.group.name}</td>--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        <td>Default</td>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>

<%--    <nav aria-label="Page navigation">--%>
<%--        <ul class="pagination">--%>
<%--            <c:forEach var="i" begin="1" end="${pages}">--%>
<%--                <li><a href="/?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>--%>
<%--            </c:forEach>--%>
<%--        </ul>--%>
<%--    </nav>--%>
<%--</div>--%>

<%--<script>--%>
<%--    $('.dropdown-toggle').dropdown();--%>

<%--    $('#add_contact').click(function(){--%>
<%--        window.location.href='/contact_add_page';--%>
<%--    });--%>

<%--    $('#add_group').click(function(){--%>
<%--        window.location.href='/group_add_page';--%>
<%--    });--%>

<%--    $('#delete_contact').click(function(){--%>
<%--        var data = { 'toDelete[]' : []};--%>
<%--        $(":checked").each(function() {--%>
<%--            data['toDelete[]'].push($(this).val());--%>
<%--        });--%>
<%--        $.post("/contact/delete", data, function(data, status) {--%>
<%--            window.location.reload();--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>