import java.util.*;

public class School
{
	private String name;
	private TreeSet<Building> buildings;
	
	public static class Building implements Comparable<Building>
	{
		private String name;
		private TreeSet<Student> students;
		private TreeSet<String> studentNames;
		public boolean search(String name){return students.contains(name);}
		
		public Building(String name)
		{
			this.name = name;
		}
		
		public boolean add(Student s)
		{
			if(students.contains(s)) return false;
			students.add(s);
			studentNames.add(s.getName());
			return true;
		}
		
		public String getName(){return name;}
		
		@Override
		public int compareTo(Building other)
		{
			return name.compareTo(other.getName());
		}
	}
	
	public School(String name)
	{
		this.name = name;
		buildings = new TreeSet<Building>();
	}
	
	public boolean add(Building name)
	{
		if(buildings.contains(name)) return false;
		buildings.add(name);
		return true;
	}
	
	public String getName() {return name;}
	
}
