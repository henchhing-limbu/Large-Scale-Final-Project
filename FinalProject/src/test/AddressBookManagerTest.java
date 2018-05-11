package test;

import java.io.File;

import org.junit.jupiter.api.Test;

import JavaProject.AddressBookManager;
import JavaProject.Individual;
import junit.framework.Assert;

public class AddressBookManagerTest {
	String input = "Address Book 1";
	String input2 = "Address Book 2";
	@Test
	public void canCreateAddrBook() {
		AddressBookManager addrBookMngr = new AddressBookManager();
		addrBookMngr.create(input);
		Assert.assertEquals(false, addrBookMngr.getAddrBook().equals(null));
	}
	
	@Test
	public void canSaveAndSaveAsAddrBook() {
		AddressBookManager addrBookMngr = new AddressBookManager();
		addrBookMngr.create(input);
		addrBookMngr.save(input);
		boolean found = false;
		File dir = new File(".");
		File[] dir_contents = dir.listFiles();
		for (File file: dir_contents) {
			if (file.getName().equals(input)) 
				System.out.println(file.getName());
				found = true;
		}
		Assert.assertEquals(true, found);
		addrBookMngr.saveAs(input2);
		boolean found1 = false;
		File dir1 = new File(".");
		File[] dir_contents1 = dir.listFiles();
		for (File file: dir_contents1) {
			if (file.getName().equals(input)) 
				System.out.println(file.getName());
				found1 = true;
		}
		Assert.assertEquals(true, found1);
	}

	@Test
	public void canOpenAddrBook() {
		AddressBookManager addrBookMngr = new AddressBookManager();
		addrBookMngr.create(input);
		addrBookMngr.getAddrBook().getEntries().add(new Individual());
		addrBookMngr.save(input);
		addrBookMngr.open(input);
		Assert.assertEquals(1, addrBookMngr.getAddrBook().getEntries().size());
	}
	
	@Test
	public void canCloseAddrBook() {
		AddressBookManager addrBookMngr = new AddressBookManager();
		addrBookMngr.open(input);
		addrBookMngr.close(input);
		Assert.assertEquals(true, addrBookMngr.getAddrBook() == null);
	}
}
