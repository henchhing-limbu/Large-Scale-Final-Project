package JavaProject;

// import java.util.Collections;

public class MainFunction {
	public static void main(String[] args) {
		// check for address
		Address addr = new Address();
		addr.city = "Washington";
		addr.streetNum = 1923;
		addr.street = "North Capitol St NW";
		addr.state = "DC";
		addr.zipCode = 20059;
		// System.out.println(addr);
		
		// check for Individual
		Individual person = new Individual();
		// Address personAddr = new Address();
		person.fName = "Henchhing";
		person.lName = "Limbu";
		person.phoneNum = "202-849-1017";
		person.editAddr(addr);
		// System.out.println(person);
		
		// check for AddressBook
		AddressBook addrBook = new AddressBook();
		addrBook.insert(person);
		addrBook.insert(person);
		System.out.println(addrBook);
		
		// checking delete of AddressBook
		Individual person2 = new Individual();
		person2.fName = "Bijesh";
		person2.lName = "Singh";
		person2.addr.zipCode = 20060;
		addrBook.insert(person2);
		// addrBook.delete(person);
		// System.out.println(addrBook.entries.size());
		Individual person3 = new Individual();
		person3.fName = "Akash";
		person3.lName = "Singh";
		person3.addr.zipCode = 20054;
		addrBook.insert(person3);
		
		// addrBook.insert(person);
		addrBook.sortName();
		System.out.println(addrBook.entries.size());
		System.out.println((addrBook.entries.get(1).fName));
		
		addrBook.sortCode();
		System.out.println(addrBook.entries.size());
		System.out.println((addrBook.entries.get(0).fName));
		addrBook.edit();
		
	}
}
