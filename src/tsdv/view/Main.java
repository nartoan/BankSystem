package tsdv.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tsdv.controller.BankController;
import tsdv.controller.CustomerController;
import tsdv.dao.AccountDAO;
import tsdv.dao.AccountDAOimpl;
import tsdv.dao.CustomerDAO;
import tsdv.dao.CustomerDAOimpl;
import tsdv.model.Account;
import tsdv.model.Customer;

public class Main {
	public static void main(String[] args) throws IOException {
		System.out.println("Bank System");
		System.out.println("Please choose :");
		System.out.println("1. Open account for customer");
		System.out.println("2. Withdraw");
		System.out.println("3. Deposit");
		System.out.println("Please choose option: 1 - 3");
		
		Scanner scanner = new Scanner(System.in);
		
		int inputChar;
		do {
			System.out.print("Choose : ");
			inputChar = scanner.nextInt();
		} while(inputChar != 1 && inputChar != 2 && inputChar != 3);

		switch (inputChar) {
		case 1:
			System.out.println("\nCreate account");
			System.out.println("Create customer: ");
			Customer customer = new Customer();
			Account account = new Account();
			String temp = "";
			scanner.nextLine();
			System.out.print("Name :");
			temp = scanner.nextLine();  customer.setName(temp);
			
			System.out.print("Adrress : ");
			temp = scanner.nextLine();  customer.setAddress(temp);
			
			System.out.print("Password : ");
			temp = scanner.nextLine();  customer.setPassword(temp);
			customer.setBankId(1);
			
			CustomerDAO customerDAOx = new CustomerDAOimpl();
			List<Customer> customersTemp = customerDAOx.getAll();
			
			customer.setId(customersTemp.size() + 1);
			
			System.out.println("Create account: ");
			System.out.print("Balance :");
			Double balance = scanner.nextDouble();  account.setBalance(balance);
			account.setCustomerId(customer.getId());
			
			
			account.setId(customersTemp.size() + 1); 
			
			List<Account> accounts = new ArrayList<Account>();
			accounts.add(account);
			
			BankController.openAccount(customer, accounts);
			
			break;
		case 2:
			System.out.println("\nWithdraw : ");
			System.out.println("List Customer : ");
			CustomerDAO customerDAO = new CustomerDAOimpl();
			List<Customer> customers = customerDAO.getAll();
			System.out.println("Id\t\tName\t\tAddress");
			for(Customer customerTemp : customers) {
				System.out.println(customerTemp.toString());
			}
			
			System.out.print("Choose customer: ");
			int idTemp = scanner.nextInt();
			Customer customer2 = customerDAO.searchById(idTemp);
			
			AccountDAO accountDAO = new AccountDAOimpl();
		
			Account account2 = accountDAO.searchByIdCustomer(customer2.getId());
			System.out.print(customer2.toString());
			System.out.println(account2.toString());
			System.out.println("Enter money : ");
			Double money = scanner.nextDouble();
			CustomerController.withdraw(account2, money);
			System.out.print(customer2.toString());
			System.out.println(account2.toString());
			break;
			
		case 3:
			System.out.println("\nDeposit : ");
			System.out.println("List Customer : ");
			CustomerDAO customerDAO1 = new CustomerDAOimpl();
			List<Customer> customers1 = customerDAO1.getAll();
			System.out.println("Id\t\tName\t\tAddress");
			for(Customer customerTemp : customers1) {
				System.out.println(customerTemp.toString());
			}
			
			System.out.print("Choose customer: ");
			int idTemp1 = scanner.nextInt();
			Customer customer3 = customerDAO1.searchById(idTemp1);
			
			AccountDAO accountDAO1 = new AccountDAOimpl();
			Account account3 = accountDAO1.searchByIdCustomer(customer3.getId());
			System.out.print(customer3.toString());
			System.out.println(account3.toString());
			System.out.println("Enter money : ");
			Double money1 = scanner.nextDouble();
			BankController.deposit(account3, money1);
			
			System.out.print(customer3.toString());
			System.out.println(account3.toString());
		default:
			break;
		}
	}
}
