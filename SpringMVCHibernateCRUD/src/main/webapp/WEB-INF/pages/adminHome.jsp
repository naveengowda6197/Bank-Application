<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account Management Screen</title>
</head>
<body>
	<div align="center">
		<h1>Login</h1>
		
		<table border="1">

			<th>A/c Holder Name</th>
			<th>Account No.</th>
			<th>Balance</th>
			<th>Email</th>
			<th>Address</th>
			<th>Telephone</th>
			<th>Action</th>

			<c:forEach var="account" items="${listAccount}">
				<tr>

					<td>${account.name}</td>
					<td>${account.ac_no}</td>
					<td>${account.balance}</td>
					<td>${account.email}</td>
					<td>${account.address}</td>
					<td>${account.telephone}</td>
					<td><a href="editAccount?ac_no=${account.ac_no}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;

				</tr>
			</c:forEach>
		</table>
		<h4>
			New Account Register <a href="newAccount">here</a>
			<h4><a href="">Logout</a></h4>
		</h4>
	</div>
</body>
</html>