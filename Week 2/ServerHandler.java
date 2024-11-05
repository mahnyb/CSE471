import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerHandler extends Thread {


    Socket clientSocket;
    DataInputStream dis;
    DataOutputStream dos;

    public ServerHandler(Socket s) throws IOException {

        clientSocket = s;
        dis = new DataInputStream(clientSocket.getInputStream());
        dos = new DataOutputStream(clientSocket.getOutputStream());

        System.out.println("A client has connected. IP: " + clientSocket.getInetAddress());

    }

    public void run(){

        byte[] arr = new byte[1024];

        int a;
        int i = 0;

        while (true) {
            try {
                while (((a = dis.read()) != '\n'))
                    arr[i++] = (byte) a;

                String myString = new String(arr);
                System.out.println("Request from client: " + myString);

                String anotherString = myString.toUpperCase();
                dos.writeBytes(anotherString + "\n");

                clientSocket.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}