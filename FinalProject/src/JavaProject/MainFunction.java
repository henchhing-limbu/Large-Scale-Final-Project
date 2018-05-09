package JavaProject;

// import java.util.Collections;

public class MainFunction {
	public static void main(String[] args) {
		// check for address
		Address addr = new Address();
		addr.setCity("Washington");
		addr.setStreet("1923 North Capitol St NW");
		addr.setState("DC");
		addr.setZipCode(20059);
		addr.editCity("Kathmandu");
		// System.out.println(addr);
		
		// check for Individual
		Individual person = new Individual();
		// Address personAddr = new Address();
		person.setfName("Henchhing");
		person.setlName("Limbu");
		person.setPhoneNum("202-849-1017");
		person.editAddr(addr);
		// System.out.println(person);
		
		/*
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
		System.out.println(addrBook);
		
		// addrBook.insert(person);
		addrBook.sortName();
		System.out.println(addrBook.entries.size());
		System.out.println((addrBook.entries.get(1).fName));
		
		addrBook.sortCode();
		System.out.println(addrBook.entries.size());
		System.out.println((addrBook.entries.get(0).fName));
		addrBook.edit();
		System.out.println(person.phoneNum);
		System.out.println(person.addr.streetNum);
		*/
		AddressBookManager addrbookmng = new AddressBookManager();
		addrbookmng.menuOption();
		// addrbookmng.create();
		// addrbookmng.getAddrBook().insert(person);
		// System.out.println(addrbookmng.bookName);
		// addrbookmng.addrBook = addrbookmng.open("henchhing");
		// System.out.println(addrbookmng.getAddrBook().getEntries().get(0).getAddr().getCity());
		// addrbookmng.quit();
		// Address newAddr = new Address();
		// newAddr.setCity("Dallas");
		// addrbookmng.getAddrBook().getEntries().get(0).editAddr(newAddr);
		// System.out.println(addrbookmng.getAddrBook().getEntries().get(0).getAddr().getCity());
		// addrbookmng.saveAs();
		// addrbookmng.save();		
	}
}
