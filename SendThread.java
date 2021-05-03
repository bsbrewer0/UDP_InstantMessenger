
import java.io.*;
import java.net.Socket;

class SendThread implements Runnable
{
    Socket sock=null;
    PrintWriter print=null;
    BufferedReader brinput=null;
	
    public SendThread(Socket sock)
    {
	this.sock = sock;
    }
    public void run()
    {
		
        try
        {
            
            if(sock.isConnected())
            {
		System.out.println("Client connected to the Server....  on Port Number"+sock.getPort());             // verified the successful connection
		this.print = new PrintWriter(sock.getOutputStream(), true);
                System.out.println("Type your message to send to the server,Type 'VOICE' to start the server side voice chat,\n or type 'EXIT' to exit the Chat Program");    // giving instructions to the client
                
		while(true){
			
			brinput = new BufferedReader(new InputStreamReader(System.in));
			String msgtoServerString=null;
			msgtoServerString = brinput.readLine();
			this.print.println(msgtoServerString);
			this.print.flush();
		
			if(msgtoServerString.equals("EXIT"))
			break;
			}
		sock.close();
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
	
    }
}