package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.inventoryitem;
import com.dao.InsertinventoryDao;


@WebServlet("/Inventoryitemservlet")
public class Inventoryitemservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Inventoryitemservlet() {
    	 super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		String itemID = request.getParameter("itemid");
		String adminID = request.getParameter("adminid");
		String itemName = request.getParameter("name");
		String itemStock = request.getParameter("stock");
		String aquiredDate = request.getParameter("aquired");
		String expiryDate = request.getParameter("expiry");
		String unitDosage = request.getParameter("udosage");
		String itemType = request.getParameter("type");
		String maintenanceDate = request.getParameter("maintenance");
		
		 boolean isTrue;

	        isTrue = InsertinventoryDao.addItem(itemID, adminID, itemName, itemStock, aquiredDate, expiryDate, unitDosage, itemType, maintenanceDate);

	        if(isTrue == true) {
	            RequestDispatcher dis = request.getRequestDispatcher("/inventorymain.jsp");
	            dis.forward(request, response);
	        }
	        else {
	            RequestDispatcher dis2 = request.getRequestDispatcher("/test.jsp");
	            dis2.forward(request, response);
	        }
	
	       
	        
	}

}
