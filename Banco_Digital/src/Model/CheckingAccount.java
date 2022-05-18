package Model;

import java.util.Date;

public class CheckingAccount extends Account{
	
	//Constructor
	public CheckingAccount(int identity, Client clientName, int password) {
		this.accountId = identity;
		this.client = clientName;
		this.password = password; 
		openingDate = new Date();
	}	
}
