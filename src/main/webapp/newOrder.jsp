<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 01.02.2021
  Time: 0:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="mainStyle.css" media="screen" />
    <title>$Title$</title>
</head>
<body>
<div>
    <form action="/uber" method="post">
        <td> <input type="hidden"  name="command" value="create_location"  /> </td>
        <table style="background-color: #836ef8;margin-left:20px;margin-right: 20px " >
            <tr>
                <td>From</td>
                <td> <input type="text" name="street_from"  /> </td></tr>
            <tr><td>To</td><td> <input type="text" name="street_to" /> </td></tr>
            <tr><td>   <input type="submit" name="submit" value="location_submit"  /> </td></tr>
        </table>
    </form>
    <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
        <a href="main.jsp">back to main</a>
    </div>
</div>
</body>
</html>