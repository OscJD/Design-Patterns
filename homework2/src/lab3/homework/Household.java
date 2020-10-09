package lab3.homework;

import java.util.ArrayList;

public class Household {
	Integer index_household;
	Integer index;
    ArrayList<Person_> inhabitants;
    
    public Household(ArrayList<Person_> people, Integer index) {
        this.inhabitants = people;
        this.index = index;
    }
    public void newDay() {
        Boolean printed = false;
       
        for (Person_ e : inhabitants) {
        	
            String state = e.newDay(index_household);
            if (state.length()>0) {
                if (!printed) {
                    System.out.println("Household "+index);
                    printed = true;
                }
                System.out.println(state);
            }
         
        }
    }
}

