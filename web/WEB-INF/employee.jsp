<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
            <%@include file="css/employee.css" %>
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
        <link href="employee.css" rel="stylesheet" type="text/css">
        <title>Employee JSP</title>
    </head>
    <body>  
        <script>
            if (window.history.replaceState) {
                window.history.replaceState(null, null, window.location.href);
            }
        </script>

        <header class="loginHeader">
            <br>
            <h1>${companyName} & OurSafety</h1>
            <h3>Employee Manager</h3>
            <br>
            <table class="navi">
                <tr>
                    <td class="roll"><a href="companyWelcome?companyWelcome">Welcome Page</a></td>
                    <td class="roll"><a href="equipmentmanager">Equipment Page</a></td>
                    <td class="roll"><a href="manual?manual">Manual Page</a></td>
                    <td class="roll"><a href="employee?logout=logout">Logout</a> </td>
                </tr>
            </table>
            <br>
        </header>
        <div class="content">
            <div class="companyEmployees">
                <br>
                <h3 class="welcome"><strong>Current Active Employee List</strong></h3>
                <br>
                <div class="responsive-table">
                    <table class="maint">
                        <tr class="main">
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
                            <th>Emergency Contact</th>
                        </tr>

                        <c:forEach  var="emp" items="${employeeList}">
                            <tr class="main">
                                <td class="main">${emp.personID.firstName}</td>
                                <td class="main">${emp.personID.lastName}</td>
                                <td class="main"><fmt:formatDate value="${emp.personID.dateOfBirth}" pattern="dd/MMM/YYYY"/></td>
                                <td class="main">${emp.personID.gender}</td>
                                <td class="main">${emp.email}</td>

                                <c:if test="${empty emp.companypersonphoneList}">
                                    <td class="main"> </td>
                                </c:if>

                                <c:if test="${not empty emp.companypersonphoneList}">
                                    <c:forEach  var="phone" items="${emp.companypersonphoneList}">
                                        <td class="main">
                                            <c:if test="${phone.companyPersonID eq emp}">
                                                ${phone.phoneID.countryCode}-${phone.phoneID.areaCode}-${phone.phoneID.localNumber} <c:if test="${not empty phone.phoneID.extension}"> ext:${phone.phoneID.extension} </c:if>
                                            </c:if>
                                        </td>
                                    </c:forEach>
                                </c:if>

                                <c:if test="${empty emp.companypersonaddressList}">
                                    <td class="main"></td>
                                </c:if>


                                <c:if test="${not empty emp.companypersonaddressList}">
                                    <c:forEach  var="add" items="${emp.companypersonaddressList}">
                                        <td class="main">
                                            ${add.addressID.addressLine1} ${add.addressID.addressLine2}, ${add.addressID.city}, ${add.addressID.province} ${add.addressID.postalCode}, ${add.addressID.country}
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:forEach var="pos" items="${emp.companypositionsList}">
                                    <td class="main">${pos.positionTitle}</td>
                                </c:forEach>
                                <td class="main">
                                    <form action="employee" method="get">
                                        <input type="hidden" name="edactive" value="${emp.companyPersonID}">
                                        <input type="hidden" name="action" value="view">
                                        <input type="submit" class="btn btn-primary" value="Edit">
                                    </form>
                                </td>
                                <td class="main">
                                    <form action="employee" method="post">
                                        <input type="hidden" name="hidden_da_cp" value="${emp.companyPersonID}">
                                        <input type="hidden" name="hidden_da_person" value="${emp.personID.personID}">
                                        <input type="hidden" name="action" value="DeactivateEmployee">
                                        <input type="hidden" name="token" value="<c:out value="${token}"/>">
                                        <input type="submit" class="btn btn-danger" value="Deactivate" onclick="return confirm('Are you sure you want to deactivate ${emp.personID.firstName} ${emp.personID.lastName}?')">
                                    </form>
                                </td>
                                <td class="main">
                                    <input type="button" class="btn btn-primary" value="Emergency Contact" onclick="alert('Firstname: ${emp.personID.emergencyContactID.emergencyContactFirstName}\nLastname: ${emp.personID.emergencyContactID.emergencyContactLastName}\nContact Number: ${emp.personID.emergencyContactID.emergencyContactNumber}\nRelationship: ${emp.personID.emergencyContactID.emergencyContactRelationship}')">
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <br>
                <h3 class="welcome"><strong>Current Inactive Employee List</strong></h3>
                <br>
                <div class="responsive-table">
                    <table class="maint">
                        <tr class="main">
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
                            <th>Emergency Contact</th>
                        </tr>

                        <c:forEach  var="empInActive" items="${inActiveEmployeeList}">
                            <tr>
                                <td class="main">${empInActive.personID.firstName}</td>
                                <td class="main">${empInActive.personID.lastName}</td>
                                <td class="main"><fmt:formatDate value="${empInActive.personID.dateOfBirth}" pattern="dd/MMM/YYYY"/></td>
                                <td class="main">${empInActive.personID.gender}</td>
                                <td class="main">${empInActive.email}</td>

                                <c:if test="${empty empInActive.companypersonphoneList}">
                                    <td class="main"> </td>
                                </c:if>

                                <c:if test="${not empty empInActive.companypersonphoneList}">
                                    <c:forEach  var="phone" items="${empInActive.companypersonphoneList}">
                                        <td class="main">
                                            <c:if test="${phone.companyPersonID eq empInActive}">
                                                ${phone.phoneID.countryCode}-${phone.phoneID.areaCode}-${phone.phoneID.localNumber}-${phone.phoneID.extension}
                                            </c:if>
                                        </td>
                                    </c:forEach>
                                </c:if>

                                <c:if test="${empty empInActive.companypersonaddressList}">
                                    <td class="main"></td>
                                </c:if>

                                <c:if test="${not empty empInActive.companypersonaddressList}">
                                    <c:forEach  var="add" items="${empInActive.companypersonaddressList}">
                                        <td class="main">
                                            ${add.addressID.addressLine1} ${add.addressID.addressLine2}, ${add.addressID.city}, ${add.addressID.province} ${add.addressID.postalCode}, ${add.addressID.country}
                                        </td>
                                    </c:forEach>
                                </c:if>
                                <c:forEach var="pos" items="${empInActive.companypositionsList}">
                                    <td class="main">${pos.positionTitle}</td>
                                </c:forEach>
                                <td class="main">
                                    <form action="employee" method="get">
                                        <input type="hidden" name="edinactive" value="${empInActive.companyPersonID}">
                                        <input type="hidden" name="action" value="view1">
                                        <input type="submit"  class="btn btn-primary" value="Edit">
                                    </form>
                                </td>
                                <td class="main">
                                    <form action="employee" method="post">
                                        <input type="hidden" name="hidden_ra_cp" value="${empInActive.companyPersonID}">
                                        <input type="hidden" name="hidden_ra_person" value="${empInActive.personID.personID}">
                                        <input type="hidden" name="action" value="ActivateEmployee">
                                        <input type="hidden" name="token" value="<c:out value="${token}"/>">
                                        <input type="submit"  class="btn btn-primary" value="Activate" onclick="return confirm('Are you sure you want to reactivate ${empInActive.personID.firstName} ${empInActive.personID.lastName}?')">
                                    </form>
                                </td>
                                <td class="main">
                                    <input type="button"  class="btn btn-primary" value="Emergency Contact" onclick="alert('Firstname: ${empInActive.personID.emergencyContactID.emergencyContactFirstName}\nLastname: ${empInActive.personID.emergencyContactID.emergencyContactLastName}\nContact Number: ${empInActive.personID.emergencyContactID.emergencyContactNumber}\nRelationship: ${empInActive.personID.emergencyContactID.emergencyContactRelationship}')">
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <br>
            <p><strong><i>${message}</i></strong></p>
            <br>
            <c:if test="${user == null}">
                <h3 class="welcome"><strong>Add a new employee</strong></h3>
                <form method="POST" class="companyAddForm">
                    <input type="hidden" name="hidden_comp_emp_add" value="hiddenCompany"><br>
                    <input type="hidden" name="token" value="<c:out value="${token}"/>">
                    <div class="responsive-form">
                        <br>
 <table class="mainf">
                            <tr>
                                <td><label>First Name </label></td>
                                <td><input required type="text" name="comp_firstname" placeholder="John"></td>
                            </tr>
                            <tr>
                                <td><label>Last Name </label></td>
                                <td><input required type="text" name="comp_lastname" placeholder="Doe"></td>
                            </tr>
                            <tr>
                                <td><label>Birth Date </label></td>
                                <td><input required type="date" name="comp_birthday"></td>
                            </tr>
                            <tr>
                                <td><label>Gender </label></td>
                                <td><select name="comp_gender" id="comp_gender">
                                        <option value="F">Female</option>
                                        <option value="M">Male</option>
                                        <option value="O">Other</option>
                                    </select></td>
                            </tr>
                            <tr>
                                <td><label>Phone Number </label></td>
                                <td><input required pattern="[0-9]{1}-[0-9]{3}-[0-9]{3}-[0-9]{4}" type="tel" name="comp_phone" placeholder="1-123-456-7890"></td>
                            </tr>
                            <tr>
                                <td><label>Phone Ext </label></td>
                                <td><input type="tel" name="comp_phoneExt" placeholder="7890"></td>
                            </tr>
                            <tr>
                                <td><label>Email </label></td>
                                <td><input required type="email" name="comp_email" placeholder="address@service.com"></td>
                            </tr>
                            <tr>
                                <td> <label>Address Line 1 </label></td>
                                <td><input required type="text" name="comp_addressLine1" placeholder="32 Test Ave."></td>
                            </tr>
                            <tr>
                                <td><label>Address Line 2 </label></td>
                                <td><input type="text" name="comp_addressLine2"></td>
                            </tr>
                            <tr>
                                <td><label>City </label></td>
                                <td><input required type="text" name="comp_city"></td>
                            </tr>
                            <tr>
                                <td><label>Province </label></td>
                                <td><input required type="text" name="comp_prov"></td>
                            </tr>
                            <tr>
                                <td><label>Postal Code </label></td>
                                <td><input required type="text" name="comp_postal"></td>
                            </tr>
                            <tr>
                                <td><label>Country </label></td>
                                <td><input required type="text" name="comp_country"></td>
                            </tr>
                            <tr>
                                <td><label>Position </label></td>
                                <td><input required type="text" name="comp_pos" placeholder="CEO"></td>
                            </tr>
                        </table>
                        <br>
                    </div>
                    <%--
                    <label>Gender</label><input required type="text" name="comp_gender"><br>
                    --%>
                    <br>
                    <h3 class="welcome"><strong>Emergency Contact Details</strong></h3>
                    <br>
                    <div class="responsive-form">
                        <br>
                        <table class="mainf">
                            <tr>
                                <td><label>First name </label></td>
                                <td><input required type="text" name="emer_first"></td>
                            </tr>
                            <tr>
                                <td><label>Last name </label></td>
                                <td><input required type="text" name="emer_last"></td>
                            </tr>
                            <tr>
                                <td><label>Phone Number </label></td>
                                <td><input required type="tel" name="emer_phone" pattern="[0-9]{1}-[0-9]{3}-[0-9]{3}-[0-9]{4}" placeholder="1-623-456-7890"></td>
                            </tr>
                            <tr>
                                <td><label>Relationship </label></td>
                                <td><input required type="text" name="emer_relationship"></td>
                            </tr>
                        </table>
                        <br>
                    </div>
                    <br>
                    <input type="submit" name="action"  class="btn btn-primary" id="BTNS" value="Add">
                    ${compAddMsg}
                    <br>
                </form>
            </c:if>

            <c:if test="${user != null}">
                <h3 class="welcome"><strong>Edit employee</strong></h3>

                <form action="employee"  method="POST" class="companyAddForm">
                    <input type="hidden" name="compPerID" value="${user.companyPersonID}">
                    <input type="hidden" name="perID" value="${user.personID.personID}">
                    <input type="hidden" name="hidden_comp_emp_add" value="hiddenCompany"><br>
                    <input type="hidden" name="token" value="<c:out value="${token}"/>">
                    <div class="responsive-form">
                        <br>
                        <table class="mainf">
                            <tr>
                                <td><label>First Name </label></td>
                                <td><input required type="text" name="edcomp_firstname" value="${user.personID.firstName}"></td>
                            </tr>
                            <tr>
                                <td><label>Last Name </label></td>
                                <td><input required type="text" name="edcomp_lastname" value="${user.personID.lastName}"></td>
                            </tr>
                            <tr>
                                <td> <label>Birth Date </label></td>
                                <td><input required type="date" name="edcomp_birthday" value="${birthday}"></td>
                            </tr>
                            <input type="hidden" name="gender" value="${genderOfPerson}">
                            <c:if test="${gender == 'F'}">
                                <tr><td><label>Gender</label></td>
                                    <td>
                                        <select name="edcomp_gender" var="gen" id="edcomp_gender">
                                            <option value="F" selected>Female</option>
                                            <option value="M">Male</option>
                                            <option value="O">Other</option>
                                        </select></td></tr>
                                    </c:if>
                                    <c:if test="${gender == 'M'}">
                                <tr><td><label>Gender</label></td>
                                    <td>
                                        <select name="edcomp_gender" var="gen" id="edcomp_gender">
                                            <option value="F">Female</option>
                                            <option value="M" selected>Male</option>
                                            <option value="O">Other</option>
                                        </select></td></tr>
                                    </c:if>
                                    <c:if test="${gender == 'O'}">
                                <tr><td><label>Gender</label></td>
                                    <td>
                                        <select name="edcomp_gender" var="gen" id="edcomp_gender">
                                            <option value="F">Female</option>
                                            <option value="M">Male</option>
                                            <option value="O" selected>Other</option>
                                        </select></td></tr>
                                    </c:if>
                                    <c:forEach  var="phone" items="${user.companypersonphoneList}">
                                        <c:if test="${phone.companyPersonID eq user}">
                                    <tr>
                                        <td>


                                            <label>Phone Number </label></td>
                                        <td><input pattern="[0-9]{1}-[0-9]{3}-[0-9]{3}-[0-9]{4}" required type="tel" name="edcomp_phone" placeholder="1-123-456-7890" value="${phone.phoneID.countryCode}-${phone.phoneID.areaCode}-${phone.phoneID.localNumber}"></td>
                                    </tr>
                                    <tr>
                                        <td><label>Phone Ext </label></td>
                                        <td><input type="tel" name="edcomp_phoneExt" placeholder="7890" value="${phone.phoneID.extension}">
                                            <input type="hidden" name="phoneID" value="${phone.phoneID.phoneID}">
                                        </td>
                                    </tr></c:if></c:forEach>
                                    <tr>
                                        <td><label>Email</label></td>
                                        <td><input required type="email" name="edcomp_email" placeholder="Ex: address@service.com" value="${user.email}"></td>
                            </tr>
                            <c:forEach  var="add" items="${user.companypersonaddressList}">
                                <tr><td><label>Address Line 1 </label></td><td><input required type="text" name="edcomp_addressLine1" value="${add.addressID.addressLine1}"></td></tr>
                                <tr><td><label>Address Line 2 </label></td><td><input required type="text" name="edcomp_addressLine2" value="${add.addressID.addressLine2}"></td></tr>  
                                <tr><td><label>City </label></td><td><input type="text" name="edcomp_city" value="${add.addressID.city}"></td></tr> 
                                <tr><td><label>Province </label></td><td><input required type="text" name="edcomp_prov" value="${add.addressID.province}"></td></tr> 
                                <tr><td><label>Postal Code </label></td><td><input required type="text" name="edcomp_postal" value="${add.addressID.postalCode}"></td></tr> 
                                <tr><td><label>Country </label></td><td><input required type="text" name="edcomp_country" value="${add.addressID.country}">
                                        <input type="hidden" name="addressID" value="${add.addressID.addressID}"></td></tr> 
                                    </c:forEach>
                                    <c:forEach var="pos" items="${user.companypositionsList}">
                                <tr><td><label>Position</label></td><td><input required type="text" name="edcomp_pos" value="${pos.positionTitle}">
                                        <input type="hidden" name="positionID" value="${pos.companyPositionsID}"></td></tr>
                                    </c:forEach>
                        </table>
                        <br>
                    </div>
                    <br>
                    <h3 class="welcome"><strong>Emergency Contact Details</strong></h3>
                    <br>
                    <div class="responsive-form"><br><table class="mainf">
                            <tr><td><label>First name</label></td><td><input required type="text" name="edemer_first" value="${user.personID.emergencyContactID.emergencyContactFirstName}"></td></tr>
                            <tr><td><label>Last name</label></td><td><input required type="text" name="edemer_last" value="${user.personID.emergencyContactID.emergencyContactLastName}"></td></tr>
                            <tr><td><label>Phone Number</label></td><td><input required type="tel" name="edemer_phone" placeholder="1-234-567-8900" pattern="[0-9]{1}-[0-9]{3}-[0-9]{3}-[0-9]{4}"  value="${user.personID.emergencyContactID.emergencyContactNumber}"></td></tr>
                            <tr><td><label>Relationship</label></td><td><input required type="text" name="edemer_relationship"  value="${user.personID.emergencyContactID.emergencyContactRelationship}"></td></tr>
                        </table><br>
                    </div>
                    <br>
                    <input type="submit" name="action"  class="btn btn-primary" id="BTNS" value="Save">
                    ${compAddMsg}
                </form>
            </c:if>
            <br>
        </div>

        <footer>
            <br>
            <table class="contact">
                <tr>
                    <td>Phone Number: (403) 587-1245</td>
                    <td>Fax Number: (403) 587-1246</td>
                    <td>Email: info@oursafety.ca</td>
                    <td>Mailing Address: 168 16 St SE, Calgary</td>
                </tr>
            </table>
            <br>
            <div class="socialMedia">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-facebook" viewBox="0 0 16 16">
                <path d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z"/>
                </svg>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-twitter" viewBox="0 0 16 16">
                <path d="M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z"/>
                </svg>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-instagram" viewBox="0 0 16 16">
                <path d="M8 0C5.829 0 5.556.01 4.703.048 3.85.088 3.269.222 2.76.42a3.917 3.917 0 0 0-1.417.923A3.927 3.927 0 0 0 .42 2.76C.222 3.268.087 3.85.048 4.7.01 5.555 0 5.827 0 8.001c0 2.172.01 2.444.048 3.297.04.852.174 1.433.372 1.942.205.526.478.972.923 1.417.444.445.89.719 1.416.923.51.198 1.09.333 1.942.372C5.555 15.99 5.827 16 8 16s2.444-.01 3.298-.048c.851-.04 1.434-.174 1.943-.372a3.916 3.916 0 0 0 1.416-.923c.445-.445.718-.891.923-1.417.197-.509.332-1.09.372-1.942C15.99 10.445 16 10.173 16 8s-.01-2.445-.048-3.299c-.04-.851-.175-1.433-.372-1.941a3.926 3.926 0 0 0-.923-1.417A3.911 3.911 0 0 0 13.24.42c-.51-.198-1.092-.333-1.943-.372C10.443.01 10.172 0 7.998 0h.003zm-.717 1.442h.718c2.136 0 2.389.007 3.232.046.78.035 1.204.166 1.486.275.373.145.64.319.92.599.28.28.453.546.598.92.11.281.24.705.275 1.485.039.843.047 1.096.047 3.231s-.008 2.389-.047 3.232c-.035.78-.166 1.203-.275 1.485a2.47 2.47 0 0 1-.599.919c-.28.28-.546.453-.92.598-.28.11-.704.24-1.485.276-.843.038-1.096.047-3.232.047s-2.39-.009-3.233-.047c-.78-.036-1.203-.166-1.485-.276a2.478 2.478 0 0 1-.92-.598 2.48 2.48 0 0 1-.6-.92c-.109-.281-.24-.705-.275-1.485-.038-.843-.046-1.096-.046-3.233 0-2.136.008-2.388.046-3.231.036-.78.166-1.204.276-1.486.145-.373.319-.64.599-.92.28-.28.546-.453.92-.598.282-.11.705-.24 1.485-.276.738-.034 1.024-.044 2.515-.045v.002zm4.988 1.328a.96.96 0 1 0 0 1.92.96.96 0 0 0 0-1.92zm-4.27 1.122a4.109 4.109 0 1 0 0 8.217 4.109 4.109 0 0 0 0-8.217zm0 1.441a2.667 2.667 0 1 1 0 5.334 2.667 2.667 0 0 1 0-5.334z"/>
                </svg>
            </div>
            <br>
        </footer>
    </body>
</html>
