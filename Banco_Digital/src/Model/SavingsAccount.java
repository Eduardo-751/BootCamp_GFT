package Model;

public class SavingsAccount extends Account{

	private double yield;
	
	//Constructor
	public SavingsAccount(int identity, Client clientName, int password, double balance) {
		super(identity, clientName, password, balance);
	}

	//Gets and Sets
	public double getYield() {
		return yield;
	}
	public void setYield(double yield) {
		this.yield = yield;
	}
}
