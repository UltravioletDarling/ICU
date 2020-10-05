package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.PatientHandoff_bean;
import com.dao.PatientHandoff_dao;

@WebServlet("/Patient_Handoff")
public class PatientHandoff_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	 System.out.println("A");
	        //Copying all the input parameters in to local variables
	         String idString = request.getParameter("id");
	         System.out.println("ppppp");
	         int id = Integer.parseInt(idString); 
	         System.out.println("aaaaaa");
	         String status = request.getParameter("status");
	         String alergies = request.getParameter("alergies");
	         String critical_condition = request.getParameter("critical_condition");
	         String others = request.getParameter("others");
	         String checked_by = request.getParameter("checked_by");

	         
	         PatientHandoff_bean PatientHandoff_bean = new PatientHandoff_bean(id,status,alergies,critical_condition,others,checked_by);
	         
	         
	         PatientHandoff_dao PatientHandoff_dao = new PatientHandoff_dao();
	         
	        //The core Logic of the insert data is present here.
	         String dataInserted = null;
			try {
				 System.out.println("B");
				 dataInserted = PatientHandoff_dao.insertData(PatientHandoff_bean);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	         
	         if(dataInserted.equals("SUCCESS"))   //On success, you can display a message to user on Home page
	         {
	        	request.setAttribute(idString, PatientHandoff_bean);
	            request.getRequestDispatcher("sucessfully_added.jsp").forward(request, response);
	         }
	         else   //On Failure, display a meaningful message to the User.
	         {
	            //request.setAttribute("errMessage", userRegistered);
	            request.getRequestDispatcher("failed_to_add.jsp").forward(request, response);
	         }
	     }
	}

