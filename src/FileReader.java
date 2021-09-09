import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader implements Reader {
	
	Scanner scanner;
	//Constructor
	FileReader(File f) throws FileNotFoundException{
		try {
			scanner = new Scanner(f);
		}catch(FileNotFoundException e) {
			throw e;
		}
	}
	//Reads the next line every time it's called. Returns null at the end of the file
	public String readLine(){
		if(scanner.hasNextLine()) {
			return scanner.nextLine();
		}else return null;
	}
}
