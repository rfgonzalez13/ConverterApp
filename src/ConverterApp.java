
import java.io.File;
import java.io.FileNotFoundException;

public class ConverterApp {

	public static void main(String[] args){
		
		File input;
		File output;
		Reader reader = null;
		Writer writer = null;
		UI ui = new UI();
		
		ui.showMessage("input filename: ");
		input = new File(ui.getLine());
		try {
			reader = new FileReader(input);
		}catch(FileNotFoundException e) {
			ui.showError("the file " + input.getAbsolutePath()
			+ " does not exists: " + e.getMessage());
			System.exit(1);
		}
		
		
		ui.showMessage("output filename: ");
		output = new File(ui.getLine());
		
		 
		writer = new ConsoleWriter();
		 
		
		try {
			writer = new FileWriter(output);
		}catch(FileNotFoundException e) {
			ui.showError("the file " + output.getAbsolutePath()
			+ " does cannot be created: " + e.getMessage());
			System.exit(1);;
		}
		
		
		String[] categories = {"name", "price"}; 
		Transform mode = new TABtoXMLTransform("products", "product", categories);

		TextTransformer t = new TextTransformer(reader,writer,mode);
		
		try {
			t.transform();
		}catch(IllegalArgumentException e){
			ui.showError("Wrong format: " + e.getMessage());
			output.delete();
			System.exit(1);;
		}
		
	
	}
}
