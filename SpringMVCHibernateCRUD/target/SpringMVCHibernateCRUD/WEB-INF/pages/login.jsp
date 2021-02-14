<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<div>
	
	
	<center>
	


<form:form action="admin" method="post" modelAttribute="loginforms">
        Email: <form:input path="email" />         
        <br><br>  
       Pass: <form:input path="pass" />  
        <br><br>  
        <input type="submit" value="Login">      
    </form:form>  



</center>
</div>
</body>
</html>