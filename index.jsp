<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Uber</title>
</head>
<body>
<h1>Uber</h1>
<br/>
<br/>
<form action="${pageContext.request.contextPath}login.jsp" method="post">
    <input name="login" value="login" type="submit"/>
</form>
<form action="${pageContext.request.contextPath}register.jsp" method="post">
    <input name="register" value="register" type="submit"/>
</form>
</body>
</html>