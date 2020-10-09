package lab3.homework;

import lab3.homework.Person_.Sex;

public class Female extends Sex_class{
	
	private Sex sex_info;
	
	public Female(Sex sex) {
		this.sex_info = sex;
	}
	
	@Override
	public void Sex_definition(Sex sex) {
	}
	
	@Override
	public void Show_sex(String extra_data) {
		System.out.println("Sex " + this.sex_info + " Other data " + extra_data);

	}
	
	@Override
	public Sex getSex_info() {
		return this.sex_info;
	}

}
