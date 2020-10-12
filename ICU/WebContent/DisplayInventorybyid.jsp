<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<%
	String itemid = request.getParameter("itemid");
	String adminid = request.getParameter("adminid");
	String name = request.getParameter("name");
	String stock = request.getParameter("stock");
	String aquired = request.getParameter("aquired");
	String expiry = request.getParameter("expiry");
	String udosage = request.getParameter("udosage");
	String type = request.getParameter("type");
	String maintenance = request.getParameter("maintenance");
%>



<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Blank Page - Brand</title>
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
				
				 <div class="container-fluid">
                <h3 class="text-dark mb-1" style="margin: 48px;">Viewing Item  <%= itemid %></h3>
            </div>
            <form action="Updateinventoryservlet" method="post">
            
            <table>
	     	<tr>
	     	
			<td>Item ID</td>
			<td><input type="text" name="itemid" value="<%= itemid %>" readonly></td>
		    </tr>
		    <tr>
			<td>Admin ID</td>
			<td><input type="text" name="adminid" value="<%= adminid %>"></td>
		    </tr>
		     <tr>
			<td>Item Name</td>
			<td><input type="text" name="name" value="<%= name %>"></td>
		    </tr>
		     <tr>
			<td>Stock</td>
			<td><input type="text" name="stock" value="<%= stock %>"></td>
		    </tr>
		     <tr>
			<td>Aquired Date</td>
			<td><input type="date" name="aquired" value="<%= aquired %>"></td>
		    </tr>
		     <tr>
			<td>Expiry Date</td>
			<td><input type="text" name="expiry" value="<%= expiry %>"></td>
		    </tr>
		     <tr>
			<td>Unit Dosage</td>
			<td><input type="text" name="udosage" value="<%= udosage %>"></td>
		    </tr>
		    <tr>
			<td>Item Type</td>
			<td><input type="text" name="type" value="<%= type %>"></td>
		    </tr>
		     <tr>
			<td>Next Maintenance Date</td>
			<td><input type="date" name="maintenance" value="<%= maintenance %>"></td>
		    <td> 
		     </tr>
		    
		    
	</table>
	</br>
	<input type="submit" name="submit" value="Update Record">
	  
            </form>
            <br>
            
            <form method="POST" action="Deleteinventoryservlet">
			<input type="submit" value= "Delete Record" class="select-button" /> 
	</form>
	
	
	
		        
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
	
	<script>
    window.onload = function() {
        document.getElementById("autoSubmit").submit();
    }
</script>

</body>

</html>