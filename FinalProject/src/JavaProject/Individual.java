package JavaProject;

import java.io.Serializable;

public class Individual implements Comparable<Individual>, Serializable {
	private String fName;
	private String lName;
	private Address addr;
	private String phoneNum;
	
	/**
	 * This method gets the first name of the person.
	 * @return String This is the returned first name.
	 */
	public String getfName() {
		return fName;
	}
	
	/**
	 * This method sets the first name.
	 * @param fName This is the parameter to the method.
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	/**
	 * This method gets the last name of the person.
	 * @return String This is the returned last name.
	 */
	public String getlName() {
		return lName;
	}
	
	/**
	 * This method sets the last name of the person.
	 * @param lName This is the parameter to the method.
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	/**
	 * This method gets the address of the person.
	 * @return Address This is the returned address.
	 */
	public Address getAddr() {
		return addr;
	}
	
	/**
	 * This method sets the address of the person.
	 * @param addr This is the parameter to the method.
	 */
	public void setAddr(Address addr) {
		this.copyValue(addr);
	}
	
	/**
	 * This method gets the phone number of the person.
	 * @return String This is the returned phone number.
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	/**
	 * This method sets the phone number of the person.
	 * @param phoneNum This is the parameter to the method.
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	/**
	 * This method updates the phone number of the person.
	 * @param num This is the parameter to the method.
	 */
	void editPhoneNum(String num) {
		phoneNum = num;
	}

	/**
	 * This method updates the address.
	 * @param address This is the new address.
	 */
	void editAddr(Address address) {
		this.copyValue(address);
	}
	
	/**
	 * This method copies values by value, not by reference
	 * @param address This is the parameter to the method.
	 */
	public void copyValue(Address address) {
		addr.setCity(address.getCity());
		addr.setState(address.getState());
		addr.setStreet(address.getStreet());
		addr.setStreetNum(address.getStreetNum());
		addr.setZipCode(address.getZipCode());
	}
	
	/**
	 * This is the constructor for Individual class
	 */
	public Individual()
	{
		fName = "";
		lName = "";
		phoneNum = "";
		addr = new Address();
		// System.out.println("Constructor of Individual.\n");
	}
	
	/**
	 * This is the overridden toString() method.
	 * This returns the attributes of the class in string format
	 * @return String This is the return string from the method. 
	 */
	@Override
	public String toString() {
		return String.format("First Name     : " + fName + "\nLast name      : " + lName +
				"\nPhone Number   : " + phoneNum + "\nAddress Information \n");
	}
	
	/**
	 * This is overridden compareTo() method.
	 * This method compares two Individual objects by last name.
	 * If tie, then they are compared using first name.
	 * @param person This is the parameter to the method.
	 */
	@Override
	public int compareTo(Individual person) {
		if ((this.lName.toLowerCase()).equals(person.lName.toLowerCase())) {
			return ((this.fName.toLowerCase()).compareTo(person.fName.toLowerCase()));
		}
		else {
			return ((this.lName.toLowerCase()).compareTo(person.lName.toLowerCase()));
		}
	}
	
	/**
	 * This method compares equates two Individual objects.
	 * @param obj This is the only parameter to the method.
	 * @return boolean This is the returned boolean value.
	 */
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
}