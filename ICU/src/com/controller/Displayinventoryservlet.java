package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.inventoryitem;
import com.dao.DisplayinventoryDao;

@WebServlet("/Displayinventoryservlet")
public class Displayinventoryservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Displayinventoryservlet() {
        super();
	}
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String itemid = request.getParameter("itemid");	
		
		DisplayinventoryDao displayInventory = new DisplayinventoryDao();
		ArrayList<inventoryitem> inventoryitem = displayInventory.getdetails();
	
		
		request.setAttribute("inventoryitem", displayInventory);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("inventorymain.jsp");
		dispatcher.forward(request, response);
						
		
	}
	

}
