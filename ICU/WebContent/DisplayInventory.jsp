<%@page import="com.bean.inventoryitem"%>
<%@page import="com.controller.Displayinventoryservlet"%>
<%@page import="com.dao.DisplayinventoryDao"%>
<%@page import="com.dao.Inventorylistinterfacedao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Inventory Manager</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
<link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
</head>

<body id="page-top">
	<div id="wrapper">
		<nav
			class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0">
			<div class="container-fluid d-flex flex-column p-0">
				<a
					class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0"
					href="#">
					<div class="sidebar-brand-icon rotate-n-15">
						<i class="fas fa-laugh-wink"></i>
					</div>
					<div class="sidebar-brand-text mx-3">
						<span>Brand</span>
					</div>
				</a>
				<hr class="sidebar-divider my-0">
				<ul class="nav navbar-nav text-light" id="accordionSidebar">
					<li class="nav-item" role="presentation"><a class="nav-link"
						href="index.html"><i class="fas fa-tachometer-alt"></i><span>Dashboard</span></a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						href="profile.html"><i class="fas fa-user"></i><span>Profile</span></a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						href="table.html"><i class="fas fa-table"></i><span>Table</span></a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						href="login.html"><i class="far fa-user-circle"></i><span>Login</span></a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						href="register.html"><i class="fas fa-user-circle"></i><span>Register</span></a></li>
				</ul>
				<div class="text-center d-none d-md-inline">
					<button class="btn rounded-circle border-0" id="sidebarToggle"
						type="button"></button>
				</div>
			</div>
		</nav>
		<div class="d-flex flex-column" id="content-wrapper">
			<div id="content">
				<nav
					class="navbar navbar-light navbar-expand bg-white shadow mb-4 topbar static-top">
					<div class="container-fluid">
						<button class="btn btn-link d-md-none rounded-circle mr-3"
							id="sidebarToggleTop" type="button">
							<i class="fas fa-bars"></i>
						</button>
						<form
							class="form-inline d-none d-sm-inline-block mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
							<div class="input-group">
								<input class="bg-light form-control border-0 small" type="text"
									placeholder="Search for ...">
								<div class="input-group-append">
									<button class="btn btn-primary py-0" type="button">
										<i class="fas fa-search"></i>
									</button>
								</div>
							</div>
						</form>

					</div>
				</nav>
	
<div class="limiter">
<div class="container-table100">
<div class="wrap-table100">
				<div class="table100">
					
<table>
			 
			  	<tr class="table100-head">
	              	   <th class="column1">Item ID</th>
		               <th class="column2">Admin ID</th>
		               <th class="column3">Item Name</th> 
		               <th class="column4">Remaining Stock</th>
		               <th class="column5">Aquired Date</th>
		               <th class="column6">Expiry Date</th>
		               <th class="column5">Unit Dosage</th>
		               <th class="column4">Item Type</th>
		               <th class="column3">Next Maintenance</th>
		               <th colspan = "0"></th>
		        </tr>
		        
		        <%
		            Inventorylistinterfacedao inventorylistinterfacedao = new DisplayinventoryDao();
		            ArrayList<inventoryitem> arraylist = inventorylistinterfacedao.getdetails();
		        		        		for(inventoryitem inventoryitem: arraylist){
		        		        %>
				
		     <tr>
					<td class="column1"> <%=inventoryitem.getItemid() %></td>
					<td class="column2"> <%=inventoryitem.getAdminid() %></td>
					<td class="column3"> <%=inventoryitem.getName() %></td>
					<td class="column4"> <%=inventoryitem.getStock() %></td>
					<td class="column5"> <%=inventoryitem.getAquired() %></td>
					<td class="column6"> <%=inventoryitem.getExpiry() %></td>
					<td class="column5"> <%=inventoryitem.getUdosage() %></td>
					<td class="column4"> <%=inventoryitem.getType() %></td>
					<td class="column3"> <%=inventoryitem.getMaintenance() %></td>
					<td class="column1"> 
						<form method="POST" action="DisplayInventorybyid.jsp">
						<input type="hidden" name="itemID" value="<%=inventoryitem.getItemid()%>"/>
						<input type="submit" value= "Select" class="select-button" /> 
					   </form>
					</td>
					
				</tr>			
					<%	
				    }
				      %>    
				      <!-- test -->
				
</table>
</div>
</div>
</div>
</div>


		        
			</div>
			<footer class="bg-white sticky-footer">
				<div class="container my-auto">
					<div class="text-center my-auto copyright">
						<span>Copyright © Brand 2020</span>
					</div>
				</div>
			</footer>
		</div>
		<a class="border rounded d-inline scroll-to-top" href="#page-top"><i
			class="fas fa-angle-up"></i></a>
	</div>
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/chart.min.js"></script>
	<script src="assets/js/bs-init.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
	<script src="assets/js/theme.js"></script>
</body>

</html>