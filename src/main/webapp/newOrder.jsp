<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 01.02.2021
  Time: 0:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="newOrderStyle.css" media="screen"/>
    <title>$Title$</title>
    <script src="https://api-maps.yandex.ru/2.1/?apikey=<99b6fdef-3c81-4a66-b727-df5e1b2838a2>&lang=ru_RU" type="text/javascript">
    </script>
    <script src="./index.js"></script>
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
        <li style="float:right"><a href="accountUpdate.jsp">${sessionScope.account.username}</a></li>
    </c:if>
</ul>

<div>
    <form action="/uber" method="post">
        <td><input type="hidden" name="command" value="create_order"/></td>
        <table style="background-color: #836ef8;margin-left:20px;margin-right: 20px ">
            <tr>
                <td>Lng</td>
                <td><input id="fromlng" type="text" onchange="elog('change',this);return false;"   name="lng"/></td>
                <td>Lat</td>
                <td><input id="fromlat" type="text" onchange="elog('change',this);return false;"  name="lat"/></td>
            <tr>
                <td>Lng2</td>
                <td><input id="tolng" onchange="elog('change',this);return false;"  type="text" name="lng2"/></td>
                <td>Lat2</td>
                <td><input id="tolat" onchange="elog('change',this);return false;" type="text" name="lat2"/></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="Search a taxi"/></td>
            </tr>
        </table>
    </form>
    <div>
        <a href="main.jsp">back to main</a>
    </div>
</div>
<div id="map" style="width:100%;height:400px;"></div>
</body>
</html>