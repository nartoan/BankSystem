package tsdv.dao;

import java.util.List;

import tsdv.model.Customer;

public interface CustomerDAO {
	List<Customer> getAll();
	void add(Customer customer);
	void update(int id, Customer customer);
	List<Customer> searchByName(String name);
	Customer searchById(int id);
}
