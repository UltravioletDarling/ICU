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
import com.dao.DisplayinventorybyidDao;

import java.util.ArrayList;
import java.util.List;


@WebServlet("/Displayinventorybyidservlet")
public class Displayinventorybyidservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Displayinventorybyidservlet() {
        super();
	}
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String itemid = request.getParameter("itemidentifier");
		boolean isTrue;
		
		
		DisplayinventorybyidDao displayinventorybyid = new DisplayinventorybyidDao();
		ArrayList<inventoryitem> inventoryitem = displayinventorybyid.getdetailsbyid(itemid);
	
		
		

			RequestDispatcher dis = request.getRequestDispatcher("Displayinventorybyid.jsp");
			dis.forward(request, response);
		}
		
		
		
}


