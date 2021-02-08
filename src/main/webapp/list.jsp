<%@ page import="entities.Account" %>
<%@ page import="Services.Implementation.AccountService" %>
<%@ page import="exceptions.DaoException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="exceptions.ServiceException" %><%--
  Created by IntelliJ IDEA.
  User: Laptop
  Date: 03.02.2021
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <ul>
        <%
            AccountService accountService=new AccountService();
            try {
                List<Account> accounts = accountService.read();

                for (Account a : accounts) {
                    if(a.getUserType().toString().equals("TAXI")) {
                        out.println("<li>" + a + "</li>");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        %>
    </ul>
</head>
<body>

</body>
</html>