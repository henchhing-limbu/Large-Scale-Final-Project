package JavaProject;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class AddressBook {
	List<Individual> entries = new ArrayList<Individual>();
	
	/*
	 *  Adds a new individual object to the address book list
	 *  If individual already exists in the book, won't add object to the book
	 */
	public void insert(Individual person) {
		Iterator<Individual> iter = entries.iterator();
		while (iter.hasNext()) {
			Individual x = iter.next();
			if (x.equals(person)) {
					System.out.println("Individual already exists in the book.\n");
					return;
			}
		}
		entries.add(person);
	}
	/*
	 * deletes an individual from the address book
	 * does nothing if the individual doesn't exist in the book
	 */
	public void delete(Individual person) {
		Iterator<Individual> iter = entries.iterator();
		while (iter.hasNext()) {
			Individual x = iter.next();
			if (x.equals(person)) {
					iter.remove();
					return;
			}
		}
	}
	// edits entry
	// TODO: Fix me
	public void edit() {
		Scanner read = new Scanner(System.in);
		System.out.println("Editing the Address Book.\n");
		System.out.println("First name of the person: ");
		String fName = read.nextLine();
		System.out.println("\nLast name of the person: ");
		String lName = read.nextLine();
		Iterator<Individual> iter = entries.iterator();
		while (iter.hasNext()) {
			Individual x = iter.next();
			if (x.fName.equals(fName)) {
				if (x.lName.equals(lName)) {
					System.out.println("Found the individual.\n");
					editHelper(x);
				}
				else {
					System.out.println(fName + " " + lName + " Individual does not exist in the address book.");
				}
			}
		}
		read.close();
	}
	
	/*
	 * helper function for the edit method
	 * depending on the user input, edits the attributes of the individual
	 * won't let the user edit first name and last name
	 */
	public void editHelper(Individual x) {
		Scanner read = new Scanner(System.in);
		System.out.println("What do you want to edit? \n");
		String userInput = read.nextLine();
		switch (userInput) {
			case "first name":
				System.out.println("You can't change first name.\n");
				System.out.println("Try again.\n");
				editHelper(x);
				break;
			case "last name":
				System.out.println("You can't change last name.\n");
				System.out.println("Try again.\n");
				editHelper(x);
				break;
			case "phone number":
				System.out.println("Can you pass the new phone number?\n");
				String phoneNum = read.nextLine();
				x.phoneNum = phoneNum;
				break;
			case "address":
				editAddress(x);
				break;
		}
		read.close();
	}
	
	/*
	 * a helper functions to edit the address
	 * prompts the user for correct input as long as he doesn't pass correct input
	 */
	public void editAddress(Individual x) {
		Scanner read = new Scanner(System.in);
		System.out.println("What part of address you want to change?\n");
		String editAddrPart = read.nextLine();
		switch (editAddrPart) {
			case "street number":
				System.out.println("Can you pass the new street number?\n");
				int streetNum = read.nextInt();
				x.addr.editStreetNum(streetNum);
				break;
			case "city":
				System.out.println("Can you pass the new city name?\n");
				String city = read.nextLine();
				x.addr.editCity(city);
				break;
			case "street":
				System.out.println("Can you pass the new street name?\n");
				String street = read.nextLine();
				x.addr.editStreet(street);
				break;
			case "state":
				System.out.println("Can you pass the new state name?\n");
				String state = read.nextLine();
				x.addr.editState(state);
				break;
			case "zip code":
				System.out.println("Can you pass the new street number?\n");
				int zipCode = read.nextInt();
				x.addr.editZipCode(zipCode);
				break;
			default:
				System.out.println("Your response didn't match to any of the cases.\n");
				System.out.println("The valid responses are:\nstreet number\ncity\nstreet\nstate\nzip code\n");
				editAddress(x);
				break;
		}
		read.close();
	}
	/*
	 *  sorts the entries in the book by last name of the individual
	 *  if same last name, first name is used to sort the entries
	 */
	public void sortName() {
		// System.out.println("Entered sort.\n");
		Collections.sort(entries);;
	}
	
	/*
	 * comparator class with comparing method
	 * compare method compares two Individual objects based on their zip code
	 * if same zip code, objects are compared based on their last names
	 * if same last name, objects are compared based on their first names
	 */
	Comparator<Individual> com = new Comparator<Individual>() {
		public int compare(Individual person1, Individual person2) {
			if (person1.addr.zipCode == person2.addr.zipCode) {
				if (person1.lName.toLowerCase().equals(person2.lName.toLowerCase())) {
					if (person1.fName.toLowerCase().equals(person2.fName.toLowerCase())) {
						return 0;
					}
					else
						return person1.fName.toLowerCase().compareTo(person2.fName.toLowerCase());
				}
				else
					return person1.lName.toLowerCase().compareTo(person2.lName.toLowerCase());
			}
			else {
				if (person1.addr.zipCode < person2.addr.zipCode) return -1; 
				else return 1;
			}
		}
	};
	/*
	 *  sorts Individual objects based on their zip codes
	 *  calls Collections.sort(Indivual obj, Comparator<Individual> com) to sort the entires of the book
	 */
	public void sortCode() {
		Collections.sort(entries, com);
	}
	@Override
	public String toString() {
		String mailLabel = null;
		for (Individual x: entries) {
			mailLabel += x.fName + " " + x.lName + "\n" + x.addr.streetNum + " " + x.addr.street +
					"\n" + x.addr.city + ", " + x.addr.state + ", " + x.addr.zipCode + "\n" +
					x.phoneNum + "\n\n";
		}
		return String.format(mailLabel);
	}
}
