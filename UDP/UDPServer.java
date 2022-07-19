import java.io.*;
import java.util.*;
import java.net.*;
public class UDPServer{
	public static void main(String args[])throws Exception{
		DatagramSocket mysock=new DatagramSocket(8000);
		byte[] rcvdata=new byte[1024];
		byte[] snddata=new byte[1024];
		System.out.println("waiting for message\n");
		
		while(true){
			DatagramPacket rcvpkt=new DatagramPacket(rcvdata,rcvdata.length);
			mysock.receive(rcvpkt);
			String data=new String(rcvpkt.getData());
			System.out.println("Client:"+data);
			InetAddress clientip=rcvpkt.getAddress();
			int port=rcvpkt.getPort();
			System.out.println("Enter the message for the client\n");
			Scanner sc=new Scanner(System.in);
			String tosend=sc.nextLine();
			snddata=tosend.getBytes();
			DatagramPacket sndpkt=new DatagramPacket(snddata,snddata.length,clientip,port);
			mysock.send(sndpkt);
		}
	}
}
			
