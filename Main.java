package Banking_System;
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		Account acc = new Account();
		//initial balance for opening an account
		Savings_Account sacc = new Savings_Account(500); 
		Current_Account cacc = new Current_Account(45);
		
		File user = new File("User.txt");
		try {
			user.createNewFile();
		}catch(Exception x) {
			System.out.println(x);
		}
		
		int user_choice = 0;
		
		System.out.println("        --Welcome to Group 13's Project--");
		System.out.println();
		do {
			System.out.println("\n1. Log in Account.");
			System.out.println("2. Quite.");
			System.out.print("Choose one [1-2] : ");
			//user input and InputMismatchException handling
			do {
				try {
					user_choice = ob.nextInt();
					while (user_choice < 1 || user_choice > 2) {
						System.out.println("Invalid Input\nPlease re-enter : ");
						user_choice = ob.nextInt();
					}
				}catch(Exception e) {
					System.out.print("Error Input!!\nPlease re-enter : ");
					ob.nextLine();
				}
			}while (user_choice < 1 || user_choice > 2);
				
			switch(user_choice) {
				case 1: //For Login
					try {
						Formatter input = new Formatter("User.txt");
						System.out.print("\nEnter your name : ");
						acc.acc_name = ob.next();
						System.out.print("Account number : ");
						acc.acc_num = ob.next();
						System.out.print("Age : ");
						acc.acc_age = ob.nextInt();
						
						input.format("Name: %s \nAcc-num: %s \nAge: %s\r\n", acc.acc_name, acc.acc_num, acc.acc_age);
						input.close();
					}catch(Exception e) {
						System.out.print("Error Input!! \nPlease re-enter : ");
						ob.nextLine();
					}
					acc.details(acc.acc_name, acc.acc_num);//showing details about user
						
						System.out.println("\n1. Savings Account.");
						System.out.println("2. Current Account.");
						System.out.println("3. Quite.");
						System.out.print("Choose one [1-3] : ");
						//user input
						do {
							try {
								user_choice = ob.nextInt();
								while (user_choice < 1 || user_choice > 3) {
									System.out.println("Invalid Input\nPlease re-enter : ");
									user_choice = ob.nextInt(); 
								}
							}catch(InputMismatchException e) {
								System.out.print("Error Input!!\nPlease re-enter : ");
								ob.nextLine();
							}
						}while (user_choice < 1 || user_choice > 3);
						
						switch(user_choice) {
							case 1: //savings account options
								do {
									System.out.println("\n1. Deposit money.");
									System.out.println("2. Withdraw money.");
									System.out.println("3. Quite");
									System.out.print("Enter your choice : ");
									//user input
									do {
										try {
											user_choice = ob.nextInt();
											while (user_choice < 1 || user_choice > 3) {
												System.out.println("Invalid Input\nPlease re-enter : ");
												user_choice = ob.nextInt();
											}
										}catch(InputMismatchException e) {
											System.out.print("Error Input!!\nPlease re-enter : ");
											ob.nextLine();
										}
									}while (user_choice < 1 || user_choice > 3);
									
									switch(user_choice) {
										case 1: //savings account > deposit money 
											double balance = 0;
											System.out.print("Please Enter your amount : ");
											//input amount for deposit
											do {
												try {
													balance = ob.nextInt();
													while (balance < 0) {
														System.out.println("Please input Positve number : ");
														balance = ob.nextInt();
													}
												}catch(InputMismatchException e) {
													System.out.print("Error Input!!\nPlease re-enter : ");
													ob.nextLine();
												}
											}while (balance < 0);
											
											sacc.deposit(balance);
											break;
										case 2: //savings account > withdraw money
											double amount = 0;
											
											System.out.println("Your account has = " + sacc.acc_balance);
											System.out.print("Please Enter your amount : ");
											//input amount for withdraw
											do {
												try {
													amount = ob.nextInt();
													while (amount > sacc.acc_balance) {
														System.out.println("Incufficient amount \nPlease re-enter : ");
														amount = ob.nextInt();
													}
												}catch(InputMismatchException e) {
													System.out.print("Error Input!!\nPlease re-enter : ");
													ob.nextLine();
												}
											}while (amount > sacc.acc_balance);
											
											sacc.interest(18);
											sacc.add_interest(); //adding interest while withdraw
											sacc.withdraw(amount);
											break;
										case 3: //quite
											System.exit(0);
									}
								}while (user_choice != 4);
								break;
								
							case 2: //current account options
								do {
									System.out.println("1. Deposit money.");
									System.out.println("2. Withdraw money.");
									System.out.println("3. Quite");
									System.out.print("Enter your choice : ");
									//user input
									do {
										try {
											user_choice = ob.nextInt();
											while (user_choice < 1 || user_choice > 2) {
												System.out.println("Invalid Input\nPlease re-enter : ");
												user_choice = ob.nextInt();
											}
										}catch(InputMismatchException e) {
											System.out.print("Error Input!!\nPlease re-enter : ");
											ob.nextLine();
										}
									}while (user_choice < 1 || user_choice > 2);
									
									switch(user_choice) {
										case 1: //current account > deposit money
											double balance = 0;
											System.out.println("Your account has = " + cacc.acc_balance);
											System.out.print("Please Enter your amount : ");
											//input amount for deposit
											do {
												try {
													balance = ob.nextInt();
												}catch(InputMismatchException e) {
													System.out.print("Error!!\nPlease re-enter your Balance : ");
													ob.nextLine();
												}
											}while (balance < 0);
											
											System.out.println("Now your account balance is : " + cacc.debit(balance));
										case 2: //current account > withdraw money
											double amount = 0;
											System.out.println("Your account has = " + cacc.acc_balance);
											System.out.print("Please Enter your amount : ");
											//input amount for withdraw
											do {
												try {
													amount = ob.nextInt();
													while (amount > cacc.acc_balance) {
														System.out.println("Incufficient amount \nPlease re-enter : ");
													amount = ob.nextInt();
													}
												}catch(InputMismatchException e) {
													System.out.print("Error!!\nPlease re-enter your Balance : ");
													ob.nextLine();
												}
											}while (amount > cacc.acc_balance);
											
											System.out.println("Now your account balance is : " + cacc.credit(amount) + "$");
											break;
										case 3: //quite
											System.exit(0);
									}
								}while (user_choice != 4);
								break;
							case 3: //quite
								System.exit(0);
						}break;
				case 2: //quite
					System.exit(0);
			}
		}while (user_choice != 3);	
		
	}
}

