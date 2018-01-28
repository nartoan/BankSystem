package tsdv.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tsdv.model.Account;
import tsdv.utils.FileUtils;
import tsdv.utils.Paths;

public class AccountDAOimpl implements AccountDAO {
	private Scanner scanner;
	private static String pathFile = Paths.FILE_STORE_ACCOUNT;

	@Override
	public List<Account> getAll() {
		List<Account> accounts = new ArrayList<>();
		try {
			scanner = new Scanner(new File(pathFile));
			while (scanner.hasNextLine()) {               
				String[] tempAccount = scanner.nextLine().split("\\|");
				accounts.add(new Account(Integer.parseInt(tempAccount[0]), Integer.parseInt(tempAccount[1]),
						Double.parseDouble(tempAccount[2])));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}
		return accounts;
	}

	@Override
	public void add(Account account) {
		FileUtils.writeToEndFile(pathFile, account.toStringToFile());
	}

	@Override
	public void update(int id, Account account) {
		List<Account> accounts = this.getAll();
		FileUtils.writeToFile(pathFile, "");
		for (Account accountTemp : accounts) {
			if (accountTemp.getId() == id) {
				this.add(account);
			} else {
				this.add(accountTemp);
			}
		}
	}
	
	@Override
	public void update(int id, double balance) {
		List<Account> accounts = this.getAll();
		FileUtils.writeToFile(pathFile, "");
		for (Account accountTemp : accounts) {
			if (accountTemp.getId() == id) {
				accountTemp.setBalance(balance);
			}
			this.add(accountTemp);
		}
	}

	@Override
	public List<Account> searchByName(String name) {
		List<Account> accounts = new ArrayList<>();
		try {
			scanner = new Scanner(new File(pathFile));
			while (scanner.hasNextLine()) {
				String[] tempAccount = scanner.nextLine().split("\\|");
				if (tempAccount[1].toLowerCase().indexOf(name.toLowerCase()) != -1) {
					accounts.add(new Account(Integer.parseInt(tempAccount[0]), Integer.parseInt(tempAccount[1]),
							Double.parseDouble(tempAccount[2])));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}
		return accounts;
	}

	@Override
	public Account searchById(int id) {
		Account account = null;
		try {
			scanner = new Scanner(new File(pathFile));
			while (scanner.hasNextLine()) {
				String[] tempAccount = scanner.nextLine().split("\\|");
				if (Integer.parseInt(tempAccount[0]) == id) {
					account = new Account(Integer.parseInt(tempAccount[0]), Integer.parseInt(tempAccount[1]),
							Double.parseDouble(tempAccount[2]));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}
		return account;
	}
	
	@Override
	public Account searchByIdCustomer(int id) {
		Account account = null;
		try {
			scanner = new Scanner(new File(pathFile));
			while (scanner.hasNextLine()) {
				String[] tempAccount = scanner.nextLine().split("\\|");
				if (Integer.parseInt(tempAccount[1]) == id) {
					account = new Account(Integer.parseInt(tempAccount[0]), Integer.parseInt(tempAccount[1]),
							Double.parseDouble(tempAccount[2]));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}
		return account;
	}
}
