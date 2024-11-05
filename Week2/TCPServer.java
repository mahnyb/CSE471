import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(1234); //1024-65535

        while(true){
            Socket clientSocket = s.accept();
            new ServerHandler(clientSocket).start();
        }
    }
}
