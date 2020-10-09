
public class PizzeriaCF implements IPizzeria{

	
	public Pizza crearPizza(String tipo) {
		
		if (tipo=="Peperoni") {
			return new Pizza(8, "Peperoni");
		}
		if (tipo=="Hawaiana") {
			return new Pizza(8, "Hawaiana");
		}
		
		return null;
	}

}
