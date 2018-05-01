package JavaProject;

public class Individual {
	String fName;
	String lName;
	Address addr;
	String phoneNum;
	void editFName(String name) {
		fName = name;
	}
	void editLName(String name) {
		lName = name;
	}
	void editAddr(Address address) {
		this.copyValue(address);
	}
	void editPhoneNum(String num) {
		phoneNum = num;
	}

	// copies object by value instead of by reference
	void copyValue(Address address) {
		addr.city = address.city;
		addr.state = address.state;
		addr.street = address.street;
		addr.streetNum = address.streetNum;
		addr.zipCode = address.zipCode;
	}
	// constructor
	Individual()
	{
		fName = "";
		lName = "";
		phoneNum = "";
		addr = new Address();
		System.out.println("Constructor of Individual.\n");
	}
	@Override
	public String toString() {
		return String.format("First Name     : " + fName + "\nLast name      : " + lName +
				"\nPhone Number   : " + phoneNum + "\nAddress Information \n");
	}
}
