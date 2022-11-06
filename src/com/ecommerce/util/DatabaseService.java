package com.ecommerce.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ecommerce.model.Product;
import com.ecommerce.model.Register;

public class DatabaseService {

//product retrieval operation from Database
	public void getProduct() throws SQLException {

		try {
			DatabaseUtil util = new DatabaseUtil();
			Connection connection = util.getConnection();

			Statement stmt = connection.createStatement();
			ResultSet resultset = stmt.executeQuery(QueryUtil.selectAllProduct());
			while (resultset.next()) {
				printProduct(new Product(resultset.getInt("product_ID"), resultset.getString("product_Name"),
						resultset.getString("product_Description"), resultset.getInt("product_Price"),
						resultset.getInt("product_Quantity")));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void printProduct(Product product) {
		System.out.println("product_ID : " + product.getProduct_ID());
		System.out.println("product_Name : " + product.getProduct_Name());
		System.out.println("product_Description : " + product.getProduct_Description());
		System.out.println("product_Price : " + product.getProduct_Price());
		System.out.println("product_Quantity : " + product.getProduct_Quantity());
		System.out.println("-------------------------------------------------------");
	}
//product retrieval operation from Database Ended

	// product retrieval operation from Database by Id
	public boolean getProductbyId(int product_ID) throws SQLException {
		boolean isFound = false;
		try {
			DatabaseUtil util = new DatabaseUtil();
			Connection connection = util.getConnection();

			Statement stmt = connection.createStatement();
			ResultSet resultset = stmt.executeQuery(QueryUtil.selectProductbyid(product_ID));

			if (resultset.next()) {
				isFound = true;

				printProduct(new Product(resultset.getInt("product_ID"), resultset.getString("product_Name"),
						resultset.getString("product_Description"), resultset.getInt("product_Price"),
						resultset.getInt("product_Quantity")));

				Product p = new Product(product_ID, null, null, product_ID, product_ID);

				Connection con = util.getConnection();

				PreparedStatement pstmt = con.prepareStatement(QueryUtil.inserttocart());

				pstmt.setInt(1, resultset.getInt("product_ID"));

				pstmt.setString(2, resultset.getString("product_Name"));

				pstmt.setString(3, resultset.getString("product_Description"));

				pstmt.setInt(4, resultset.getInt("product_Price"));

				pstmt.setInt(5, resultset.getInt("product_Quantity"));

				int row = pstmt.executeUpdate();

				if (row > 0) {
					System.out.println("Above Product Added to cart Successfully.");
				} else {
					System.out.println("Something Went Wrong, Product not added.");
				}

			}

			else {
				System.out.println("Record Not Found With ID" + product_ID);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return isFound;
	}
	// product retrieval operation from Database by Id Ended

	// product Insertion operation from to Database by admin
	public static void insertProductByAdmin(Product product) throws Exception {
		Scanner sc = new Scanner(System.in);

		DatabaseUtil util = new DatabaseUtil();
		Connection con = util.getConnection();

		PreparedStatement pstmt = con.prepareStatement(QueryUtil.insertProduct());

		pstmt.setInt(1, product.getProduct_ID());

		pstmt.setString(2, product.getProduct_Name());

		pstmt.setString(3, product.getProduct_Description());

		pstmt.setInt(4, product.getProduct_Price());

		pstmt.setInt(5, product.getProduct_Quantity());

		int row = pstmt.executeUpdate();

		if (row > 0) {
			System.out.println("Product Inserted Successfully.");
		} else {
			System.out.println("Something Went Wrong, Product not added.");
		}

	}

	// product Insertion operation to Database by admin is Ended

	// Insert customer data operation to DataBasde Start

	public static void insertCustomer(Register register) {
		Scanner sc = new Scanner(System.in);
		try {
			DatabaseUtil util = new DatabaseUtil();
			Connection con = util.getConnection();

			PreparedStatement pstmt = con.prepareStatement(QueryUtil.registeruser());

			pstmt.setString(1, register.getFirstName());

			pstmt.setString(2, register.getLastName());

			pstmt.setString(3, register.getUserName());
			pstmt.setString(4, register.getPassword());

			pstmt.setString(5, register.getEmailId());

			pstmt.setLong(6, register.getPhoneNo());

			int row = pstmt.executeUpdate();

			if (row > 0) {
				System.out.println("Customer Register  Successfully.");
			}

			else {
				System.out.println("Something Went Wrong, Customer Not Added.");
			}

		} catch (Exception e) {
			System.out.println("Wrong Entry" + e);
		}

	}
	// Insert customer data operation to DataBasde Start ended

	// Data Retrival Cart
	public void getcart() throws SQLException {

		try {
			DatabaseUtil util = new DatabaseUtil();
			Connection connection = util.getConnection();

			Statement stmt = connection.createStatement();
			ResultSet resultset = stmt.executeQuery(QueryUtil.selectcart());
			while (resultset.next()) {
				printProduct(new Product(resultset.getInt("product_ID"), resultset.getString("product_Name"),
						resultset.getString("product_Description"), resultset.getInt("product_Price"),
						resultset.getInt("product_Quantity")));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void printcart(Product product) {
		System.out.println("product_ID : " + product.getProduct_ID());
		System.out.println("product_Name : " + product.getProduct_Name());
		System.out.println("product_Description : " + product.getProduct_Description());
		System.out.println("product_Price : " + product.getProduct_Price());
		System.out.println("product_Quantity : " + product.getProduct_Quantity());
		System.out.println("-------------------------------------------------------");

	}
	// Data Retrieval in Cart ended

	// Data retrieval for all User Profile for Admin
	public void getloginuser() throws SQLException {

		try {
			Register register = new Register();
			DatabaseUtil util = new DatabaseUtil();
			Connection connection = util.getConnection();

			Statement stmt1 = connection.createStatement();
			ResultSet resultset = stmt1.executeQuery(QueryUtil.allloginuser());
			while (resultset.next()) {
				printloginuser(new Register(resultset.getInt(1), resultset.getString("FirstName"),
						resultset.getString("LastName"), resultset.getString("UserName"),
						resultset.getString("Password"), resultset.getString("EmailID"),
						resultset.getLong("PhoneNumber")));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void printloginuser(Register register) {
		System.out.println("Customer_ID : " + register.getId());
		System.out.println("Customer_LastName : " + register.getFirstName());
		System.out.println("Customer_LastName : " + register.getLastName());
		System.out.println("Customer_UserName : " + register.getUserName());
		System.out.println("Customer_Password : " + register.getPassword());
		System.out.println("Customer_EmailId : " + register.getEmailId());
		System.out.println("Customer_PhoneN : " + register.getPhoneNo());

		System.out.println("-------------------------------------------------------");
	}
	// Data retrieval for all User Profile for Admin ended

	// Data retrieval for User Profile in User Account
	public static void loginuserbyId(int Id) throws SQLException {
		boolean isFound = false;

		try {
			Register register = new Register();
			DatabaseUtil util = new DatabaseUtil();
			Connection connection = util.getConnection();

			Statement stmt1 = connection.createStatement();
			ResultSet resultset = stmt1.executeQuery(QueryUtil.loginuserbyId(Id));
			if (resultset.next()) {
				isFound = true;
				printloginuserbyId(new Register(resultset.getInt(1), resultset.getString("FirstName"),
						resultset.getString("LastName"), resultset.getString("UserName"),
						resultset.getString("Password"), resultset.getString("EmailID"),
						resultset.getLong("PhoneNumber")));
			} else {
				System.out.println("Profile does not Found With This ID" + Id);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void printloginuserbyId(Register register) {
		System.out.println("Customer_ID : " + register.getId());
		System.out.println("Customer_LastName : " + register.getFirstName());
		System.out.println("Customer_LastName : " + register.getLastName());
		System.out.println("Customer_UserName : " + register.getUserName());

		System.out.println("Customer_EmailId : " + register.getEmailId());
		System.out.println("Customer_PhoneN : " + register.getPhoneNo());

		System.out.println("-------------------------------------------------------");

	}
////Data retrieval for  User Profile in User Account Ended

}