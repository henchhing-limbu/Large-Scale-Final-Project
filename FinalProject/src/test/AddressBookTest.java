package test;

import org.junit.jupiter.api.Test;

import JavaProject.AddressBook;
import JavaProject.Individual;
import junit.framework.Assert;

public class AddressBookTest {
	@Test
	public void canAddIndividual() {
		
	}
	
	@Test
	public void canDeleteIndividual() {
		AddressBook addrBook = new AddressBook();
		Individual person = new Individual();
		addrBook.getEntries().add(person);
		Assert.assertEquals(1, addrBook.getEntries().size());
		addrBook.delete(person);
		Assert.assertEquals(0, addrBook.getEntries().size());
	}
	
	@Test
	public void canSortByName() {
		AddressBook addrBook = new AddressBook();
		Individual person1 = new Individual();
		person1.setfName("Henchhing");
		person1.setlName("Limbu");
		Individual person4 = new Individual();
		person4.setfName("Kishor");
		person4.setlName("Subedi");
		Individual person2 = new Individual();
		person2.setfName("Bijesh");
		person2.setlName("Subedi");
		Individual person3 = new Individual();
		person3.setfName("Sushan");
		person3.setlName("Dhakal");
		addrBook.getEntries().add(person1);
		addrBook.getEntries().add(person4);
		addrBook.getEntries().add(person2);
		addrBook.getEntries().add(person3);
		
		addrBook.sortName();
		
		Assert.assertEquals(person3, addrBook.getEntries().get(0));
		Assert.assertEquals(person1, addrBook.getEntries().get(1));
		Assert.assertEquals(person2, addrBook.getEntries().get(2));
		Assert.assertEquals(person4, addrBook.getEntries().get(3));

	}
	
	@Test
	public void canSortByZipCode() {
		AddressBook addrBook = new AddressBook();
		Individual person1 = new Individual();
		person1.setfName("Henchhing");
		person1.setlName("Limbu");
		person1.getAddr().setZipCode(20059);
		Individual person4 = new Individual();
		person4.setfName("Kishor");
		person4.setlName("Subedi");
		person4.getAddr().setZipCode(12345);
		Individual person2 = new Individual();
		person2.setfName("Bijesh");
		person2.setlName("Subedi");
		person2.getAddr().setZipCode(12345);
		Individual person3 = new Individual();
		person3.setfName("Sushan");
		person3.setlName("Dhakal");
		person3.getAddr().setZipCode(20060);
		addrBook.getEntries().add(person1);
		addrBook.getEntries().add(person4);
		addrBook.getEntries().add(person2);
		addrBook.getEntries().add(person3);
		
		addrBook.sortCode();
		
		Assert.assertEquals(person2, addrBook.getEntries().get(0));
		Assert.assertEquals(person4, addrBook.getEntries().get(1));
		Assert.assertEquals(person1, addrBook.getEntries().get(2));
		Assert.assertEquals(person3, addrBook.getEntries().get(3));
	}
	
	String in = "Henchhing" + System.getProperty("line.separator") + "Limbu" + System.getProperty("line.separator")
				+ "202-849-1017" + System.getProperty("line.separator") + "2205 4th St NW" +
				System.getProperty("line.separator") + 20059 + System.getProperty("line.separator") +
				"Washington" + System.getProperty("line.separator") + "DC" + System.getProperty("line.separator");
	@Test
	public void canInsertPerson() {
		AddressBook addrBook = new AddressBook();
		addrBook.insert(in);
		Assert.assertEquals("Henchhing", addrBook.getEntries().get(0).getfName());
		Assert.assertEquals("Limbu", addrBook.getEntries().get(0).getlName());
		Assert.assertEquals("202-849-1017", addrBook.getEntries().get(0).getPhoneNum());
		Assert.assertEquals("2205 4th St NW", addrBook.getEntries().get(0).getAddr().getStreet());
		Assert.assertEquals(20059, addrBook.getEntries().get(0).getAddr().getZipCode());
		Assert.assertEquals("Washington", addrBook.getEntries().get(0).getAddr().getCity());
		Assert.assertEquals("DC", addrBook.getEntries().get(0).getAddr().getState());
	}
}
