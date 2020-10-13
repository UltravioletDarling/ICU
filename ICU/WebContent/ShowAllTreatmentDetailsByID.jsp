<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.bean.TreatmentDetails"%>
<%@page import="com.bean.TreatmentDetails_investigations"%>
<%@page import="com.bean.TreatmentDetails_medicine"%>
<%@page import="com.bean.TreatmentDetails_supportSystems"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.ITreatmentDetailsDAO"%>
<%@page import="com.dao.TreatmentDetailsDAO"%>
<!DOCTYPE html>
<html>

<head>
	<style> 
		.deleteButton{
		  background-color: #ff0000;
		  border: none;
		  color: white;
		  padding: 16px 32px;
		  text-decoration: none;
		  margin: 4px 2px;
		  cursor: pointer;
		}
	</style>
	<%
       							int TreatmentDetailsID = (int) request.getAttribute("TreatmentDetailsID");
       
					            ITreatmentDetailsDAO iTreatmentDetailsDAO = new TreatmentDetailsDAO();
					            
								TreatmentDetails treatmentDetails = iTreatmentDetailsDAO.getTreatmentDetailsByID(Integer.toString(TreatmentDetailsID));
								ArrayList<TreatmentDetails_investigations> arrayListInvestigations = iTreatmentDetailsDAO.getTreatmentDetails_investigationsByID(Integer.toString(TreatmentDetailsID));
								ArrayList<TreatmentDetails_medicine> arrayListMedicine = iTreatmentDetailsDAO.getTreatmentDetails_medicineByID(Integer.toString(TreatmentDetailsID));
								ArrayList<TreatmentDetails_supportSystems> arrayListSupportSystems = iTreatmentDetailsDAO.getTreatmentDetails_supportSystemsByID(Integer.toString(TreatmentDetailsID));
	%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Treatment Details of patient <%=treatmentDetails.getPatientID() %></title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/css/select2.css">
</head>

