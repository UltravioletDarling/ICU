package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.PatientHandoff_bean;
import com.dao.ShowPatientHandoff_dao;

/**
 * Servlet implementation class ShowPatientHandoffServlet
 */
@WebServlet("/ShowPatientHandoffServlet")
public class ShowPatientHandoff_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		
		System.out.println("get para" + idString);
        int id = Integer.parseInt(idString);
        
        List<PatientHandoff_bean> handoff_details = ShowPatientHandoff_dao.getCustomer(idString);
        request.setAttribute("handoff_details", handoff_details);
        
        RequestDispatcher dis = request.getRequestDispatcher("show_patient_handoff_details.jsp");
        dis.forward(request, response);
	}

}
