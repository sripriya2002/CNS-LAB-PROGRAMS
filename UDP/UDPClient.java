import java.io.*;
import java.net.*;
import java.util.*;
public class UDPClient{
	public static void main(String args[])throws Exception{
		DatagramSocket sock=new DatagramSocket();
		byte[] rcvdata=new byte[1024];
		byte[] snddata=new byte[1024];
		Scanner sc=new Scanner(System.in);
		System.out.println("enter message to send to server\n");
		String data=sc.nextLine();
		snddata=data.getBytes();
		InetAddress myip=InetAddress.getByName("localhost");
		DatagramPacket sndpkt=new DatagramPacket(snddata,snddata.length,myip,8000);
		sock.send(sndpkt);
		DatagramPacket rcvpkt=new DatagramPacket(rcvdata,rcvdata.length);
		sock.receive(rcvpkt);
		String todisplay=new String(rcvpkt.getData());
		System.out.println("Server:"+todisplay);
	}
}
