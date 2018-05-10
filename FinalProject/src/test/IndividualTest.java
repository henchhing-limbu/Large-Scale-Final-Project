package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import JavaProject.Address;
import JavaProject.Individual;

public class IndividualTest {

	@Test
	public void canEditPhoneNum() {
		Individual person = new Individual();
		person.setPhoneNum("202-849-1017");
		Assert.assertEquals("202-849-1017", person.getPhoneNum());
	}
	
	@Test
	public void canEditAddress() {
		Individual person = new Individual();
		Address addr = new Address();
		addr.editStreet("2205 4th St NW");
		addr.editCity("Washington");
		addr.editState("DC");
		addr.editZipCode(20059);
		person.editAddr(addr);
		
		Assert.assertEquals("2205 4th St NW", person.getAddr().getStreet());
		Assert.assertEquals("Washington", person.getAddr().getCity());
		Assert.assertEquals("DC", person.getAddr().getState());
		Assert.assertEquals(20059, person.getAddr().getZipCode());
	}

}
