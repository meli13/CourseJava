import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws FileNotFoundException {
		
		//Array array = new Array();
		//array.CreateArray();
		
		ReadFile read = new ReadFile();
		read.ReadTxt("students");
	}

}
