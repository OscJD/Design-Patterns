package lab3.homework;

import lab3.homework.Person_.Sex;

public abstract class Sex_class {
	
	public Sex sex_info;
	
	public abstract void Sex_definition(Sex sex);
	
	public Sex getSex_info() {
		return sex_info;
	}


	public void Show_sex(String extra_data) {
		System.out.println("Sex " + this.sex_info + " Other data " + extra_data);
	}
}
