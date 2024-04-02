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

@WebServlet("/changepassword")
public class ChangePassword extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailId = request.getParameter("mailId");
		String accountNumber = request.getParameter("accNumber");
		String password = request.getParameter("pass");
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		
		 UserDao userDao = new UserDaoImpl();
		 if(userDao.changePassword(emailId, accountNumber, password))
		 {
			 writer.println("<h1> Updated Successfully </h1>");
			 writer.println("<br>");
			 RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
			 rd.include(request, response);
			
		 }
		 
		 else
		 {
			 writer.println("<h1> Invalid Details </h1>");
			 writer.println("<br>");
			 RequestDispatcher rd =request.getRequestDispatcher("ChangePassword.jsp");
			 rd.include(request, response);
			
		 }
		 
		
	}

}
