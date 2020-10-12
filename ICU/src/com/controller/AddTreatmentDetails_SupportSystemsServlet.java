package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.TreatmentDetails_supportSystems;
import com.dao.ITreatmentDetailsDAO;
import com.dao.TreatmentDetailsDAO;

/**
 * Servlet implementation class AddTreatmentDetails_SupportSystemsServlet
 */
@WebServlet("/AddTreatmentDetails_SupportSystemsServlet")
public class AddTreatmentDetails_SupportSystemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{response.setContentType("text/html");
		
		
		request.setAttribute("TreatmentDetailsID", Integer.parseInt(request.getParameter("treatmentDetailsID")));
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addTreatmentDetails_SupportSystems.jsp");
		dispatcher.forward(request, response);
		
		}catch(Exception e){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Fail.jsp");
			dispatcher.forward(request, response);
		}
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			response.setContentType("text/html; charset=ISO-8859-1");

			TreatmentDetails_supportSystems treatmentDetails_supportSystems = new TreatmentDetails_supportSystems();
		
			treatmentDetails_supportSystems.setTreatmentDetailsID(Integer.parseInt(request.getParameter("treatmentDetailsID")));
			treatmentDetails_supportSystems.setSystemName(request.getParameter("supportSystemName"));
			treatmentDetails_supportSystems.setAmount(request.getParameter("amount"));
			
		
			
			ITreatmentDetailsDAO iTreatmentDetails= new TreatmentDetailsDAO();
			iTreatmentDetails.addTreatmentDetails_supportSystems(treatmentDetails_supportSystems);
				
			request.setAttribute("TreatmentDetailsID", treatmentDetails_supportSystems.getTreatmentDetailsID());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addTreatmentDetails_SupportSystems.jsp");
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

}
