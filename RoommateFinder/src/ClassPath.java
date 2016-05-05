import java.util.ArrayList;

public class ClassPath 
{
	private static final int V = 16;
	private static int temp;
	private static int track=0;
	private static int heading=0;
	private static double total=0;


	public static int minDistance(double dist[], boolean sptSet[])
	{

		double min = 999;
		int min_index = -1;

		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min)
			{
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}

	private static void printPath(int parent[], int j)
	{
		if (parent[j]==-1)
		{
			return;	
		}
		printPath(parent, parent[j]);
		System.out.printf("%d ", j);
	}

	private static void printSolution(double[] dist, int n, int[] parent,ArrayList<Integer> arr)
	{
		String error="";
		int src = temp;
		if(heading==0)
		{
			System.out.printf("Vertex\t\t  Distance\t\tPath");
			heading++;
		}
		
		
		for (int i = 0; i <= V && ((track+1)<arr.size()) ; i++)
		{ 
			
		
			if( arr.get(track+1) == i)
			{
				if(dist[i]==999)
				{
					error="no path";
				}
				else
				{
					error=""+temp;
				}
				for(int k=0; k <arr.size(); k++)
				{
					System.out.printf("\n%d -> %d \t\t %f\t\t%s ", temp, i, dist[i], error);
					total = total+ dist[i];
					if(error.equals("no path"))
					{
						continue;
					}
					else
					{
						printPath(parent, i);
					}
					break;
				}
			}
		
				
			
		}
		track++;
		
	}

	private static void dijkstra(double graph[][], int src, ArrayList<Integer>arr)
	{

		temp=src;

		double[] dist = new double[V];
		boolean[] sptSet = new boolean[V];


		int[] parent = new int[V];


		for (int i = 0; i < V; i++)
		{
			parent[i] = -1;
			dist[i] = 999;
			sptSet[i] = false;
		}


		dist[src] = 0;


		int u = minDistance(dist, sptSet);

		sptSet[u] = true;

		for (int v = 0; v < V; v++)

			if (!sptSet[v] && graph[u][v] != 0 &&
			dist[u] + graph[u][v] < dist[v])
			{
				parent[v]  = u;
				dist[v] = dist[u] + graph[u][v];
			}  

		printSolution(dist, V, parent,arr);




	}
	
	public static double getTotal()
	{
		return total;
	}
	public static void main(String[] args)
	{
		//0= CVB
		//1=McQuarrie Hall
		//2=Sweeney Hall
		//3= Health Bulding
		//4=Bricks
		//5=CVC
		//6=CVA
		//7=Student Union
		//8=Clark Hall
		//9=Library
		//10=Business Building
		//11=Duncan Hall
		//12=old Science
		//13=washington square hall
		//14=yoshida uchida hall
		//15 Engineering

		double graph[][] = 
			{
					{0,0.27,0.22,0.23,0.15,0.04,0.05,0.21,0.3,0.42, 0.18,0.31,0.39,0.38,0.37,0.26},//cvb start
					{0.27,0,0.04,0.09,0.12,0.27,0.23,0.2,0.19,0.21,0.29,0.22,0.18,0.14,0.1,0.16},//mcq
					{0.23,0.04,0,0.06,0.07,0.22,0.18,0.16,0.16,0.22,0.23,0.18,0.19,0.17,0.14,0.13,},//sweeney
					{0.23,0.08,0.06,0,0.08,0.2,0.17,0.11,0.12,0.20,0.20,0.13,0.17,0.15,0.16,0.07},//health
					{0.17,0.11,0.07,0.07,0,0.16,0.12,0.15,0.18,0.27,0.19,0.21,0.23,0.21,0.18,0.1},//bricks
					{0.07,0.23,0.19,0.18,0.11,0,0.04,0.2,0.25,0.36,0.13,0.22,0.34,0.33,0.33,0.14},//cvc
					{0.06,0.27,0.23,0.22,0.15,0,0.06,0.21,0.27,0.39,0.12,0.26,0.38,0.36,0.36,0.17},//cva
					{0.25,0.21,0.18,0.11,0.15,0.17,0.19,0,0.09,0.22,0.12,0.05,0.22,0.22,0.24,0.06},//student union
					{0.32,0.19,0.16,0.11,0.18,0.24,0.27,0.05,0,0.15,0.2,0.04,0.16,0.15,0.17,0.1},//clark
					{0.43,0.20,0.21,0.19,0.27,0.36,0.39,0.21,0.12,0,0.33,0.23,0.06,0.09,0.12,0.20},//library
					{0.19,0.29,0.26,0.2,0.19,0.12,0.13,0.13,0.21,0.33,0,34,0.34,0.35,0.35,0.15},//business building
					{0.24,0.05,0.04,0.1,0.09,0.24,0.21,0.21,0.22,0.25,0.28,0,0.21,0.18,0.16,0.21},//duncan
					{0.4,0.16,0.18,0.16,0.24,0.34,0.37,0.18,0.14,0.05,0.33,0.21,0,0.04,0.07,0.21},//old science
					{0.38,0.12,0.16,0.14,0.21,0.32,0.36,0.2,0.15,0.08,0.33,0.18,0.02,0,0.04,0.2},//wsq
					{0.38,0.11,0.15,0.15,0.2,0.33,0.37,0.22,0.19,0.13,0.35,0.16,0.08,0.05,0,0.26},//yoshida
					{0.26,0.16,0.13,0.07,0.1,0.14,0.17,0.06,0.1,0.2,0.15,0.21,0.21,0.2,0.26,0}//engineering

			};

		ArrayList<Integer> schedule = new ArrayList<Integer>();
		schedule.add(1);
		schedule.add(7);
		schedule.add(3);
		schedule.add(9);

		for(int i=0; i <schedule.size(); i++)
		{
			dijkstra(graph, schedule.get(i),schedule);//A=0, B=1, C=2 etc	
		}
		
		System.out.println("\nTotal walk length: " + getTotal()) ;
	}

}