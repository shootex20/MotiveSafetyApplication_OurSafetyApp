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
        <h3>Enter your email to reset it</h3>
        <form action="forgot" method="post" class="">
            <input type="hidden" name="token" value="<c:out value="${token}"/>">
            <label>Email: </label><input type="email" name="username_input" <c:out value=""></c:out>><br><br>
                <input type="submit" value="Reset password" class="">
                <br>
                <br>
                <br>
                <br>
                <a href="<c:url value='/login'/>">Go back to the log in page</a>
            <br>
            <span>${resetMsg}</span>
        </form>
    </body>
</html>
