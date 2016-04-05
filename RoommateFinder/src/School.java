import java.util.*;


public class School
{
	private String name;
	private Set<Building> buildings;
	
	public static class Building implements Comparable<Building>
	{
		private String name;
		private Set<Room> rooms;
		
		public static class Room implements Comparable<Room>
		{
			private int capacity;
			public Room(int capactity)
			{
				this.capacity = capactity;
				students = new HashSet<Student>();
			}
			private Set<Student> students;
			public int compareTo(School.Building.Room other)
			{
				return 0;
			}
			public boolean contains(Student student)
			{
				for(Student s : students) if(s == student) return true;
				return false;
			}
			public boolean add(Student student)
			{
				if(students.size()+1 > capacity) return false;
				return students.add(student);
			}
			
			public boolean remove(Student student) {return students.remove(student);}
		}
		public boolean contains(Student student)
		{
			return rooms.contains(student);
		}
		
		public Building(String name)
		{
			this.name = name;
			rooms = new HashSet<Room>();
		}
		
		public boolean add(Room room)
		{
			if(rooms.contains(room)) return false;
			rooms.add(room);
			return true;
		}
		
		public boolean add(Room room, Student student)
		{
			if(!rooms.contains(room)) throw new IllegalArgumentException();
			for(Room r : rooms) if(r.contains(student)) return false;
			room.add(student); //all rooms must be checked, so this return value is not useful
			return true;
		}
		
		public boolean remove(Student student)
		{
			for(Room room : rooms) if(room.remove(student)) return true;
			return false;
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
	
	public boolean contains(Student student)
	{
		for(Building building : buildings) if(building.contains(student)) return true;
		return false;
	}
	
	public boolean add(Building building){ return buildings.add(building);}
	public boolean add(Student student, Building building, Building.Room room)
	{
		if(!buildings.contains(building)) throw new IllegalArgumentException();
		return building.add(room, student);
	}
	
	public boolean remove(Student student)
	{
		for(Building building : buildings) if(building.remove(student)) return true;
		return false;
	}
	
	
	public String getName() {return name;}
	
}
