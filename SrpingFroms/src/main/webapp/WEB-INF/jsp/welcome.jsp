<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form:form action="save" method="post" modelAttribute="model">
     <table>
     <tr>
     <td>
      <form:label path="name">Name:</form:label>   
     </td>
     
     <td>
     <form:input path="name"/>
     </td>
     <form:errors path="name" />
     </tr>
     <tr>
     <td>
     <form:label path="email">Email:</form:label>
     </td>
     <td>
     <form:input path="email"/></td>
     </tr>
     </table>
  
    <input type="submit" value="submit"/>
  </form:form>
</body>
</html>