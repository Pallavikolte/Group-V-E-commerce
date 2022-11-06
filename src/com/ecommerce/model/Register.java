package com.ecommerce.model;

public class Register {
	private int Id;
	private String firstName;
	private String lastName;
	private String userName;
	private String passward;
	private String emailId;
	private long phoneNo;
 // New user Registration Fields
	
	

	public Register(String firstName, String lastName, String userName, String passward, String emailId, long phoneNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passward = passward;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
	}

	public Register(int id, String firstName, String lastName, String userName, String passward, String emailId,
		long phoneNo) {
	super();
	Id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.userName = userName;
	this.passward = passward;
	this.emailId = emailId;
	this.phoneNo = phoneNo;
}

		


	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return passward;
	}

	public void setPassword(String password) {
		this.passward = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	

	@Override
	public String toString() {
		return "Register [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", passward="
				+ passward + ", emailId=" + emailId + ", phoneNo=" + phoneNo + "]";
	}

	
	public void setId(int id) {
		Id = id;
	}

	public int getId() {
		
		return Id;
	}

	

	
	
	
}

