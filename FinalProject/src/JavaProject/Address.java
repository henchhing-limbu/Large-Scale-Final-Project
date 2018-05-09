package JavaProject;

import java.io.Serializable;
/**
 * This class contains address attributes.
 * This class has methods editCity(), editStreet(), editZipCode(), editState()
 */
public class Address implements Serializable{
	private String city;
	private String street;
	private String state;
	private int zipCode;
	
	/**
	 * This method gets the city name.
	 * @return String This is the returned city name.
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * This methods sets the city name.
	 * @param city This is the passed city name.
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * This methods gets the street name.
	 * @return String This is the returned street name.
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * This methods sets the street nam.e
	 * @param street This is the parameter to the method. 
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * This method gets the state name.
	 * @return String This is the returned state name.
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * This method sets the state name.
	 * @param state This is the parameter to the method.
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * This method gets the zip code.
	 * @return int This is the returned zipcode.
	 */
	public int getZipCode() {
		return zipCode;
	}
	
	/**
	 * This method sets the zip code.
	 * @param zipCode This is the parameter to the method.
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	 * This method is used to update the street name.
	 * @param x This is the new street name.
	 */
	public void editStreet(String x) {
		street = x;
	}
	/**
	 * This method is used to update the City name.
	 * @param x This is the new City name.
	 */
	public void editCity(String x) {
		city = x;
	}
	/**
	 * This method is used to update the State name.
	 * @param x This is the new State name.
	 */
	public void editState(String x) {
		state = x;
	}
	/**
	 * This method is used to update the ZipCode.
	 * @param x This is the new ZipCode.
	 */
	public void editZipCode(int x) {
		zipCode = x;
	}
	/**
	 * This is the default constructor of Address class.
	 * It sets each private attributes to either 0 or ""
	 */
	public Address()
	{
		city = "";
		street = "";
		state = "";
		zipCode = 0;
		// System.out.println("Constructor for address.\n");
	}
	
	/**
	 * This is overridden toString() method.
	 * This method returns attributes of the Address class in string format.
	 * @return String This is the string this method returns.
	 */
	@Override
	public String toString() {
		return String.format("City     : " + city + "\nState    : " + state 
				+ "\nStreet   : " + street + "\nZip Code : " + zipCode);
	}
	
	/**
	 * This method compares the Address object (one that calls this methods)
	 * with the Address object (parameter for the method). If they are same,
	 * this method returns true, else it returns false.
	 * @param addr This is the Address object that is compared with the calling 
	 * Address object.
	 * @return boolean This returns true if the addresses are same, else false.
	 */
	public boolean equals(Address addr) {
			if (this.city.equals(addr.city)) {
				if (this.street.equals(addr.street)) {
					if (this.state.equals(addr.state)) {
						if (this.zipCode == addr.zipCode) {
							return true;
						}
					}
				}
			}
			return false;
	}
}
