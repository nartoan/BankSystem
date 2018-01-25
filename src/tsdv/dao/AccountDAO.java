package tsdv.dao;

import java.util.List;

import tsdv.model.Account;

public interface AccountDAO {
	List<Account> getAll();
	void add(Account account);
	void update(int id, Account account);
	void update(int id, double balance);
	List<Account> searchByName(String name);
	Account searchById(int id);
}
