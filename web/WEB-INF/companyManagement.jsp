
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>companyManagement JSP</title>
        <link href="CSS-MEDIA/Index.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="companyHeader">
            <h1>${companyName} & OurSafety</h1>
            <h3>Employee List</h3>
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Birthdate</th>
                    <th>Gender</th>
                    <th>Phone Number</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Position</th>
                    <th>Role</th>
                </tr>
                <c:forEach items="employeeList" var="emp">
                    <tr>
                        <th>${emp.firstName}</th>
                        <th>${emp.lastName}</th>
                        <th>${emp.birthdate}</th>
                        <th>${emp.gender}</th>
                        <th>${emp.phone}</th>
                        <th>${emp.email}</th>
                        <th>${emp.address}</th>
                        <th>${emp.position}</th>
                        <th>${emp.role}</th>
                    </tr>
                </c:forEach>
            </table>

        </div>
        <form action="company" method="post" class="companyForm">
            <h1>Add a new employee</h1>
            <input type="hidden" name="hidden_company" value="hiddenCompany">
            <label>First Name</label><input type="text" name="" value="">
            <label>Last Name</label><input type="text" name="" value="">
            <label>Birthdate</label><input type="text" name="" value="">
            <label>Gender</label><input type="text" name="" value="">
            <label>Phone Number</label><input type="text" name="" value="">
            <label>Email</label><input type="text" name="" value="">
            <label>Address</label><input type="text" name="" value="">
            <label>Position</label><input type="text" name="" value="">
            <label>Role</label><input type="text" name="" value="">
            <input type="submit" value="Add To Company">

        </form>
    </body>
</html>