<body id="page-top">
    <div id="wrapper">
        <nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0">
            <div class="container-fluid d-flex flex-column p-0">
                <a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#">
                    <div class="sidebar-brand-icon rotate-n-15"><i class="fas fa-laugh-wink"></i></div>
                    <div class="sidebar-brand-text mx-3"><span>ICU Management</span></div>
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
						href="AddTreatmentDetails.jsp"><i class="fas fa-table"></i><span>Add new Record</span></a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						href="login.html"><i class="far fa-user-circle"></i><span>Login</span></a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						href="register.html"><i class="fas fa-user-circle"></i><span>Register</span></a></li>
                </ul>
                <div class="text-center d-none d-md-inline"><button class="btn rounded-circle border-0" id="sidebarToggle" type="button"></button></div>
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
                <h3 class="text-dark mb-4">All Treatment Details of Patient ID: <%=treatmentDetails.getPatientID() %></h3>
                <div class="row mb-3">
                    <div class="col-lg-4">
                        <div class="card mb-3">
                        <div class="card-header py-3">
                                <h6 class="text-primary font-weight-bold m-0">General Details</h6>
                            </div>
                            <div class="card-body text-center shadow"><img class="rounded-circle mb-3 mt-4" src="assets/img/avatars/default.jpeg" width="160" height="160">
                                <div>
                                    <p class="text-left small">Treatment Details ID</p>
                                    <p id="name" class="text-left font-weight-bold"><%=TreatmentDetailsID%></p>
                                    <hr>
                                    <p class="text-left small">Patient ID</p>
                                    <p id="age-gender" class="text-left font-weight-bold"><%=treatmentDetails.getPatientID()%></p>
                                    <hr>
                                    <p class="text-left small">Patient Name</p>
                                    <p id="diagnosis" class="text-left font-weight-bold">Name of Patient</p>
                                    <hr>
                                    <p class="text-left small">Id of Attending Doctor</p>
                                    <p id="diagnosis" class="text-left font-weight-bold"><%=treatmentDetails.getDoctorID()%></p>
                          


                                </div>
                                <div class="mb-3"></div>
                            </div>
                        </div>
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="text-primary font-weight-bold m-0">Vitals</h6>
                            </div>
                            <div class="card-body">
                                <div>
                                    <p class="text-left small">Blood Pressure</p>
                                    <p id="diagnosis" class="text-left font-weight-bold"><%=treatmentDetails.getbP() %></p>
                                    <hr>
                                    <p class="text-left small">Heart Rate</p>
                                    <p id="diagnosis" class="text-left font-weight-bold"><%=treatmentDetails.gethR() %></p>
                                    <hr>
                                    <p class="text-left small">Blood Oxygen Level(SPO2)</p>
                                    <p id="diagnosis" class="text-left font-weight-bold"><%=treatmentDetails.getsPO2() %></p>
                                    <hr>
                                    <p class="text-left small">Fluid In-take</p>
                                    <p id="diagnosis" class="text-left font-weight-bold"><%=treatmentDetails.getFintake() %></p>
                                    <hr>
                                    <p class="text-left small">Fluid Out-put</p>
                                    <p id="diagnosis" class="text-left font-weight-bold"><%=treatmentDetails.getFoutput() %></p>
                                    <hr>
                                    <form method="POST" action="DisplayTreatmentDetailsByIDServlet">
										<input type="hidden" name="treatmentDetailsID" value="<%=TreatmentDetailsID%>"/>
										<input type="submit" value= "Update general and Vital details" class="select-button" /> 
									 </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8">
                      <!-- <div class="row mb-3 d-none">
                            <div class="col">
                                <div class="card text-white bg-primary shadow">
                                    <div class="card-body">
                                        <div class="row mb-2">
                                            <div class="col">
                                                <p class="m-0">Peformance</p>
                                                <p class="m-0"><strong>65.2%</strong></p>
                                            </div>
                                            <div class="col-auto"><i class="fas fa-rocket fa-2x"></i></div>
                                        </div>
                                        <p class="text-white-50 small m-0"><i class="fas fa-arrow-up"></i>&nbsp;5% since last month</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col">
                                <div class="card text-white bg-success shadow">
                                    <div class="card-body">
                                        <div class="row mb-2">
                                            <div class="col">
                                                <p class="m-0">Peformance</p>
                                                <p class="m-0"><strong>65.2%</strong></p>
                                            </div>
                                            <div class="col-auto"><i class="fas fa-rocket fa-2x"></i></div>
                                        </div>
                                        <p class="text-white-50 small m-0"><i class="fas fa-arrow-up"></i>&nbsp;5% since last month</p>
                                    </div>
                                </div>
                            </div>
                        </div> -->  
                        <div class="row">
                            <div class="col">
                                <div class="card shadow">
                                    <div class="card-header py-3">
                                       
                                        <p class="text-primary m-0 font-weight-bold">Medicine</p>
                                        <div class="d-flex justify-content-end">	
												<form method="GET" action="AddTreatmentDetails_MedicineServlet">
													<input type="hidden" value ="<%=TreatmentDetailsID%>" name="treatmentDetailsID"> 
													<input type="submit"
																value="Add Support Systems" class="add-button" />
												</form>
											</div>	
                                    </div>
                                    <div class="card-body">
                                       
                                    	<table class="table">
										  	<tr>
								                <th>ID</th>
								                <th>Medicine</th>
								                <th>Dossage</th>
								                <th>Update</th>
								                <th>Delete</th>
								                 
								            </tr>
								            <%
									         
												for(TreatmentDetails_medicine treatmentDetails_medicine : arrayListMedicine){
											%>
											 <tr>
												<td> <%=treatmentDetails_medicine.getTreatmentDetails_medicineID() %> </td>
												<td> <%=treatmentDetails_medicine.getItemId()%> </td>
												<td> <%=treatmentDetails_medicine.getDosage() %> </td>
												<td>  
													<form method="POST" action="DisplayTreatmentDetails_MedicineByID">
					
														<input type="hidden" name="treatmentDetailsID_Medicine" value="<%=treatmentDetails_medicine.getTreatmentDetails_medicineID() %>"/>
														<input type="submit" value= "Update " class="select-button" /> 
									 				</form>
												</td>
												<td>  
													<form method="POST" action="DeleteTreatmentDetails_MedicineServlet">
														<input type="hidden" name="treatmentDetailsID" value="<%=treatmentDetails.getTreatmentDetailsID()%>"/>
														<input type="hidden" name="treatmentDetailsID_Medicine" value="<%=treatmentDetails_medicine.getTreatmentDetails_medicineID() %>"/>
														<input type="submit" value= "Delete" class="select-button" /> 
									 				</form>
												</td>
											</tr>			
											<%	
											   }
								            %>     
										</table>
											
									</div>
								</div>
								<div class="card shadow mt-3">
									<div class="card-header py-3">
												
											<p class="text-primary m-0 font-weight-bold">Support Systems</p>
											<div class="d-flex justify-content-end">	
												<form method="GET" action="AddTreatmentDetails_SupportSystemsServlet">
													<input type="hidden" value ="<%=TreatmentDetailsID%>" name="treatmentDetailsID"> 
													<input type="submit"
																value="Add Support Systems" class="add-button" />
												</form>
											</div>		
									</div>
											
									<div class="card-body">
											
										<table class="table">
										  	<tr>
								                <th>ID</th>
								                <th>Support System</th>
								                <th>Amount</th>
								                <th>Update</th>
								                <th>Delete</th>
								                 
								            </tr>
								            <%
									           
												for(TreatmentDetails_supportSystems treatmentDetails_medicine : arrayListSupportSystems){
											%>
											 <tr>
												<td> <%=treatmentDetails_medicine.getTreatmentDetails_supportSystemsID() %> </td>
												<td> <%=treatmentDetails_medicine.getSystemName()%> </td>
												<td> <%=treatmentDetails_medicine.getAmount() %> </td>
												<td>  
													<form method="POST" action="">
														<input type="hidden" name="treatmentDetailsID" value="<%=treatmentDetails.getTreatmentDetailsID()%>"/>
														<input type="hidden" name="treatmentDetailsID_SupportSystems" value="<%=treatmentDetails_medicine.getTreatmentDetails_supportSystemsID() %>"/>
														<input type="submit" value= "Update " class="select-button" /> 
									 				</form>
												</td>
												<td>  
													<form method="POST" action="DeleteTreatmentDetails_SupportSystemsServlet">
														<input type="hidden" name="treatmentDetailsID" value="<%=treatmentDetails.getTreatmentDetailsID()%>"/>
														<input type="hidden" name="treatmentDetailsID_SupportSystems" value="<%=treatmentDetails_medicine.getTreatmentDetails_supportSystemsID() %>"/>
														<input type="submit" value= "Delete" class="select-button" /> 
									 				</form>
												</td>
											
											</tr>			
											<%	
											   }
								            %>     
										</table>
												
									</div>
								</div>
												
								<div class="card shadow mt-3" id="description-card">
									<div class="card-header py-3">
												
											<p class="text-primary m-0 font-weight-bold">Investigations</p>
											<div class="d-flex justify-content-end">	
												<form method="GET" action="AddTreatmentDetails_InvestigationsServlet">
													<input type="hidden" value ="<%=TreatmentDetailsID%>" name="treatmentDetailsID"> 
													<input type="submit"
																value="Add Support Systems" class="add-button" />
												</form>
											</div>			
									</div>
												
									<div class="card-body">
										<table class="table">
										 	<tr>
								                <th>ID</th>
								                <th>Investigation Name</th>
								                <th>Result</th>
								                <th>Update</th>
								                <th>Delete</th>
								                 
								            </tr>
								            <%
												for(TreatmentDetails_investigations treatmentDetails_investigations : arrayListInvestigations){
											%>
											 <tr>
												<td> <%=treatmentDetails_investigations.getTreatmentDetails_investigationsID() %> </td>
												<td> <%=treatmentDetails_investigations.getInvestigationname()%> </td>
												<td> <%=treatmentDetails_investigations.getResult()%> </td>
												<td>  
													<form method="POST" action="">
														<input type="hidden" name="treatmentDetailsID" value="<%=treatmentDetails.getTreatmentDetailsID()%>"/>
														<input type="hidden" name="treatmentDetailsID_Investigations" value="<%=treatmentDetails_investigations.getTreatmentDetails_investigationsID() %>"/>
														<input type="submit" value= "Update " class="select-button" /> 
									 				</form>
												</td>
												<td>  
													<form method="POST" action="DeleteTreatmentDetails_InvestigationsServlet">
														<input type="hidden" name="treatmentDetailsID" value="<%=treatmentDetails.getTreatmentDetailsID()%>"/>
														<input type="hidden" name="treatmentDetailsID_Investigations" value="<%=treatmentDetails_investigations.getTreatmentDetails_investigationsID() %>"/>
														<input type="submit" value= "Delete" class="select-button" /> 
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
						</div>
					</div>
				</div>								
			</div>									
			<div class="d-flex justify-content-center">
				<form method="POST" action="DeleteTreatmentDetails_ALLByIDServelet">
					<input type="hidden" name="treatmentDetailsID" value="<%=treatmentDetails.getTreatmentDetailsID()%>"/>
					<input type="submit" value= "Delete This Whole Record" class="deleteButton" /> 									
				</form>					 													
			</div>					
			
			
        </div>
			<footer class="bg-white sticky-footer">
				<div class="container my-auto">
					<div class="text-center my-auto copyright"><span>Copyright © ICU Management 2020</span></div>
				</div>
			</footer>
		</div><a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a></div>
		

</body>

</html>