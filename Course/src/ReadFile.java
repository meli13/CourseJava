import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
	
	
	public void ReadTxt(String txt) throws FileNotFoundException{
		List<String> students = new ArrayList<String>();
		File file = new File(txt);
		Scanner sc = new Scanner(file);
		
		while(sc.hasNextLine()) {
			students.add(sc.nextLine());
		}
		
		for(String student:students) {
			System.out.println("Name: " + student);
		}
		
		sc.close();
		
	}

}
