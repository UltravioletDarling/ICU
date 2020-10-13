package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TreatmentDetails_investigations;
import com.bean.TreatmentDetails_supportSystems;
import com.dao.ITreatmentDetailsDAO;
import com.dao.TreatmentDetailsDAO;

/**
 * Servlet implementation class DisplayTreatmentDetails_InvestigationsByID
 */
@WebServlet("/DisplayTreatmentDetails_InvestigationsByID")
public class DisplayTreatmentDetails_InvestigationsByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayTreatmentDetails_InvestigationsByID() {
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
			int TreatmentDetails_investigationsID = Integer.parseInt(request.getParameter("treatmentDetailsID_Investigations"));
		       
	        ITreatmentDetailsDAO iTreatmentDetailsDAO = new TreatmentDetailsDAO();
	        
			TreatmentDetails_investigations treatmentDetails_investigationsOut = iTreatmentDetailsDAO.getTreatmentDetails_investigationsSingle(Integer.toString(TreatmentDetails_investigationsID));

			request.setAttribute("TreatmentDetails_investigations", (TreatmentDetails_investigations)treatmentDetails_investigationsOut);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateTreatmentDetails_investigationsByID.jsp");
			dispatcher.forward(request, response);
				
			
		}
		catch(NumberFormatException e) 
		{
			e.printStackTrace();
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Fail.jsp");
			dispatcher.forward(request, response);
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Fail.jsp");
			dispatcher.forward(request, response);
		}
	}

}
