
<%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 27.01.2021
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="stylesheet" href="loginStyle.css" media="screen" />
    <title>login</title>
  </head>
  <body background="BaTHWn4zvcA.jpg">

  <ul>
    <li><a href="newOrder.jsp">About</a></li>

  </ul>
<div>
  <form action="/uber" method="post">
    <td> <input type="hidden"  name="command" value="login"  /> </td>
    <table >
      <tr>
      <td>Username</td>
      <td> <input type="text" name="username"  /> </td></tr>
      <tr><td>Password</td><td> <input type="text" name="password" /> </td></tr>
      <tr><td>   <input type="submit" name="submit" value="login"  /> </td></tr>
    </table>
  </form>
</div>
  </body>
</html>
