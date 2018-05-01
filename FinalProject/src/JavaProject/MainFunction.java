package JavaProject;

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
		Address personAddr = new Address();
		person.fName = "Henchhing";
		person.lName = "Limbu";
		person.phoneNum = "202-849-1017";
		person.editAddr(addr);
		System.out.println(person);
	}
}
