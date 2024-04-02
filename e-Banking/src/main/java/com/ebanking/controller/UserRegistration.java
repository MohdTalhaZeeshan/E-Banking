package com.ebanking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ebanking.DAO.UserDao;
import com.ebanking.DAO.UserDaoImpl;
import com.ebanking.model.BankUserDetails;

@WebServlet("/registration")
public class UserRegistration extends HttpServlet
{
  @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	                             
         String name = request.getParameter("name");
         String  emailId =  request.getParameter("id");
         String   password  = request.getParameter("pass");
         String   mobileNumber = request.getParameter("mobileNumber");	
         String  address	= request.getParameter("address");
         
         BankUserDetails bankUserDetails = new BankUserDetails();
          bankUserDetails.setUsername(name);
          bankUserDetails.setUseremailid(emailId);
          bankUserDetails.setUserpassword(password);
          bankUserDetails.setUsermobilenumber(mobileNumber);
          bankUserDetails.setAddress(address);
          
          System.out.println(bankUserDetails);
          
           UserDao userDao = new UserDaoImpl();
           PrintWriter writer=response.getWriter();
           response.setContentType("text/html");
           
          if(userDao.userRegistration(bankUserDetails))
          {
        	  RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
        	  rd.forward(request, response);
          }
          else
          {
        	  writer.println("<h1 style='color:white' >Please provide valid details</h1>");
        	  writer.println("<br>");
        	  RequestDispatcher rd=request.getRequestDispatcher("UserRegistration.jsp");
        	  rd.include(request, response);
        	  
          }
}     
}
