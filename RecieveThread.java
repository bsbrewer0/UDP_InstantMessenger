
import java.io.*;
import java.net.Socket;

class RecieveThread implements Runnable
{
	Socket sock=null;
	BufferedReader recieve=null;
	
	public RecieveThread(Socket sock) {
		this.sock = sock;
	}
        @Override
	public void run() {
		try{
		recieve = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));        //get inputstream from the server
		String msgRecieved = null;
		while((msgRecieved = recieve.readLine())!= null)
		{
			System.out.println("Server: " + msgRecieved);                                    // outputting the message from the server
			
		}
		}catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
	}
}
