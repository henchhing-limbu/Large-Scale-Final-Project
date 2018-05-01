package JavaProject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AddressBook {
	List<Individual> entries = new ArrayList<Individual>();
	/*
	void create() {
		Individual person = new Individual();
		entries.add(person);
	}
	*/
	// adding a new individual to the address book
	public void insert(Individual person) {
		Iterator<Individual> iter = entries.iterator();
		while (iter.hasNext()) {
			Individual x = iter.next();
			if (x.fName.equals(person.fName)) {
				if (x.lName.equals(person.lName)) {
					System.out.println("Individual already exists in the book.\n");
					return;
				}
			}
		}
		entries.add(person);
	}
	// deleting an individual from the address book
	public void delete(Individual person) {
		Iterator<Individual> iter = entries.iterator();
		while (iter.hasNext()) {
			Individual x = iter.next();
			if (x.fName.equals(person.fName)) {
				if (x.lName.equals(person.lName)) {
					iter.remove();
				}
			}
		}
	}
	// get entry
	// TODO: Fix me
	public Individual get(String fName, String lName) {
		Individual person = new Individual();
		for (Individual x: entries) {
			if (x.fName.equals(fName)) {
				if (x.lName.equals(lName)) {
					person.fName = fName;
					person.lName = lName;
					person.editAddr(x.addr);
					person.phoneNum = x.phoneNum;
					return person;
				}
			}
		}
		return null;
	}
	// edits entry
	// TODO: Fix me
	public void edit() {
		
	}

	// sort by name
	public void sortName() {
		System.out.println("Entered sort.\n");
		Collections.sort(entries);;
	}
	// sort by zip code
	public void sortCode() {
		
	}
}
