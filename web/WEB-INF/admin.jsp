
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
                <th>Commpany Id</th>
                <th>Date Added</th>
                <th>User Added</th>
                <th>Name</th>
                <th>Short Name</th>
                <th>Description</th>
                <th>Salt Hash</th>
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
        <c:if test="${selectedUser == null}">
            <h3>Add Company</h3>
            <form action="users" method="POST">
                Company Id: <input type="text" name="username"><br>
                Date Added <input type="password" name="password"><br>
                User Added: <input type="text" name="firstname"><br>
                Name: <input type="text" name="lastname"><br>
                Short Name: <input type="email" name="email"><br>
                Description: <input type="email" name="email"><br>
                Salt Hash: <input type="email" name="email"><br>
                Account: <input type="email" name="email"><br>
                Industry: <input type="email" name="email"><br>
                URL: <input type="email" name="email"><br>
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Save">
            </form>
        </c:if>
        <c:if test="${selectedUser != null}">
            <h3>Edit User</h3>
            <form action="users" method="POST">
                username: <input type="text" name="username" value="${selectedUser.username}" readonly><br>
                password: <input type="password" name="password" value="${selectedUser.password}"><br>
                first name: <input type="text" name="firstname" value="${selectedUser.firstname}"><br>
                last name: <input type="text" name="lastname" value="${selectedUser.lastname}"><br>
                email: <input type="email" name="email" value="${selectedUser.email}"><br>
                <input type="hidden" name="action" value="edit">
                <input type="submit" value="Save">
            </form>
        </c:if>
    </body>
</html>
