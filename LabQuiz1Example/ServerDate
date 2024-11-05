import java.text.SimpleDateFormat;
import java.util.*;

public class ServerDate {
    public static void main(String[] args) {
       
    	ServerHelper serverHelper = new ServerHelper();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    	
    	while(true) {
    		
    		String recieved = serverHelper.receiveStr();
    		System.out.println("Recieved: " + recieved);
    		
    		if (recieved != null) {
    			Date date;
    			
    			switch(recieved.toLowerCase()) {
    			
    			case "today":
    				date = new Date();
    				break;
    				
    			case "yesterday":
    				date = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
    				break;
    				
    			default:
    				serverHelper.sendStr("Invalid Request");
    				continue;
    			}
    			
    			String response = dateFormat.format(date);
    			serverHelper.sendStr(response + "\n");
    			System.out.println("Sending back the date...");
    			
    			
    		}
    		
    	} 
    }
    
}



// Step 1: Receive date request from client ("today" or "yesterday")

// Step 2: Send back the received request for client verification
// Step 3: Determine the date to send back
//Calendar calendar = Calendar.getInstance(); //to get todays date
//calendar.add(Calendar.DATE, -1); // to get yesterdays date
// Format date as "dd/MM/yyyy HH:mm:ss"
//SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//String formattedDate = dateFormat.format(calendar.getTime());
// Step 4: Send the formatted date back to the client
