
public interface INode {
	
	public int get_value();
	
	public void iterate(IVisitor visitor);
	
	public int accept(IVisitor visitor);

}
