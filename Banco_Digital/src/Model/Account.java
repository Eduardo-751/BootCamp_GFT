package Model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
	protected int accountId;
	protected double balance;
	protected Client client;
	protected Date openingDate;
	protected int password;
	private List<Operation> operations =  new ArrayList<Operation>();
	
	
	//Gets and Sets
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getAccountId() {
		return accountId;
	}
	public Date getOpeningDate() {
		return openingDate;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	
	//Methods
	public String Withdraw(double value) {
		if(balance > value) {
			balance -= value;
			operations.add(new Operation(value, this, null, OperationType.WITHDRAW));
			return new String("Operação Realizado com Sucesso!");
		}
		else {
			return new String("Saldo insuficiente!");
		}
	}
	
	public String Deposit(double value) {
		balance += value;
		operations.add(new Operation(value, this, null, OperationType.DEPOSIT));
		return new String("Operação Realizado com Sucesso!");
	}
	
	public String Transfer(Account destination, double value) {
		if(balance > value) {
			balance -= value;
			destination.Deposit(value);
			operations.add(new Operation(value, this, destination, OperationType.TRANSFER));
			return new String("Operação Realizado com Sucesso!");
		}
		else {
			return new String("Saldo insuficiente!");
		}
	}
	
	@Override
	public String toString() {
		return "\nNumero da Conta = " + accountId + "\n" + "Conta = " + this.getClass().getSimpleName() + "\n" + "Saldo = " + balance + "\n" + client.toString() + "Data de Abertura = "
				+ openingDate + "\n";
	}
	
	
}
