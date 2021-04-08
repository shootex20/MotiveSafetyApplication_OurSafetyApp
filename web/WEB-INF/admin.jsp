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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
        <title>MotiveSafety OurSafety Admin Functionality</title>
    </head>
    <body>
        <header class="loginHeader">
            <br>
            <h1>MotiveSafety OurSafety Application</h1>
            <a href="admin?logout=logout"><u>Logout</u></a>
            <br>
            <br>
        </header>
        <br>
        <div class="outline">
            <br>
            <h3 class="welcome"><strong>Manage Companies</strong></h3>

            <div class="search_box">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                </svg>
                <input type="text" id="searchcomp" placeholder="search company table">
            </div>
            <br>
            <table id="company_table" class="mains">
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
                                <input type="hidden" name="token" value="<c:out value="${token}"/>">
                            </form>
                        </td>
                        <td>
                            <form action="admin" method="get">
                                <input type="submit" value="Edit">
                                <input type="hidden" name="action" value="view">
                                <input type="hidden" name="selectedCompany" value="${companys.companyID}">
                                <input type="hidden" name="token" value="<c:out value="${token}"/>">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <c:out value="${message}"></c:out>
                <br>
            </div>
            <br>
            <br>

        <c:if test="${selectedComp == null}">
            <div class="outline">
                <br>
                <h3 class="welcome"><strong>Add Company</strong></h3>
                <form action="admin" method="POST">
                    <table class="formS">
                        <tr class="formrow">
                            <td  class="formrow">Name: </td>
                            <td class="formrow"><input type="text" name="compname" required placeholder="AAA_Company"></td>
                        </tr>
                        <tr class="formrow">
                            <td class="formrow">Short Name: </td>
                            <td class="formrow"><input type="text" name="shortname" required placeholder="AAA_Company"></td>
                        </tr>
                        <tr class="formrow">
                            <td class="formrow">Description: </td>
                            <td class="formrow"><input type="text" name="description"></td>
                        </tr>
                        <tr class="formrow">
                            <td class="formrow">Account: </td>
                            <td class="formrow"><input type="text" name="account"></td>
                        </tr>
                        <tr class="formrow">
                            <td class="formrow">Industry: </td>
                            <td class="formrow"><input type="text" name="industry"><br></td>
                        </tr>
                    </table>
                    <br>
                    <input type="hidden" name="action" value="add">
                    <input type="submit" value="Add Company" class="btn btn-primary">
                    <input type="hidden" name="token" value="<c:out value="${token}"/>">
                </form>
                <br>
            </div>
        </c:if>
        <c:if test="${selectedComp != null}">

            <div class="outline">
                <br>
                <h3 class="welcome"><strong>Edit Company</strong></h3>
                <form action="admin" method="POST">
                    <table class="formS">
                        <tr class="formrow">
                            <td class="formrow">Company ID: </td>
                            <td class="formrow"><input type="text" name="id" value="${selectedComp.companyID}" readonly=""></td>
                        </tr>
                        <tr class="formrow">
                            <td class="formrow">Date Added:</td>
                            <td class="formrow"><input type="date" name="dateAdded" value="${selectedComp.dateAdded}" readonly=""></td>
                        </tr>
                        <tr class="formrow">
                            <td class="formrow">Name: </td>
                            <td class="formrow"><input type="text" name="compname" value="${selectedComp.name}" ></td>
                        </tr>
                        <tr class="formrow">
                            <td class="formrow">Short Name: </td>
                            <td class="formrow"><input type="text" name="shortname" value="${selectedComp.shortname}"></td>
                        </tr>
                        <tr class="formrow">
                            <td class="formrow">Description: </td>
                            <td class="formrow"><input type="text" name="description" value="${selectedComp.description}"></td>
                        </tr>
                        <tr class="formrow">
                            <td class="formrow">Account: </td>
                            <td class="formrow"><input type="text" name="account" value="${selectedComp.account}"></td>
                        </tr>
                        <tr class="formrow">
                            <td class="formrow">Industry: </td>
                            <td class="formrow"><input type="text" name="industry" value="${selectedComp.industry}"></td>
                        </tr>
                    </table>
                    <input type="hidden" name="action" value="edit">
                    <input type="submit" value="Save Edit" class="btn btn-primary">
                    <input type="hidden" name="token" value="<c:out value="${token}"/>">
                </form>
                <br>       
            </div>
        </c:if>
        <!--for managers-->
        <br>
        <br>
        <div class="outline">
            <br>
            <h3 class="welcome"><strong>Manage Active Managers</strong></h3>
            <div class="search_box">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                </svg>
                <input type="text" id="searchActiveManagers" placeholder="search active managers table">
            </div>
            <br>
            <table id="activeManagersTable" class="mains">
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
                                <input type="hidden" name="token" value="<c:out value="${token}"/>">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            ${messageManager}
            <br>
        </div>
        <br>
        <br>
        <div class="outline">
            <br>
            <h3 class="welcome"><strong>Manage In-Active Managers</strong></h3>
            <div class="search_box">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                </svg>
                <input type="text" id="searchInActiveManagers" placeholder="search active managers table">
                <input type="hidden" name="token" value="<c:out value="${token}"/>">
            </div>
            <br>
            <table id="inActiveManagersTable" class="mains">
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
                                <input type="hidden" name="token" value="<c:out value="${token}"/>">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br>
        </div>
        <br>
        <br>
        <div class="outline">
            <br>
            <c:if test="${selectedManager == null}">
                <h3 class="welcome"><strong>Add Manager</strong></h3>
                <form action="admin" method="POST">

                    <table class="formS">
                        <tr class="formrow">
                            <td class="formrow">Username: </td>
                            <td class="formrow"><input type="text" name="username" placeholder="manager1" name="username" required ></td>
                        </tr>
                        <tr class="formrow">
                            <td class="formrow">Password: </td>
                            <td class="formrow"><input type="password" minlength="8" name="password" id="password"
                                                       required title="Must be at least 8 characters long"></td>
                        </tr>
                        <tr class="formrow">
                            <td class="formrow">Confirm Password: </td>
                            <td class="formrow"> <input type="password" required name="confirmPassword" 
                                                        id="confirmPassword"></td>
                        </tr>
                        <tr class="formrow">
                            <td class="formrow"><label for="userCompanyID">Company Name: </label></td>
                            <td class="formrow"> <select name="userCompanyID" id="userCompanyID">
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
                                </select></td>
                        </tr>
                        <tr class="formrow">
                            <td class="formrow"><label for="isActive" name="isActive"> Is Active?: </label></td>
                            <td class="formrow"> <select name="isActive" var="isActive">  
                                    <option value="T">True</option>
                                    <option value="F">False</option>
                                </select> </td>
                        </tr><tr class="formrow">
                            <td class="formrow"><label for="isAdmin" name="isAdmin"> Is Admin?: </label></td>
                            <td class="formrow"> <select name="isAdmin" var="isAdmin">  
                                    <option value="F">False</option>
                                    <option value="T">True</option>
                                </select> 
                            </td>
                        </tr>
                    </table>
                    <input type="hidden" name="actionM" value="addUser">
                    <input type="submit" value="Add User" onclick="return passwordmatch()" class="btn btn-primary">
                    <input type="hidden" name="token" value="<c:out value="${token}"/>">
                    <br>
                    <br>
                    </div>
                    <br>
                    <br>
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


                    if (password != conPassword) {
                        alert("Passwords do not match.");
                        return false;
                    }
                    return true;
                }
            </script>

            <footer>
                <br>
                <table class="contact">
                    <tr class="noborder">
                        <td  class="noborder">Phone Number: (403) 587-1245</td>
                        <td  class="noborder">Fax Number: (403) 587-1246</td>
                        <td  class="noborder">Email: info@oursafety.ca</td>
                        <td  class="noborder">Mailing Address: 168 16 St SE, Calgary</td>
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