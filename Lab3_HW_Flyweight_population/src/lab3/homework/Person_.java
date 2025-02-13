package lab3.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Person_ {
	private List<Integer> person_age_list = new ArrayList<Integer>();
	private int person_age[];
	private static Map<Integer, ArrayList<Double>> problsHospital_Map = new HashMap<Integer, ArrayList<Double>>();
	private static Map<Integer, ArrayList<Double>> problsHospitalDeath_Map = new HashMap<Integer, ArrayList<Double>>();
	private static Map<Integer, ArrayList<Double>> problsSuddenDeath_Map = new HashMap<Integer, ArrayList<Double>>();
	private static List<Boolean> dead_List = new ArrayList<>();
	private static List<Integer> hospital_d_List = new ArrayList<>();
	private static List<Sex> sex_List = new ArrayList<>();
	
    public enum Sex {Male, Female};
    public static ArrayList<Integer> ageGroups;
    
    private ArrayList<Double> probabilityHospital;
    private ArrayList<Double> probabilityHospitalDeath;
    private ArrayList<Double> probabilitySuddenDeath;
    private Integer age;
    private Sex sex;
    private Integer daysInHospital;
    private Boolean dead;
    private Integer index;

    public Person_(Sex sex) {
    	System.out.println("Creating person object: " + sex);
    }
    
    public void Person_set(ArrayList<Double> probsHospital, ArrayList<Double> probsHospitalDeath,
            ArrayList<Double> probsSuddenDeath, Integer age, Sex sex, Integer index) {
    	
         
    	 person_age_list.add(age);
         problsHospital_Map.put(index, probsHospital);
         problsHospitalDeath_Map.put(index, probsHospitalDeath);
         problsSuddenDeath_Map.put(index, probsSuddenDeath);
         dead_List.add(false);
         hospital_d_List.add(-1);
         sex_List.add(sex);
    	
    }
    
    public Sex get_sex(){
    	return sex;
    }
    
    public String newDay(Integer total_index) {
    	//System.out.println(total_index);
    	//System.out.println(person_age_list.size());
    	this.probabilityHospital = problsHospital_Map.get(total_index);
        this.probabilitySuddenDeath = problsSuddenDeath_Map.get(total_index);
        this.probabilityHospitalDeath = problsHospitalDeath_Map.get(total_index);
        System.out.println(person_age_list.size());
        this.age = person_age_list.get(total_index);
        this.daysInHospital = hospital_d_List.get(total_index);
        this.dead = dead_List.get(total_index);
        this.index = total_index;
        this.sex = sex_List.get(total_index);
    	
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
        	hospital_d_List.set(total_index,this.daysInHospital - 1);
        } else if (daysInHospital == 0) { //If at the end of hospital stay, see if dies or lives
            
        	hospital_d_List.set(total_index,this.daysInHospital - 1);
            if (randomno.nextDouble() < probabilityHospitalDeath.get(myGroup)) {
                //this.dead = true;
            	dead_List.set(total_index, true);

                return "Agent "+index+" ("+sex+", age: "+age+") died in hospital";
            }
        } else { //Person not in hospital
            	//Chance of sudden death
      
            if ( randomno.nextDouble() < probabilitySuddenDeath.get(myGroup)) {
            	dead_List.set(total_index, true);
                return "Agent "+index+" ("+sex+", age: "+age+") died a sudden death";
            } else {
                //Chance of hospitalization
                if (randomno.nextDouble() < probabilityHospital.get(myGroup)) {
                	hospital_d_List.set(total_index,6);
                    return "Agent "+index+" ("+sex+", age: "+age+") hospitalized";
                }
            }
        }
        return "";
    }
    
    public Sex getSex() {
    	
    	return this.sex;
    }
}
