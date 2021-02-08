<%@ page import="java.util.List" %>
<%@ page import="Services.Implementation.AccountService" %>
<%@ page import="entities.Account" %>
<%@ page import="entities.Location" %>
<%@ page import="Services.Implementation.LocationService" %>
<%@ page import="entities.enums.ReqStatus" %>
<%@ page import="entities.enums.UserType" %>
<%@ page import="entities.enums.DriverStatus" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        </div>
        <%
            AccountService accountService=new AccountService();
            try {
                    List<Account> accounts = accountService.read();
                    if(!accounts.isEmpty()) {
                        out.println("<ul class=\"w3-ul\">");
                    for (Account a : accounts) {
                        if(a.getUserType().equals(UserType.TAXI)&&a.getStatus().equals(DriverStatus.WAITING))
                        {
                            out.println("<li class=\"w3-hover-sand\">"+"Taxi"+a.getUsername()+ "</li>");
                        }
                        out.println("</ul>");
                    }
                }else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                        +
                        "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                        "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                        "   <h5>There are no users yet!</h5>\n" +
                        "</div>");
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
     <a href="main.jsp">back to main</a>
</div>
</body>