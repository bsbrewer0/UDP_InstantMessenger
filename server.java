import java.io.*;
import java.net.*;
import java.lang.*;


public class server
{
	
    
    public static void main(String[] args) throws IOException 
    {
		
        final int port = 4000;
        InetAddress Addr;
        
        Addr = InetAddress.getLocalHost();
        String hostName = Addr.getHostName();
        String hostAddress = Addr.getHostAddress();
        
        System.out.println("IP Adress : "+ hostAddress);
        System.out.println("Port Number : "+ port);
        System.out.println("Host Name : "+ hostName);
        System.out.println("-------------------------------------------------------------------------------------------------------"+"\n\n");
        
        System.out.println("Server waiting for connection...");
	ServerSocket ss = new ServerSocket(port);
	Socket clientSocket = ss.accept();
	
	//create two threads to send and recieve from client for multiple messages at a time
        
	RecieveFromClientThread recieve = new RecieveFromClientThread(clientSocket);        // creating the first thread
	Thread thread = new Thread(recieve);
	thread.start();                                                                     //start of the thread
        
	SendToClientThread send = new SendToClientThread(clientSocket);                     // creating the second thread
	Thread thread2 = new Thread(send);
	thread2.start();                                                                    // start of the thread
                
	}
}