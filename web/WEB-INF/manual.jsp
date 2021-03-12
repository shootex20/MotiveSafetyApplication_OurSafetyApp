
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manuals Page for OurSafety Application</title>
        <link href="CSS-MEDIA/Index.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Manual Pages for OurSafety Application</h1>
        <h1>${test}</h1>
 <!--Load data from database-->        
        <table>
            <tr>
                <th>Manual Id</th>
                <th>Date Added</th>
                <th>Title</th>
                <th>Intention</th>
                <th>Content</th> would have links to the actual manuals
            </tr>
            <c:forEach var="manual" items="${manualList}">
            <tr>
                <td>${manual.manualID}</td>
                <td>${manual.dateAdded}</td>
                <td>${manual.title}</td>
                <td>${manual.intention}</td>
                <td>${manual.content}</td>
                <td>
                        <form action="manual" method="post"> 
                            <input type="submit" name="action"  value="delete" onclick="return confirm('Are you sure you want to delete ${manualDelete.title} with item information ${manual.intention}?')">
                            <input type="hidden" name="manualID" value="${manual.manualID}">
                        </form>
                </td>
                    
                <td>
                        <form action="manual" method="get"> 
                            <input type="submit" name="action"  value="view">
                            <input type="hidden" name="manualID" value="${manual.manualID}">
                        </form>
                </td>
            </tr>
            </c:forEach>
        </table>
 
        <form action="manual "method="get"> 
            <input type="submit" name="action" value="addform">
        </form>

        <br>
         <c:if test="${selectedManual == null}">
              <c:if test="${selectedAdd != null}">
        <h3>Add Manual</h3>
        <form action="manual" method="post">
                <label for="manualType" id="manualType">Type of manual: </label>
                
                <select name="manualType" id="manualType">
                     <c:forEach items="${types}" var="manualType">
                         <option value = "${manualType.typeLibraryID}">${manualType.description}</option>
                     </c:forEach>                
                </select>
                <br>
                <label for="dateAdded">Date Added </label>
                <input type="date" name="dateAdded"  required></date-input>
                <br>
                <label for="title">title: </label>
                <input type="text" name="title" >
                <br>
                <label for="intention">intention: </label>
                <input type="text" name="intention" >
                <br>
                <label for="content">content: </label>
                <input type="text" name="content" >
                <br>
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Add">
                
        </form>
              </c:if>
        </c:if>
        
        <c:if test="${selectedManual != null}">
        <h3>Edit Manual</h3>
        <form action="manual" method="post">
            <label for="manualType" id="manualType">Type of manual: </label>
            <select name="manualType" id="manualType">
                         <c:forEach items="${types}" var="manualType">
                             <option value = "${manualType.typeLibraryID}">${manualType.description}</option>
                         </c:forEach>
            </select>
                    <br>
                    <label for="title">title: </label>
                    <input type="text" name="title" value="${selectedManual.title}">
                    <br>
                    <label for="intention">intention: </label>
                    <input type="text" name="intention" value="${selectedManual.intention}">
                    <br>
                    <label for="content">content: </label>
                    <input type="text" name="content" value="${selectedManual.content}">
                    
                     <input type="hidden" name="manualID" value="${selectedManual.manualID}">
                    <br>

            <input type="hidden" name="action" value="edit">
            <input type="submit" value="Save">
        </form>
        </c:if>
    </body>
</html>
