<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ElectroGrid Online System</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/customer.js"></script>
<style type="text/css">
.hide{  
	visibility: hidden;
  	border: none;
  	}
</style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>

<div class="container">
<br>
<center><h2>Customer Management</h2>\</center>
<div class="row">
	<div class="col-lg-12">
	<div class="card m-b-32">
	<div class="card-body">
	<form id="formCustomer" name="formCustomer" method="post" action="AddCustomer.jsp">
	
		<label>Customer Name</label> <input id="cus_name"
			name="cus_name" type="text"
		    class="form-control form-control-sm">
			<br>
			
			<label>Address</label> <input id="cus_address"
			name="cus_address" type="text"
		    class="form-control form-control-sm">
			<br>
			
		    <label>Phone Number</label> <input id="cus_phone_no"
			name="cus_phone_no" type="text"
		    class="form-control form-control-sm">
			<br>
			
			<label>NIC</label> <input id="cus_nic"
			name="cus_nic" type="text"
		    class="form-control form-control-sm">
			<br>
			
			<label>UserName</label> <input id="username"
			name="username" type="text"
		    class="form-control form-control-sm">
			<br>
			
			<label>Password</label> <input id="password"
			name="password" type="password"
		    class="form-control form-control-sm">
			<br>

			<div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" onclick="myFunction()">
  <label class="form-check-label" for="flexCheckDefault">
    Show Password
  </label>
</div>
			<br>
			<label>Account Number</label> <input id="account_number"
			name="account_number" type="text"
		    class="form-control form-control-sm">
			<br>
			
			<input id="btnSave" name="btnSave" type="button" value="Save"
			class="btn btn-primary"> <input type="hidden"
				id="idcustomer" name="idcustomer" value="">		
	</form>
	<br>
						<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>
					<br> <br>
										<div id="divUserGrid">
						<%
						Customer customerObj = new Customer();
											out.print(customerObj.readCustomers());
						%>
					</div>
	</div>
	</div>
	</div>
</div>
<br>
</div>
<script>
function myFunction() {
  var x = document.getElementById("password");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>
</body>
</html>