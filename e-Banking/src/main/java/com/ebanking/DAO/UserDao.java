package com.ebanking.DAO;

import java.sql.Date;

import com.ebanking.model.BankStatment;
import com.ebanking.model.BankUserDetails;

public interface UserDao {
	
	boolean userRegistration(BankUserDetails bankUserDetails);
	BankUserDetails  userLogIn(String emailId,String Password);
	boolean debitAmount(BankStatment statement);
	boolean creditAmount(BankStatment statement);
	boolean changePassword(String emailId,String accNumber,String Password);
    
}
