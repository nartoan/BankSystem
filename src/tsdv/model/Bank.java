package tsdv.model;

/**
 * @author toantd
 *
 */
public class Bank {
	private int id;
	private String name;
	private String location;
	
	public Bank() {
	}
	
	public Bank(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String toStringToFile() {
		return id + "|" + name + "|" + location;
	}
	
	public String toString() {
		return id + "\t" + name + "\t" + location;
	}
}
