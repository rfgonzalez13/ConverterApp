import java.util.Scanner;

//User Interface
public class UI {
	
	//Displays messages
	public void showMessage(String msg) {
		System.out.println(msg);
	} 
	
	//Gets text directly from the user
	public String getLine() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		return in.nextLine();
		
	}
	
	//Displays error messages
	public void showError(String msg) {		
		System.err.println(msg);
	}
}
