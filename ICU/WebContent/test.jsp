<%@page import="com.bean.inventoryitem"%>
<%@page import="com.controller.Inventoryitemservlet"%>
<%@page import="com.dao.InsertinventoryDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!DOCTYPE html>
<html lang="en">
<head>
<title>test</title>
<meta charset="utf-8">


</head>
<body class="page1" id="top">

  

 
<form name="inventoryform" action="Inventoryitemservlet" method="post">
							
		<div class="col-md-6">
			<div class="form-group">
				<span class="form-label">itemid</span>
				<input id="itemid" name="itemid" class="form-control" type="text" >
			</div>
		</div>

	<div class="col-md-6">
			<div class="form-group">
				<span class="form-label">adminid</span>
				<input id="adminid" name="adminid" class="form-control" type="text"  >
			</div>
		</div>
	
	<div class="col-md-6">
			<div class="form-group">
				<span class="form-label">name</span>
				<input id="name" name="name" class="form-control" type="text"  >
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<span class="form-label">stock</span>
				<input id="stock" name="stock" class="form-control" type="text"  >
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<span class="form-label">aquired</span>
				<input id="aquired" name="aquired" class="form-control" type="text"  >
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<span class="form-label">expiry</span>
				<input id="expiry" name="expiry" class="form-control" type="text"  >
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<span class="form-label">udosage</span>
				<input id="udosage" name="udosage" class="form-control" type="text"  >
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<span class="form-label">type</span>
				<input id="type" name="type" class="form-control" type="text"  >
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<span class="form-label">maintenance</span>
				<input id="maintenance" name="maintenance" class="form-control" type="text"  >
			</div>
		</div>
	
		<div class="col-md-3">
			<div class="form-btn">
				<input class="form-btn" type="submit"  name="submit" value="submit Information">
			</div>
		</div>
</form>
	
	


	
</body>

</html>

