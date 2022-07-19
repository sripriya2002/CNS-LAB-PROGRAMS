import java.util.Random;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
public class RSA{
	private BigInteger p,q,n,phi,d,e;
	private Random r;
	private int bitlength=1024;
	public RSA(){
		r=new Random();
		p=BigInteger.probablePrime(bitlength,r);
		q=BigInteger.probablePrime(bitlength,r);
		n=p.multiply(q);
		phi=((p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE)));
		e=BigInteger.probablePrime(bitlength/2,r);
		while(phi.gcd(e).compareTo(BigInteger.ONE)>0 && e.compareTo(phi)<0){
			e.add(BigInteger.ONE);
		}
		d=e.modInverse(phi);
	}
	public RSA(BigInteger e,BigInteger d,BigInteger n){
		this.e=e;
		this.n=n;
		this.d=d;
	}
	@SuppressWarnings("deprecation")
	public static void main(String args[])throws IOException{
		RSA rsa=new RSA();
		DataInputStream in=new DataInputStream(System.in);
		System.out.println("enter a plain text message\n");
		String teststring=in.readLine();
		System.out.println("plain text message is:"+teststring);
		System.out.println("String message in bytes is:"+bytesToString(teststring.getBytes()));
		byte[] encrypted=rsa.encrypt(teststring.getBytes());
		byte[] decrypted=rsa.decrypt(encrypted);
		System.out.println("decrypted message in bytes is:"+bytesToString(decrypted));
		System.out.println("decrypted message is:"+new String(decrypted));
	}
	private static String bytesToString(byte[] encrypted){
		String test="";
		for(byte b:encrypted){
			test+=Byte.toString(b);
		}
		return test;
	}
	public byte[] encrypt(byte[] message){
		return (new BigInteger(message)).modPow(e,n).toByteArray();
	}
	public byte[] decrypt(byte[] message){
		return (new BigInteger(message)).modPow(d,n).toByteArray();
		}
}
		
