import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.lang.String;

public class HTTP {

    public static void main(String[] args) throws UnknownHostException, IOException {
        Scanner myscanner = new Scanner(System.in);
        System.out.println("Please Enter the URL address of the web page: ");
        String host = myscanner.nextLine();

        if(!host.contains("http://"))
            host = "http://" + host;

        URL url = new URL(host);

        Socket clientSocket = new Socket(url.getHost(), 80);

        DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

        String path = url.getPath();
        if(path.equals("")) //if there is no path
            path = "/";

        String request = "GET " + path + " HTTP/1.1\r\nHost: " + url.getHost() + "\r\nConnection: close\r\n\r\n";
        System.out.println(request);

        dos.writeBytes(request);




        System.out.println("------------------------------BEGIN-HEADER------------------------------");

        while(true) {
            String output = dis.readLine();

            if(output.equals(""))  //readline reads \r\n as ""
                break;

            System.out.println(output);
        }

        System.out.println("------------------------------END-HEADER------------------------------");


        byte[] buffer = new byte[10000];
        int byteCount = 0;

        System.out.println("------------------------------BEGIN-PAYLOAD------------------------------");

        while( (byteCount = dis.read(buffer)) != -1 ) {
            System.out.write(buffer,0,byteCount);
        }

        System.out.println("------------------------------END-PAYLOAD------------------------------");


    }
}