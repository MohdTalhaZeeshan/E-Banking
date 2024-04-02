package com.ebanking.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import com.ebanking.model.BankStatment;
import com.ebanking.model.BankUserDetails;

@WebServlet("/register")
public class UserDaoImpl implements UserDao    
{ 
	
	
	private final String url="jdbc:mysql://localhost:3306/bank?user=root&password=12345";
	Connection connection;
	
private final 	String insert="insert into bankuserdetails(userName,userEmailId,userPassword,userMobilenumber, accountNumber, ifscCode,address,amount) values(?,?,?,?,?,?,?,?)";

private final String update="update bankuserdetails set amount=? where accountNumber=?";

private final String insertStatement = "insert into statement(DateOfTransaction, transactionType, transactionAmount, balance, timeOfTransaction, bankAccountNumber, userId) values(?,?,?,?,?,?,?)";
	public boolean userRegistration(BankUserDetails bankUserDetails) {
		
	 
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=	DriverManager.getConnection(url);
	  PreparedStatement	ps=connection.prepareStatement(insert);
	  ps.setString(1, bankUserDetails.getUsername());
	  ps.setString(2, bankUserDetails.getUseremailid());
	  ps.setString(3, bankUserDetails.getUserpassword());
	  ps.setString(4, bankUserDetails.getUsermobilenumber());
	  Random r= new Random();
	  int accountNumber=r.nextInt(10000000);//7-digit number.
	  if(accountNumber<1000000)
	  {
		  accountNumber=accountNumber+1000000;
	  }
	  ps.setString(5, accountNumber+"");
	  ps.setString(6, "TECA540007");
	  ps.setString(7, bankUserDetails.getAddress());
	  ps.setDouble(8, bankUserDetails.getAmount());
	  
	         int result=  ps.executeUpdate();
	         if(result!=0)
	         {
	        	 return true;
	         }
		       
	         else
	         {
	        	return false;
	         }
	}
	
	catch (SQLException e) {
		
		e.printStackTrace();
		
		try {
			connection.close();
		} 
		
		catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	 }
	
	catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
		
		return false;
	}

	
	public BankUserDetails userLogIn(String emailIdOrMobileNumber, String Password) {
		
		String select="select * from bankuserdetails where (userEmailId=? or userMobilenumber=?) and userPassword=?";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 connection	=DriverManager.getConnection(url);
		 PreparedStatement ps= connection.prepareStatement(select);
		 ps.setString(1, emailIdOrMobileNumber);
		 ps.setString(2, emailIdOrMobileNumber);
		 ps.setString(3, Password);
		 
		      ResultSet   resultSet = ps.executeQuery();
		      
		      if(resultSet.next())
		      {       
		    	  int userId=resultSet.getInt("userId");
		    	  String name=resultSet.getString("userName");
		    	  String emailId=resultSet.getString("userEmailId");
		    	  String mobileNumber=resultSet.getString("userMobilenumber");
		    	  String password=resultSet.getString("userPassword");
		    	  String accountNumber=resultSet.getString("accountNumber");
		    	  String ifscCode=resultSet.getString("ifscCode");
		    	  String addressOfuser=resultSet.getString("address");
		    	  double amount=resultSet.getDouble("amount");
		    	  
		    	  BankUserDetails bankUserDetails = new BankUserDetails();
		    	  bankUserDetails.setUserid(userId);
		    	  bankUserDetails.setUsername(name);
		    	  bankUserDetails.setUseremailid(emailId);
		    	  bankUserDetails.setUsermobilenumber(mobileNumber);
		    	  bankUserDetails.setUserpassword(password);
		    	  bankUserDetails.setAccountnumber(accountNumber);
		    	  bankUserDetails.setIfsccode(ifscCode);
		    	  bankUserDetails.setAddress(addressOfuser);
		    	  bankUserDetails.setAmount(amount);
		    	  
		    	  return bankUserDetails;
		    	  
		      }
		      else
		      {
		    	  return null;
		      }
		}
		
		catch (SQLException e) {
			
			try {
				connection.close();
			}
			catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	public boolean debitAmount(BankStatment statement) {
		
		try {
			connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(update);
			ps.setDouble(1, statement.getBalance());
			ps.setString(2, statement.getBankaccountnumber());
			int result = ps.executeUpdate();
			if(result!=0)
			{
				
				System.out.println("Amount Debited");
				PreparedStatement ps1 = connection.prepareStatement(insertStatement);
				ps1.setDate(1, statement.getDateoftransaction());
				ps1.setString(2, statement.getTransactiontype());
				ps1.setString(3,statement.getTransactionamount());
				ps1.setDouble(4, statement.getBalance());
				ps1.setTime(5, statement.getTimeoftransaction());
				ps1.setString(6, statement.getBankaccountnumber());
				ps1.setInt(7, statement.getUserid());
				int result1= ps1.executeUpdate();
				if(result1!=0)
				{
				      return true;
				}
				
				else
				{
					return false;
				}
			}
			
			else
			{
				return false;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}


	public boolean creditAmount(BankStatment statement) {
		
		String update1="update bankuserdetails set amount=? where accountNumber=? ";
		String insert1="insert into statement(DateOfTransaction, transactionType, transactionAmount, balance, timeOfTransaction, bankAccountNumber, userId) values(?,?,?,?,?,?,?)";
		
		try {
			connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(update1);
			ps.setDouble(1, statement.getBalance());
			ps.setString(2, statement.getBankaccountnumber());
			
			int result = ps.executeUpdate();
			if(result!=0)
			{
				PreparedStatement ps1 = connection.prepareStatement(insert1);
				ps1.setDate(1, statement.getDateoftransaction());
				ps1.setString(2, statement.getTransactiontype());
				ps1.setString(3,statement.getTransactionamount());
				ps1.setDouble(4, statement.getBalance());
				ps1.setTime(5, statement.getTimeoftransaction());
				ps1.setString(6, statement.getBankaccountnumber());
				ps1.setInt(7, statement.getUserid());
				int result1= ps1.executeUpdate();
				if(result1!=0)
				{
					return true;
				}
				
				else
				{
					return false;
				}
				
			}
			else
			{
				return false;
			}
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
		 
	}


	public boolean changePassword(String emailId, String accNumber, String Password) {
		
		String update = "update bankuserdetails set userPassword=? where userEmailId=? and accountNumber=?";
		
		 try {
			connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(update);
			ps.setString(1, Password);
			ps.setString(2, emailId);
			ps.setString(3, accNumber);
			
			int result = ps.executeUpdate();
			if(result!=0)
			{
				return true;
			}
			
			else
			{
				return false;
			}
		} 
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		 return false;
	}
	
}
