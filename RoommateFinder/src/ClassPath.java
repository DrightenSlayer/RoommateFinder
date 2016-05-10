import java.util.ArrayList;

/**
 * calculates the minimum distance to each class 
 * to find shortest, efficient path
 */
public class ClassPath 
{
	private static final int V = 16;
	private static int temp;
	private static int track=0;
	private static int heading=0;
	private static double total=0;
	public static String str = "";

	static double graph[][] =
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
	static ArrayList<Integer> classes;
	
	/**
	 * copy array list for class functions
	 * @param temp the temporary array list
	 */
	public ClassPath(ArrayList<Integer> temp)
	{
		classes = temp;
	}
	
	/**
	 * inserts class building into array list
	 * @param buildingNumber the building you are going to
	 */
	public static void insert(int buildingNumber)
	{
		classes.add(buildingNumber);
	}

	/**
	 * finds the distance between buildings and overwrites if shorter
	 * @param dist keeps minimum distance from each building
	 * @param sptSet checks if we visited building yet
	 * @return
	 */
	public static int minDistance(double dist[], boolean sptSet[])
	{

		double min = 999;
		int min_index = -1;

		for (int v = 0; v < V; v++)
			if (!sptSet[v] && dist[v] <= min)
			{
				min = dist[v];
				min_index = v;
			}
		return min_index;
	}

	/**
	 * prints the shortest path to building
	 * @param parent the list of vertices we pass to get shortest distance
	 * @param j the spot in the array containing vertex number
	 * @return string containing path
	 */
	private static String printPath(int parent[], int j)
	{
		if (parent[j] == -1)
		{
			return"";	
		}
		printPath(parent, parent[j]);
		return "" + j;
	}

	/**
	 * formats and prints out a table containing paths and costs
	 * also gets total distance for schedule
	 * @param dist the shortest distance to each location
	 * @param n number of vertices
	 * @param parent array containing path
	 * @param arr list of buildings student needs to go to, in order
	 * @return string version of result
	 */
	private static String printSolution(double[] dist, int n, int[] parent,ArrayList<Integer> arr)
	{
		String error = "";
		String result = "";
		int start = temp;
		String top = "";

		for (int i = 0; i <= V && ((track + 1)<arr.size()); i++)
		{
			if( arr.get(track + 1) == i)
			{
				if(dist[i] == 999)
				{
					error = "no path";
				}
				else
				{
					error= "" + temp;
				}
				for(int k = 0; k <arr.size(); k++)
				{
					result = convertToName(temp)+" -> " + convertToName(i)+"		   "+ dist[i]+"			   " ;
					total = total+ dist[i];
					if(error.equals("no path"))
					{
						continue;
					}
					else
					{
						str = printPath(parent, i);
					}
					break;
				}
			}
		}
		track++;
		result = top + "\n" + result + " ";
		return result;
	}

	/**
	 * sets the values with default values before start
	 * gets the minimum distance and overwrites if smaller than one already in parent
	 * after finish, calls printSolution
	 * @param graph the adjacency matrix
	 * @param start where to start
	 * @param arr list of building order must follow
	 * @return returnResult the solution string
	 */
	static String dijkstra(double graph[][], int start, ArrayList<Integer>arr)
	{
		temp = start;
		double[] dist = new double[V];
		boolean[] sptSet = new boolean[V];
		int[] parent = new int[V];

		for (int i = 0; i < V; i++)
		{
			parent[i] = -1;
			dist[i] = 999;
			sptSet[i] = false;
		}

		dist[start] = 0;
		int u = minDistance(dist, sptSet);
		sptSet[u] = true;

		for (int v = 0; v < V; v++)
			if (!sptSet[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v])
			{
				parent[v]  = u;
				dist[v] = dist[u] + graph[u][v];
			}
		String returnResult = printSolution(dist, V, parent,arr);
		return returnResult;
	}

	/**
	 * converts int into a string value
	 * @param i the building number
	 * @return string with building name equivalent
	 */
	private static String convertToName(int i) {
		switch (i) {
			case 0  : return "CVB";
			case 1  : return "MQH";
			case 2  : return "SH";
			case 3  : return "SWC";
			case 4  : return "HOV";
			case 5  : return "CVC";
			case 6  : return "CVA";
			case 7  : return "SU";
			case 8  : return "CL";
			case 9  : return "King";
			case 10 : return "BBC";
			case 11 : return "DH";
			case 12 : return "SCI";
			case 13 : return "WSQ";
			case 14 : return "YUH";
			case 15 : return "ENG";
			default : return "Didn't work";
		}
	}

	/**
	 * gets the total journey distance
	 * @return total, the distance for your schedule
	 */
	static String getTotal()
	{
		return "\nTotal walk length: " + total;
	}
	
	static void reset()
	{
		str = "";
		track = 0;
		total = 0;
	}

	/**
	 * tester class
	 * @param args
	 */
	public static void main(String[] args)
	{
		ArrayList<Integer> schedule = new ArrayList<Integer>();
		schedule.add(1);
		schedule.add(7);
		schedule.add(3);
		schedule.add(9);

		for(int i=0; i <schedule.size(); i++)
		{
			System.out.println(dijkstra(graph, schedule.get(i),schedule));//A=0, B=1, C=2 etc
		}
	System.out.println(getTotal());
	}
}

