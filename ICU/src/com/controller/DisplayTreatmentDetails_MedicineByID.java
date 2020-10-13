package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TreatmentDetails;
import com.bean.TreatmentDetails_medicine;
import com.dao.ITreatmentDetailsDAO;
import com.dao.TreatmentDetailsDAO;

/**
 * Servlet implementation class DisplayTreatmentDetails_MedicineByID
 */
@WebServlet("/DisplayTreatmentDetails_MedicineByID")
public class DisplayTreatmentDetails_MedicineByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayTreatmentDetails_MedicineByID() {
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
			int TreatmentDetails_medicineID = Integer.parseInt(request.getParameter("treatmentDetailsID_Medicine"));
		       
	        ITreatmentDetailsDAO iTreatmentDetailsDAO = new TreatmentDetailsDAO();
	        
			TreatmentDetails_medicine treatmentDetails_medicine = iTreatmentDetailsDAO.getTreatmentDetails_medicineSingle(Integer.toString(TreatmentDetails_medicineID));

			request.setAttribute("TreatmentDetails_medicine", (TreatmentDetails_medicine)treatmentDetails_medicine);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateTreatmentDetails_medicineByID.jsp");
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
