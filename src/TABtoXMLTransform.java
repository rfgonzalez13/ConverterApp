//Specific Class that transforms lines from TAB format into XML format
public class TABtoXMLTransform implements Transform{
	//Format header
	String header;
	//Format footer
	String footer;
	//Name of the items
	String item;
	//Ordered categories array
	String[] categories;
	//Number of categories
	int numCat;
	
	//Constructor 
	TABtoXMLTransform(String hf, String i, String[] cat){
		header = "<" + hf + ">";
		footer = "</" + hf + ">";
		item = i;
		categories = cat;
		numCat = cat.length;
	}
	//Gives back the header
	public String getHeader() {
		return header;
	}
	//Gives back the footer
	public String getFooter() {
		return footer;
	}
	//Method that transforms a given TAB line to XML line
	public String transform(String line) throws IllegalArgumentException{
		//line splitting through TABS
		String[] tokens = line.split("\t");
		//Check if given format it is correct
		if (tokens.length != numCat) {
			throw new IllegalArgumentException(
						"the line does not contain " + numCat + " tokens");
		}
		String toret = "<" + item + ">\n";
			for(int j=0;j<numCat; j++) {
				toret += "\t<" + categories[j] + ">" + tokens[j] + "</" + categories[j] + ">\n";
			}
		return toret +=  "</" + item + ">";

	}
		
}
