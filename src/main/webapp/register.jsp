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
    <link rel="stylesheet" href="Registration.css" media="screen" />
    <title>Account Registration Form</title>
  </head>
  <body>

  <div align="center">
  <form action="/uber"  method="post"><tr>
    <td> <input type="hidden"  name="command" value="account_create"  /> </td>
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
    <tr><td>   <input type="submit" name="submit" value="Register" /> </td>></tr>
  </table>
  </form>
  </div>
  </body>
</html>
