package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.TreatmentDetails_medicine;
import com.dao.ITreatmentDetailsDAO;
import com.dao.TreatmentDetailsDAO;

/**
 * Servlet implementation class AddTreatmentDetails_MedicineServlet
 */
@WebServlet("/AddTreatmentDetails_MedicineServlet")
public class AddTreatmentDetails_MedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		try {
				response.setContentType("text/html; charset=ISO-8859-1");
	
				TreatmentDetails_medicine treatmentDetails_medicine = new TreatmentDetails_medicine();
			
				treatmentDetails_medicine.setTreatmentDetailsID(Integer.parseInt(request.getParameter("treatmentDetailsID")));
				treatmentDetails_medicine.setItemId(request.getParameter("itemID"));
				treatmentDetails_medicine.setDosage(request.getParameter("dosage"));
				
			
				
				ITreatmentDetailsDAO iTreatmentDetails= new TreatmentDetailsDAO();
				iTreatmentDetails.addTreatmentDetails_medicine(treatmentDetails_medicine);
					
				request.setAttribute("TreatmentDetailsID", treatmentDetails_medicine.getTreatmentDetailsID());
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addTreatmentDetails_Medicine.jsp");
				dispatcher.forward(request, response);
					
				
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try{response.setContentType("text/html");
		
		
		request.setAttribute("TreatmentDetailsID", Integer.parseInt(request.getParameter("treatmentDetailsID")));
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addTreatmentDetails_Medicine.jsp");
		dispatcher.forward(request, response);
		
		}catch(Exception e){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Fail.jsp");
			dispatcher.forward(request, response);
		}
	}
}
