<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
            <%@include file="css/login.css" %>
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login JSP</title>
    </head>
    <body>
        <div class="loginHeader">
            <h1>MotiveSafety OurSafety Application</h1>
            <h2>Occupational Health & Safety Consultants</h2>
            <h3>Preventative Maintenance Program</h3>
            <p>${loginMsg}</p>
        </div>
        <form action="login" method="post" class="loginForm">
            <label>Username: </label><input type="text" name="username_input">
            <label>Password: </label><input type="password" name="password_input">
            <input type="submit" value="Log in">
        </form>
    </body>
</html>