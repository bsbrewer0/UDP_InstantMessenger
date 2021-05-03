
import java.io.*;
import java.net.Socket;

    class SendToClientThread implements Runnable
    {
	PrintWriter pwPrintWriter;
	Socket clientSock = null;
	
	public SendToClientThread(Socket clientSock)
	{
		this.clientSock = clientSock;
	}
	public void run() {
		try{
                    
                    pwPrintWriter =new PrintWriter(new OutputStreamWriter(this.clientSock.getOutputStream()));  //get the outputstream
		
                    while(true)
                    {
			String msgToClientString = null;
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));        //get userinput text
			
			msgToClientString = input.readLine();                           //get text message to send to the client from the server
			
			pwPrintWriter.println(msgToClientString);                            //send message to client with PrintWriter
			pwPrintWriter.flush();                                          //flush the PrintWriter
			
                    }
		}
		catch(Exception ex){System.out.println(ex.getMessage());}	
            }
    }