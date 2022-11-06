package com.ecommerce.model;

public class Product {
	private int product_ID;
	private String product_Name;
	private String product_Description;
	private int product_Price;
	private int product_Quantity;
	
	public Product(int product_ID, String product_Name, String product_Description, int product_Price,
			int product_Quantity) {
		super();
		this.product_ID = product_ID;
		this.product_Name = product_Name;
		this.product_Description = product_Description;
		this.product_Price = product_Price;
		this.product_Quantity = product_Quantity;
	}
	public int getProduct_ID() {
		return product_ID;
	}
	public void setProduct_ID(int product_ID) {
		this.product_ID = product_ID;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	public String getProduct_Description() {
		return product_Description;
	}
	public void setProduct_Description(String product_Description) {
		this.product_Description = product_Description;
	}
	public int getProduct_Price() {
		return product_Price;
	}
	public void setProduct_Price(int product_Price) {
		this.product_Price = product_Price;
	}
	public int getProduct_Quantity() {
		return product_Quantity;
	}
	public void setProduct_Quantity(int product_Quantity) {
		this.product_Quantity = product_Quantity;
	}
	@Override
	public String toString() {
		return "Product [product_ID=" + product_ID + ", product_Name=" + product_Name + ", product_Description="
				+ product_Description + ", product_Price=" + product_Price + ", product_Quantity=" + product_Quantity
				+ "]";
	}
	
	
	
}