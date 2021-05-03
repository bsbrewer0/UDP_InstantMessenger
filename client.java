import java.io.*;
import java.net.*;
import java.util.Scanner;


public class client {
    
    
    public static void main(String[] args)
	{
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the IP of the server or type HOST if on the same IP");
            String IP = input.next();
            if(IP.equals("HOST"))
                IP = "localhost";
            try {
                    
                Socket sock = new Socket(IP,4000);
                SendThread sendThread = new SendThread(sock);
                    
                Thread thread = new Thread(sendThread);thread.start();
                    
                RecieveThread recieveThread = new RecieveThread(sock);
                    
                Thread thread2 =new Thread(recieveThread);thread2.start();
                    
		} catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    } 
	}
}