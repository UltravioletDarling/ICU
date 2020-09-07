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
import com.dao.DeleteitemDao;
import com.dao.DisplayinventoryDao;
import com.dao.InventoryDao;


@WebServlet("/Deleteitemservlet")
public class Deleteitemservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isTrue = false;
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		System.out.println("delete" + username);
		
		
		isTrue = DeleteitemDao.deleteitem(id);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("DeleteSucess.jsp");
			dis.forward(request, response);	
		}
		else {
			try {
				List<inventoryitem> itemDetails;
				itemDetails = InventoryDao.getDetails(username);
				request.setAttribute("Item ID",itemDetails);
	            System.out.println("Dispa"+ request.getContextPath());
	            request.getRequestDispatcher("inventorymain.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
