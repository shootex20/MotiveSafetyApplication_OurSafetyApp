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
                <th>Item Information</th>
            </tr>
            <c:forEach var="equipmentItem" items="${equipment}">
            <tr>
                <td>${equipmentItem.itemID}</td>
                <td>${equipmentItem.model}</td>
                <td>${equipmentItem.serialNumber}</td>
                <td>${equipmentItem.dateAdded}</td>
                <td>${equipmentItem.userAdded}</td>
                <td>${equipmentItem.itemClassInformation}</td>
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
        ${message}
        <br>
        
        <h3>Add Equipment</h3>
        <br>
        <form method="post"> 
        <label for="title">Make/Model: </label>
        <input type="text" name="model" value="${newItem.model}">
        <br>
        <br>
        <label for="title">Serial Number: </label>
        <input type="text" name="serialnumber" value="${newItem.serialNumber}">
        <br>
        <br>
        <label for="isChargeable">Equipment is Chargeable?(Yes/No): </label>
        <select name="isChargeable" var="isChargeable">
            <option value="true">Yes</option>
            <option value="false">No</option>
        </select>
        <br>
        <br>
          <label for="isDepleting">Equipment Depletes? (Yes/No):  </label>
        <select name="isDepleting" var="isDepleting">
            <option value="true">Yes</option>
            <option value="false">No</option>
        </select>
        <br>
        <br>
        <label for="isDepreactiationType">Equipment Depreaction? (Yes/No):  </label>
        <select name="isDepreactiationType" var="isDepreactiationType">
            <option value="true">Yes</option>
            <option value="false">No</option>
        </select>
        <br>
        <br>
        <label for="itemnames">Item Information: </label>
        <input type="text" name="itemClassInformation" value="${newItem.itemClassInformation}">
        <br>
        <br>
        <label for="datePurchased">Date Purchased: </label>
        <input type="date" name="datePurchased" value="newItem.datePurchased"></date-input>
    <br>
    <br>
    <!--This is where the itemclass database starts! -->
     <label for="itemnames">Item Information: </label>
        <input type="text" name="itemnames" value="${newItemclass.itemType}">
        <br>
        <br>
      <!--This is where the itemclassfields database starts -->
      <!--  <label for="itemType">Type of Item: </label>
        <select name="itemType" id="itemType">
        <c:forEach items="${itemTypes}" var="itemType">
        <option value="${itemType.categoryID}">${itemType.categoryName}</option>
        </c:forEach>--->
        <br>
        <br>
        <label for="title">Brief Description: </label>
        <input type="text" name="fieldDescr" value="${itemclassfields.fieldDescr}">
        <br>
        <br>
        <label for="title">Type of Equipment: </label>
        <input type="text" name="fieldDescrType" value="${itemclassfields.fieldDescrType}">
        <br>
        <br>
        <input type="submit" name="action" value="Add">
        </form>
    </body>
</html>