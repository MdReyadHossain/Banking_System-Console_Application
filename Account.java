package Banking_System;

public class Account {
	protected String acc_name;
	protected int acc_age;
	protected String acc_num;
	protected double acc_balance;
	
	public double get_balance(double balance) {
		acc_balance = balance;
		return acc_balance;
	}
	
	public void details(String name, String number) {
		acc_name = name;
		acc_num = number;
		System.out.println("Account Username : " + acc_name);
		System.out.println("Account Number : " + acc_num);
	}
}
