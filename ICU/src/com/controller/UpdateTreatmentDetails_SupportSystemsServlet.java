package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TreatmentDetails_medicine;
import com.bean.TreatmentDetails_supportSystems;
import com.dao.ITreatmentDetailsDAO;
import com.dao.TreatmentDetailsDAO;

/**
 * Servlet implementation class UpdateTreatmentDetails_SupportSystemsServlet
 */
@WebServlet("/UpdateTreatmentDetails_SupportSystemsServlet")
public class UpdateTreatmentDetails_SupportSystemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTreatmentDetails_SupportSystemsServlet() {
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

			TreatmentDetails_supportSystems treatmentDetails_supportSystems = new TreatmentDetails_supportSystems();
			
			treatmentDetails_supportSystems.setTreatmentDetails_supportSystemsID(Integer.parseInt(request.getParameter("treatmentDetailsID_SupportSystems")));
			
			treatmentDetails_supportSystems.setSystemName(request.getParameter("supportSystemName"));
			treatmentDetails_supportSystems.setAmount(request.getParameter("amount"));
			

			ITreatmentDetailsDAO iTreatmentDetails= new TreatmentDetailsDAO();
			TreatmentDetails_supportSystems treatmentDetails_supportSystemsOut = iTreatmentDetails.UpdateTreatmentDetails_supportSystems(treatmentDetails_supportSystems);
				
			request.setAttribute("TreatmentDetails_supportSystems", (TreatmentDetails_supportSystems)treatmentDetails_supportSystemsOut);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateTreatmentDetails_supportSystemsByID.jsp");
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
