package com.ecommerce.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.ecommerce.main.MainPage;
import com.ecommerce.model.Product;
import com.ecommerce.util.DatabaseService;

public class UserChoice {

	public static void choice() throws Exception {
		Scanner sc = new Scanner(System.in);

		boolean isRunning = true;

		while (isRunning) {
			System.out.println("Enter Your Choice");
			System.out.println("---------------------------------------------------------");
			System.out.println("1. Show all Products");
			System.out.println("2. Delet Product From Cart");
			System.out.println("3. Add product to Cart");
			System.out.println("4. Show Cart");
			System.out.println("5. View Customer Profile");
			System.out.println("6. Update Customers Profile");
			System.out.println("7. Return to Main Page");

			DatabaseService service = new DatabaseService();
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
			case 1:
//Show all Products
				service.getProduct();

				break;
			case 2:
//Delet Product From Cart

				System.out.println("Case 2");
				break;

			case 3:
//Add product to Cart
				System.out.println("Enter id to add the product into cart");
				service.getProductbyId(Integer.parseInt(sc.nextLine()));

				break;

			case 4:

				service.getcart();

				break;
			case 5:
				// View Customer Profile
				System.out.println("Enter Id to get your Profile");

				int Id = Integer.parseInt(sc.nextLine());

				DatabaseService.loginuserbyId(Id);

				break;
			case 6:

// Update Customers Profile				
				System.out.println("5. Update Customers Profile");
				break;

			case 7:
//Return to main page			

				MainPage.main(null);

				break;
			default:
				System.out.println("Enter Valid Choice");
				break;

			}

		}

	}
}