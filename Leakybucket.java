import java.util.*;
public class Leakybucket{
	public static void main(String args[]){
		int size,rate,tno,r=0,flag=0,rem=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter bucket size\n");
		size=sc.nextInt();
		System.out.println("enter the rate\n");
		rate=sc.nextInt();
		int inp[]=new int[25];
		System.out.println("enter the no of packets\n");
		tno=sc.nextInt();
		for(int i=1;i<=tno;i++){
			System.out.println("enter the packet size\n");
			inp[i]=sc.nextInt();
		}
		System.out.println("clock\t\tpacket size\t\taccept\t\tpacket sent\t\tpacket left\t");
		System.out.println("----------------------------------------------------------------------------------------");
		for(int i=1;i<=tno;i++){
			if(inp[i]+rem>size)
				flag=1;
			else{
				flag=0;
				if(inp[i]>rate)
					rem=inp[i]+rem-rate;
				else{
					rem=inp[i]+rem-rate;
					if(inp[i]<rate && rem<0)
						rem=0;
				}
				if(rem>inp[i]){
					rem=rate-inp[i];
				}
			}
			if(inp[i]<rate && inp[i]+rem<rate)
				r=rem+inp[i];
			else
				r=rate;
			
			if(flag==1){
				System.out.println(i+"\t\t"+inp[i]+"\t\t\t"+"packet dropped"+"\t"+"0"+"\t\t\t"+rem);
			}
			else
				
				System.out.println(i+"\t\t"+inp[i]+"\t\t\t"+inp[i]+"\t\t"+r+"\t\t\t"+rem);
		}
	}
}
		
