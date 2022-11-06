package com.ecommerce.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryUtil {

	
	public static String selectAllProduct() {
		return "SELECT * FROM miniproject.products";

	}

	public static String selectProductbyid(int Product_ID) {
		return "SELECT * FROM miniproject.products where product_ID = " + Product_ID;

	}

	public static String insertProduct() {

		return "insert into miniproject.cart(product_Id,product_Name,product_Description,product_Price,Product_Quantity) values(?,?,?,?,?)";

	}

	public static String inserttocart() {

		return "insert into miniproject.cart(product_Id,product_Name,product_Description,product_Price,Product_Quantity) values(?,?,?,?,?)";

	}

	public static String registeruser() {

		return "insert into miniproject.loginuser(FirstName,LastName,UserName,Password,EmailID,PhoneNumber) values(?,?,?,?,?,?)";

	}

	public static String selectcart() {
		return "SELECT * FROM miniproject.cart";

	}

	public static String allloginuser() {

		return "SELECT * FROM miniproject.loginuser";
	}

	public static String loginuserbyId(int id) {

		return "SELECT * FROM miniproject.loginuser where Id = " + id;
	}

}
