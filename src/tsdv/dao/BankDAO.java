package tsdv.dao;

import java.util.List;

import tsdv.model.Bank;

public interface BankDAO {
	List<Bank> getAll();
	void add(Bank bank);
	void update(int id, Bank bank);
	List<Bank> searchByName(String name);
	Bank searchById(int id);
}
