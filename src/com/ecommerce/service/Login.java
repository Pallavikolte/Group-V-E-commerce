package com.ecommerce.service;

import java.util.Scanner;

import com.ecommerce.main.MainPage;

public class Login {
//Coding for Admin Login
	public void adminLogin() {

		Scanner scanner = new Scanner(System.in);

		System.out.println(" Enter user name => ");
		String userName = scanner.nextLine();

		System.out.println(" Enter password => ");
		String password = scanner.nextLine();

		if ("Pankaj".equals(userName) && "Ishanvi".equals(password)) {
			System.out.println("Admin successfully logged-in.. ");

			AdminChoice.adminchoice();

		} else {
			System.out.println(" In valid UserName or Password ");
			MainPage.main(null);
		}
	}

	//// Coding for Admin Login Ended

	// Coding for User Login

	public static void userLogin() throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println(" Enter user name => ");
		String userName = scanner.nextLine();

		System.out.println(" Enter password => ");
		String password = scanner.nextLine();

		if ("root".equals(userName) && "root".equals(password)) {
			System.out.println("User successfully logged-in.. ");
			UserChoice.choice();

		} else {
			System.out.println(" In valid UserName or Password ");
			MainPage.main(null);
		} // Coding for User Login ended
	}
}
