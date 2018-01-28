package tsdv.controller;

import java.util.List;

import tsdv.dao.AccountDAO;
import tsdv.dao.AccountDAOimpl;
import tsdv.dao.CustomerDAO;
import tsdv.dao.CustomerDAOimpl;
import tsdv.model.Account;
import tsdv.model.Customer;

public class BankController {
	public static void openAccount(Customer customer, List<Account> accounts) {
		CustomerDAO customerDAO = new CustomerDAOimpl();
		customerDAO.add(customer);
		
		//Create account
		AccountDAO accountDAO = new AccountDAOimpl();
		for (Account account : accounts) {
			accountDAO.add(account);
		}
	}
	
	public static void deposit(Account account, double money) {
		AccountDAO accountDAO = new AccountDAOimpl();
		account.setBalance(account.getBalance() + money);
		accountDAO.update(account.getId(), account);
	}
}
