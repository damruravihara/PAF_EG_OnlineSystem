<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
		.consumptionForm{
			width: 800px;
			margin: 50px auto;

		}
	</style>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	
	<script type="text/javascript"><script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script></script>

</head>
<body>
<div class="consumptionForm">
	<div class="container">
<form class="row g-3">
  <div class="col-md-2">
    <label for="inputEmail4" class="form-label" >User ID</label>
    <input type="text" class="form-control" id="inputEmail4" placeholder="User ID" >
  </div>
  <div class="col-12">
    <label for="inputAddress" class="form-label">Account Number</label>
    <input type="text" class="form-control" id="inputAddress" placeholder="Account Number">
  </div>
  <div class="col-12">
    <label for="inputAddress" class="form-label">Customer Name</label>
    <input type="text" class="form-control" id="inputAddress" placeholder="Customer Name">
  </div>
 
 
  <div class="col-md-4">
    <label for="inputState" class="form-label">Units</label>
    <input type="text" name="" id="inputState" class="form-select" placeholder="Units" /> 
      
  </div>
  <div class="col-md-2">
    <label for="inputZip" class="form-label">Days</label>
    <input type="text" class="form-control" id="inputZip" placeholder="Days">
  </div><br/><br/>
   <div class="col-md-6">
    <label for="inputCity" class="form-label">Generated date</label>
    <input type="date" class="form-control" id="inputCity">
  </div>
  
  <div class="col-12">
    <button type="submit" class="btn btn-primary">Done</button>
  </div>
  
</form>
</div>
</div>
</body>
</html>