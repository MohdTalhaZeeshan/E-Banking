package com.ebanking.model;

import java.sql.Date;
import java.sql.Time;

public class BankStatment {
	
	private int transactionid;
	private Date dateoftransaction;
	private Time timeoftransaction;
	private String transactiontype;
	private String  transactionamount;
	private double  balance;
	private String  bankaccountnumber;
	private int userid;
	
	
	
	public BankStatment() {
		
	}



	public BankStatment(int transactionid, Date dateoftransaction, Time timeoftransaction, String transactiontype,
			String transactionamount, double balance, String bankaccountnumber, int userid) {
		
		this.transactionid = transactionid;
		this.dateoftransaction = dateoftransaction;
		this.timeoftransaction = timeoftransaction;
		this.transactiontype = transactiontype;
		this.transactionamount = transactionamount;
		this.balance = balance;
		this.bankaccountnumber = bankaccountnumber;
		this.userid = userid;
	}



	public int getTransactionid() {
		return transactionid;
	}



	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}



	public Date getDateoftransaction() {
		return dateoftransaction;
	}



	public void setDateoftransaction(Date dateoftransaction) {
		this.dateoftransaction = dateoftransaction;
	}



	public Time getTimeoftransaction() {
		return timeoftransaction;
	}



	public void setTimeoftransaction(Time timeoftransaction) {
		this.timeoftransaction = timeoftransaction;
	}



	public String getTransactiontype() {
		return transactiontype;
	}



	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}



	public String getTransactionamount() {
		return transactionamount;
	}



	public void setTransactionamount(String transactionamount) {
		this.transactionamount = transactionamount;
	}



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	public String getBankaccountnumber() {
		return bankaccountnumber;
	}



	public void setBankaccountnumber(String bankaccountnumber) {
		this.bankaccountnumber = bankaccountnumber;
	}



	public int getUserid() {
		return userid;
	}



	public void setUserid(int userid) {
		this.userid = userid;
	}



	@Override
	public String toString() {
		return "BankStatment [transactionid=" + transactionid + ", dateoftransaction=" + dateoftransaction
				+ ", timeoftransaction=" + timeoftransaction + ", transactiontype=" + transactiontype
				+ ", transactionamount=" + transactionamount + ", balance=" + balance + ", bankaccountnumber="
				+ bankaccountnumber + ", userid=" + userid + "]";
	}
	
	
	

}
