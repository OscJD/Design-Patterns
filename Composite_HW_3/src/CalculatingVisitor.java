import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class CalculatingVisitor implements IVisitor{
	
	private ArrayList<String> acc_calculation = new  ArrayList<String>();
	private Stack<String> stack_calculation = new Stack<String>(); 
	private Deque<String> deque_calculation = new LinkedList<>();

	
	public CalculatingVisitor() {
		
	}

	public int visit(Number number) {
		
		acc_calculation.add(Integer.toString(number.get_value()));
		stack_calculation.push(Integer.toString(number.get_value()));
		deque_calculation.addFirst(Integer.toString(number.get_value()));
	
		return number.get_value();
	}


	public int visit(IOperation node) {
		System.out.println(node.getClass().getName());
		
		if (node.getClass().getName() == "Addition"){
			acc_calculation.add("+");
			stack_calculation.push("+");
			deque_calculation.addLast("+");
		}
		if (node.getClass().getName() == "Multiplication") {
			acc_calculation.add("*");
			stack_calculation.push("*");
			deque_calculation.addLast("*");
		}
		
		node.iterate(this);
		return 0;	
	}

	public void printResult() {
		// TODO Auto-generated method stub
		for (String element : acc_calculation) { 		      
	           System.out.print(element); 		
	      }
		System.out.println();
		
	
		System.out.println(stack_calculation.pop());
		System.out.println(stack_calculation);
		
		System.out.println();
		System.out.println(deque_calculation);
		for(int i =0; i <= deque_calculation.size()+1 ; i++) {
		System.out.print(deque_calculation.pollFirst());
		if (!deque_calculation.isEmpty()) {
		System.out.print(deque_calculation.pollLast());
		}
		}
		System.out.println();
	
	}



}
