package lab3.homework;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import lab3.homework.Person_.Sex;

public class personFactory {
	
	private static Map<Sex, Person_> personMap = new HashMap<Sex, Person_>();
	
	public Person_ add_person(Sex sex) {
		Person_ person = personMap.get(sex);
		if(person ==null) {
			person = new Person_(sex);
			System.out.println("New person added");
			personMap.put(sex, person);
			
		}	
		//System.out.println("Existent person");
		//System.out.println(personMap);
		return person;
		
		
	}
	
	
	

}
