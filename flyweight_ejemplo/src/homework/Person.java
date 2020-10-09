package homework;

import java.util.ArrayList;
import java.util.Random;

public class Person {
    public enum Sex {Male, Female};
    public static ArrayList<Integer> ageGroups;
    ArrayList<Double> probabilityHospital;
    ArrayList<Double> probabilityHospitalDeath;
    ArrayList<Double> probabilitySuddenDeath;
    Integer age;
    Sex sex;
    Integer daysInHospital;
    Boolean dead;
    Integer index;

    public Person(ArrayList<Double> probsHospital, ArrayList<Double> probsHospitalDeath,
                  ArrayList<Double> probsSuddenDeath, Integer age, Sex sex, Integer index) {
        this.probabilityHospital = probsHospital;
        this.probabilitySuddenDeath = probsSuddenDeath;
        this.probabilityHospitalDeath = probsHospitalDeath;
        this.age = age;
        this.sex = sex;
        this.daysInHospital = -1;
        this.dead = false;
        this.index = index;
    }

    /**
     * A method computing what happens to a person that day
     * @return a String describing what happened (if anything)
     */
    public String newDay() {
        //If dead, do nothing
        if (this.dead) return "";

        //Calculate what age group this person belongs to
        int myGroup = 0;
        while (age > ageGroups.get(myGroup)) {
            myGroup++;
        }

        // create random object
        Random randomno = new Random();

        if (daysInHospital>0) { //If still in hospital, reduce days left in hospital
            this.daysInHospital = this.daysInHospital - 1;
        } else if (daysInHospital == 0) { //If at the end of hospital stay, see if dies or lives
            this.daysInHospital = this.daysInHospital - 1;
            if (randomno.nextDouble() < probabilityHospitalDeath.get(myGroup)) {
                this.dead = true;
                return "Agent "+index+" ("+sex+", age: "+age+") died in hospital";
            }
        } else { //Person not in hospital
            //Chance of sudden death
            if (randomno.nextDouble() < probabilitySuddenDeath.get(myGroup)) {
                this.dead = true;
                return "Agent "+index+" ("+sex+", age: "+age+") died a sudden death";
            } else {
                //Chance of hospitalization
                if (randomno.nextDouble() < probabilityHospital.get(myGroup)) {
                    this.daysInHospital = 6;
                    return "Agent "+index+" ("+sex+", age: "+age+") hospitalized";
                }
            }
        }
        return "";
    }
}
