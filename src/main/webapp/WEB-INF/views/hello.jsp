<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2>Abhishek</h2>
 <% 
 	Object object=request.getAttribute("message");
 Object object2= request.getAttribute("message2");
 	out.print(object+""+object2);
 
 
 
 
 %>
 <h1> ${message} </h1>

</body>
</html>