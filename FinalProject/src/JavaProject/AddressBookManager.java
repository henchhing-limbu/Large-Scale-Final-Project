package JavaProject;

import java.util.Scanner;
import java.util.HashMap;

public class AddressBookManager {
	Scanner read = new Scanner(System.in);
	HashMap<String, AddressBook> map = new HashMap<>();
	/*
	 * creates a new address book
	 * promts the user for address book name 
	 * address book name is mapped to the address book
	 */
	public void newAddrBook() {
		System.out.println("Address book name: ");
		String name = read.nextLine();
		map.put(name, new AddressBook());
	}
	
}

