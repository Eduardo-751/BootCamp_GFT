package Model;

import java.util.Date;

public class SavingsAccount extends Account{
	
	private double yield;
	
	//Constructor
	public SavingsAccount(int identity, Client clientName, int password, double balance) {
		this.accountId = identity;
		this.client = clientName;
		this.password = password;
		this.balance = balance;
		openingDate = new Date();
		yield = 0.05;
	}
	
	//Gets and Sets
	public double getYield() {
		return yield;
	}
	public void setYield(double yield) {
		this.yield = yield;
	}
	
	//Methods
	public double CalculateYield() {
		return this.balance*yield;
	}
}
