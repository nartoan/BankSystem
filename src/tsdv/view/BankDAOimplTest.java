package tsdv.view;

import tsdv.dao.BankDAO;
import tsdv.dao.BankDAOimpl;
import tsdv.model.Bank;

public class BankDAOimplTest {
	public static void main(String[] args) {
		BankDAO bankDAOimpl = new BankDAOimpl();
		bankDAOimpl.update(1, new Bank(1, "VietComBank", "Giang Van Minh, Ba Dinh, Ha Noi"));
		
		System.out.println("Success");
	}
}
