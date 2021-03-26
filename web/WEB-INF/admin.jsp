<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
            <%@include file="css/adminCSS.css" %>
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <title>MotiveSafety OurSafety Admin Functionality</title>
        <%-- <link href="CSS-MEDIA/Index.css" rel="stylesheet" type="text/css"> --%>


    </head>
    <body>
        <h1>MotiveSafety OurSafety Application</h1>
        <p><a href="admin?logout=logout">Logout</a></p>
        <h2>Manage Companies</h2>

        <div class="search_box">
            <input type="text" id="searchcomp" placeholder="search company table">
        </div>

        <table id="company_table">
            <tr>
                <th>Company Id</th>
                <th onclick="sortTable(0)">Date Added</th>
                <th >Name</th>
                <th>Short Name</th>
                <th>Description</th>
                <th>Account</th>
                <th>Industry</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>
            <c:forEach var="companys" items="${company}">
                <tr>
                    <td>${companys.companyID}</td>
                    <td><fmt:formatDate value="${companys.dateAdded}" pattern="dd/MM/YYYY"/></td>
                    <td>${companys.name}</td>
                    <td>${companys.shortname}</td>
                    <td>${companys.description}</td>
                    <td>${companys.account}</td>
                    <td>${companys.industry}</td>
                    <td>
                        <form action="admin" method="post" >
                            <input type="submit" value="Delete" onClick="return confirm('Are you sure you want to delete ${companys.name}?')">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="selectedCompany" value="${companys.companyID}">
                        </form>
                    </td>
                    <td>
                        <form action="admin" method="get">
                            <input type="submit" value="Edit">
                            <input type="hidden" name="action" value="view">
                            <input type="hidden" name="selectedCompany" value="${companys.companyID}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        ${message}
        <br>

        <c:if test="${selectedComp == null}">
            <h3>Add Company</h3>
            <form action="admin" method="POST">
                Name: <input type="text" name="compname" required placeholder="AAA_Company"><br>
                Short Name: <input type="text" name="shortname" required placeholder="AAA_Company"><br>
                Description: <input type="text" name="description"><br>

                Account: <input type="text" name="account"><br>
                Industry: <input type="text" name="industry"><br>
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Add Company">
            </form>
        </c:if>
        <c:if test="${selectedComp != null}">
            <h3>Edit Company</h3>
            <form action="admin" method="POST">

                Company ID: <input type="text" name="id" value="${selectedComp.companyID}" readonly=""><br> 
                Date Added: <input type="date" name="dateAdded" value="${selectedComp.dateAdded}" readonly=""><br> 
                Name: <input type="text" name="compname" value="${selectedComp.name}" ><br>
                Short Name: <input type="text" name="shortname" value="${selectedComp.shortname}"><br>
                Description: <input type="text" name="description" value="${selectedComp.description}"><br>
                Account: <input type="text" name="account" value="${selectedComp.account}"><br>
                Industry: <input type="text" name="industry" value="${selectedComp.industry}"><br>
                <input type="hidden" name="action" value="edit">
                <input type="submit" value="Save Edit">
            </form>
        </c:if>

        <!--for managers-->
        <h2>Manage Active Managers</h2>
         <div class="search_box">
            <input type="text" id="searchActiveManagers" placeholder="search active managers table">
        </div>
        <table id="activeManagersTable">
            <tr>
                <th>User Id</th>
                <th>Date Added</th>
                <th>Username</th>
                <th>Password</th>
                <th>Company Name</th>
                <th>Is Active?</th>
                <th>Is Admin</th>

                <th>Deactivate</th>

            </tr>
            <c:forEach var="user"  items="${activeManagers}">

                <tr>
                    <td>${user.userId}</td>
                    <td><fmt:formatDate value="${user.dateAdded}" pattern="dd/MM/YYYY"/></td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.companyID.name}</td>

                    <td>${user.isActive}</td>
                    <td>${user.isAdmin}</td>
                    <td>
                        <form action="admin" method="post" >
                            <input type="submit" value="Deactivate" onClick="return confirm('Are you sure you want to deactivate ${user.username}?')">
                            <input type="hidden" name="actionM" value="deleteM">
                            <input type="hidden" name="selectedMan" value="${user.userId}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        ${messageManager}
        <br>
        <h2>Manage In-Active Managers</h2>
        <div class="search_box">
            <input type="text" id="searchInActiveManagers" placeholder="search active managers table">
        </div>
        
        <table id="inActiveManagersTable">
            <tr>
                <th>User Id</th>
                <th>Date Added</th>
                <th>Username</th>
                <th>Password</th>
                <th>Company Name</th>
                <th>Is Active?</th>
                <th>Is Admin</th>

                <th>Reactivate</th>

            </tr>
            <c:forEach var="inActiveUser"  items="${inActiveManagers}">

                <tr>
                    <td>${inActiveUser.userId}</td>
                    <td><fmt:formatDate  value="${inActiveUser.dateAdded}" pattern="dd/MM/YYYY"/></td>
                    <td>${inActiveUser.username}</td>
                    <td>${inActiveUser.password}</td>
                    <td>${inActiveUser.companyID.name}</td>

                    <td>${inActiveUser.isActive}</td>
                    <td>${inActiveUser.isAdmin}</td>
                    <td>
                        <form action="admin" method="post" >
                            <input type="submit" value="Reactivate" onClick="return confirm('Are you sure you want to reactivate ${inActiveUser.username}?')">
                            <input type="hidden" name="actionM" value="Reactivate">
                            <input type="hidden" name="selectedManReactivate" value="${inActiveUser.userId}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <c:if test="${selectedManager == null}">
            <h3>Add Manager</h3>
            <form action="admin" method="POST">


                Username: <input type="text" name="username" placeholder="manager1" name="username" required ><br>
                Password: <input type="password" minlength="8" name="password" id="password"
                                 required title="Must be at least 8 characters long"><br>

                Confirm Password: <input type="password" required name="confirmPassword" 
                                         id="confirmPassword">  <br> 
  
                    <label for="userCompanyID">Company Name: </label>
                    <select name="userCompanyID" id="userCompanyID">
                        <c:forEach var="logincompanyID" items="${company}">
                            <c:choose>
                                <c:when test="${not empty selectedComp && selectedComp eq company.companyID}">
                                    <option value="${logincompanyID.companyID}" selected="true">${logincompanyID.name} </option>

                                </c:when>
                                <c:otherwise>
                                    <option value="${logincompanyID.companyID}">${logincompanyID.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>

                    <br>
                    <label for="isActive" name="isActive"> Is Active?: </label>
                    <select name="isActive" var="isActive">  
                        <option value="T">True</option>
                        <option value="F">False</option>
                    </select> <br>
                    <label for="isAdmin" name="isAdmin"> Is Admin?: </label>
                    <select name="isAdmin" var="isAdmin">  
                        <option value="F">False</option>
                        <option value="T">True</option>
                    </select> 

                    <br>

                    <input type="hidden" name="actionM" value="addUser">
                    <input type="submit" value="Add User" onclick="return passwordmatch()" class="btn btn-primary"> 
                    </form>
                </c:if>



                <script>
                    $(document).ready(function () {
                        // for company table
                        $("#searchcomp").on("keyup", function () {
                            var value = $(this).val().toLowerCase();
                            $("#company_table tbody tr + tr ").filter(function () {
                                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                            });
                        });
                        
                        
                        // for active managers table 
                         $("#searchActiveManagers").on("keyup", function () {
                            var value = $(this).val().toLowerCase();
                            $("#activeManagersTable tbody tr + tr").filter(function () {
                                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                            });
                        });
                        
                        
                         
                        // for inactive managers table 
                         $("#searchInActiveManagers").on("keyup", function () {
                            var value = $(this).val().toLowerCase();
                            $("#inActiveManagersTable tbody tr + tr").filter(function () {
                                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                            });
                        });
                        
                        
                    });
                </script>

                
                <script>
                    function passwordmatch() {
                        var password = document.getElementById("password").value;
                        var conPassword = document.getElementById("confirmPassword").value;
                        
                        
                        if (password != conPassword ) {
                            alert("Passwords do not match.");
                            return false;
                        }
                        return true;
                    }
                </script>

                </body>
                </html>