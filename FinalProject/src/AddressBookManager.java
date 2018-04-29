import java.util.*;
public class AddressBookManager {
	public static void main(String[] args) {
		System.out.println("Let's get started.\n");
		Individual person = new Individual();
		person.fName = "Henchhing";
		person.lName = "Limbu";
		System.out.println(person.fName + " " + person.lName);
	}
}
	class AddressBook {
		// address book holds collection of entries
		// entries are individuals
		// needs to add a new person to the address book
		// edit existing information about person (except person's name)
		// sort entries in the addr book by last name or by zip code
		// print out all entries in the address book in mailing label format
		
		// using hashset as collection for all these entries
		HashSet<Address> entries = new HashSet<Address>();
		
		// methods
		// inserts entry
		public void insert(Individual person) {
			
		}
		// deletes entry
		public void delete(Individual person) {
			
		}
		// get entry
		Individual get(String fName, String lName) {
			
			return null;
		}
	}
	
	class Address {
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
	}
	
	class Individual {
		String fName;
		String lName;
		Address addr;
		int phoneNum;
		
		// editing methods
		public void editFName(String name) {
			fName = name;
		}
		public void editLName(String name) {
			lName = name;
		}
		// TODO: Fixe me
		public void editAddr(Address address) {
			addr = address;
		}
		public void editPhoneNum(int num) {
			phoneNum = num;
		}
		// constructor
		Individual()
		{
			fName = "";
			lName = "";
			phoneNum = 0;
			System.out.println("Constructor of Individual.\n");
		}
	}

