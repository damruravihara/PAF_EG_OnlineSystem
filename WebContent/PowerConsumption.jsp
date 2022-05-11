<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	
	<script type="text/javascript"><script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script></script>
	<style type="text/css">
		*{
			margin:0 ;
			padding: 0;
			box-sizing: border-box;
		}
		.body{
			background-color: #32312f;
			font-family: sans-serif;
		}
		.table-container{
			padding: 0 10%;
			margin: 40px auto 0;
		}
		.heading{
			font-size: 40px;
			text-align: center;
			color: #f1f1f1;
			margin-bottom: 40px;
		}
		.table{
			width: 100%;
			border-collapse: collapse;
			margin-top: 50px;
		}
		.table thead{
			background-color: #76030f;
		}
		.table thead tr th{
			font-size: 14px;
			font-weight: 600;
			letter-spacing: 0.35px;
			color: #ffff;
			opacity: 1;
			padding: 12px;
			vertical-align: top;
			border: 1px solid #dee2e685;

		}
		.table tbody tr td{
			font-size: 14px;
			font-weight: normal;
			letter-spacing: 0.35px;
			color: #f1f1f1;
			background-color: #3c3f44;
			padding: 8px;
			text-align: center;
			border:1px solid #dee2e685;
		}
		#btn-record{
			margin-left: 85%;
		}
		

		

	</style>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	
	<script type="text/javascript"><script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script></script>

</head>
<body>
<body class="body">
	<div class="table-container">
		<h1 class="heading">Power Consumption Management</h1>
		
		<a href="AddPowerConsumption.jsp">
		<button class="btn btn-primary" id="btn-record">Add New Record</button>
		</a>
		<table class="table">
			<thead>
				<tr>
					<th>User ID</th>
					<th>Account Number</th>
					<th>Customer Name</th>
					<th>Units</th>
					<th>Days</th>
					<th>Generated Date</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td data-label="User ID">001</td>
					<td data-label="Account Number">21584632</td>
					<td data-label="Customer Name">Hewageegana R.U</td>
					<td data-label="Units">120</td>
					<td data-label="Days">30</td>
					<td data-label="Generated Date">30/05/2022</td>
					<td data-label="Action" >
						<div class="consBtn"><button class="btn btn-success" id="btn-update">Update</button>&nbsp;
					<button class="btn btn-danger" id="btn-delete">Delete</button></div></td>
				</tr>
			</tbody>
	
		</table>
	</div>



</body>
</html>