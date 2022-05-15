package Model;

public class CheckingAccount extends Account{

	//Constructor
	public CheckingAccount(int identity, Client clientName, int password) {
		super(identity, clientName, password);
	}	
	public CheckingAccount(int identity, Client clientName, int password, double balance) {
		super(identity, clientName, password, balance);
	}
	
}
