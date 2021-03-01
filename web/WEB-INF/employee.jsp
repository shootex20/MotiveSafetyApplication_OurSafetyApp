<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
            <%@include file="css/employee.css" %>
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee JSP</title>
    </head>
    <body>    
        <header class="employeeHeader">
            <ul>
                <li><a href="company?company">${companyName} Page</a></li>
                <li><a href="companyWelcome?companyWelcome">${companyName} Welcome Page</a></li>
                <li><a href="equipmentmanager">Equipment Page</a></li>
                <li><a href="manual?manual">Manual Page</a></li>
                <li><a href="employee?action=logout">Logout</a></li>     
            </ul>
        </header>
        <div class="companyEmployees">
            <h1>${companyName} & OurSafety</h1>
            <h3>Employee List</h3>
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Birthdate</th>
                    <th>Gender</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Address</th>
                    <th>Position</th>
                    <th>Role</th>
                    <th></th>
                    <th></th>
                </tr>
                
                <c:forEach  var="emp" items="${employeeList}">
                    <tr>
                        <th>${emp.personID.firstName}</th>
                        <th>${emp.personID.lastName}</th>
                        <th>${emp.personID.dateOfBirth}</th>
                        <th>${emp.personID.gender}</th>
                        <th>${emp.email}</th>
                        <th>${emp.companypersonphoneList}</th>
<%--
                        <td>
                            <form action="company" method="post">
                                <input type="hidden" name="hidden_comp_emp_edit" value="hiddenEdit">
                                <input type="hidden" name="hidden_ed" value="${emp.id}">
                                <input type="submit" value="Edit">
                            </form>
                        </td>
                        <td>
                            <form action="company" method="post">
                                <input type="hidden" name="hidden_comp_emp_del" value="hiddenDelete">
                                <input type="hidden" name="hidden_del" value="${emp.id}">
                                <input type="submit" value="Remove">
                            </form>
                        </td>
--%>
                    </tr>
                </c:forEach>
                
            </table>
        </div>
            <%--
        <form action="company" method="post" class="companyAddForm">
            <h3>Add a new employee</h3>
            <input type="hidden" name="hidden_comp_emp_add" value="hiddenCompany"><br>
            <label>First Name</label><input type="text" name="comp_firstname"><br>
            <label>Last Name</label><input type="text" name="comp_lastname"><br>
            <label>Birth Date</label><input type="date" name="comp_birthday"><br>
            <label>Gender</label><input type="text" name="comp_gender"><br>
            <label>Phone Number</label><input type="tel" name="comp_phone" placeholder="1234567890"><br>
            <label>Email</label><input type="email" name="comp_email" placeholder="Ex: address@service.com"><br>
            <label>Address</label><input type="text" name="comp_address"><br>
            <label>Position</label><input type="text" name="comp_phone"><br>
            <label>Role</label><input type="text" name="comp_role"><br>
            <input type="submit" value="Add To Company">
            ${compAddMsg}
        </form>
            --%>
    </body>
</html>
