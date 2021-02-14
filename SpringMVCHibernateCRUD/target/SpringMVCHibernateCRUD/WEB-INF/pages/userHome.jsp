<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
</head>
<body>
	<div align="center">
		
		<center><h2>Thank You For Using Our Banking System</h2></center>
		<table border="1">

			<th style="background-color:#ADD8E6;">A/c Holder Name</th>
			<th style="background-color:#ADD8E6;">Account No.</th>
			<th style="background-color:#ADD8E6;">Balance</th>
			<th style="background-color:#ADD8E6;">Email</th>
			<th style="background-color:#ADD8E6;">Address</th>
			<th style="background-color:#ADD8E6;">Telephone</th>

			<c:forEach var="account" items="${listOfAccount}">
				<tr>

					<td style="background-color:#C0C0C0;">${account.name}</td>
					<td style="background-color:#C0C0C0;">${account.ac_no}</td>
					<td style="background-color:#C0C0C0;">${account.balance}</td>
					<td style="background-color:#C0C0C0;">${account.email}</td>
					<td style="background-color:#C0C0C0;">${account.address}</td>
					<td style="background-color:#C0C0C0;">${account.telephone}</td>
					
	
				</tr>
					Withdraw from this a/c<a href="/withdraw/${account.ac_no}/${account.balance}">here</a>
			</c:forEach>
		</table>
		<h4><a href="">Logout</a></h4>
	</div>
</body>
</html>