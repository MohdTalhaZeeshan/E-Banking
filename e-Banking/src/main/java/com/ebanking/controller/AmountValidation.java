package com.ebanking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ebanking.DAO.UserDao;
import com.ebanking.DAO.UserDaoImpl;
import com.ebanking.model.BankStatment;
import com.ebanking.model.BankUserDetails;

@WebServlet("/amount")
public class AmountValidation extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	BankUserDetails bankUserDetails = (BankUserDetails)	session.getAttribute("BankUserDetails");
		String amountInString=request.getParameter("amount");
  	  Double amount=Double.parseDouble(amountInString);
  	   double amountInAccount =   bankUserDetails.getAmount();
  	   
  	   PrintWriter writer = response.getWriter();
  	   response.setContentType("text/html");
  	   if(amountInString!=null)
  	{
  	  if(amount>=0.0)
  	  {
  		  if(amountInAccount>=amount)
  		  {
  			  System.out.println("Amount Debited Successfully");
  		        double balanceamount=amountInAccount-amount;
  		        BankStatment bankStatement = new BankStatment();
  		        bankStatement.setDateoftransaction(Date.valueOf(LocalDate.now()));
  		        bankStatement.setTimeoftransaction(Time.valueOf(LocalTime.now()));
  		        bankStatement.setTransactionamount(amount+"Dr");
  		        bankStatement.setBalance(balanceamount);
  		        bankStatement.setTransactiontype("Debit");
  		        bankStatement.setBankaccountnumber(bankUserDetails.getAccountnumber());
  		        bankStatement.setUserid(bankUserDetails.getUserid());
  		        
  		        UserDao userDao =new  UserDaoImpl();
  		        if(userDao.debitAmount(bankStatement))
  		        {
  		        	
  		        	writer.println("<center><h1> Debit and Statement Inserted Successfully </h1></center>");
  		        }
  		        else
  		        {
  		        	writer.println("<h1 style='color:white'>  Debit was not successfull </h1>");
  		        	writer.println("<br>");
  		        	RequestDispatcher rd = request.getRequestDispatcher("Debit.jsp");
  	  			   rd.include(request, response);
  		        	
  		        }
  		  }
  		  
  		  else
  		  {
  			 writer.println("<h1 style='color:white'> Insufficient Amount </h1>");
  			writer.println("<br>");
  			  RequestDispatcher rd = request.getRequestDispatcher("Debit.jsp");
  			  rd.include(request, response);
  			 
  			  
  		  }
  	  }
  	  else
  	  {
  		  RequestDispatcher rd = request.getRequestDispatcher("Debit.jsp");
  		  rd.include(request, response);
  		  writer.println("<center><h1 style='color:white'> Invalid Amount </h1></center>");
  	  }
	}
	}

}
