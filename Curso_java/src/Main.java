
public class Main {
	
	public static void main(String[] args) {
		Jaguar yagua = new Jaguar(10, 120f);
		
		System.out.println(yagua);
		
		yagua.comer();
		yagua.dormir();
		
		yagua.cazar();
		yagua.rugir();
		
		
		Jaguar jaguar_2 = new Jaguar();
		System.out.println(jaguar_2);
		
		
		Animal jaguar_3 = new Jaguar(3);
		System.out.println(jaguar_3);
		
		IFelino jaguar_4 = new Jaguar(100f);
		System.out.println(jaguar_4);
	
	}

}
