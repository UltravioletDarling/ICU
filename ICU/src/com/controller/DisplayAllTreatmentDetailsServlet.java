package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayAllTreatmentDetailsServlet
 */
@WebServlet("/DisplayAllTreatmentDetailsServlet")
public class DisplayAllTreatmentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			response.setContentType("text/html; charset=ISO-8859-1");
			request.setAttribute("TreatmentDetailsID", Integer.parseInt(request.getParameter("treatmentDetailsID")));
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ShowAllTreatmentDetailsByID.jsp");
			dispatcher.forward(request, response);	
		
		}catch(Exception e){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Fail.jsp");
			dispatcher.forward(request, response);		
		}		
	}
	
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

}
