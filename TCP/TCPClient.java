import java.io.*;
import java.net.*;
import java.util.*;
public class TCPClient{
	public static void main(String args[])throws IOException,FileNotFoundException{
		Socket sock=new Socket("localhost",8000);
		System.out.println("enter the filename\n");
		BufferedReader buffread=new BufferedReader(new InputStreamReader(System.in));
		String fname=buffread.readLine();
		OutputStream ostream=sock.getOutputStream();
		PrintWriter pwrite=new PrintWriter(ostream,true);
		pwrite.println(fname);
		InputStream istream=sock.getInputStream();
		BufferedReader toread=new BufferedReader(new InputStreamReader(istream));
		String str;
		while((str=toread.readLine())!=null){
			System.out.println(str);
		}
		toread.close();
		sock.close();
		pwrite.close();
		buffread.close();
	}
}
