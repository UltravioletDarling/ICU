<%@page import="com.bean.TreatmentDetails_investigations"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.ITreatmentDetailsDAO"%>
<%@page import="com.dao.TreatmentDetailsDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Add Investigations</title>
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
						<span>ICU Management</span>
					</div>
				</a>
				<hr class="sidebar-divider my-0">
				<ul class="nav navbar-nav text-light" id="accordionSidebar">
					<li class="nav-item" role="presentation"><a class="nav-link"
						href="index.html"><i class="fas fa-tachometer-alt"></i><span>DashBoard</span></a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						href="profile.html"><i class="fas fa-user"></i><span>Profile</span></a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						href="DisplayAllTreatmentDetails.jsp"><i class="fas fa-table"></i><span>Treatment Details Table</span></a></li>
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
					<h3 class="text-dark mb-1">Insert the Patient's Treatment
						Details</h3>
						<p>PLease fill out all fields before adding</p>
						<% 
							int TreatmentDetailsID = (int) request.getAttribute("TreatmentDetailsID");
							

						%>
					<form method="POST" action="AddTreatmentDetails_InvestigationsServlet">
						<table class="table">
						<tr>
								<td>Treatment Details ID</td>
								<td><input type="text" value = "<%=TreatmentDetailsID%>" name="treatmentDetailsID" readonly/></td>
								<td>This record is for this treatment ID</td>
							</tr>

							<tr>
								<td>Investigation Name</td>
								<td><input type="text" required="required" name="investigationName" pattern="[A-Za-z0-9]{1,45}"/></td>
								<td></td>
							</tr>
							<tr>
								<td>Result</td>
								<td><input type="text" required="required" name="result"  pattern="[A-Za-z0-9]{1,200}"/></td>
								<td></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit"
									value="Add Support System" class="add-button" /></td>
							</tr>
											
							<tr>	
								<td colspan="2"><input type="reset" value="Reset" class="reset-button" /></td>
							</tr> 
			
						</table>
					</form>
					<div class="d-flex justify-content-end">	
						<form method="POST" action="AddTreatmentDetails_InvestigationsServlet">
									<input type="hidden" value="<%=TreatmentDetailsID%>" name="treatmentDetailsID" />
									<input type="hidden" value="ECG" name="investigationName" />
									<input type="hidden" value="pending" name="result" />
									<input type="submit"
										value="Add investigation DEMO" class="add-button" />
						</form>
						<form method="POST" action="DisplayAllTreatmentDetailsServlet">
							<input type="hidden" value ="<%=TreatmentDetailsID%>" name="treatmentDetailsID"> 
							<input type="submit"
										value="Display All Treatment details" class="add-button" />
						</form>
					
					</div>
					
					
					<form method="GET" action="DisplayAllTreatmentDetailsServlet">
						<input type="hidden" value ="<%=TreatmentDetailsID%>" name="treatmentDetailsID"> 
						<input type="submit"
									value="Done!" class="add-button" />
					
					</form>
					
					
					
					
					
					<table class="table">
						 
						
						  	<tr>
				                <th>ID</th>
				                <th>Investigation Name</th>
				                <th>Result</th>
				                 
				            </tr>
				            <%
					            ITreatmentDetailsDAO iTreatmentDetailsDAO = new TreatmentDetailsDAO();
								ArrayList<TreatmentDetails_investigations> arrayList = iTreatmentDetailsDAO.getTreatmentDetails_investigationsByID(Integer.toString(TreatmentDetailsID));
								
								for(TreatmentDetails_investigations treatmentDetails_investigations : arrayList){
							%>
							 <tr>
								<td> <%=treatmentDetails_investigations.getTreatmentDetails_investigationsID() %> </td>
								<td> <%=treatmentDetails_investigations.getInvestigationname()%> </td>
								<td> <%=treatmentDetails_investigations.getResult()%> </td>
							
							</tr>			
							<%	
							   }
				            %>     
						</table>

				</div>
			</div>
			<footer class="bg-white sticky-footer">
				<div class="container my-auto">
					<div class="text-center my-auto copyright">
						<span>Copyright © ICU Management 2020</span>
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