package tsdv.model;

public class Customer {
	private int id;
	private String name;
	private String address;
	private int accountId;
	
	public Customer() {
	}
	
	public Customer(int id, String name, String address, int accountId) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.accountId = accountId;
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

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
}
