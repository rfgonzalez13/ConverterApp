//Transform Interface
public interface Transform {
	
	//Gives a header (if required)
	String getHeader();
	
	//Gives a footer (if required)
	String getFooter();
	
	//Transforms a line from an input format to output format 
	String transform(String line);

}
