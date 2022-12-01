package Banking_System;

public class Savings_Account extends Account{
	double interest_rate;
	
	public Savings_Account(double ini_balance) {
		get_balance(ini_balance); 	
	}
	
	public void deposit(double balance) {
		if (balance > 0) {
			acc_balance = acc_balance + balance;
			System.out.print("Now your account balance is : " + acc_balance +"$");
		}
	}
	public double interest(double int_rate) {
		interest_rate = int_rate / 12;//monthly interest rate
		return interest_rate;
	}
	
	public void withdraw(double balance) {
		if (balance > 0 && acc_balance > 0) {
			acc_balance = acc_balance - balance;
			System.out.print("Now your account balance is : " + acc_balance +"$");
		}	
		else {
			System.out.println("Withdraw amount exceeded account balance!");
		}
	}
	
	public double add_interest() {
		acc_balance = acc_balance * interest_rate;
		return acc_balance;
	}
}
