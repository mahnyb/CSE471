import java.util.*;

public class ClientDate {
    public static void main(String[] args) {
        
    	ClientHelper clientHelper = new ClientHelper();
    	Scanner myscanner = new Scanner(System.in);
    	
    	System.out.println("Enter the date: ");
    	String input = myscanner.nextLine().toLowerCase();
    	
    	clientHelper.sendStr(input);
    	System.out.println("From Server: " + input);
    	
    	String response = clientHelper.receiveStr();
    	
    	if (response != null && input.equals("today") || input.equals("yesterday")) {
    		System.out.println("Strings match!");
    		System.out.println("Recieved " + input + "'s date from server --> " + response);
    	}
    	else {
    		System.out.println("Invalid response received from the server");
    	}
    	
    	myscanner.close();

    }
}


// Step 1: Send date request ("today" or "yesterday")
// Step 2: Receive verification from the server
// Check if the request matches the server response
// Step 3: Receive and print the date from the server
