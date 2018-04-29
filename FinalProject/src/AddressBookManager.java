import java.util.*;
public class AddressBookManager {
	public static void main(String[] args) {
		System.out.println("Let's get started.\n");
		BookManager bookManager = new BookManager();
		AddressBook addrBook = new AddressBook();
		Individual person = new Individual();
		bookManager.createBook(addrBook);
		
		person.fName = "Henchhing";
		person.lName = "Limbu";
		// System.out.println(addr.streetNum);
		System.out.println(person.addr.streetNum + person.fName + " " + person.lName + "\n");
		person.editFName("Shradha");
		person.addr.streetNum = 1923;
		System.out.println(person.addr.streetNum + person.fName + " " + person.lName + "\n");
		
		// ArrayList<AddressBook> addressBook = new ArrayList<AddressBook>();	
	}
}
class BookManager {
	// array list to store address books
	ArrayList<AddressBook> addressBookManager = new ArrayList<AddressBook>();
	// book manager methods
	public void createBook(AddressBook person) {
		addressBookManager.add(person);
	}
	public void openBook(AddressBook book) {
		
	}
	public void closeBook(AddressBook book) {
		
	}
	public void saveBook(AddressBook book) {
		
	}
}

class AddressBook {
	// using array list as collection for all these entries
	ArrayList<Individual> entries = new ArrayList<Individual>();
	// inserts entry
	void insert(Individual person) {
		entries.add(person);
	}
	// deletes entry
	// TODO: Fix me
	/*
	void delete(Individual person) {
		Iterator iter = entries.iterator();
		while (iter.hasNext()) {
			Individual x = new Individual();
		}
	}
	*/
	// get entry
	// TODO: Fix me
	Individual get(String fName, String lName) {
		
		return null;
	}
	// edits entry
	// TODO: Fix me
	void edit() {
		
	}
	// sort by name
	// TODO: Fix me
	void sortName() {
		
	}
	// sort by zip code
	// TODO: Fix me
	void sortCode() {
		
	}
	// boolean equalsTo(ArrayList )
}
	
class Individual {
	String fName;
	String lName;
	Address addr;
	int phoneNum;
	
	// editing methods
	void editFName(String name) {
		fName = name;
	}
	void editLName(String name) {
		lName = name;
	}
	// TODO: Fixe me
	void editAddr(Address address) {
		addr.equals(address);
	}
	void editPhoneNum(int num) {
		phoneNum = num;
	}
	
	void equals(Address address) {
		this.addr.city = address.city;
		this.addr.state = address.state;
		this.addr.street = address.street;
		this.addr.streetNum = address.streetNum;
		this.addr.zipCode = address.zipCode;
	}
	// constructor
	Individual()
	{
		fName = "";
		lName = "";
		phoneNum = 0;
		addr = new Address();
		System.out.println("Constructor of Individual.\n");
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
