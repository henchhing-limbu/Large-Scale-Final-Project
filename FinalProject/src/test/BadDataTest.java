package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import JavaProject.Address;
import JavaProject.AddressBook;
import JavaProject.AddressBookManager;
import JavaProject.Individual;

class BadDataTest {
	
	@Test 
	public void canDealWithBadDataAddress() {
		Address address = new Address();
		Assertions.assertThrows(ClassCastException.class, () -> address.equals(1));
	}
	
	@Test 
	public void canDealWithBadDataAddrBookMngr() {
		AddressBookManager addrBookMngr = new AddressBookManager();
		Assertions.assertThrows(ClassCastException.class, () -> addrBookMngr.create(1));
		Assertions.assertThrows(ClassCastException.class, () -> addrBookMngr.save(1));
		Assertions.assertThrows(ClassCastException.class, () -> addrBookMngr.open(3));
		Assertions.assertThrows(ClassCastException.class, () -> addrBookMngr.saveAs(5));
		Assertions.assertThrows(ClassCastException.class, () -> addrBookMngr.close(4365));
		Assertions.assertThrows(NullPointerException.class,  () ->addrBookMngr.save(null));
	}
	
	@Test
	public void canDealWithBadDataAddrBook() {
		AddressBook addrBook = new AddressBook();
		Assertions.assertThrows(NullPointerException.class, () -> addrBook.insert(null));
		Assertions.assertThrows(ClassCastException.class, () -> addrBook.insert(1));
		Assertions.assertThrows(ClassCastException.class, () -> addrBook.delete(945));
		Assertions.assertThrows(ClassCastException.class, () -> addrBook.delete("Happy Summer"));		
	}
	
	@Test
	public void canDealWithBadDataInd() {
		Individual person = new Individual();
		Assertions.assertThrows(ClassCastException.class, () -> person.editPhoneNum(9806064));
		Assertions.assertThrows(ClassCastException.class, () -> person.editAddr(6732));
		Assertions.assertThrows(ClassCastException.class, () -> person.editAddr("String"));
		Assertions.assertThrows(NullPointerException.class, () -> person.editAddr(null));
	}
}
