<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
            <%@include file="css/forgot.css" %>
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Assistance</title>
    </head>
    <body>
        <h1>Have you forgotten your password?</h1>
        <h3>Enter your information to reset it</h3>
        <form action="forgot" method="post" class="">
            <label>User name: </label><br><input type="text" name="usern_input"><br>
            <label>Email: </label><br><input type="email" name="email_input"><br>
            <label>First name: </label><br><input type="text" name="firstn_input"><br>
            <label>Last name: </label><br><input type="text" name="lastn_input"><br>
            <label>Birth Date: </label><br><input type="date" name="dob_input"><br>
            <label>Phone number: </label><br><input type="tel" name="phone_input"><br>
            <input type="submit" value="Reset password" class="">
            <br>
            <span>${resetMsg}</span>
        </form>
    </body>
</html>
