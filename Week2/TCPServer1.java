import java.io.*;
import java.net.*;

public class TCPServer1 {

	public static void main(String args[]) throws Exception {

		String clientSentence;
		String capitalizedSentence;
		ServerSocket welcomeSocket = new ServerSocket(1234);

		while (true) {

			Socket connectionSocket = welcomeSocket.accept();
			System.out.println("Incoming from: " + connectionSocket.getInetAddress().getHostAddress());

			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

			clientSentence = inFromClient.readLine();
			System.out.println("Received: " + clientSentence);

			capitalizedSentence = clientSentence.toUpperCase() + '\n';
			outToClient.writeBytes(capitalizedSentence);

		}

	}

}