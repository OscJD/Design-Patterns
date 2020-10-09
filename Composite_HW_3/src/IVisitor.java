
public interface IVisitor {
	
	public int visit(Number element);
	public int visit(IOperation element);
	
	public void printResult();
	
	
}
