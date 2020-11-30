

public class Car {

	private int ID;
	
	public Car() {
		this.ID = (int)(1000 + Math.random() * ((1000 - 2000) + 1));
	}
	
	public int getID() {
		
		return this.ID;
	}
	
	
}
