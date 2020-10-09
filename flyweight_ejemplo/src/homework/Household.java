package homework;

import java.util.ArrayList;

public class Household {
    ArrayList<Person> inhabitants;
    Integer index;
    public Household(ArrayList<Person> people, Integer index) {
        this.inhabitants = people;
        this.index = index;
    }
    public void newDay() {
        Boolean printed = false;
        for (Person e : inhabitants) {
            String state = e.newDay();
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
