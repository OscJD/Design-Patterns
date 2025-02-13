
public class Number implements INode{
	
	private Integer value;
	
	public Number(Integer value) {
		this.value = value;
	}
	
	public void iterate(IVisitor visitor)
	{	
		System.out.println(this.value);
	} 

	public int get_value() {
		return this.value;
	}

	public int accept(IVisitor visitor) {
		return visitor.visit(this); 
	}
	
	public void get_node_up() {
		System.out.println(this.getClass().getAnnotatedSuperclass().toString());
	}
	
}
