package com.ebanking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ebanking.DAO.UserDao;
import com.ebanking.DAO.UserDaoImpl;
import com.ebanking.model.BankUserDetails;

@WebServlet("/debit")
public class Debit extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String accountNumber = request.getParameter("accountNumber");
		 
		 HttpSession session=request.getSession();
	BankUserDetails bankUserDetails=	(BankUserDetails) session.getAttribute("BankUserDetails");
       String accountNo=	bankUserDetails.getAccountnumber();
      
       PrintWriter writer= response.getWriter();
       response.setContentType("text/html");
       int value=1;
       
       
    
       if(accountNo.equals(accountNumber))
       {
    	   value=2;
    	  session.setAttribute("valid", value);
    	  RequestDispatcher rd= request.getRequestDispatcher("Debit.jsp");
    	  rd.forward(request, response);
    	  
       }
       else
       {
    	   value=3;
    	  writer.println("  <h1 style='color:white'> Invalid Account number  </h1> ");
    	  writer.println("<br>");
    	  RequestDispatcher rd= request.getRequestDispatcher("Debit.jsp");
    	  rd.include(request, response);
    	 
    	  
       }
	}
	}


