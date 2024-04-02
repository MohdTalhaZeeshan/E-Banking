package com.ebanking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

@WebServlet("/statement")
public class CheckingStatement extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date1InString = request.getParameter("input1");
		 Date date1=Date.valueOf(date1InString);
		String date2InString = request.getParameter("input2");
		Date date2= Date.valueOf(date2InString);
		HttpSession session = request.getSession();
	   BankUserDetails bankUserDetails =(BankUserDetails)session.getAttribute("BankUserDetails");
		 int  userId = bankUserDetails.getUserid();
		
	PrintWriter writer = response.getWriter();
	response.setContentType("text/html");
	
	String select = "select * from statement where userId=? and DateOfTransaction between ? and ?";
	try {
	Connection	connection =	DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?user=root&password=12345");
		PreparedStatement ps = connection.prepareStatement(select);
		ps.setInt(1, userId);
		ps.setDate(2, date1);
		ps.setDate(3, date2);
		
  ResultSet	resultSet = ps.executeQuery();
  if(resultSet.isBeforeFirst())
  {
	  writer.println("<center><table style='border:2px solid black;border-collapse:collapse;'><tr><th style='border:2px solid black'>transactionId</th><th style='border:2px solid black'>DateOfTransaction</th><th style='border:2px solid black'>transactionType</th><th style='border:2px solid black'>transactionAmount</th><th style='border:2px solid black'>balance</th><th style='border:2px solid black'>timeOfTransaction</th><th style='border:2px solid black'>bankAccountNumber</th><th style='border:2px solid black'>userId</th><tr>");
	  while(resultSet.next())
	  {  
		  writer.println("<tr><td style='border:2px solid black'>"+resultSet.getInt("transactionId")+"</td><td style='border:2px solid black'>"+resultSet.getDate("DateOfTransaction")+"</td><td style='border:2px solid black'>"+resultSet.getString("transactionType")+"</td><td style='border:2px solid black'>"+resultSet.getString("transactionAmount")+"</td><td style='border:2px solid black'>"+resultSet.getDouble("balance")+"</td><td style='border:2px solid black'>"+resultSet.getTime("timeOfTransaction")+"</td><td style='border:2px solid black'>"+resultSet.getString("bankAccountNumber")+"</td><td style='border:2px solid black'>"+resultSet.getInt("userId")+"</td></tr>");
	      
	}
	  
	  writer.println("</table> <br><br> <div > <a href='index.jsp'><button style='width:60px;height:40px;background-color:aqua;border-radius:10px;'>LogIn </button></a></div></center>");
}
  else
  {
	  writer.println("<center><h1>Invalid Dates</h1></center>");
	  writer.println("</table> <div> <a href='index.jsp'><button style='width:30px;height:50px;background-color:aqua;border-radius:10px;'>LogIn </button></a></div></center>");
  }
	  
 }

	catch (SQLException e) {
		
		e.printStackTrace();
	}
}
}
