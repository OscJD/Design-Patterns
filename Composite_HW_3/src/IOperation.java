//import java.util.ArrayList;

public interface IOperation extends INode{

	public int accept(IVisitor visitor);
	
	public void add_element(INode element);

	
}
