<%@ page import="java.util.List" %>
<%@ page import="Services.Implementation.LocationService" %>
<%@ page import="entities.Location" %>
<%@ page import="entities.enums.ReqStatus" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users list</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>There could be u r advertisement</h1>
</div>

<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Clients waiting</h2>
        </div>
        <c:if test="${( not empty sessionScope.clientsWaiting)}">
        <c:forEach var="l" items="${sessionScope.clientsWaiting}">
        <form action="/uber" method="post">
            <div>
                <p> ${l.toString()}   <input type="submit" name="command" value="accept"  /></p>
            </div>
        </c:forEach>
            </c:if>
        </form>
        <c:if test="${(sessionScope.ordersWaiting !=null)}">
        <div>
            <c:forEach var="l" items="${sessionScope.ordersWaiting}">
            <form action="/uber" method="post">
                <input type="hidden"  name="command" value="accept"  />
                <div>
                    <p> ${l.toString()}   <input type="submit" name=${l.taxi_id} value="accept"  /></p>
                </div>
                </c:forEach>
    </div>
        </c:if>

    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <a href="main.jsp">back to main</a>
</div>
</body>