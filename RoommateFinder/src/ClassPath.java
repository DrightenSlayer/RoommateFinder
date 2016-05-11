import java.util.ArrayList;

/**
 * This class is used to calculate the minimum distance from
 * one building to another, in order to find the most efficient path.
 */
public class ClassPath 
{
	private static final int V = 16;
	private static int temp;
	private static int track=0;
	private static int heading=0;
	private static double total=0;
	public static String str = "";
	public static int messageCount = 0;

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

	public static boolean valid(ArrayList<Integer> arr) {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) < 0 || arr.get(i) > V - 1)
				return false;
		}
		return true;
	}
	
	/**
	 * Copies the array list
	 * @param temp the temporary array list
	 */
	public ClassPath(ArrayList<Integer> temp)
	{
		classes = temp;
	}
	
	/**
	 * Inserts class building into the array list
	 * @param buildingNumber the building you are going to
	 */
	public static void insert(int buildingNumber)
	{
		classes.add(buildingNumber);
	}

	/**
	 * Finds the distance between buildings and overwrites if shorter
	 * @param dist keeps minimum distance from each building
	 * @param sptSet checks if a building has been visited already
	 * @return the minimum index
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
	 * Prints the shortest path to a specified building.
	 * @param parent the list of vertices we pass to get shortest distance
	 * @param j the spot in the array containing vertex number
	 * @return the path
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
	 * Formats and prints out a table containing paths and costs,
	 * also gets total distance for the schedule.
	 * @param dist the shortest distance to each location
	 * @param n number of vertices
	 * @param parent array containing path
	 * @param arr list of buildings user needs to go to
	 * @return the path result
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
	 * Sets the values with default values before start.
	 * Gets the minimum distance and overwrites if smaller than one already in parent.
	 * If the input array is invalid (> 15 or < 0) it returns an error message.
	 * Calls printSolution at the end.
	 * @param graph the adjacency matrix
	 * @param start the start location
	 * @param arr the list of buildings that the order must follow
	 * @return the solution string
	 */
	static String dijkstra(double graph[][], int start, ArrayList<Integer> arr)
	{
		if (!valid(arr)) {
			if (messageCount == 0) {
				return "Invalid schedule input";
			}
			return "";
		}

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
	 * Converts the building number into an abbreviated version of the
	 * building name.
	 * @param i the building number
	 * @return the abbreviated version of the building name
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
	 * Gets the total journey distance.
	 * @return the total distance for the user's pathway
	 */
	static String getTotal()
	{
		return "\nTotal walk length: " + total;
	}

	/**
	 * Resets the values so the user can start again.
	 */
	static void reset()
	{
		str = "";
		track = 0;
		total = 0;
	}
}

