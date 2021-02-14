<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

			<th style="background-color:#ADD8E6;">A/c Account Number</th>
			
			<th style="background-color:#ADD8E6;">Balance</th>
		
				<tr>

					<td style="background-color:#C0C0C0;" id="ac_no">${ac_no}</td>
					<td style="background-color:#C0C0C0;" id="balance">${balance}</td>
					
					
				</tr>
				<tr>
					<input type="text" id="withrawn" name="withrawn"></input>
				</tr>
					<%-- <button onclick=withdraw();>Withdraw from this a/c</button>
			
		</table>
		
			Withdraw from this a/c<a href="/withdraw/${ac_no}/${balance}">here</a> --%>
	</div>
</body>
</html>
<script type="text/javascript">
<!-- function withdraw(){
		var ac_no=document.getElementById("ac_no").value;
		var balance=document.getElementById("balance").value;
		var withrawn=document.getElementById("withrawn").value;
		if(withrawn<=balance)
			{
			$.ajax({
			}
			type:"POST",
			url:"/withdraw/"+ac_no+"/"+balance+"/"+withrawn
			});
			}
else
	alert("You have less balance than you trying to withdraw");
}
</script> -->