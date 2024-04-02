package com.ebanking.model;

public class BankUserDetails {
	 
	private int userid;
	private String username;
	private String useremailid;
	private String usermobilenumber;
	private String userpassword;
	private String accountnumber;
	private String ifsccode;
	private String address;
	private double amount;
	
	
	public BankUserDetails() {
		
	}


	public BankUserDetails(int userid, String username, String useremailid, String usermobilenumber,
			String userpassword, String accountnumber, String ifsccode, String address, double amount) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremailid = useremailid;
		this.usermobilenumber = usermobilenumber;
		this.userpassword = userpassword;
		this.accountnumber = accountnumber;
		this.ifsccode = ifsccode;
		this.address = address;
		this.amount = amount;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUseremailid() {
		return useremailid;
	}


	public void setUseremailid(String useremailid) {
		this.useremailid = useremailid;
	}


	public String getUsermobilenumber() {
		return usermobilenumber;
	}


	public void setUsermobilenumber(String usermobilenumber) {
		this.usermobilenumber = usermobilenumber;
	}


	public String getUserpassword() {
		return userpassword;
	}


	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}


	public String getAccountnumber() {
		return accountnumber;
	}


	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}


	public String getIfsccode() {
		return ifsccode;
	}


	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "BankUserDetails [userid=" + userid + ", username=" + username + ", useremailid=" + useremailid
				+ ", usermobilenumber=" + usermobilenumber + ", userpassword=" + userpassword + ", accountnumber="
				+ accountnumber + ", ifsccode=" + ifsccode + ", address=" + address + ", amount=" + amount + "]";
	}
	
	
	

}
