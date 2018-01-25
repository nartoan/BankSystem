package tsdv.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tsdv.model.Bank;
import tsdv.utils.FileUtils;
import tsdv.utils.Paths;

public class BankDAOimpl implements BankDAO {
	private Scanner scanner;
	private static String pathFile = Paths.FILE_STORE_BANK;

	@Override
	public List<Bank> getAll() {
		List<Bank> banks = new ArrayList<>();
		try {
			scanner = new Scanner(new File(pathFile));
			while (scanner.hasNextLine()) {
				String[] tempBank = scanner.nextLine().split("\\|");
				banks.add(new Bank(Integer.parseInt(tempBank[0]), tempBank[1], tempBank[2]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}
		return banks;
	}

	@Override
	public void add(Bank bank) {
		FileUtils.writeToEndFile(pathFile, bank.toStringToFile());
	}

	@Override
	public void update(int id, Bank bank) {
		List<Bank> banks = this.getAll();
		FileUtils.writeToFile(pathFile, "");
		for(Bank bankTemp : banks) {
			if(bankTemp.getId() == id) {
				this.add(bank);
			} else {
				this.add(bankTemp);
			}
		}
	}

	@Override
	public List<Bank> searchByName(String name) {
		List<Bank> banks = new ArrayList<>();
		try {
			scanner = new Scanner(new File(pathFile));
			while (scanner.hasNextLine()) {
				String[] tempBank = scanner.nextLine().split("\\|");
				if (tempBank[1].toLowerCase().indexOf(name.toLowerCase()) != -1) {
					banks.add(new Bank(Integer.parseInt(tempBank[0]), tempBank[1], tempBank[2]));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}
		return banks;
	}
	
	@Override
	public Bank searchById(int id) {
		Bank bank = null;
		try {
			scanner = new Scanner(new File(pathFile));
			while (scanner.hasNextLine()) {
				String[] tempBank = scanner.nextLine().split("\\|");
				if (Integer.parseInt(tempBank[0]) == id) {
					bank = new Bank(Integer.parseInt(tempBank[0]), tempBank[1], tempBank[2]);
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null)
				scanner.close();
		}
		return bank;
	}
}
