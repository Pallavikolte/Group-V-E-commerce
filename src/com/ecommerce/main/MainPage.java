package com.ecommerce.main;

import java.util.Scanner;

import com.ecommerce.model.Product;
import com.ecommerce.model.Register;
import com.ecommerce.service.AdminChoice;

import com.ecommerce.service.Login;

import com.ecommerce.service.UserChoice;
import com.ecommerce.util.DatabaseService;

public class MainPage {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);) {
			System.out.println("---------------------WELCOME TO R Mart --------------------- ");
			System.out.println("---------------------Excelent to Quality --------------------- ");

			boolean isRunning = true;

			while (isRunning) {

				System.out.println("*****     Select Your Choice     *****");

				System.out.println("1. New User? - REGISTER");
				System.out.println("2. Existing User - LOGIN");
				System.out.println("3. Admin Login");
				System.out.println("4. EXIT");

				int choice = Integer.parseInt(sc.nextLine());

				switch (choice) {
				case 1:

					try {
						DatabaseService dbs = new DatabaseService();
						System.out.println("Enter First Name");
						String FirstName = sc.next();

						System.out.println("Enter Last Name");
						String LastName = sc.next();

						System.out.println("Enter User Name");
						String UserName = sc.next();

						System.out.println("Enter Passward");
						String Passward = sc.next();

						System.out.println("Enter Email Id");
						String Email = sc.next();

						System.out.println("Enter Mobile number");
						Long Phone = Long.parseLong(sc.next());

						DatabaseService
								.insertCustomer(new Register(FirstName, LastName, UserName, Passward, Email, Phone));
					} catch (Exception e) {
						System.out.println(e);
					}
					break;

				case 2:
					Login adm1 = new Login();
					adm1.userLogin();

					// UserChoice.choice();
					break;
				case 3:

					Login adm = new Login();
					adm.adminLogin();
					// AdminChoice.adminchoice();

				case 4:
					System.out.println("Thank You. Visit Again.");
					isRunning = false;
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