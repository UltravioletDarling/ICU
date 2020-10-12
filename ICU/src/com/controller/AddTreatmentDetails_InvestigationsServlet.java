package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TreatmentDetails_investigations;

import com.dao.ITreatmentDetailsDAO;
import com.dao.TreatmentDetailsDAO;

/**
 * Servlet implementation class AddTreatmentDetails_InvestigationsServlet
 */
@WebServlet("/AddTreatmentDetails_InvestigationsServlet")
public class AddTreatmentDetails_InvestigationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{response.setContentType("text/html; charset=ISO-8859-1");
		
		
		request.setAttribute("TreatmentDetailsID", Integer.parseInt(request.getParameter("treatmentDetailsID")));
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DisplayAllTreatmentDetails.jsp");
		dispatcher.forward(request, response);
		}catch(Exception e){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Fail.jsp");
			dispatcher.forward(request, response);
		}
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			response.setContentType("text/html; charset=ISO-8859-1");

			TreatmentDetails_investigations treatmentDetails_investigations = new TreatmentDetails_investigations();
		
			treatmentDetails_investigations.setTreatmentDetailsID(Integer.parseInt(request.getParameter("treatmentDetailsID")));
			treatmentDetails_investigations.setInvestigationname(request.getParameter("investigationName"));
			treatmentDetails_investigations.setResult(request.getParameter("result"));
			
		
			
			ITreatmentDetailsDAO iTreatmentDetails= new TreatmentDetailsDAO();
			iTreatmentDetails.addTreatmentDetails_investigations(treatmentDetails_investigations);
				
			request.setAttribute("TreatmentDetailsID", treatmentDetails_investigations.getTreatmentDetailsID());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addTreatmentDetails_investigations.jsp");
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
