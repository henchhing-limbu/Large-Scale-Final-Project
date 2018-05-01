package JavaProject;

public class Address {
	int streetNum;
	String city;
	String street;
	String state;
	int zipCode;
	// methods that edit the address
	public void editStreetNum(int x) {
		streetNum = x;
	}
	public void editStreet(String x) {
		street = x;
	}
	public void editCity(String x) {
		city = x;
	}
	public void editState(String x) {
		state = x;
	}
	public void editZipCode(int x) {
		zipCode = x;
	}
	// constructor
	Address()
	{
		streetNum = 0;
		city = "";
		street = "";
		state = "";
		zipCode = 0;
		System.out.println("Constructor for address.\n");
	}
	// returns the string representation of attributes of the class
	@Override
	public String toString() {
		return String.format("City     : " + city + "\nState    : " + state 
				+ "\nStreet   : " + street + "\nZip Code : " + zipCode);
	}
}
