package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.inventoryitem;
import com.dao.InventoryDao;
import com.dao.Inventoryupdatedao;



@WebServlet("/Inventoryupdateservlet")
public class Inventoryupdateservlet extends HttpServlet {
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
		
		System.out.println("ItemID = "+ itemID);
		System.out.println("Admin ID = "+ adminID);
		System.out.println("Item Name = "+ itemName);
		System.out.println("Item Stock = "+ itemStock);
		System.out.println("Aquired Date = "+ aquiredDate);
		System.out.println("Expiry Date = "+ expiryDate);
		System.out.println("Unit Dosage = "+ unitDosage);
		System.out.println("Type = "+ itemType);
		System.out.println("Next Maintenance = "+ maintenanceDate);
		
		
		boolean isTrue = Inventoryupdatedao.inventoryupdate(itemID,adminID,itemName,itemStock,aquiredDate,expiryDate,unitDosage,itemType,maintenanceDate);
		
		if(isTrue == true) {
			 
			try {
				List<inventoryitem> itemDetails;
				itemDetails = InventoryDao.getDetails(itemID);
				request.setAttribute("Item ID",itemDetails);
	           // System.out.println("Dispatch"+ request.getContextPath());
	            request.getRequestDispatcher("UpdateInventorySuccess.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			RequestDispatcher dis = request.getRequestDispatcher("UpdateInventory.jsp");
			dis.forward(request, response);
		}
		
	}

}
