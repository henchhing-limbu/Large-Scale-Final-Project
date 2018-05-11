package JavaProject;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class has an AddressBook attribute.
 * This class has methods like menuOption(), create(), save(), saveAs(), open(String), edit(), close(), quit(). 
 * @author henchhing.limbu
 *
 */
public class AddressBookManager {
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
	public void menuOption() throws InputMismatchException{
		Scanner read = new Scanner(System.in);
		while(true) {
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
			read.nextLine();
			try {
				switch (userInput) {
					case 1:
						this.create("");
						break;
					case 2:
						System.out.println("Name of the file you want to open.");
						String filename = read.nextLine();
						this.open(filename);
						break;
					case 3:
						this.save("");
						break;
					case 4:
						this.saveAs("");
						break;
					case 5:
						this.close("");
						break;
					case 6:
						this.edit();
						break;
					case 7:
						this.quit();
						break;
					default:
						System.out.println("Invalid input. Please provide a valid input.");
						break;
				}
			}catch(InputMismatchException a) {
				throw a;
			}
		}
	}
	/**
	 * This method creates a new address book
	 * Prompts the user for address bookName
	 * This bookName is used as default file name to save
	 */
	public void create(Object obj) throws ClassCastException {
		String in = (String) obj;
		try {
			Scanner read;
			if (in.equals(""))
				read = new Scanner(System.in);
			else {
				ByteArrayInputStream x = new ByteArrayInputStream(in.getBytes());
				System.setIn(x);
				read = new Scanner(x);
			}
				
			if (getAddrBook() != null) {
				System.out.println("Saving and closing the previous address book.");
				close("");
			}
			System.out.println("Address book name: ");
			bookName = read.nextLine();
			System.out.println("Creating a new address book ...");
			setAddrBook(new AddressBook());
		}
		catch (Exception a){
			throw a;
		}
	}
	
	/**
	 * This method saves the state of the address book object in a file
	 * will use default bookName as the save file
	 */
	public void save(Object obj) throws ClassCastException{
		String in = (String) obj;
		try {
			Scanner scanner;
			if (in.equals(""))
				scanner = new Scanner(System.in);
			else {
				ByteArrayInputStream x = new ByteArrayInputStream(in.getBytes());
				System.setIn(x);
				scanner = new Scanner(x);
			}
			try {
				if (bookName == null) {
					System.out.println("Save as: ");
					bookName = scanner.nextLine();
				}
				System.out.println("Saving the address book.");
				ObjectOutputStream objectStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(bookName)));
				objectStream.writeObject(getAddrBook());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (Exception a) {
			throw a;
		}
	}
	
	/**
	 * Saves the state of the AddressBook with a specified file name
	 * Prompts the user for the new name of the file to be saved
	 */
	public void saveAs(Object obj) throws ClassCastException{
		String in = (String) obj;
		try {
			Scanner scanner;
			if (in.equals(""))
				scanner = new Scanner(System.in);
			else {
				ByteArrayInputStream x = new ByteArrayInputStream(in.getBytes());
				System.setIn(x);
				scanner = new Scanner(x);
			}
			System.out.println("Save as: ");
			bookName = scanner.nextLine();
			try {
				System.out.println("Saving the address book as " + bookName);
				ObjectOutputStream objectStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(bookName)));
				objectStream.writeObject(getAddrBook());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (Exception a) {
			throw a;
		}
	}
	
	/**
	 * This method opens the state of the AddressBook from a file
	 * @param bookName This is the name of the file that has state of the AddressBook
	 */
	public void open(Object obj) throws ClassCastException {
		String bookName = (String) obj;
		try {
			if (!fileFound(bookName)) {
				System.out.println("Couldn't find " + bookName);
				return;
			}
			try {
				ObjectInputStream objectStream = new ObjectInputStream(Files.newInputStream(Paths.get(bookName)));
				this.setAddrBook((AddressBook) objectStream.readObject());
				System.out.println("Opened the file.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (Exception a) {
			throw a;
		}
	}
	
	
	/**
	 * This method checks if the file is in the directory or not.
	 * @param bookName This is the parameter to the method. 
	 * @return boolean This is the returned boolean from the method.
	 */
	private boolean fileFound(String bookName) {
		File dir = new File(".");
		File[] dir_contents = dir.listFiles();
		for (File file: dir_contents) {
			if (file.getName().equals(bookName)) 
				return true;
		}
		return false;
	}
	/**
	 * This method edits the Individuals in an AddressBook.
	 * This method uses the edit method of the AddressBook.
	 */
	public void edit() {
		if (this.getAddrBook() == null) {
			System.out.println("There is no address book to work on.");
			return;
		}
		getAddrBook().edit();
	}
	
	/**
	 * Closes the AddressBook
	 * Saves the state of the object before closing the AddressBook
	 */
	public void close(Object obj) throws ClassCastException{
		String in = (String) obj;
		try {
			save(in);
			this.setAddrBook(null);
		}
		catch (Exception a) {
			throw a;
		}
	}
	
	/**
	 * This method allows closing 
	 */
	public void quit() {
		if (this.getAddrBook() != null) 
			close("");
		System.out.println("Terminating the program.\n");
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

 