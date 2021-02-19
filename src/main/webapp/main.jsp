<%@ page import="entities.Account" %>
<%@ page import="entities.enums.UserType" %>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="mainStyle.css" media="screen">
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<ul>
    <c:if test="${(sessionScope.account.userType == 'CLIENT')}">
        <li><a class="active" href="main.jsp">Home</a></li>
        <li><a href="newOrder.jsp">New order</a></li>
        <li><a href="${pageContext.request.contextPath}/uber?command=create_order">My orders</a></li>
        <li><a href="${pageContext.request.contextPath}/uber?command=logout">Logout</a></li>
        <li style="float:right"><a href="accountUpdate.jsp">${sessionScope.account.username}</a></li>

    </c:if>
    <c:if test="${(sessionScope.account.userType == 'ADMIN')}">
        <li><a class="active" href="main.jsp">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/uber?command=userList">Users</a></li>
        <li><a href="${pageContext.request.contextPath}/uber?command=orders">Orders</a></li>
        <li><a href="${pageContext.request.contextPath}/uber?command=logout">Logout</a></li>
        <li style="float:right"><a href="accountUpdate.jsp">${sessionScope.account.username}</a></li>
    </c:if>
    <c:if test="${(sessionScope.account.userType == 'TAXI')}">
        <li><a class="active" href="main.jsp">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/uber?command=ordersWaiting">My orders</a></li>
        <li><a href="${pageContext.request.contextPath}/uber?command=logout">Logout</a></li>
        <li style="float:right"> <a href="accountUpdate.jsp">${sessionScope.account.username}</a></li>
    </c:if>
</ul>
</body>
</html>