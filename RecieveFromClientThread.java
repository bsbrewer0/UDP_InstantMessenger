
import java.io.*;
import java.net.Socket;

    class RecieveFromClientThread implements Runnable
    {
	Socket clientSocket=null;
	BufferedReader brBufferedReader = null;
	
	public RecieveFromClientThread(Socket clientSocket)
	{
		this.clientSocket = clientSocket;
	}
        
	public void run() {
		try{
		brBufferedReader = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));		
		
		String messageString;
		while(true){
		while((messageString = brBufferedReader.readLine())!= null){           //message from client to a Sting "messageString"
			if(messageString.equals("EXIT"))
			{
				break;                        //break to close the socket if the client types "EXIT"
			}
			System.out.println("Client: " + messageString);         //printing the message from the client to the server
			
		}
		this.clientSocket.close();
		System.exit(0);
	}
		
	}
	catch(Exception ex){System.out.println(ex.getMessage());}
	}
    }