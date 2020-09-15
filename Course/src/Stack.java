import java.util.Iterator;
import java.util.LinkedList;

public class Stack {
	
	public void stackList() {
		LinkedList<String> names = new LinkedList<String>();
		names.push("Melissa");
		names.push("Orlando");
		names.push("Lucero");
		
		/*
		System.out.println(names.pop());
		System.out.println(names.remove());
		System.out.println(names.removeFirst());
		*/
		
		Iterator<String> it = names.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		for(String n: names) {
			System.out.println(n);
		}
	}

}
