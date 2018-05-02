package JavaProject;

import java.util.Comparator;

public class Individual implements Comparable<Individual> {
	String fName;
	String lName;
	Address addr;
	String phoneNum;
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
	@Override
	public int compareTo(Individual person) {
		// TODO: Fix the lowercase and uppercase prbolem
		int x;
		if ((this.lName.toLowerCase()).equals(person.lName.toLowerCase())) {
			return ((this.fName.toLowerCase()).compareTo(person.fName.toLowerCase()));
		}
		else {
			return ((this.lName.toLowerCase()).compareTo(person.lName.toLowerCase()));
		}
	}
	public boolean equals(Individual obj) {
		// TODO Auto-generated method stub
		if (this.fName.toLowerCase().equals(obj.fName.toLowerCase())) {
			if (this.lName.toLowerCase().equals(obj.lName.toLowerCase())) {
				if (this.phoneNum.equals(obj.phoneNum)) {
					if (this.addr.equals(obj.addr)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public void edit() {
		
	}
	
}
