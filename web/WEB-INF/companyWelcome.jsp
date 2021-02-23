<%-- 
    Document   : companyWelcome
    Created on : 22-Feb-2021, 4:58:28 PM
    Author     : 809968
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Company Page</title>
    </head>
    
    <body>
          <h1>Welcome ${companyName}</h1>
          <h3>Choose your option here: </h3>
          
          <header class="companyWelcomHeader">
            <ul>
                <li><a href="company?company">${companyName} Company Page</a></li>
                <li><a href="equipmentmanager">equipment page</a></li>
                <li><a href="manual?manual">manual Page</a></li>
                <li><a href="employeeDraft?employeeDraft">employee Draft page</a></li>
                <li><a href="login?action=logout">Logout</a></li>            
            </ul>
        </header>
      
    </body>
</html>