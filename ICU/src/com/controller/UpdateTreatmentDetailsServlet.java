package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TreatmentDetails;
import com.dao.ITreatmentDetailsDAO;
import com.dao.TreatmentDetailsDAO;

/**
 * Servlet implementation class UpdateTreatmentDetailsServlet
 */
@WebServlet("/UpdateTreatmentDetailsServlet")
public class UpdateTreatmentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTreatmentDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");

			TreatmentDetails treatmentDetails = new TreatmentDetails();
		
			treatmentDetails.setTreatmentDetailsID(Integer.parseInt(request.getParameter("treatmentDetailsID")));
			treatmentDetails.setPatientID(request.getParameter("patientID"));
			treatmentDetails.setDoctorID(request.getParameter("doctorID"));
			treatmentDetails.setbP(Integer.parseInt(request.getParameter("bP")));
			treatmentDetails.sethR(Integer.parseInt(request.getParameter("hR")));
			treatmentDetails.setsPO2(Double.parseDouble(request.getParameter("sPO2")));
			treatmentDetails.setFintake(Double.parseDouble(request.getParameter("fintake")));
			treatmentDetails.setFoutput(Double.parseDouble(request.getParameter("foutput")));
			
			
			ITreatmentDetailsDAO iTreatmentDetails= new TreatmentDetailsDAO();
			TreatmentDetails treatmentDetailsout = iTreatmentDetails.UpdateTreatmentDetails(treatmentDetails);
				
			request.setAttribute("TreatmentDetails", (TreatmentDetails)treatmentDetailsout);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateTreatmentDetailsByID.jsp");
			dispatcher.forward(request, response);
//			
//			ITreatmentDetailsDAO iTreatmentDetails= new TreatmentDetailsDAO();
//			TreatmentDetails treatmentDetailsout = iTreatmentDetails.UpdateTreatmentDetails(treatmentDetails);
//				
//			request.setAttribute("TreatmentDetailsID", Integer.parseInt(request.getParameter("treatmentDetailsID")));
//			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ShowAllTreatmentDetailsByID.jsp");
//			dispatcher.forward(request, response);
//				
			
		}
		catch(NumberFormatException e) 
		{
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Fail.jsp");
			dispatcher.forward(request, response);
		}
		
		catch(Exception ex) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Fail.jsp");
			dispatcher.forward(request, response);
		}
	}

}
