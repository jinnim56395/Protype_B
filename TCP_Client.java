package Protype_B;
import java.io.*;
import java.net.*;

public class TCP_Client {
	public static void main(String[] args) {
				
		String serverIP = "127.0.0.1";
		int serverPort = 8888;
		
		try {
			Socket socket = new Socket(serverIP, serverPort);	
			PrintStream out = new PrintStream(socket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("please key the message to server¡G");
			BufferedReader fromUser = new BufferedReader(new InputStreamReader(System.in));

			out.println(fromUser.readLine());
			out.flush();
		} catch (UnknownHostException e) {	
			 System.out.println("Error:"+e.getMessage()); 	
		} catch (IOException e) {			
			 System.out.println("Error:"+e.getMessage());
		}

	}
}
