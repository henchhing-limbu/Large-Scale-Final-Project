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
}
