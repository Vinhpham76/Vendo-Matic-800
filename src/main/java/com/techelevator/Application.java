package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		try {
			Scanner scanner = new Scanner(System.in);
			InventoryManagement inventoryManagement = new InventoryManagement();

			while (true) {
				displayMainMenu();
				String option = scanner.nextLine();
				switch (option) {
					case "1": // Display Vending Machine Items
						System.out.println("Vending Machine Items:");
						inventoryManagement.displayInventory();
						System.out.println("End of list \n");
						break;
					case "2": // Prompt the purchasing process menu
						System.out.println("Purchase processing:");
						managePurchase(inventoryManagement, scanner);
						break;
					case "3": // Exiting
						System.out.println("Exiting... Goodbye!!!");
						scanner.close();
						return;
					case "4": // Generate Sales Report , hidden
						System.out.println("Sales Report");
						// Generate a sales report here
						//	SalesReportGenerator.generateSalesReport();
						break;
					default:
						System.out.println("Wrong choices, Please try again !\n");
						break;
				}
			}
		} catch (Exception e) {
			System.out.println("Error while starting vending machine: " + e.getMessage());
		}
	}
	public static void displayMainMenu() {
		System.out.println("Welcome to Vendo-Matic 800 Vending Machine. ");
		System.out.println("Main Menu:");
		System.out.print("Please choose an option: \n");
		System.out.println("(1). Display Vending Machine Items");
		System.out.println("(2). Purchase");
		System.out.println("(3). Exit");
	}
	public static void displayPurchaseMenu(){

		System.out.println("(1). Feed Money");
		System.out.println("(2). Select Product");
		System.out.println("(3). Finish Transaction");
	}
	public static void managePurchase(InventoryManagement inventoryManagement, Scanner scanner) {

		Transactions transactions = new Transactions();
		displayPurchaseMenu();

		boolean process = true;
		while (process) {
			String selection = scanner.nextLine();
			switch (selection) {
				case "1":
					System.out.println("Please Deposit Money:");
					double amount = scanner.nextDouble();
					transactions.feedMoney(amount);
					System.out.printf("Current Money Provided: $%.2f%n", transactions.getCurrentBalance());
					displayPurchaseMenu();
					break;

				case "2":
					System.out.println("Please Select a Product Slot ID:");
					String code = scanner.next();
					transactions.selectProduct(code);
					break;

				case "3":
					System.out.println("Checkout & pay:");

					process = false;  //  return to Main menu
					break;

				default:
					System.out.println("Invalid Choices, Try again !");
					break;
			}
		}
	}
}
