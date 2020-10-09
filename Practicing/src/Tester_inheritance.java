
public class Tester_inheritance {
	
	public static void main(String[] args) {
		
		
		Student s = new Student();
		Person p = new Person();
		p.set_name("Oscar");
		s.set_name("Alma");
	
		String n=s.getName();
		
		System.out.println(n);
		
	}

}
