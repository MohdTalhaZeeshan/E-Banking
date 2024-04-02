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

@WebServlet("/login")
public class UserLogIn extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String logIn=request.getParameter("login");
		String password=request.getParameter("password");
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		
		 UserDao userDao=new UserDaoImpl();
	BankUserDetails bankUserDeatails = userDao.userLogIn(logIn, password);
		if(bankUserDeatails!=null)
		{
			
			session.setAttribute("BankUserDetails", bankUserDeatails);
			
		}
		
		if(bankUserDeatails!=null)
		{
			RequestDispatcher rd= request.getRequestDispatcher("Buttons.jsp");
			rd.forward(request, response);
		}
		else
		{
			writer.println(" <h1 style='color:red' >  Invalid Credentials </h1>");
			writer.println("<br>");
			RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
			rd.include(request, response);

			
		}
		
		
	}

}
