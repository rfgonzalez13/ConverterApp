import java.io.File;
import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileWriter implements Writer{

	PrintStream out;
	
	FileWriter(File f) throws FileNotFoundException{
		try {
			out = new PrintStream(new FileOutputStream(f));
		} catch (FileNotFoundException e) {
			throw e;
		}
	}
	
	public void writeLine(String line) {
		out.println(line);		
	}
	
}
