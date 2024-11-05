import java.io.*;
import java.net.*;

class ServerHelper {
    public ServerSocket ss; // listens for incoming connections on a specified port
    public BufferedReader bR; // reads text from an input stream (used for receiving data)
    public DataOutputStream dOS; // sends data in a raw byte format (used for sending data) 
    public Socket conSock; // represents a connection socket once a client is connected 

    public ServerHelper() { // the constructor
        try {
            ss = new ServerSocket(6789); // initializes the socket on port 6789
            conSock = ss.accept(); // waits for a client connectin
            bR = new BufferedReader(new InputStreamReader(conSock.getInputStream())); // once connected, initializes bf for communication with the client
            dOS = new DataOutputStream(conSock.getOutputStream()); // once connected, initializes dOS for communication with the client
        } catch(Exception e) {
            System.err.println("Error!");
        }
    }

    // ServerHelper Methods
    
    public void sendStr(String str) {
        try {
            dOS.writeBytes(str); // sends a string to the client. it catches and logs any exceptions
        } catch(Exception e) {
            System.err.println("Error!");
        }
    }

    public String receiveStr() {
        try {
            String str = bR.readLine(); // receives a string from the client by reading a line from the input stream
            return str; // returns the string or null if an error occurs
        } catch(Exception e) {
            System.err.println("Error!");
            return null; 
        }
    }
}

class ClientHelper {
    public Socket conSock; // client socket connected to the server
    public BufferedReader bR; // reads text from server's response
    public DataOutputStream dOS; // sends data to the server

    public ClientHelper() {
        try {
            conSock = new Socket("localhost", 6789); // creates a socket to connect to the server running on local host at port 6789
            bR = new BufferedReader(new InputStreamReader(conSock.getInputStream()));
            dOS = new DataOutputStream(conSock.getOutputStream());
        } catch(Exception e) {
            System.err.println("Error!");
        }
    }

    public void sendStr(String str) {
        try {
            dOS.writeBytes(str+'\n'); // sends a string to the server. adds a /n at the end to ensure the server can read the message properly using readLine()
        } catch(Exception e) {
            System.err.println("Error!");
        }
    }

    public String receiveStr() {
        try {
            String str = bR.readLine(); // reads a line of text from the server
            return str;
        } catch(Exception e) {
            System.err.println("Error!");
            return null;
        }
    }
}
