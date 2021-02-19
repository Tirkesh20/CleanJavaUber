<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="mainStyle.css" media="screen">
    <title>Account  Form</title>
</head>
<body>
<ul>
    <c:if test="${(sessionScope.account.userType == 'CLIENT')}">
        <li><a class="active" href="main.jsp">Home</a></li>
        <li><a href="newOrder.jsp">New order</a></li>
        <li><a href="${pageContext.request.contextPath}/uber?command=create_order">My orders</a></li>
        <li><a href="${pageContext.request.contextPath}/uber?command=logout">Logout</a></li>
        <li><a href="accountUpdate.jsp">${sessionScope.account.username}</a></li>

    </c:if>
    <c:if test="${(sessionScope.account.userType == 'ADMIN')}">
        <li><a class="active" href="main.jsp">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/uber?command=userList">Users</a></li>
        <li><a href="${pageContext.request.contextPath}/uber?command=orders">Orders</a></li>
        <li><a href="${pageContext.request.contextPath}/uber?command=logout">Logout</a></li>
        <li><a href="accountUpdate.jsp">${sessionScope.account.username}</a></li>
    </c:if>
    <c:if test="${(sessionScope.account.userType == 'TAXI')}">
        <li><a class="active" href="main.jsp">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/uber?command=locationList">My orders</a></li>
        <li><a href="${pageContext.request.contextPath}/uber?command=logout">Logout</a></li>
        <li style="float:right"> <a href="accountUpdate.jsp">${sessionScope.account.username}</a></li>
    </c:if>
</ul>

<div align="center">
    <form action="/uber"  method="post"><tr>
        <td> <input type="hidden"  name="command" value="account_update"  /> </td>
    </tr>

        <table style="margin-top:150px;margin-left:20px;margin-right: 20px " >
            <tr>
                <td>First name</td>
                <td> <input type="text" name="firstname"  /> </td>
            </tr>
            <tr>
                <td>Last name</td>
                <td> <input type="text" name="lastname"  /> </td>
            </tr>
            <tr>
                <td>Username</td>
                <td> <input type="text" name="username"  /> </td>
            </tr>
            <tr>
                <td>email</td>
                <td> <input type="text" name="email"  /> </td>
            </tr>
            <tr>
                <td>Password</td>
                <td> <input type="password" name="password"  /> </td>
            </tr>
            <tr>
                <td>Usertype</td>
                <td> <input type="text" name="user_type"  /> </td>
            </tr>
            <tr><td>   <input type="submit" name="submit" value="Change" /> </td>></tr>
        </table>
    </form>
</div>
</body>
</html>
