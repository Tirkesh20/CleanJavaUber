<%@ page import="entities.Account" %>
<%@ page import="entities.enums.UserType" %>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

    Account account = (Account)session.getAttribute("account");
    if (account == null) {
        response.sendRedirect("index.jsp");
    }
    if (account.getUserType().equals(UserType.CLIENT)) {%>
<ul>
    <li><a href="newOrder.jsp">New order</a></li>
    <li><a href="taxiAvailable.jsp">My orders</a></li>
    <li><a href="accountUpdate.jsp">Account</a></li>
    <li><a href="${pageContext.request.contextPath}/uber?command=logout">Logout</a></li>
</ul>
<% } else if (account.getUserType().equals(UserType.ADMIN)){ %>
<ul>
    <li><a href="users.jsp">Users</a></li>
    <li><a href="newOrder.jsp">Orders</a></li>
    <li><a href="accountUpdate.jsp">Account</a></li>
    <li><a href="${pageContext.request.contextPath}/uber?command=logout">Logout</a></li>
</ul>
<% }else  if(account.getUserType().equals(UserType.TAXI)){  %>
<ul>
    <li><a href="requests.jsp">My orders</a></li>
    <li><a href="accountUpdate.jsp">Account</a></li>
    <li><a href="${pageContext.request.contextPath}/uber?command=logout">Logout</a></li>
</ul>
<%}%>
</body>
</html>