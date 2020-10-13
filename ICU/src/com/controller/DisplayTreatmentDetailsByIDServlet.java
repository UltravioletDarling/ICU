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
 * Servlet implementation class DisplayTreatmentDetailsByIDServlet
 */
@WebServlet("/DisplayTreatmentDetailsByIDServlet")
public class DisplayTreatmentDetailsByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayTreatmentDetailsByIDServlet() {
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
		response.setContentType("text/html");
		try {
		
	
		int TreatmentDetailsID =0;
		TreatmentDetailsID = Integer.parseInt(request.getParameter("treatmentDetailsID"));
	       
        ITreatmentDetailsDAO iTreatmentDetailsDAO = new TreatmentDetailsDAO();
        
		TreatmentDetails treatmentDetails = iTreatmentDetailsDAO.getTreatmentDetailsByID(Integer.toString(TreatmentDetailsID));

		request.setAttribute("TreatmentDetails", treatmentDetails);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateTreatmentDetailsByID.jsp");
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
