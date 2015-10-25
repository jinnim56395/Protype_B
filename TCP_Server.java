package Protype_B;
import java.io.*;
import java.net.*;


public class TCP_Server {
	public static void main(String[] args) 
			throws IOException {
		int listenPort = 8888;
		ServerSocket serverSocket = null;
		Socket clientSocket = null;

		
		

		
		
		try {

			serverSocket = new ServerSocket(listenPort);// build a ServerSocket
			// for listening the
			// connection on port
			// 8888
			System.out.println("the server information:"
			+ serverSocket.getLocalSocketAddress());

			Thread thread = null;
			while (true) {
			System.out.println("wait to client....");
			clientSocket = serverSocket.accept();
			thread = new Thread(new ServerThread(clientSocket));
			thread.start();
			}
		} catch (IOException e) {
			System.out.println("some error:" + e.getMessage());
		}
	
		
	}


}


class ServerThread implements Runnable {

	Socket clientSocket = null;
	PrintStream out = null;
	BufferedReader in = null;
	
	
	public ServerThread(Socket s) {
	this.clientSocket = s;
	}
	
	public void run() {
		System.out.println("the client information :"+ clientSocket.getRemoteSocketAddress());
		
		try {
			out = new PrintStream(clientSocket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(clientSocket
			.getInputStream()));
			String str = in.readLine();
			System.out.println("client comes message:" + str);
			out.println("I am Server");
			out.flush();
			out.close();
			in.close();
			clientSocket.close();
		} catch (IOException e) {
			System.out.println("Error:"+e.getMessage());
		}
	}
}

