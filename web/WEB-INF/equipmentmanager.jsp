<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OurSafetyApp Equipment</title>
        <link href="CSS-MEDIA/Index.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Equipment Manager</h1>
        <table>
            <tr>
                <th>Model</th>
                <th>Serial</th>
            </tr>
            <c:forEach var="equipmentItem" items="${equipment}">
            <tr>
                
                <td>${equipmentItem.model}</td>
                <td>${equipmentItem.serialNumber}</td>
            </tr>
            </c:forEach>
        </table
    </body>
</html>