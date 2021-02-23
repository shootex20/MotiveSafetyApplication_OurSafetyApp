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
                <!--  <th>URL</th> -->
                <th>Delete</th>
                <th>Edit</th>
            </tr>
            <%--
              <c:forEach var="comp" items="${comps}">
                <tr>
                    <td>${comp.compid}</td>
                    <td>${comp.dateadded}</td>
                    <td>${comp.compname}</td>
                    <td>${comp.shortname}</td>
                    <td>${comp.description}</td>
                    <td>${comp.account}</td>
                    <td>${comp.industry}</td>
                   <!-- <td>${comp.url}</td> -->
                    <td>
                        <form action="comps" method="post" >
                            <input type="submit" value="Delete">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="selectedCompany" value="${comp.compid}">
                        </form>
                    </td>
                    <td>
                        <form action="users" method="get">
                            <input type="submit" value="Edit">
                            <input type="hidden" name="action" value="view">
                            <input type="hidden" name="selectedCompany" value="${comp.compid}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            --%>
        </table>
        <c:if test="${selectedComp == null}">
            <h3>Add Company</h3>
            <form action="comps" method="POST">
                Company Id: <input type="number" name="compid"><br>
                Date Added <input type="date" name="dateadded"><br>
                Name: <input type="text" name="compname"><br>
                Short Name: <input type="text" name="shortname"><br>
                Description: <input type="text" name="description"><br>

                Account: <input type="text" name="account"><br>
                Industry: <input type="text" name="industry"><br>
                <!--  URL: <input type="text" name="url"><br> -->
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Save">
            </form>
        </c:if>
        <c:if test="${selectedComp != null}">
            <h3>Edit User</h3>
            <form action="comps" method="POST">
                Company Id: <input type="number" name="compid" value="${selectedComp.compid}" readonly><br>
                Date Added: <input type="date" name="dateadded" value="${selectedComp.dateadded}"><br>
                Name: <input type="text" name="compname" value="${selectedComp.compname}"><br>
                Short Name: <input type="text" name="shortname" value="${selectedComp.shortname}"><br>
                Description: <input type="text" name="description" value="${selectedComp.description}"><br>
                Account: <input type="text" name="account" value="${selectedComp.account}"><br>
                Industry: <input type="text" name="industry" value="${selectedComp.industry}"><br>
               <!-- URL: <input type="text" name="url" value="${selectedComp.url}"><br> -->
                <input type="hidden" name="action" value="edit">
                <input type="submit" value="Save">
            </form>
        </c:if>


        <!--for managers-->
        <h2>Manage Managers</h2>
        <table>
            <tr>
                <th>Manager Id</th>
                <th>Date Added</th>
                <th>Date Removed</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Company ID</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>

            <c:forEach var="managers" items="${managers}">
                <tr>
                    <td>${managers.managerID}</td>
                    <td>${managers.dateAdded}</td>
                    <td>${managers.dateRemoved}</td>
                    <td>${managers.firstName}</td>
                    <td>${managers.lastName}</td>
                    <td>${managers.email}</td>
                    <td>${managers.companyID}</td>
                    <td>
                        <form action="managers" method="post" >
                            <input type="submit" value="Delete">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="selectedManager" value="${managers.managerID}">
                        </form>
                    </td>
                    <td>
                        <form action="managers" method="get">
                            <input type="submit" value="Edit">
                            <input type="hidden" name="action" value="view">
                            <input type="hidden" name="selectedManager" value="${managers.selectedManager}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${selectedManager == null}">
            <h3>Add Manager</h3>
            <form action="managers" method="POST">
                Manager Id: <input type="number" name="managerID"><br>
                Date Added <input type="date" name="dateAdded"><br>
                Date Removed <input type="date" name="dateRemoved"><br>
                First Name: <input type="text" name="firstname"><br>
                last Name: <input type="text" name="lastname"><br>
                Email: <input type="email" name="email"><br>
                Company ID: <input type="number" name="companyID"><br>

                <input type="hidden" name="action" value="add">
                <input type="submit" value="Save">
            </form>
        </c:if>
        <c:if test="${selectedManager != null}">
            <h3>Edit User</h3>
            <form action="managers" method="POST">
                Manager Id: <input type="number" name="managerID" value="${selectedManager.managerID}" readonly><br>
                Date Added: <input type="date" name="dateAdded" value="${selectedManager.dateAdded}"><br>
                Date Removed: <input type="date" name="dateRemoved" value="${selectedManager.dateRemoved}"><br>
                First Name: <input type="text" name="firstname" value="${selectedManager.firstname}"><br>
                Last Name: <input type="text" name="lastname" value="${selectedManager.lastname}"><br>
                Email: <input type="email" name="email" value="${selectedManager.email}"><br>
                Company ID: <input type="number" name="account" value="${selectedManager.account}"><br>
                Industry: <input type="text" name="companyID" value="${selectedManager.companyID}" readonly><br>
                <input type="hidden" name="action" value="edit">
                <input type="submit" value="Save">
            </form>
        </c:if>



    </body>
</html>