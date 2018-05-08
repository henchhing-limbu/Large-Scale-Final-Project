package JavaProject;
import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class AddressBook implements Serializable{
	private List<Individual> entries = new ArrayList<Individual>();
	/**
	 *  This method adds a new individual object to the address book list
	 *  If individual already exists in the book, won't add object to the book
	 *  @param person This is the parameter to the method.
	 */
	public void insert(Individual person) {
		Iterator<Individual> iter = getEntries().iterator();
		while (iter.hasNext()) {
			Individual x = iter.next();
			if (x.equals(person)) {
					System.out.println("Individual already exists in the book.\n");
					return;
			}
		}
		getEntries().add(person);
	}
	/**
	 * This method deletes an individual from the address book
	 * does nothing if the individual doesn't exist in the book
	 * @param person This is the parameter to the method.
	 */
	public void delete(Individual person) {
		Iterator<Individual> iter = getEntries().iterator();
		while (iter.hasNext()) {
			Individual x = iter.next();
			if (x.equals(person)) {
					iter.remove();
					return;
			}
		}
	}
	
	/**
	 * This method edits the address book
	 */
	public void edit() {
		Scanner read = new Scanner(System.in);
		System.out.println("Editing the Address Book.\n");
		System.out.println("First name of the person: ");
		String fName = read.nextLine();
		System.out.println("\nLast name of the person: ");
		String lName = read.nextLine();
		Iterator<Individual> iter = getEntries().iterator();
		while (iter.hasNext()) {
			Individual x = iter.next();
			if (x.getfName().equals(fName)) {
				if (x.getlName().equals(lName)) {
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
	
	/**
	 * This is the helper method for the edit method.
	 * depending on the user input, edits the attributes of the individual.
	 * won't let the user edit first name and last name.
	 * @param x This is the parameter of the method.
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
				x.setPhoneNum(phoneNum);
				break;
			case "address":
				editAddress(x);
				break;
		}
		read.close();
	}
	
	/**
	 * This is a helper method to edit the address
	 * prompts the user for correct input as long as he doesn't pass correct input
	 * @param x This is the parameter of the method.
	 */
	public void editAddress(Individual x) {
		Scanner read = new Scanner(System.in);
		System.out.println("What part of address you want to change?\n");
		String editAddrPart = read.nextLine();
		switch (editAddrPart) {
			case "street number":
				System.out.println("Can you pass the new street number?\n");
				int streetNum = read.nextInt();
				x.getAddr().editStreetNum(streetNum);
				break;
			case "city":
				System.out.println("Can you pass the new city name?\n");
				String city = read.nextLine();
				x.getAddr().editCity(city);
				break;
			case "street":
				System.out.println("Can you pass the new street name?\n");
				String street = read.nextLine();
				x.getAddr().editStreet(street);
				break;
			case "state":
				System.out.println("Can you pass the new state name?\n");
				String state = read.nextLine();
				x.getAddr().editState(state);
				break;
			case "zip code":
				System.out.println("Can you pass the new street number?\n");
				int zipCode = read.nextInt();
				x.getAddr().editZipCode(zipCode);
				break;
			default:
				System.out.println("Your response didn't match to any of the cases.\n");
				System.out.println("The valid responses are:\nstreet number\ncity\nstreet\nstate\nzip code\n");
				editAddress(x);
				break;
		}
		read.close();
	}
	/**
	 *  This method sorts the entries in the book by last name of the individual
	 *  if same last name, first name is used to sort the entries
	 */
	public void sortName() {
		// System.out.println("Entered sort.\n");
		Collections.sort(getEntries());;
	}
	
	/**
	 * comparator class
	 */
	transient Comparator<Individual> com = new Comparator<Individual>() {
		/**
		 * This method compares two Individual objects based on their zip code
		 * if same zip code, objects are compared based on their last names
		 * if same last name, objects are compared based on their first names
		 * @param person1 This is the first individual passed as parameter to the method.
		 * @param person2 This is the second individual passed as parameter to the method.
		 * @return int This is the returned int value by the method.
		 */

		public int compare(Individual person1, Individual person2) {
			if (person1.getAddr().getZipCode() == person2.getAddr().getZipCode()) {
				if (person1.getlName().toLowerCase().equals(person2.getlName().toLowerCase())) {
					if (person1.getfName().toLowerCase().equals(person2.getfName().toLowerCase())) {
						return 0;
					}
					else
						return person1.getfName().toLowerCase().compareTo(person2.getfName().toLowerCase());
				}
				else
					return person1.getlName().toLowerCase().compareTo(person2.getlName().toLowerCase());
			}
			else {
				if (person1.getAddr().getZipCode() < person2.getAddr().getZipCode()) return -1; 
				else return 1;
			}
		}
	};
	/**
	 * This method sorts Individual objects based on their zip codes
	 * calls Collections.sort(Indivual obj, Comparator<Individual> com) to sort the entires of the book
	 */
	public void sortCode() {
		Collections.sort(getEntries(), com);
	}
	
	/**
	 * This method overrides toString() method and returns the address book information in mailing label format.
	 */
	@Override
	public String toString() {
		String mailLabel = null;
		for (Individual x: getEntries()) {
			mailLabel += x.getfName() + " " + x.getlName() + "\n" + x.getAddr().getStreetNum() + " " + x.getAddr().getStreet() +
					"\n" + x.getAddr().getCity() + ", " + x.getAddr().getState() + ", " + x.getAddr().getZipCode() + "\n" +
					x.getPhoneNum() + "\n\n";
		}
		return String.format(mailLabel);
	}
	/**
	 * This is the get method of entries.
	 * @return List<Individual> This is the returned list of individuals.
	 */
	public List<Individual> getEntries() {
		return entries;
	}
}
