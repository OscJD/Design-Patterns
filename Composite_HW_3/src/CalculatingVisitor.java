
public class CalculatingVisitor implements IVisitor{

	
	public CalculatingVisitor() {
		
	}

	public int visit(Number number) {
		return number.get_value();
	}


	public int visit(IOperation node) {
		System.out.println(node.getClass().getName());
		return 0;	
	}

	public void printResult() {
		// TODO Auto-generated method stub
		
	}



}
