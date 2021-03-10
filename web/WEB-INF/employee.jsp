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
            <h3>Current Active Employee List</h3>
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Birth date</th>
                    <th>Gender</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Address</th>
                    <th>Position</th>
                    <th>Edit</th>
                    <th>Deactivate</th>
                </tr>
                
                <c:forEach  var="emp" items="${employeeList}">
                    <tr>
                        <th>${emp.personID.firstName}</th>
                        <th>${emp.personID.lastName}</th>
                        <th>${emp.personID.dateOfBirth}</th>
                        <th>${emp.personID.gender}</th>
                        <th>${emp.email}</th>

                        <c:if test="${empty emp.companypersonphoneList}">
                            <th> </th>
                        </c:if>
                            
                        <c:if test="${not empty emp.companypersonphoneList}">
                        <c:forEach  var="phone" items="${emp.companypersonphoneList}">
                            <th>
                            <c:if test="${phone.companyPersonID eq emp}">
                        ${phone.phoneID.countryCode}-${phone.phoneID.areaCode}-${phone.phoneID.localNumber}-${phone.phoneID.extension}
                            </c:if>
                        </th>
                        </c:forEach>
                        </c:if>
                        
                        <c:if test="${empty emp.companypersonaddressList}">
                            <th></th>
                        </c:if>
                                
                                
                        <c:if test="${not empty emp.companypersonaddressList}">
                        <c:forEach  var="add" items="${emp.companypersonaddressList}">
                        <th>
                        ${add.addressID.addressLine1} ${add.addressID.addressLine2}, ${add.addressID.city}, ${add.addressID.province} ${add.addressID.postalCode}, ${add.addressID.country}
                        </th>
                        </c:forEach>
                        </c:if>
                        <c:forEach var="pos" items="${emp.companypositionsList}">
                        <th>${pos.positionTitle}</th>
                        </c:forEach>
                        <th>
                            <form action="employee" method="post">
                                <input type="hidden" name="hidden_comp_emp_edit" value="hiddenEdit">
                                <input type="hidden" name="hidden_ed_cp" value="${emp.companyPersonID}">
                                <input type="hidden" name="hidden_ed_person" value="${emp.personID.personID}">
                                <input type="submit" name="action" value="Edit">
                            </form>
                        </th>
                        <th>
                            <form action="employee" method="post">
                                <input type="hidden" name="hidden_da_cp" value="${emp.companyPersonID}">
                                <input type="hidden" name="hidden_da_person" value="${emp.personID.personID}">
                                <input type="hidden" name="action" value="DeactivateEmployee">
                                <input type="submit" value="Deactivate" onclick="return confirm('Are you sure you want to deactivate ${emp.personID.firstName} ${emp.personID.lastName}?')">
                            </form>
                        </th>
                    </tr>
                </c:forEach>
            </table>
            
            <h3>Current In-Active Employee List</h3>
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Birth date</th>
                    <th>Gender</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Address</th>
                    <th>Position</th>
                    <th>Edit</th>
                    <th>Activate</th>
                </tr>
                
                <c:forEach  var="empInActive" items="${inActiveEmployeeList}">
                    <tr>
                        <th>${empInActive.personID.firstName}</th>
                        <th>${empInActive.personID.lastName}</th>
                        <th>${empInActive.personID.dateOfBirth}</th>
                        <th>${empInActive.personID.gender}</th>
                        <th>${empInActive.email}</th>

                        <c:if test="${empty empInActive.companypersonphoneList}">
                            <th> </th>
                        </c:if>
                            
                        <c:if test="${not empty empInActive.companypersonphoneList}">
                        <c:forEach  var="phone" items="${empInActive.companypersonphoneList}">
                            <th>
                            <c:if test="${phone.companyPersonID eq empInActive}">
                        ${phone.phoneID.countryCode}-${phone.phoneID.areaCode}-${phone.phoneID.localNumber}-${phone.phoneID.extension}
                            </c:if>
                        </th>
                        </c:forEach>
                        </c:if>
                        
                        <c:if test="${empty empInActive.companypersonaddressList}">
                            <th></th>
                        </c:if>
                                           
                        <c:if test="${not empty empInActive.companypersonaddressList}">
                        <c:forEach  var="add" items="${empInActive.companypersonaddressList}">
                        <th>
                        ${add.addressID.addressLine1} ${add.addressID.addressLine2}, ${add.addressID.city}, ${add.addressID.province} ${add.addressID.postalCode}, ${add.addressID.country}
                        </th>
                        </c:forEach>
                        </c:if>
                        <c:forEach var="pos" items="${empInActive.companypositionsList}">
                        <th>${pos.positionTitle}</th>
                        </c:forEach>
                        <th>
                            <form action="employee" method="post">
                                <input type="hidden" name="hidden_ed_cp" value="${empInActive.companyPersonID}">
                                <input type="hidden" name="hidden_ed_person" value="${empInActive.personID.personID}">
                                <input type="submit" name="action" value="Edit">
                            </form>
                        </th>
                        <th>
                            <form action="employee" method="post">
                                <input type="hidden" name="hidden_ra_cp" value="${empInActive.companyPersonID}">
                                <input type="hidden" name="hidden_ra_person" value="${empInActive.personID.personID}">
                                <input type="hidden" name="action" value="ActivateEmployee">
                                <input type="submit" value="Activate" onclick="return confirm('Are you sure you want to reactivate ${empInActive.personID.firstName} ${empInActive.personID.lastName}?')">
                            </form>
                        </th>
                    </tr>
                </c:forEach>
            </table>
        </div>
            
            <br>
            ${message}
            <br>
        <form action="employee"  method="post" class="companyAddForm">
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
            <input type="submit" name="action" value="Add">
            ${compAddMsg}
        </form>
    </body>
</html>
