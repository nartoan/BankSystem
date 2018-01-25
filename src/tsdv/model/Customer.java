package tsdv.model;

public class Customer {
	private int id;
	private String name;
	private String password;
	private String address;
	private int bankId;
	
	public Customer() {
	}
	
	public Customer(int id, String name, String password, String address, int bankId) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.address = address;
		this.bankId = bankId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	
	public String toStringToFile() {
		return id + "|" + name + "|" + address + "|" + bankId;
	}
	
	public String toString() {
		return id + "\t" + name + "\t" + address + "\t" + bankId;
	}
}
