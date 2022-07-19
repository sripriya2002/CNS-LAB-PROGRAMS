import java.io.*;
import java.net.*;
import java.util.*;
public class TCPServer{
	public static void main(String args[])throws IOException,FileNotFoundException{
		ServerSocket servsock=new ServerSocket(8000);
		System.out.println("Ready to accept\n");
		Socket sock=servsock.accept();
		System.out.println("connection established successfully\n");
		InputStream istream=sock.getInputStream();
		BufferedReader buffread=new BufferedReader(new InputStreamReader(istream));
		String fname=buffread.readLine();
		System.out.println("file name is "+fname);
		BufferedReader contreader=new BufferedReader(new FileReader(fname));
		OutputStream ostream=sock.getOutputStream();
		PrintWriter pwriter=new PrintWriter(ostream,true);
		String str;
		while((str=contreader.readLine())!=null){
			pwriter.println(str);
		}
		sock.close();
		pwriter.close();
		buffread.close();
		contreader.close();
	}
}
		
