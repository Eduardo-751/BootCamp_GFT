package Main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Model.Account;
import Model.CheckingAccount;
import Model.Client;
import Model.Operation;
import Model.SavingsAccount;

public class MainApplication {
	
	static Scanner scanner = new Scanner(System.in);
	static Map<String, Account> accountsMap = new HashMap<>();
	
	public static void main(String[] args) {
		int option;
		do {
			System.out.println("--Selecione a Operação!--");
			System.out.println("1 - Cadastrar nova Conta!");
			System.out.println("2 - Consultar Conta!");
			System.out.println("3 - Fechar Systema!");
			option = scanner.nextInt();
			switch(option) {
				case 1:
					RegisterAccount();
					break;
				case 2:
					ConsultAccount();
					break;
			}
		}while(option != 3);
	}
	
	private static void RegisterAccount() {
		int option;
		int password;
		String cpf, name, email;
		System.out.println("\n--Selecione o tipo da Conta!--");
		System.out.println("1 - Conta Poupança");
		System.out.println("2 - Conta Corrente");
		option = scanner.nextInt();
		System.out.println("Digite seu CPF: ");
		cpf = scanner.next();
		System.out.println("Digite seu Nome: ");
		name = scanner.next();
		do {
			System.out.println("Digite seu Email: ");
			email = scanner.next();
			if(accountsMap.containsKey(email))
				System.out.println("Email ja cadastrado!");
		}while(accountsMap.containsKey(email));
		System.out.println("Escolha sua Senha (6 digitos): ");
		password = scanner.nextInt();
		switch(option) {
			case 1:
				accountsMap.put(email, new SavingsAccount(accountsMap.size()+1, new Client(cpf, name, email), password, 50));
				System.out.println("Conta Cadastrada com sucesso!\n");
				break;
			case 2:	
				accountsMap.put(email, new CheckingAccount(accountsMap.size()+1, new Client(cpf, name, email), password));
				System.out.println("Conta Cadastrada com sucesso!\n");
				break;
		}
	}
	
	private static void ConsultAccount(){
		Account Account = null;
		String email;
		int password, option;
		
		System.out.println("\nEntre com seu email: ");
		email = scanner.next();
		if(accountsMap.containsKey(email)) {
			Account = accountsMap.get(email);
			System.out.println("Digite sua senha: ");
			password = scanner.nextInt();
			if(Account.getPassword() == password)
				do {
					System.out.println(Account.toString());
					System.out.println("--Selecione a Operação!--");
					System.out.println("1 - Deposito");
					System.out.println("2 - Transferencia");
					System.out.println("3 - Saque");
					System.out.println("4 - Consultar Operações");
					System.out.println("5 - Sair");
					option = scanner.nextInt();
					switch(option) {
						case 1:
							System.out.println("Digite o Valor do Deposito: ");
							System.out.println(Account.Deposit(scanner.nextInt()));
							break;
						case 2:
							System.out.println("Digite o email para transferencia: ");
							email = scanner.next();
							if(accountsMap.containsKey(email)) {
								System.out.println("Digite o Valor do Saque: ");
								System.out.println(Account.Transfer(accountsMap.get(email), scanner.nextInt()));
							}
							else
								System.out.println("Email não encontrado!\n");
							break;
						case 3:
							System.out.println("Digite o Valor do Saque: ");
							System.out.println(Account.Withdraw(scanner.nextInt()));
							break;
						case 4:
							for(Operation op : Account.getOperations())
								System.out.println(op.toString());
							break;
					}
				}while(option != 5);	
			else
				System.out.println("Senha invalida!\n");	
		}
		else
			System.out.println("Email não Cadastrado!\n");		
	}
}
