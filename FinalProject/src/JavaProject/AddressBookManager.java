package JavaProject;

import java.util.Scanner;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AddressBookManager {
	Scanner read = new Scanner(System.in);
	private AddressBook addrBook;
	private String bookName;
	
	/**
	 * This method is the getter method for Address book.
	 * @return AddressBook This is the returned address book.
	 */
	public AddressBook getAddrBook() {
		return addrBook;
	}

	/**
	 * This method is the setter method of the Address book.
	 * @param addrBook This is the parameter to the method.
	 */
	public void setAddrBook(AddressBook addrBook) {
		this.addrBook = addrBook;
	}
	
	/**
	 * This method allows user to interact with the program.
	 */
	public void menuOption() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\tADDRESS BOOK MANAGER\t\n");
		System.out.println("Menu Options: ");
		System.out.println("1 ~ NEW");
		System.out.println("2 ~ OPEN");
		System.out.println("3 ~ SAVE");
		System.out.println("4 ~ SAVE AS");
		System.out.println("5 ~ CLOSE");
		System.out.println("6 ~ EDIT");
		System.out.println("7 ~ QUIT");
		int userInput = read.nextInt();
		switch (userInput) {
			case 1:
				this.create();
				break;
			case 2:
				System.out.println("Name of the file you want to open.\n");
				String fileName = scanner.nextLine();
				this.open(fileName);
				break;
			case 3:
				this.save();
				break;
			case 4:
				this.saveAs();
				break;
			case 5:
				this.close();
				break;
			case 6:
				this.edit();
				break;
			case 7:
				this.quit();
				break;
		}
		scanner.close();
	}
	/**
	 * Creates a new address book
	 * Prompts the user for address bookName
	 * This bookName is used as default file name to save
	 */
	public void create() {
		if (getAddrBook() != null) {
			System.out.println("Saving and closing the previous address book.");
			close();
		}
		System.out.println("Address book name: ");
		bookName = read.nextLine();
		System.out.println("Creating a new address book ...");
		setAddrBook(new AddressBook());
	}
	
	/**
	 * saves the state of the address book object in a file
	 * will use default bookName as the save file
	 */
	public void save() {
		try {
			ObjectOutputStream objectStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(bookName)));
			objectStream.writeObject(getAddrBook());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Saves the state of the AddressBook with a specified file name
	 * Prompts the user for the new name of the file to be saved
	 */
	public void saveAs() {
		System.out.println("Name of the file you want to save as: ");
		bookName = read.nextLine();
		try {
			ObjectOutputStream objectStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(bookName)));
			objectStream.writeObject(getAddrBook());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Opens the state of the AddressBook from a file
	 * @param bookName This is the name of the file that has state of the AddressBook
	 * @return AddressBook This returns the AddressBook with the saved state
	 */
	public AddressBook open(String bookName) {
		AddressBook addrBook = null;
		try {
			ObjectInputStream objectStream = new ObjectInputStream(Files.newInputStream(Paths.get(bookName)));
			addrBook = (AddressBook) objectStream.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addrBook;
	}
	
	/**
	 * This method edits the Individuals in an AddressBook.
	 * This method uses the edit method of the AddressBook.
	 */
	public void edit() {
		getAddrBook().edit();
	}
	
	/**
	 * Closes the AddressBook
	 * Saves the state of the object before closing the AddressBook
	 */
	public void close() {
		save();
		setAddrBook(null);
	}
	
	/**
	 * This method allows closing 
	 */
	public void quit() {
		close();
		System.out.println("Terminating the prgram.\n");
		System.exit(0);		
	}
	
	/**
	 * Constructor for the AddressBookManager class
	 */
	public AddressBookManager() {
		setAddrBook(null);
		bookName = null;
	}
}

 