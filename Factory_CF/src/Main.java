
public class Main {
	
	public static void main(String[] args) {
		
		PizzeriaCF cf= new PizzeriaCF();
		
		Pizza peperoni = cf.crearPizza("Peperoni");
		Pizza hawaiana = cf.crearPizza("Hawaiana");
		
		
		System.out.println(peperoni);
		System.out.println(hawaiana);
	}

}
