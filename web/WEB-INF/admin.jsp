
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MotiveSafety OurSafety Admin Functionality</title>
        <link href="CSS-MEDIA/Index.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>MotiveSafety OurSafety Application</h1>
        <h2>Manage Companies</h2>
        <table>
            <tr>
                <th>Company Id</th>
                <th>Date Added</th>
                <th>Name</th>
                <th>Short Name</th>
                <th>Description</th>
                <th>Account</th>
                <th>Industry</th>
                <th>URL</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>
            
              <c:forEach var="comp" items="${comps}">
                <tr>
                    <td>${comp.compid}</td>
                    <td>${comp.dateadded}</td>
                    <td>${comp.compname}</td>
                    <td>${comp.shortname}</td>
                    <td>${comp.description}</td>
                    <td>${comp.account}</td>
                    <td>${comp.industry}</td>
                    <td>${comp.url}</td>
                    <td>
                        <form action="comps" method="post" >
                            <input type="submit" value="Delete">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="selectedUsername" value="${comp.compid}">
                        </form>
                    </td>
                    <td>
                        <form action="users" method="get">
                            <input type="submit" value="Edit">
                            <input type="hidden" name="action" value="view">
                            <input type="hidden" name="selectedUsername" value="${comp.compid}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${selectedComp == null}">
            <h3>Add Company</h3>
            <form action="comps" method="POST">
                Company Id: <input type="text" name="compid"><br>
                Date Added <input type="text" name="dateadded"><br>
                Name: <input type="text" name="compname"><br>
                Short Name: <input type="text" name="shortname"><br>
                Description: <input type="text" name="description"><br>
                
                Account: <input type="text" name="account"><br>
                Industry: <input type="text" name="industry"><br>
                URL: <input type="text" name="url"><br>
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Save">
            </form>
        </c:if>
        <c:if test="${selectedComp != null}">
            <h3>Edit User</h3>
            <form action="comps" method="POST">
                Company Id: <input type="text" name="compid" value="${selectedComp.compid}" readonly><br>
                Date Added: <input type="text" name="dateadded" value="${selectedComp.dateadded}"><br>
                Name: <input type="text" name="compname" value="${selectedComp.compname}"><br>
                Short Name: <input type="text" name="shortname" value="${selectedComp.shortname}"><br>
                Description: <input type="text" name="description" value="${selectedComp.description}"><br>
                Account: <input type="text" name="account" value="${selectedComp.account}"><br>
                Industry: <input type="text" name="industry" value="${selectedComp.industry}"><br>
                URL: <input type="text" name="url" value="${selectedComp.url}"><br>
                <input type="hidden" name="action" value="edit">
                <input type="submit" value="Save">
            </form>
        </c:if>
            
            
            <!--for managers
             <h2>Manage Managers</h2>
        <table>
            <tr>
                <th>Company Id</th>
                <th>Date Added</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Description</th>
                <th>Account</th>
                <th>Industry</th>
                <th>URL</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>
            
              <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.firstname}</td>
                    <td>${user.lastname}</td>
                    <td>
                        <form action="users" method="post" >
                            <input type="submit" value="Delete">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="selectedUsername" value="${user.username}">
                        </form>
                    </td>
                    <td>
                        <form action="users" method="get">
                            <input type="submit" value="Edit">
                            <input type="hidden" name="action" value="view">
                            <input type="hidden" name="selectedUsername" value="${user.username}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
            
            -->
            
    </body>
</html>
