<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>equipment JSP</title>
        <link href="CSS-MEDIA/Index.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Equipment Manager</h1>
        <table>
            <tr>
                <th>Item</th>
                <th>Model</th>
                <th>Serial</th>
                <th>Depleting Type</th>
                <th>Chargeable Type</th>
                <th>Description</th>
                <th>Description Type</th>
            </tr>
            <c:forEach var="equipmentItems" items="${equipment}">
            <tr>
                <td>${equipment.item}</td>
                <td>${equipment.model}</td>
                <td>${equipment.serial}</td>
                <td>${equipment.depletingType}</td>
                <td>${equipment.chargeableType}</td>
                <td>${equipment.description}</td>
                <td>${equipment.descriptionType}</td>
                <td>
                    <form method="post" >
                         <input type="submit" value="Delete">
                            <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="selectedSerial" value="${equipment.serial}">
                    </form>
                </td>
                <td>
                    <form action="admin" method="get">
                        <input type="submit" value="Edit">
                        <input type="hidden" name="action" value="view">
                        <input type="hidden" name="selectedSerial" value="${equipment.serial}">
                    </form>
                </td>
            </tr>
            </c:forEach>
        </table
        
        <c:if test="${selectedCat == null}">
            <h2>Add Equipment</h2>
            <form method="POST">
                Category Name: <input type="text" name="nameofCat" value="${selectedCat.categoryName}"><br>
                <br>
                <input type="hidden" name="action" value="addCat">
                <input type="submit" value="Save">
            </form>
        </c:if>
        <c:if test="${selectedCat != null}">
            <h2>Edit Equipment</h2>
            <form action="admin" method="POST">
                Category Name: <input type="text" name="nameOfCat" value="${selectedCat.categoryName}">
                <input type="hidden" name="catID" value="${selectedCat.categoryID}"><br>
                <br>
                    <input type="hidden" name="action" value="editCat">
                    <input type="submit" value="Save">
                </form>
            </c:if>
    </body>
</html>