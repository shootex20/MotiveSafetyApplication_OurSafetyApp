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
        <header class="companyHeader">
            <ul>
                <li><a href=" <c:url value='/company'/> ">${companyName} Company Page</a></li>
                <li><a href=" <c:url value='/equipment'/> ">Equipment Page</a></li>
                <li><a href=" <c:url value='/manual'/> ">Safety Page</a></li>
                <li><a href=" <c:url value='/admin'/>" >Administrator Page</a></li>
                <li><a href="login?action=logout">Logout</a></li>
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
                    <th>Phone Number</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Position</th>
                    <th>Role</th>
                    <th></th>
                    <th></th>
                </tr>
                <%--
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
                    </tr>
                </c:forEach>
                --%>
            </table>

        </div>
        <form action="company" method="post" class="companyAddForm">
            <h3>Add a new employee</h3>
            <input type="hidden" name="hidden_comp_emp_add" value="hiddenCompany"><br>
            <label>First Name</label><input type="text" name="comp_firstname"><br>
            <label>Last Name</label><input type="text" name="comp_lastname"><br>
            <label>Birthdate</label><input type="date" name="comp_birthday"><br>
            <label>Gender</label><input type="text" name="comp_gender"><br>
            <label>Phone Number</label><input type="tel" name="comp_phone" placeholder="1234567890"><br>
            <label>Email</label><input type="email" name="comp_email" placeholder="Ex: address@service.com"><br>
            <label>Address</label><input type="text" name="comp_address"><br>
            <label>Position</label><input type="text" name="comp_phone"><br>
            <label>Role</label><input type="text" name="comp_role"><br>
            <input type="submit" value="Add To Company">
            ${compAddMsg}
        </form>
    </body>
</html>