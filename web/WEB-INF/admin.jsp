<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
            <%@include file="css/adminCSS.css" %>
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MotiveSafety OurSafety Administrators</title>
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

            <c:forEach var="companys" items="${company}">
                <tr>
                    <td>${companys.companyID}</td>
                    <td>${companys.dateadded}</td>
                    <td>${companys.name}</td>
                    <td>${companys.shortname}</td>
                    <td>${companys.description}</td>
                    <td>${companys.account}</td>
                    <td>${companys.industry}</td>
                   <!-- <td>${comp.url}</td> -->
                    <td>
                        <form action="comps" method="post" >
                            <input type="submit" value="Delete">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="selectedCompany" value="${companys.companyID}">
                        </form>
                    </td>
                    <td>
                        <form action="comps" method="get">
                            <input type="submit" value="Edit">
                            <input type="hidden" name="action" value="view">
                            <input type="hidden" name="selectedCompany" value="${companys.companyID}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <c:if test="${selectedComp == null}">
            <h3>Add Company</h3>
            <form action="comps" method="POST">
                <label>Company Id: </label><input type="number" name="compid"><br>
                <label>Date Added </label><input type="date" name="dateadded"><br>
                <label>Name: </label><input type="text" name="compname"><br>
                <label>Short Name: </label><input type="text" name="shortname"><br>
                <label>Description: </label><input type="text" name="description"><br>
                <label>Account: </label><input type="text" name="account"><br>
                <label>Industry: </label><input type="text" name="industry"><br>
                <%--<label>URL: </label><input type="text" name="url"><br> --%>
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Save">
            </form>
        </c:if>
        <c:if test="${selectedComp != null}">
            <h3>Edit User</h3>
            <form action="comps" method="POST">
                <label>Company Id: </label><input type="number" name="compid" value="${selectedComp.compid}" readonly><br>
                <label>Date Added: </label><input type="date" name="dateadded" value="${selectedComp.dateadded}"><br>
                <label>Name: </label><input type="text" name="compname" value="${selectedComp.compname}"><br>
                <label>Short Name: </label><input type="text" name="shortname" value="${selectedComp.shortname}"><br>
                <label>Description: </label><input type="text" name="description" value="${selectedComp.description}"><br>
                <label>Account: </label><input type="text" name="account" value="${selectedComp.account}"><br>
                <label>Industry: </label><input type="text" name="industry" value="${selectedComp.industry}"><br>
                <%-- <label>URL: </label<input type="text" name="url" value="${selectedComp.url}"><br> --%>
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
                <label>Manager Id: </label><input type="number" name="managerID"><br>
                <label>Date Added </label><input type="date" name="dateAdded"><br>
                <label>Date Removed </label> <input type="date" name="dateRemoved"><br>
                <label>First Name: </label><input type="text" name="firstname"><br>
                <label>last Name: </label><input type="text" name="lastname"><br>
                <label>Email: </label><input type="email" name="email"><br>
                <label>Password: </label><input type="password" name="passwordAdd"><span>${passAddMsg}</span><br>
                <label>Company ID: </label><input type="number" name="companyID"><br>
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Save">
            </form>
            <form action="managers" method="POST">
                <input type="hidden" name="displayPass" value="showAdd">
                <input type="submit" value="Show Password"
            </form>
        </c:if>
        <c:if test="${selectedManager != null}">
            <h3>Edit User</h3>
            <form action="managers" method="POST">
                <label>Manager Id: </label><input type="number" name="managerID" value="${selectedManager.managerID}" readonly><br>
                <label>Date Added: </label><input type="date" name="dateAdded" value="${selectedManager.dateAdded}"><br>
                <label>Date Removed: </label><input type="date" name="dateRemoved" value="${selectedManager.dateRemoved}"><br>
                <label>First Name: </label><input type="text" name="firstname" value="${selectedManager.firstname}"><br>
                <label>Last Name: </label><input type="text" name="lastname" value="${selectedManager.lastname}"><br>
                <label>Email: </label><input type="email" name="email" value="${selectedManager.email}"><br>
                <label>Old Password: </label><input type="password" name="oldpassword"><span>${passEditOldMsg}</span><br>
                <label>New Password: </label><input type="password" name="newpassword"><span>passEditNewMsg</span><br>
                <label>Company ID: </label><input type="number" name="account" value="${selectedManager.account}"><br>
                <label>Industry: </label><input type="text" name="companyID" value="${selectedManager.companyID}" readonly><br>
                <input type="hidden" name="action" value="edit">
                <input type="submit" value="Save">
            </form>
            <form action="managers" method="POST">
                <input type="hidden" name="displayPass" value="showEdit">
                <input type="submit" value="Show Password"
            </form>
        </c:if>

    </body>
</html>