import java.io.*;
import java.util.*;
import java.net.*;
public class Bellmanford{
	public static void main(String args[]){
		int n=0,source;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the no of vertices\n");
		n=sc.nextInt();
		int adj[][]=new int[n+1][n+1];
		System.out.println("enter the adjacency matrix\n");
		for(int sn=1;sn<=n;sn++){
			for(int dn=1;dn<=n;dn++){
				adj[sn][dn]=sc.nextInt();
				if(sn==dn){
					adj[sn][dn]=0;
					continue;
				}
				if(adj[sn][dn]==0){
					adj[sn][dn]=999;
				}
			}
		}
		for(int sn=1;sn<=n;sn++){
			for(int dn=1;dn<=n;dn++){
				System.out.print(adj[sn][dn]+"\t");
			}
			System.out.println();
		}
		System.out.println("enter the source vertex\n");
		source=sc.nextInt();
		Bellmanford bf=new Bellmanford(n);
		bf.evaluation(source,adj);
		sc.close();
	}
	private int distance[];
	private int n;
	public Bellmanford(int n){
		this.n=n;
		distance=new int[n+1];
	}
	public void evaluation(int source,int adj[][]){
		for(int node=1;node<=n;node++){
			distance[node]=999;
		}
		distance[source]=0;
		for(int node=1;node<=n;node++){
			for(int sn=1;sn<=n;sn++){
				for(int dn=1;dn<=n;dn++){
					if(adj[sn][dn]!=999){
						if(distance[dn]>distance[sn]+adj[sn][dn]){
							distance[dn]=distance[sn]+adj[sn][dn];
						}
					}
				}
			}
		}
		for(int sn=1;sn<=n;sn++){
				for(int dn=1;dn<=n;dn++){
					if(adj[sn][dn]!=999){
						if(distance[dn]>distance[sn]+adj[sn][dn]){
							distance[dn]=distance[sn]+adj[sn][dn];
							System.out.println("graph has negative cycles\n");
							return;
						}
					}
				}
			}
			for(int v=1;v<=n;v++){
				System.out.println("distance from "+source+" to vertex "+v+" is "+distance[v]);
			}
		
		}
}

		
