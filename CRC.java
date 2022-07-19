import java.io.*;
import java.util.*;
import java.net.*;
public class CRC{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the dataword\n");
		String data=sc.nextLine();
		System.out.println("enter the generator\n");
		String gen=sc.nextLine();
		String code=data;
		while(code.length()<data.length()+gen.length()-1){
			code+="0";
		}
		code=data+div(code,gen);
		System.out.println("The codeword genrated is "+code);
		String rem=div(code,gen);
		if(Integer.parseInt(rem)==0)
			System.out.println("no errors");
		else
			System.out.println("error");
		System.out.println("enter the position to change the bits\n");
		int pos=sc.nextInt();
		if(code.charAt(pos)=='0')
			code=code.substring(0,pos)+"1"+code.substring(pos+1);
		else
			code=code.substring(0,pos)+"0"+code.substring(pos+1);
		System.out.println("The altered code is "+code);
		if(Integer.parseInt(div(code,gen))==0){
			System.out.println("no errors");
		}
		else
			System.out.println("errors");
	}
	public static String div(String num1,String num2){
			int pointer=num2.length();
			String result=num1.substring(0,pointer);
			String remainder="";
			for(int i=0;i<pointer;i++){
				if(result.charAt(i)==num2.charAt(i))
					remainder+="0";
				else
					remainder+="1";
			}
			while(pointer<num1.length()){
				if(remainder.charAt(0)=='0'){
					remainder=remainder.substring(1,remainder.length());
					remainder=remainder+String.valueOf(num1.charAt(pointer));
					pointer++;
				}
				
				
			result=remainder;
			remainder="";
			if(result.charAt(0)!='0'){
				for(int i=0;i<num2.length();i++){
					if(result.charAt(i)==num2.charAt(i))
						remainder+="0";
					else
						remainder+="1";
				}
			}
			else
				remainder=result;
			
			}
			return remainder.substring(1,remainder.length());
		}
}

			
