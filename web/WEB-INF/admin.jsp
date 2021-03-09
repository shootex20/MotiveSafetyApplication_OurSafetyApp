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
        
        <%--
        <div class="form-group">
            <form method="post">
                
        <label>Company Name: </label>
        <select name="companyNames" id="companyNames">
            <c:forEach var="companys" items="${company}">
              
                <c:choose>
                            <c:when test="${not empty selectedComp && selectedComp eq company.companyID}">
                                <option value="${company.companyID}" selected = "true">${company.name}</option>
                            </c:when>
                            <c:otherwise>
                            <option value="${company.companyID}">${company.name}</option>
                            </c:otherwise>
                         </c:choose>
         <option value="${companys.name}" ${companys.companyID == selectedComp ? 'selected="selected"' : ''}> ${companys.getName()}</option> 
         
            </c:forEach>
                             <input type="hidden" name="action" value="addform">
        </select>
         <br>
                    <input type="hidden" name="selectedComp" value="">
                    <input type="submit" id="addbutton" class="btn btn-primary" value="Load Managers">
                    <br>
                    <br>
            </form>
        </div>
        --%>
        <table>
            <tr>
                <th>User Id</th>
                <th>Date Added</th>
                <th>Username</th>
                <th>Password</th>
                <th>Company Id</th>
                <th>Is Active?</th>
                <th>Is Admin</th>
                <<%-- 
                <th>First Name</th>
                <th>Last Name</th>
                <th>Date of Birth</th>
                <th>Gender</th>--%>
                <th>Delete</th>
                <%--   <th>Email</th>
                 --%>
            </tr>
             <c:forEach var="user"  items="${logins}">
                
                    <tr>
                    <td>${user.userId}</td>
                    <td>${user.dateAdded}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.companyID.companyID}</td>
                    
                    <td>${user.isActive}</td>
                    <td>${user.isAdmin}</td>
                    
                  <%--
                    <td>${user.personID.firstName}</td>
                    <td>${user.personID.lastName}</td>
                    <td>${user.personID.dateOfBirth}</td>
                    <td>${user.personID.gender}</td>
                    <td>${user.personID..email}</td> --%>
                    </tr>
              
               
              <%--
                    <td>
                        <form action="admin" method="post" >
                            <input type="submit" value="Delete">
                            <input type="hidden" name="actionM" value="delete">
                            <input type="hidden" name="selectedUser" value="${user.userId}">
                        </form>
                    </td>
                                        
  <%--
                    <td>
                        <form action="admin" method="get">
                            <input type="submit" value="Edit">
                            <input type="hidden" name="actionM" value="view">
                            <input type="hidden" name="selectedManager" value="${persons.personID}">
                        </form>
                    </td>
                   
                    
                </tr>
            --%>
            
            </c:forEach>
                  
        </table>
        <h3>Add Manager</h3>
        <div class="admin-group">
            <form method="admin">
                <label for="managerCompany">Company Name: </label>
                <select name="managerCompany" id="managerCompany">
                    <c:forEach var="companyNames" items="${company}">
                        <c:choose>
                            <c:when test="${not empty selectedComp && selectedComp eq company.companyID}">
                                <option value="${companyNames.companyID}" selected="true">${companyNames.name} </option>
                                
                            </c:when>
                            <c:otherwise>
                                <option value="${companyNames.companyID}">${companyNames.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    
                </select>
                <br>
                    <input type="hidden" name="selectedComp" value="">
                    <input type="submit" id="addCompanybutton" class="btn btn-primary" value="Select Company">
                    <br>
                    <br>
            </form>
            <c:if test="${selectedManager == null}">
                <form method="admin">
                    Username: <input type="text" name="username"><br>
                    Password: <input type="text" name="password"><br>
                    Company ID <input type="date" name="compID"><br>
                    <label for="isActive"> Is Active?: </label>
                <select name="isActive" var="isActive">  
                     <option value="T">True</option>
                    <option value="F">False</option>
                </select> <br>
                     <label for="isAdmin"> Is Admin?: </label>
                <select name="isAdmin" var="isAdmin">  
                     <option value="T">True</option>
                    <option value="F">False</option>
                </select> 
                    
                    
                    <br>
           
                <input type="hidden" name="actionM" value="add">
                <input type="submit" value="Add User" class="btn btn-primary"> 
                </form>
            </c:if>
        </div>
        
        
        
        
        
        <%--
        <c:if test="${selectedManager == null}">
            <h3>Add Manager</h3>
            <form action="admin" method="POST">
              <!--  Manager Id: <input type="number" name="managerID"><br> -->
              <!--  Date Added <input type="date" name="dateAdded"><br> -->
              <!--  Date Removed <input type="date" name="dateRemoved"><br> -->
              
                Username: <input type="text" name="username"><br>
                Password: <input type="text" name="password"><br>
                <label for="isActive"> Is active? (Yes/No): </label>
                <select name="isActive" var="isActive">  
                     <option value="true">Yes</option>
                    <option value="false">No</option>
                </select> <br>
                <label for="isAdmin"> Is admin? (Yes/No): </label>
                <select name="isAdmin" var="isAdmin">  
                     <option value="true">Yes</option>
                    <option value="false">No</option>
                </select> <br>
           
                <input type="hidden" name="actionM" value="add">
                <input type="submit" value="Add User"> 
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