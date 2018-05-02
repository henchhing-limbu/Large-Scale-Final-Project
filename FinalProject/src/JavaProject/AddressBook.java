package JavaProject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		// System.out.println("Entered sort.\n");
		Collections.sort(entries);;
	}
	
	Comparator<Individual> com = new Comparator<Individual>() {
		public int compare(Individual person1, Individual person2) {
			if (person1.addr.zipCode == person2.addr.zipCode) {
				if (person1.lName.equals(person2.lName)) {
					if (person1.fName.equals(person2.fName)) {
						return 0;
					}
					else
						return person1.fName.compareTo(person2.fName);
				}
				else
					return person1.lName.compareTo(person2.lName);
			}
			else {
				if (person1.addr.zipCode < person2.addr.zipCode) return -1; 
				else return 1;
			}
		}
	};
	// sort by zip code
	public void sortCode() {
		Collections.sort(entries, com);
	}
}
