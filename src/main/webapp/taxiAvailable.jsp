<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
            <h2>Taxi available</h2>

            <c:if test="${ not empty sessionScope.Order}">
                <div>
                    <a href="${pageContext.request.contextPath}/uber?command=getResponse">${sessionScope.Order}</a>
                </div>
            </c:if>
            <c:if test="${(sessionScope.Order ==null)}">
            <p>Wait please</p>
            </c:if>
        </div>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
     <a href="main.jsp">back to main</a>
</div>
</body>