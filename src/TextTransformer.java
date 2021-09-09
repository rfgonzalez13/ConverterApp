//Transforms text from a Reader to a Writer. Controller class
public class TextTransformer {

		Reader r;
		Writer w;
		Transform t;
		
		TextTransformer(Reader r, Writer w, Transform t){
			
			this.r = r;
			this.w = w;
			this.t = t;
		
		}
		//Method 
		void transform() {
			//Writes the header
			w.writeLine(t.getHeader());
			//Get the first line of the input
			String s = r.readLine();
			
			try {
				//loop while there is more lines to process
				while(s != null) {
					//Transformation method + write the output
					w.writeLine((t.transform(s)));
					//Gets next line
					s = r.readLine();
				}
			}catch(IllegalArgumentException e) {
				throw e;
			}
			
			//Writes the footer
			w.writeLine(t.getFooter());
			
		}
}
