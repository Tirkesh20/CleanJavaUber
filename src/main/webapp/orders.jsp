<%--
  Created by IntelliJ IDEA.
  User: WTF
  Date: 13.02.2021
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Users list</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Z-Project</h1>
</div>
<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Orders</h2>
        </div>
        <c:forEach var="l" items="${sessionScope.orders}">
                <c:if test="${l.status=='DONE'}">
                    <div>
                        ${l}
                    </div>
                </c:if>>
        </c:forEach>
        <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
            <a href="main.jsp">back to main</a>
        </div>
    </div>
</div>

<%--<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">--%>
<%--    <button class="w3-btn w3-round-large" onclick="location.href='mainAdmin.css'">Back to main</button>--%>
<%--</div>--%>
</body>
</html>