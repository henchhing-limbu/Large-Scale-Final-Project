package JavaProject;
import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;

/**
 * This class has a List that holds the Individual objects.
 * This class has methods insert(), delete(Individual), edit(), sortName(), sortCode().
 * @author henchhing.limbu
 *
 */
public class AddressBook implements Serializable{
	private List<Individual> entries = new ArrayList<Individual>();
	/**
	 *  This method adds a new individual object to the address book list
	 *  If individual already exists in the book, won't add object to the book
	 *  @param person This is the parameter to the method.
	 */
	public void insert() {
		Scanner scanner = new Scanner(System.in);
		Individual person = new Individual();
		System.out.println("First name of the person: ");
		person.setfName(scanner.nextLine());
		System.out.println("Last name of the person: ");
		person.setlName(scanner.nextLine());
		System.out.println("Phone number of the person: ");
		person.setPhoneNum(scanner.nextLine());
		System.out.println("City name: ");
		person.getAddr().setCity(scanner.nextLine());
		System.out.println("State name: ");
		person.getAddr().setState(scanner.nextLine());
		System.out.println("Street name: ");
		person.getAddr().setStreet(scanner.nextLine());
		System.out.println("Zip Code: ");
		person.getAddr().setZipCode(scanner.nextInt());
		this.getEntries().add(person);
	}
	/**
	 * This method deletes an individual from the address book
	 * does nothing if the individual doesn't exist in the book
	 * @param person This is the parameter to the method.
	 */
	public boolean delete(Individual person) {
		for (Individual x : this.entries) {
			if (x.equals(person)) {
				entries.remove(x);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method edits the address book.
	 */
	public void edit() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("EDIT MENU OPTIONS.");
		System.out.println("1 ~ INSERT INDIVIDUAL");
		System.out.println("2 ~ SORT INDIVIDUALS BY NAME");
		System.out.println("3 ~ SORT INDIVIDUALS BY ZIP CODE");
		System.out.println("4 ~ EDIT AN INDIVIDUAL ENTRY");
		System.out.println("5 ~ DELETE AN INDIVIDUAL ENTRY");
		System.out.println("6 ~ DISPLAY ENTRIES");
		int userInput = scanner.nextInt();
		scanner.nextLine();
		try {
			switch (userInput) {
				case 1:
					this.insert();
					break;
				case 2:
					this.sortName();
					System.out.println("Sorted by name.");
					break;
				case 3:
					this.sortCode();
					System.out.println("Sorted by zip code.");
					break;
				case 4:
					this.editPerson();
					break;
				case 5:
					System.out.println("INDIVIDUAL'S INFORMATION: ");
					Individual person = new Individual();
					System.out.println("First name: ");
					person.setfName(scanner.nextLine());
					System.out.println("Last name: ");
					person.setlName(scanner.nextLine());
					System.out.println("Phone number: ");
					person.setPhoneNum(scanner.nextLine());
					if (this.delete(person))
						System.out.println("Entry deleted.");
					else
						System.out.println("Entry not found.");
					break;
				case 6:
					System.out.println(this);
					break;
				default:
					System.out.println("Inocrrect input. Please provide a number from 1-6 based on what you need!");
					break;
			}
		} catch(IllegalArgumentException message) {
				System.out.println(message);
		}
	}
	/**
	 * This method edits an Individual object of the address book.
	 */
	private void editPerson( ) {
		Scanner read = new Scanner(System.in);
		System.out.println("Information about the person you want to edit");
		System.out.println("First name: ");
		String fName = read.nextLine();
		System.out.println("Last name: ");
		String lName = read.nextLine();
		System.out.println("Phone number: ");
		String phoneNum = read.nextLine();
		Iterator<Individual> iter = getEntries().iterator();
		while (iter.hasNext()) {
			Individual x = iter.next();
			if (x.getfName().equals(fName)) {
				if (x.getlName().equals(lName)) {
					if (x.getPhoneNum().equals(phoneNum)) {
						System.out.println("Found the individual.\n");
						editHelper(x);
					}
				}
				else {
					System.out.println(fName + " " + lName + " Individual does not exist in the address book.");
				}
			}
		}
	}
	
	/**
	 * This is the helper method for the edit method.
	 * depending on the user input, edits the attributes of the individual.
	 * won't let the user edit first name and last name.
	 * @param x This is the parameter of the method.
	 */
	private void editHelper(Individual x) {
		Scanner read = new Scanner(System.in);
		System.out.println("What do you want to edit?");
		System.out.println("1 ~ PHONE NUMBER");
		System.out.println("2 ~ ADDRESS");
		int userInput = read.nextInt();
		read.nextLine();
		try {
			switch (userInput) {
				case 1:
					System.out.println("Can you pass the new phone number?");
					String phoneNum = read.nextLine();
					x.setPhoneNum(phoneNum);
					break;
				case 2:
					editAddress(x);
					break;
				default:
					System.out.println("Invalid input. Please provide correct input.");
					editHelper(x);
					break;
			}
		}catch (InputMismatchException e) {
			System.out.println(e);
			
		}
	}
	
	/**
	 * This is a helper method to edit the address
	 * prompts the user for correct input as long as he doesn't pass correct input
	 * @param x This is the parameter of the method.
	 */
	private void editAddress(Individual x) {
		Scanner read = new Scanner(System.in);
		System.out.println("What part of address you want to change?");
		System.out.println("1 ~ CITY");
		System.out.println("2 ~ STREET");
		System.out.println("3 ~ STATE");
		System.out.println("4 ~ ZIP CODE");
		try {
			int editAddrPart = read.nextInt();
			read.nextLine();
			switch (editAddrPart) {
				case 1:
					System.out.println("Please pass in the new City name:");
					// String city = read.nextLine();
					// read.nextLine();
					// System.out.println(x.getAddr().getCity());
					x.getAddr().editCity(read.nextLine());
					break;
				case 2:
					System.out.println("Please pass in the new street name?\n");
					String street = read.nextLine();
					x.getAddr().editStreet(street);
					break;
				case 3:
					System.out.println("Please pass in the new state name?\n");
					String state = read.nextLine();
					x.getAddr().editState(state);
					break;
				case 4:
					System.out.println("Please pass in the new zip code?\n");
					int zipCode = read.nextInt();
					read.nextLine();
					x.getAddr().editZipCode(zipCode);
					break;
				default:
					System.out.println("Invalid response. Please provide a valide response.\n");
					editAddress(x);
					break;
			}
		}catch(InputMismatchException e) {
			System.out.println(e);
		}
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
	 * This method sorts Individual objects based on their zip codes
	 * calls Collections.sort(Indivual obj, Comparator<Individual> com) to sort the entires of the book
	 */
	public void sortCode() {
		Collections.sort(this.entries, new SortByCode());
	}
	
	/**
	 * This method overrides toString() method and returns the address book information in mailing label format.
	 */
	@Override
	public String toString() {
		String mailLabel = "";
		for (Individual x: getEntries()) {
			mailLabel += x.getfName() + " " + x.getlName() + "\n" + x.getAddr().getStreet() +
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
	
	/**
	 * This is the class that implements comparator.
	 * @author henchhing.limbu
	 *
	 */
	class SortByCode implements Comparator<Individual> {
		
		/**
		 * This method compares two Individual objects based on their zip code
		 * if same zip code, objects are compared based on their last names
		 * if same last name, objects are compared based on their first names
		 * @param person1 This is the first individual passed as parameter to the method.
		 * @param person2 This is the second individual passed as parameter to the method.
		 * @return int This is the returned int value by the method.
		 */
		@Override
		public int compare(Individual person1, Individual person2) {
			// TODO Auto-generated method stub
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
				if (person1.getAddr().getZipCode() < person2.getAddr().getZipCode()) {
					return -1; 
				}
					else return 1;
			}
		}
		
	}
}
