import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Collections {

	public static void main(String[] args) {
		
		//HashMap
		
		/* 
		HashMap<String, Integer> ids = new HashMap<String, Integer>();
		ids.put("Melissa", 13);
		ids.put("Orlando", ids.getOrDefault("Orlando", 15) + 1);
		
		Set<String> keys = ids.keySet();
		for(String key: keys) {
			System.out.println(key);
		}
		*/
		
		
		//HashCode
		
		/* 
		Person p = new Person("email@email.com");
		Person q = new Person("other@email.com");
		
		System.out.println(p.equals(q));
		System.out.println(p.hashCode());
		System.out.println(q.hashCode());
		*/
		
		
		//HashSet
		
		/*
		String hello = "hello";
		String bye = "bye";
		
		HashSet<String> words = new HashSet<String>();
		words.add(hello);
		words.add(bye);
		words.add("hello");
		words.add("bye");
		words.add("hello");
		words.add("bye");
		
		for(String word: words) {
			System.out.println(word);
		}
		*/
		
		
		//Generic classes
		
		/*
		Item<String, Person> item = new Item<String, Person>();
		item.setX("Hello");
		Person p = new Person("email");
		item.setY(p);
		System.out.println(item.getX());
		System.out.println(item.getY().email);
		*/
		
		
		//Casting Lists
		
		Admin a = new Admin();
		a.email = "@email";
		
		ArrayList<Admin> admins = new ArrayList<Admin>();
		admins.add(a);
		
		List<Person> people = (List<Person>)(List<?>)admins;
		
		doSomething(people);
	}
	
	static void doSomething(List<Person> peeps) {
		for(Person p: peeps) {
			System.out.println(p.email);
		}
	}

}
