<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Expense</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("#deleteExpense").hide();
     $("#updateExpense").hide();
    
    $("#update").click(function(){
        $("#updateExpense").show();
        $("#deleteExpense").hide();
    });
    $("#delete").click(function(){
        $("#deleteExpense").show();
         $("#updateExpense").hide();
    });
});

</script>
</head>
<body class="container container-fluid">
	<div id="add">
		<h1>Add Expense</h1>
		<form action="ExpenseController" method="GET">
			<table class="table">
				<tr >
					<td>Expense Name:</td>
					<td><input type="text" name="ename"></td>
				</tr>
				<tr >
					<td>Expense Description:</td>
					<td><input type="text" name="edesc"></td>
				</tr>
				<tr >
					<td>Expense Price:</td>
					<td><input type="text" name="eprice"></td>
				</tr>
				

				
			</table>
		<div>
		<button class="btn btn-danger" type="submit" name="addExpense" value="Add">ADD</button>
		<button class="btn btn-info" type="submit" formmethod="post" name="showExpense" value="Show">SHOW</button>
		</div>
		</form>
	</div>
    <div class="mt-3">
		<h1>All Expenses:</h1>
		<br>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Expense Name</th>
					<th scope="col">Expense Description</th>
					<th scope="col">Expense Price</th>
					<th scope="col">Expense Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="exp" items="${ExpenseList}">
					<tr>
						<th scope="row">${exp.id}</th>
						<td>${exp.ename}</td>
						<td>${exp.edesc}</td>
						<td>${exp.eprice}</td>
						<td>${exp.edate}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<form name="formid" action="ExpenseController" method="POST">
			<br>Select ID of Expense for update or delete:  <select class="browser-default custom-select" name="id" onchange="document.getElementById('butn').click()">
			    <option value="">--Select one--</option>
				<c:forEach items="${ExpenseList}" var="Expense">
     			
     				<option value="${Expense.id}" ${record.id == Expense.id ? 'selected' : ''}>${Expense.id}</option>
     				
				</c:forEach>
			</select> 
			<input class="btn btn-white mt-2" type="submit" hidden="true" id="butn" value="Fill existing field values" name="showInfo" formmethod="get">
			<br>
			<br>
			<div class="d-flex flex-column ">
			<div><input type="radio" id="update" name="choice" onclick="document.getElementById('hiddenUpdate').hidden=!this.checked;" ${empty record ? 'disabled': ''}>   Update</div>
			<div><input type="radio" id="delete" name="choice" 
				onclick="document.getElementById('hiddenUpdate').hidden=this.checked;" ${empty record ? 'disabled': ''}>   Delete<br>
				</div></div>
			<div id="hiddenUpdate" hidden="true" >
			<table class="table mt-3">
				<tr >
					<td>Update Expense Name:</td>
					<td><input type="text" id="enameupdate" name="enameupdate" value="${record.ename}"></td>
				</tr>
				<tr >
					<td>Update Expense Description:</td>
					<td><input type="text" id="edescupdate" name="edescupdate" value="${record.edesc}"></td>
				</tr>
				<tr >
					<td>Update Expense Price:</td>
					<td><input type="text" id="epriceupdate" name="epriceupdate" value="${record.eprice}" ></td>
				</tr>
			</table>
			</div>	
			<button type="submit" class="btn btn-success" id="updateExpense" name="updateExpense">
				UPDATE</button>
			<br> <br>
			<button class="btn btn-danger" type="submit" id="deleteExpense" name="deleteExpense">
				DELETE</button>




		</form>
	</div>
	
</body>
</html>
