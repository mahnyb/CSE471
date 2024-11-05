import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

    public static void main(String[] args) throws IOException {

        Socket connectionSocket = new Socket("localhost", 1234);
        System.out.println("Connection established.");


        BufferedReader bf = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));


        DataOutputStream dos = new DataOutputStream(connectionSocket.getOutputStream());
        //Automatically converts strings to byte arrays.

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = myScanner.nextLine();

        dos.writeBytes(s+"\n");

        String anotherString = bf.readLine();
        System.out.println("Server response: " + anotherString);
        connectionSocket.close();


    }

}
