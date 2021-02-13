<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
    <%@include file="css/equipmentCSS.css" %>
</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OurSafetyApp Equipment</title>
        <link href="CSS-MEDIA/Index.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Equipment Manager</h1>
        <br>
        <h3>Manage Current Equipment</h3>
        <table>
            <tr>
                <th>DB ID </th>
                <th>Model</th>
                <th>Serial</th>
                <th>Date Added</th>
                <th>UserID Added</th>
            </tr>
            <c:forEach var="equipmentItem" items="${equipment}">
            <tr>
                <td>${equipmentItem.itemID}</td>
                <td>${equipmentItem.model}</td>
                <td>${equipmentItem.serialNumber}</td>
                <td>${equipmentItem.dateAdded}</td>
                <td>${equipmentItem.userAdded}</td>
                <td>
                <form method="post"> 
                <input type="submit" name="action" value="Delete">
                <input type="hidden" name="itemID" value="${equipmentItem.itemID}">
                </form>
                </td>
            </tr>
            </c:forEach>
        </table>
        <br>
        <h3>Add Equipment</h3>
        <br>
        <label for="title">Make/Model</label>
        <input type="text" name="itemnames" value="${newItem.model}">
        <br>
        <label for="title">Serial Number</label>
        <input type="text" name="itemnames" value="${newItem.serialNumber}">
        <br>
        <label for="title">Serial Number</label>
        <input type="text" name="itemnames" value="${newItem.serialNumber}">
        <br>
        <select name="isChargeable" var="isChargeable">
            <option value="NoneSelected" label=" "></option>
            <option value="True">Yes</option>
            <option value="False">No</option>
        </select>
        <br>
        <select name="isDepleting" var="isDepleting">
            <option value="NoneSelected" label=" "></option>
            <option value="True">Yes</option>
            <option value="False">No</option>
        </select>
        <br>
        <select name="isDepreactiationType" var="isDepreactiationType">
            <option value="NoneSelected" label=" "></option>
            <option value="True">Yes</option>
            <option value="False">No</option>
        </select>
        <br>
        <label for="title">Item Information</label>
        <input type="text" name="itemnames" value="${newItem.itemClassInformation}">
    </body>
</html>