package com.ecommerce.service;

import java.util.Scanner;

import com.ecommerce.main.MainPage;
import com.ecommerce.model.Product;
import com.ecommerce.model.Register;
import com.ecommerce.util.DatabaseService;

public class AdminChoice {

	public static void adminchoice() {
		try (Scanner sc = new Scanner(System.in);) {
			System.out.println("---------------------WELCOME TO R Mart Admin Portal --------------------- ");

			boolean isRunning = true;

			while (isRunning) {

				System.out.println("*****     Select Your Choice     *****");

				System.out.println("1. Add Product to Database");
				System.out.println("2. Update Product");
				System.out.println("3. All User Profile");
				System.out.println("4. Update User Profile ");
				System.out.println("5. All Procuct added to Database");
				System.out.println("6. Signout");

				int choice = Integer.parseInt(sc.nextLine());
				DatabaseService service = new DatabaseService();
				switch (choice) {
				case 1:
					// 1. Add Product to Database
					try {
						System.out.println("Enter Product_ID");
						int id = Integer.parseInt(sc.next());
						System.out.println("Product_Name");
						String name = sc.next();
						System.out.println("Description");
						String des = sc.next();
						System.out.println("Price");
						int price = Integer.parseInt(sc.next());
						System.out.println("Quantity");
						int qty = Integer.parseInt(sc.next());

						DatabaseService.insertProductByAdmin(new Product(id, name, des, price, qty));
					} catch (Exception e) {
						System.out.println(e);
					}

					break;

				case 2:
					// 2. Update Product
					System.out.println("2. Update Product");

					break;

				case 3:
					// 3. All User Profile
					service.getloginuser();

					break;

				case 4:
					// 4. Update User Profile
					System.out.println("4. Edit user profilet");

					break;

				case 5:

					// 5. All Product Which added to Database
					service.getProduct();

					break;

				case 6:
					// Signout
					MainPage.main(null);

					break;

				default:
					System.out.println("Enter Valid Choice.");
				}

			}

		} catch (Exception e) {
			System.out.println("Something went Wrong" + e);

		}
	}

}
