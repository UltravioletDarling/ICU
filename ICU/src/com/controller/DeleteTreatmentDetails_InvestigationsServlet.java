package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ITreatmentDetailsDAO;
import com.dao.TreatmentDetailsDAO;

/**
 * Servlet implementation class DeleteTreatmentDetails_InvestigationsServlet
 */
@WebServlet("/DeleteTreatmentDetails_InvestigationsServlet")
public class DeleteTreatmentDetails_InvestigationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTreatmentDetails_InvestigationsServlet() {
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
			response.setContentType("text/html; charset=ISO-8859-1");

			ITreatmentDetailsDAO iTreatmentDetails= new TreatmentDetailsDAO();
			iTreatmentDetails.DeleteTreatmentDetails_investigationsByID(request.getParameter("treatmentDetailsID_Investigations"));
				
			request.setAttribute("TreatmentDetailsID", Integer.parseInt(request.getParameter("treatmentDetailsID")));
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ShowAllTreatmentDetailsByID.jsp");
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
