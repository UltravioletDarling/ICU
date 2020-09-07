package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.inventoryitem;
import com.dao.DisplayinventoryDao;


@WebServlet("/Inventoryitemservlet")
public class Inventoryitemservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Inventoryitemservlet() {
    	

    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		//Passing the input parameters to local variables
		
		String itemID = request.getParameter("itemid");
		String adminID = request.getParameter("adminid");
		String itemName = request.getParameter("name");
		String itemStock = request.getParameter("stock");
		String aquiredDate = request.getParameter("aquired");
		String expiryDate = request.getParameter("expiry");
		String unitDosage = request.getParameter("udosage");
		String itemType = request.getParameter("type");
		String maintenanceDate = request.getParameter("maintenance");
		
		inventoryitem inventoryitem = new inventoryitem(maintenanceDate, maintenanceDate, maintenanceDate, maintenanceDate, maintenanceDate, maintenanceDate, maintenanceDate, maintenanceDate, maintenanceDate);
		
		inventoryitem.setItemid(itemID);
		inventoryitem.setAdminid(adminID);
		inventoryitem.setName(itemName);
		inventoryitem.setStock(itemStock);
		inventoryitem.setAquired(aquiredDate);
		inventoryitem.setExpiry(expiryDate);
		inventoryitem.setExpiry(expiryDate);
		inventoryitem.setUdosage(unitDosage);
		inventoryitem.setType(itemType);
		inventoryitem.setMaintenance(maintenanceDate);
		
		DisplayinventoryDao inventoryDao = new DisplayinventoryDao();
		
		 String itemAdded = null;
		 
			try {
				itemAdded = inventoryDao.addItem(inventoryitem);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	         
	         if(itemAdded.equals("SUCCESS"))  
	         {
	            request.getRequestDispatcher("inventorymain.jsp").forward(request, response);
	         }
	         else
	         {
	            request.setAttribute("error", itemAdded);
	            request.getRequestDispatcher("editinventory.jsp").forward(request, response);
	         }
	}

}
