package tsdv.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tsdv.model.Customer;
import tsdv.utils.FileUtils;
import tsdv.utils.Paths;

public class CustomerDAOimpl implements CustomerDAO {
	private Scanner scanner;
	private static String pathFile = Paths.FILE_STORE_CUSTOMER;

	@Override
	public List<Customer> getAll() {
		List<Customer> customers = new ArrayList<>();
		try {
			scanner = new Scanner(new File(pathFile));
			while (scanner.hasNextLine()) {
				String[] tempCustomer = scanner.nextLine().split("\\|");
				customers.add(new Customer(Integer.parseInt(tempCustomer[0]), tempCustomer[1], tempCustomer[2], tempCustomer[3],
						Integer.parseInt(tempCustomer[4])));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}
		return customers;
	}

	@Override
	public void add(Customer customer) {
		FileUtils.writeToEndFile(pathFile, customer.toStringToFile());
	}

	@Override
	public void update(int id, Customer customer) {
		List<Customer> customers = this.getAll();
		FileUtils.writeToFile(pathFile, "");
		for (Customer customerTemp : customers) {
			if (customerTemp.getId() == id) {
				this.add(customer);
			} else {
				this.add(customerTemp);
			}
		}
	}

	@Override
	public List<Customer> searchByName(String name) {
		List<Customer> customers = new ArrayList<>();
		try {
			scanner = new Scanner(new File(pathFile));
			while (scanner.hasNextLine()) {
				String[] tempCustomer = scanner.nextLine().split("\\|");
				if (tempCustomer[1].toLowerCase().indexOf(name.toLowerCase()) != -1) {
					customers.add(new Customer(Integer.parseInt(tempCustomer[0]), tempCustomer[1], tempCustomer[2],tempCustomer[3],
							Integer.parseInt(tempCustomer[4])));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}
		return customers;
	}

	@Override
	public Customer searchById(int id) {
		Customer customer = null;
		try {
			scanner = new Scanner(new File(pathFile));
			while (scanner.hasNextLine()) {
				String[] tempCustomer = scanner.nextLine().split("\\|");
				if (Integer.parseInt(tempCustomer[0]) == id) {
					customer = new Customer(Integer.parseInt(tempCustomer[0]), tempCustomer[1], tempCustomer[2], tempCustomer[3],
							Integer.parseInt(tempCustomer[4]));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}
		return customer;
	}

}
