package Banking_System;

public class Current_Account extends Account {
	
	public Current_Account(int initial_balance) {
		get_balance(initial_balance);
	}
	
	public double debit(double balance) {
		acc_balance = acc_balance + balance;
		return acc_balance;
	}
	
	public double credit(double balance) {
		acc_balance = acc_balance - balance;
		return acc_balance;
	} 
}
