<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
                <style type="text/css">
            <%@include file="css/equipmentCSS.css" %>
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MotiveSafety OurSafety Admin Functionality</title>
        <link href="CSS-MEDIA/Index.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>MotiveSafety OurSafety Application</h1>
        <p><a href="admin?logout=logout">Logout</a></p>
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
                <th>Delete</th>
                <th>Edit</th>
            </tr>
            <c:forEach var="companys" items="${company}">
                <tr>
                    <td>${companys.companyID}</td>
                   <td>${companys.dateAdded}</td>
                    <td>${companys.name}</td>
                    <td>${companys.shortname}</td>
                    <td>${companys.description}</td>
                    <td>${companys.account}</td>
                    <td>${companys.industry}</td>
                    <td>
                        <form action="admin" method="post" >
                            <input type="submit" value="Delete">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="selectedCompany" value="${companys.companyID}">
                        </form>
                    </td>
                    <td>
                        <form action="admin" method="get">
                            <input type="submit" value="edit">
                            <input type="hidden" name="action" value="view">
                            <input type="hidden" name="selectedCompany" value="${companys.companyID}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <c:if test="${selectedComp == null}">
            <h3>Add Company</h3>
            <form action="admin" method="POST">
                Name: <input type="text" name="compname"><br>
                Short Name: <input type="text" name="shortname"><br>
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
        <h2>Manage Managers</h2>
        
        <table>
            <tr>
                <th>User Id</th>
                <th>Date Added</th>
                <th>Username</th>
                <th>Password</th>
                <th>Company Name</th>
                <th>Is Active?</th>
                <th>Is Admin</th>
          
                <th>Delete</th>
  
            </tr>
             <c:forEach var="user"  items="${logins}">
                
                    <tr>
                    <td>${user.userId}</td>
                    <td>${user.dateAdded}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.companyID.name}</td>
                    
                    <td>${user.isActive}</td>
                    <td>${user.isAdmin}</td>
                    <td>
                    <form action="admin" method="post" >
                            <input type="submit" value="Delete">
                            <input type="hidden" name="action" value="deleteM">
                            <input type="hidden" name="selectedMan" value="${user.userId}">
                        </form>
                    </td>
                    </tr>
            </c:forEach>
        </table>
       
             <c:if test="${selectedManager == null}">
            <h3>Add Manager</h3>
            <form action="admin" method="POST">
                
                
                 Username: <input type="text" name="username"><br>
                 Password: <input type="password" name="password"><br>
                       
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
                     <option value="T">True</option>
                    <option value="F">False</option>
                </select> 
           
                    <br>
           
                <input type="hidden" name="actionM" value="addUser">
                <input type="submit" value="Add User" class="btn btn-primary"> 
            </form>
        </c:if>
            
              
            <%--
        <c:if test="${selectedManager != null}">
            <h3>Edit Manager</h3>
            <form action="admin" method="POST">
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
            --%>

    </body>
</html>