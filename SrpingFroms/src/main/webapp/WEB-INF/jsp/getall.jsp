<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <h1>Employees List</h1>  
<table border="2" width="70%">  
<tr><th>Name</th><th>Email<th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="emp" items="${modellist}">   
   <tr>  
   <td>${emp.name}</td>  
   <td>${emp.email}</td>  
   <td><a href="editemp/${emp.name}">Edit</a></td>  
   <td><a href="deleteemp/${emp.name}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="/SrpingFroms/">Add New Employee</a>  
   
</body>
</html>