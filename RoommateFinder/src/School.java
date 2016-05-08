import java.util.*;

/**
 * This class houses the student objects at two levels: school and building.
 * The building class is found at the end, nested within the school class.
 * @author Matt
 *
 */
public class School
{
	private String name;
	private List<Building> buildings;
	
	/**
	 * Each school has a name; however, the name is not really used for anything.
	 * Buildings are stored in a list for the sake of chronological retrieval.
	 * @param name
	 */
	public School(String name)
	{
		this.name = name;
		buildings = new ArrayList<Building>();
	}
	/**
	 * Check if the school has a certain student in it.
	 * This works by iterating through all of the associated buildings to find a match.
	 * This method is O(n) by itself, but O(n^2) including the method it calls.
	 * @param student The student to be searched for.
	 * @return
	 */
	public boolean contains(Student student)
	{
		for(Building building : buildings) if(building.contains(student)) return true;
		return false;
	}
	/**
	 * Add a building to the school by placing it in the list of buildings.
	 * @param building the building to be added.
	 * @return success of adding building
	 */
	public boolean add(Building building){return buildings.add(building);}
	
	/**
	 * Add a student to a specified building within the school.
	 * If the building is not within the school, an exception is thrown.
	 * @param student The student to add to the building
	 * @param building The building within the school
	 * @return The success of adding student to building
	 */
	public boolean add(Student student, Building building)
	{
		if(!buildings.contains(building)) throw new IllegalArgumentException();
		student.setSchool(this);
		return building.add(student);
	}
	/**
	 * Add a student to a building within the school
	 * based on the index of the building in the school's list of buildings.
	 * @param student The student to add to the building
	 * @param buildingIndex The index of the building within the school.
	 * @return The success of adding the student,
	 */
	public boolean add(Student student, int buildingIndex)
	{
		if(buildings.get(buildingIndex) == null) throw new IllegalArgumentException();
		student.setSchool(this);
		return buildings.get(buildingIndex).add(student);
	}
	/**
	 * This is the easy way of adding a student to a school.
	 * This will add the student to the first available building in the list.
	 * @param student The student to be added.
	 * @return The success of adding the student.
	 */
	public boolean add(Student student)
	{
		for(Building building: buildings)
		{
			if(building.add(student))
			{
				student.setSchool(this);
				return true;
			}
		}
		return false;
	}
	
	public boolean remove(Student student)
	{
		for(Building building : buildings) if(building.remove(student)) return true;
		return false;
	}
	
	
	public String getName() {return name;}
	public Set<Student> getStudents()
	{
		Set<Student> students = new HashSet<Student>();
		for(Building building : buildings) students.addAll(building.getStudents());
		return students;
	}
	
	public static class Building
	{
		private String name;
		int capacity;
		private Set<Student> students;
		
		public Building(String name, int capacity)
		{
			this.name = name;
			this.capacity = capacity;
			students = new HashSet<Student>();
		}
		
		public boolean add(Student student)
		{
			if(students.size()+1 > capacity) return false;
			return students.add(student);
		}
		
		public Set<Student> getStudents(){return students;}
		public boolean contains(Student student) {return students.contains(student);}
		public boolean remove(Student student) {return students.remove(student);}
		
		public String getName(){return name;}
	}
}
