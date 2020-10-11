<%@page import="com.bean.TreatmentDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.ITreatmentDetailsDAO"%>
<%@page import="com.dao.TreatmentDetailsDAO"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Display All treatment Details of Patients</title>
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
						href="index.html"><i class="fas fa-tachometer-alt"></i><span>DashBoard</span></a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						href="profile.html"><i class="fas fa-user"></i><span>Profile</span></a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						href="#"><i class="fas fa-table"></i><span>Treatment Details Table</span></a></li>
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
					<div align="left">		
						<table class="table">
						 
						
						  	<tr>
				                <th>Treatment Details ID</th>
				                <th>Patient ID</th>
				                <th>Doctor ID</th>
				                <th>Blood Pressure</th>
				                <th>Heart Rate</th>
				                <th>SPO2</th>
				                <th>Fluid In-take</th>
				                <th>Fluid Output</th>
				               	<th>Select</th> 
				            </tr>
				            <%
					            ITreatmentDetailsDAO iTreatmentDetailsDAO = new TreatmentDetailsDAO();
								ArrayList<TreatmentDetails> arrayList = iTreatmentDetailsDAO.getTreatmentDetails();
								
								for(TreatmentDetails treatmentDetails : arrayList){
							%>
							 <tr>
								<td> <%=treatmentDetails.getTreatmentDetailsID() %> </td>
								<td> <%=treatmentDetails.getPatientID() %> </td>
								<td> <%=treatmentDetails.getDoctorID()%> </td>
								<td> <%=treatmentDetails.getbP() %> </td>
								<td> <%=treatmentDetails.gethR()%> </td>
								<td> <%=treatmentDetails.getsPO2() %> </td>
								<td> <%=treatmentDetails.getFintake() %> </td>
								<td> <%=treatmentDetails.getFoutput() %> </td>	
								<td> 
									<form method="POST" action="#">
										<input type="hidden" name="treatmentDetailsID" value="<%=treatmentDetails.getTreatmentDetailsID()%>"/>
										<input type="submit" value= "selectTreatmentDetails" class="select-button" /> 
									 </form>
								 </td>
								</tr>			
							<%	
							   }
				            %>     
						</table>
					</div>
				</div>
			</div>
			<footer class="bg-white sticky-footer">
				<div class="container my-auto">
					<div class="text-center my-auto copyright">
						<span>Copyright � Brand 2020</span>
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