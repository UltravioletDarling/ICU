package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.inventoryitem;
import com.dao.Updateinventorydao;
import com.dao.DisplayinventoryDao;

import java.util.List;


@WebServlet("/Updateinventoryservlet")
public class Updateinventoryservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
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
		
		isTrue = Updateinventorydao.updateinventory(itemID, adminID, itemName, itemStock, aquiredDate, expiryDate, unitDosage, itemType, maintenanceDate );
		
		if(isTrue == true) {
			
		
			
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/Success.jsp");
			dis.forward(request, response);
		}
		
		else {
			
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/Fail.jsp");
			dis.forward(request, response);
		}
		
		
		
	}

}
