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
    <title>Account Registration Form</title>
  </head>
  <body>
  <div align="center">
  <form action="Register" method="post">
    <table style="background-color: aquamarine;margin-left:20px;margin-right: 20px " >
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
    <td> <input type="text" name="Username"  /> </td>
  </tr>
  <tr>
    <td>email</td>
    <td> <input type="text" name="Email"  /> </td>
  </tr>
  <tr>
    <td>Password</td>
    <td> <input type="text" name="Password"  /> </td>
  </tr>
  <tr>
    <td>User type</td>
    <td> <input type="text" name="User type"  /> </td>
  </tr>
    <tr><td>   <input type="submit" name="submit" value="Register"  /> </td>></tr>
  </table>
  </form>
  </div>
  </body>
</html>
