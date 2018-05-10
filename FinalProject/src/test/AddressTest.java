package test;

import org.junit.Test;

import JavaProject.Address;

import org.junit.Assert;

public class AddressTest {

	@Test
	public void canEditStreet() {
		Address address = new Address();

		address.editStreet("2205 4th Street NW");

		Assert.assertEquals("2205 4th Street NW", address.getStreet());
	}

	@Test
	public void canEditCity() {
		Address address = new Address();

		address.editCity("Washington");

		Assert.assertEquals("Washington", address.getCity());
	}

	@Test
	public void canEditState() {
		Address address = new Address();

		address.editState("DC");

		Assert.assertEquals("DC", address.getState());
	}

	@Test
	public void canEditZipCode() {
		Address address = new Address();

		address.editZipCode(20059);

		Assert.assertEquals(20059, address.getZipCode());
	}
}
