import java.util.LinkedList;

public class Stack {
	
	public void StackList() {
		LinkedList<String> names = new LinkedList<String>();
		names.push("Melissa");
		names.push("Orlando");
		names.push("Lucero");
		
		System.out.println(names.pop());
		System.out.println(names.remove());
		System.out.println(names.removeFirst());
	}

}
