<%-- 
    Document   : companyWelcome
    Created on : 22-Feb-2021, 4:58:28 PM
    Author     : 809968
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
            <%@include file="css/company.css" %>
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company Page</title>
    </head>

    <body>
        <h1>Welcome ${companyName}</h1>
        <h3>Choose your option here: </h3>

        <header class="companyWelcomHeader">
            <ul>
                <li><a href="company?company">${companyName} Company Page</a></li>
                <li><a href="equipmentmanager">Equipment page</a></li>
                <li><a href="manual?manual">Manual Page</a></li>
                <li><a href="employee?employee">Employee page</a></li>
                <li><a href="companyWelcome?action=logout">Logout</a></li>            
            </ul>
        </header>

    </body>
</html>
