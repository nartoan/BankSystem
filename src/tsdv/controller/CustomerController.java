package tsdv.controller;

import tsdv.dao.AccountDAO;
import tsdv.dao.AccountDAOimpl;
import tsdv.model.Account;

public class CustomerController {
	public static void withdraw(Account account, double money) {
		AccountDAO accountDAO = new AccountDAOimpl();
		account.setBalance(account.getBalance() - money);
		accountDAO.update(account.getId(), account);
	}
}
