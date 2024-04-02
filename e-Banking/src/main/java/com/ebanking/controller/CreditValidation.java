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

@WebServlet("/credit")
public class CreditValidation extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   String amountInString = request.getParameter("creditAmount");
		     double amount = Double.parseDouble(amountInString);
		   HttpSession session= request.getSession();
		    BankUserDetails bankUserDetails = (BankUserDetails) session.getAttribute("BankUserDetails");
		 String accountNumber =  bankUserDetails.getAccountnumber();
		 double amountInAccount=bankUserDetails.getAmount();
		 PrintWriter writer=response.getWriter();
		 response.setContentType("text/html");
		 
		 double balance= amount+amountInAccount;
		 if(amount>=0.0)
		 {
			 BankStatment bankStatment= new BankStatment();
			 bankStatment.setBankaccountnumber(accountNumber);
			 bankStatment.setDateoftransaction(Date.valueOf(LocalDate.now()));
			 bankStatment.setTimeoftransaction(Time.valueOf(LocalTime.now()));
			 bankStatment.setTransactiontype("Credit");
			 bankStatment.setBalance(balance);
			 bankStatment.setTransactionamount(amount+"Cr");
			 bankStatment.setUserid(bankUserDetails.getUserid());
			 
			 UserDao userDao = new UserDaoImpl();
			 if(userDao.creditAmount(bankStatment))
			 {
				 writer.println("<center><h1> Credited Successfully </h1></center>");
			 }
			 
			 
		 }
		 else
		 {
			 writer.println("<h1 style='color:white';> Invalid Amount </h1>");
			 writer.println("<br>");
			 RequestDispatcher rd= request.getRequestDispatcher("Credit.jsp");
			 rd.include(request, response);
			
		 }
	}

}
