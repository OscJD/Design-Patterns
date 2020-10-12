import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class PrintingVisitor implements IVisitor{
	
	private ArrayList<String> acc_print = new  ArrayList<String>();
	private Stack<String> stack_print = new Stack<String>(); 
	private Deque<String> deque = new LinkedList<>();
	
	public PrintingVisitor() {
		
	}

	public int visit(Number number) {
	
		acc_print.add(Integer.toString(number.get_value()));
		stack_print.push(Integer.toString(number.get_value()));
		deque.addFirst(Integer.toString(number.get_value()));
		return number.get_value();
	}


	public int visit(IOperation node) {
		
		System.out.println(node.getClass().getName());
		if (node.getClass().getName() == "Addition"){
			acc_print.add("+");
			stack_print.push("+");
			deque.addLast("+");
		}
		if (node.getClass().getName() == "Multiplication") {
			acc_print.add("*");
			stack_print.push("*");
			deque.addLast("*");
		}
		
		node.iterate(this);
		
		
		
		
		return 0;
	}
	// Infix 3 + 5 * 6
	public void printResult() {
		for (String element : acc_print) { 		      
	           System.out.print(element); 		
	      }
		System.out.println();
		
	
		System.out.println(stack_print.pop());
		System.out.println(stack_print);
		
		System.out.println();
		System.out.println(deque);
		for(int i =0; i <= deque.size()+1 ; i++) {
		System.out.print(deque.pollFirst());
		if (!deque.isEmpty()) {
		System.out.print(deque.pollLast());
		}
		}
		System.out.println();
		
	}

}
