package com.example;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/exampleservlet")
public class exampleservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public exampleservlet() {
        super();

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //declare variables to store the requested parameteres from the database

        boolean isTrue;

        isTrue = exampleDButil.example(//records);

        if(isTrue == true) {
            RequestDispatcher dis = request.getRequestDispatcher(// success page);
            dis.forward(request, response);
        }
        else {
            RequestDispatcher dis2 = request.getRequestDispatcher(// fail page);
            dis2.forward(request, response);
        }
    }

}