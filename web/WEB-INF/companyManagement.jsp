<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
            <%@include file="css/company.css" %>
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>companyManagement JSP</title>
    </head>
    <body>
        <header class="companyHeader">
            <ul>
                <li><a href=" <c:url value='/company'/> ">${companyName} Company Page</a></li>
                <li><a href=" <c:url value='/equipment'/> ">Equipment Page</a></li>
                <li><a href=" <c:url value='/manual'/> ">Safety Page</a></li>
                <li><a href=" <c:url value='/admin'/>" >Administrator Page</a></li>
                <li><a href="login?action=logout">Logout</a></li>
            </ul>
        </header>
    </body>
</html>