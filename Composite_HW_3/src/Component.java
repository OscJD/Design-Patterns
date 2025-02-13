import java.util.ArrayList;

public class Component {
	
	INode n1 = new Number(5);
	INode n2 = new Number(6);
	INode n3 = new Number(3);
	IOperation sum1;
	IOperation mult1;
	
	protected ArrayList<INode> elements;
	
	public Component() {
		
		mult1 = new Multiplication();
		mult1.add_element(n1);
		mult1.add_element(n2); 
		
		sum1 = new Addition();
		sum1.add_element(n3);
		sum1.add_element(mult1);
		
		
		
	}
	
	public void iterate(IVisitor visitor) {
		sum1.accept(visitor);
	}
	
	
}
