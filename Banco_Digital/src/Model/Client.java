package Model;

public class Client {
	private String cpf;
	private String name;
	private String email;

	//Constructor
	public Client(String cpf, String name, String email) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.email = email;
	}
	
	//Gets and Sets
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public String getName() {
		return name;
	}
	
	//Methods
	@Override
	public String toString() {
		return "Name = " + name + "\n" + "Cpf = " + cpf + "\n" + "Email = " + email + "\n";
	}
}
