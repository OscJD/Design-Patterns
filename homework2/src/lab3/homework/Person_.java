package lab3.homework;

import java.util.ArrayList;
import java.util.Random;

public class Person_ {
	private Sex_class implicit_data;
	
    public enum Sex {Male, Female};
    public static ArrayList<Integer> ageGroups;
    
    private ArrayList<Double> probabilityHospital;
    private ArrayList<Double> probabilityHospitalDeath;
    private ArrayList<Double> probabilitySuddenDeath;
    private Integer age;
    private Integer daysInHospital;
    private Boolean dead;
    private Integer index;
    
    public Sex sex_data;

    public Sex getSex_data() {
		return implicit_data.getSex_info();
	}

	public Person_(ArrayList<Double> probsHospital, ArrayList<Double> probsHospitalDeath,
            ArrayList<Double> probsSuddenDeath, Integer age_person, Sex sex, Integer index_data) {
		
		this.implicit_data = personFactory.add_person(sex);
		
		this.probabilityHospital = probsHospital;
		this.probabilityHospitalDeath = probsHospitalDeath;
		this.probabilitySuddenDeath = probsSuddenDeath;
		this.age = age_person;
		this.index = index_data;
		this.dead = false;
		this.daysInHospital = -1;
		
    	//
		//System.out.println("Creating person object: " + this.implicit_data);
    }
   
    public String newDay(Integer total_index) {
    	
        //If dead, do nothing
        if (this.dead) return "";

        //Calculate what age group this person belongs to
        int myGroup = 0;
        while (age > ageGroups.get(myGroup)) {
            myGroup++;
        }
        // create random object
        Random randomno = new Random();
        
        if (this.daysInHospital>0) { //If still in hospital, reduce days left in hospital
        	
        	this.daysInHospital = this.daysInHospital - 1;
        } else if (daysInHospital == 0) { //If at the end of hospital stay, see if dies or lives
            
        	this.daysInHospital = this.daysInHospital - 1;
            if (randomno.nextDouble() < probabilityHospitalDeath.get(myGroup)) {
                
            	this.dead = true;

                return "Agent "+index+" ("+ getSex_data() +", age: "+age+") died in hospital";
            }
        } else { //Person not in hospital
            	//Chance of sudden death
      
            if ( randomno.nextDouble() < probabilitySuddenDeath.get(myGroup)) {
            	this.dead = true;
                return "Agent "+index+" ("+ getSex_data() +", age: "+age+") died a sudden death";
            } else {
                //Chance of hospitalization
                if (randomno.nextDouble() < probabilityHospital.get(myGroup)) {
                	this.daysInHospital = 6;
                    return "Agent "+index+" ("+ getSex_data() +", age: "+age+") hospitalized";
                }
            }
        }
        return "";
    }
   
}

