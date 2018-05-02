package JavaProject;

import java.util.Comparator;

public class Individual implements Comparable<Individual> {
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
	@Override
	public int compareTo(Individual person) {
		// TODO: Fix the lowercase and uppercase prbolem
		int x;
		if ((this.lName).equals(person.lName)) {
			return ((this.fName).compareTo(person.fName));
		}
		else {
			return ((this.lName).compareTo(person.lName));
		}
	}
	/*
	public int compareZipCode(Individual person) {
		if (this.addr.zipCode == person.addr.zipCode) {
			if (this.lName.equals(person.lName)) {
				
			}
		}
		return 0;
	}
	*/
}
