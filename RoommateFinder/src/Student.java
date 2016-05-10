import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * The student class is the backbone of the roommate finder.
 * It hosts the methods and properties of a user and other students
 */
public class Student implements Comparable<Student>
{
	private String name;
	private School school;
	private String major;
	
	private static final int PROPCOUNT = 14;

	private static final int LANGUAGE = 0;
	private static final int GENDER = 1;
	private static final int MAJOR = 2;
	private static final int YEAR = 3;
	private static final int SLEEP = 4;
	private static final int WAKE = 5;
	private static final int PREFERENCES = 6;
	private static final int PRICE = 7;
	private static final int KITCHEN = 8;
	private static final int SHOWER = 9;
	private static final int WASH_DRY = 10;
	private static final int FLOOR = 11;
	private static final int LIGHT = 12;
	private static final int BUNK = 13;

	private int[] properties = new int[PROPCOUNT];

	public Student(){}

	/**
	 * Creates a random student.  This was used for testing purposes
	 * but not used in the final code.
 	 * @return the random student that was created
     */
	static Student generate()
	{
		int nameLength = (int) ((100 * Math.random()) % 11) + 4;
		String name = "";
		name += (char) (65 + ((int)(10*Math.random())%25));
		for(int i = 0; i < nameLength; i++)
		{
			name += (char) (97 + (((int)((100*Math.random())))%25));
		}
		String name2 = ""; String name3 = "";
		if((int)(Math.random()*10) >= 3)
		{
			int index = ((int) (Math.random()*10) % name.length());
			if(index == 0) index = name.length()/2;
			name2 = name.substring(0, index);
			name3 = name.substring(index);
			name = name2 + " " + name3;
		}
		int[] p = new int[PROPCOUNT];
		for(int i = 0; i < PROPCOUNT; i++)
		{
				p[i] = (int) (10*Math.random());
		};
		return new Student(name, p);
	}

	Queue<Student> matches(){return matches(this.school);}

	/**
	 * Creates a list of matches, based on how many
	 * attributes of another student match the attributes
	 * of the user.
	 * The queue is ordered from high to low.
	 * @param school the name of the school that students are housed in
	 * @return the queue of matches.
     */
	private Queue<Student> matches(School school)
	{
		Set<Student> others = school.getStudents();
		others.remove(this);
		Map<Student, Integer> matchMap = new HashMap<>();
		for(Student other : others)
		{
			matchMap.put(other, compareTo(other));
		}
		Queue<Student> matches = new LinkedList<>();
		while(!matchMap.isEmpty())
		{
			Student most = null;
			for(Student key : matchMap.keySet())
			{
				if(most == null) most = key;
				else
				{
					if(matchMap.get(key) > matchMap.get(most)) most = key;
				}
			}
			matches.add(most);
			matchMap.remove(most);
		}
		return matches;
	}

	/**
	 * This constructor is to be used if one knows the numeric codes for all student properties.
	 * Add those codes in an array placed into the constructor, and the student will be quickly generated.
	 * @param p the properties of the student.
	 */
	public Student(String name, int[] p)
	{
		this.name = name;
		if(p.length != PROPCOUNT) throw new IllegalArgumentException();
		for(int i = 0; i < PROPCOUNT; i++) properties[i] = p[i];
	}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	School getSchool(){return school;}

	void setSchool(School school)
	{
		if(this.school != null) this.school.remove(this);
		this.school = school;
	}

	/*
	 * The following are switch statements for the properties.
	 * The get and set methods will do just that for each property.
	 */

	String getLanguage() //Property 1
	{
		switch(properties[LANGUAGE])
		{
		case 1: return "English";
		case 2: return "Farsi";
		case 3: return "Japanese";
		case 4: return "Chinese";
		case 5: return "Vietnamese";
		case 6: return "Russian";
		default: return "English";
		}
	}

	String getGender() //Property 2
	{
		switch(properties[GENDER])
		{
		case 1: return "Male";
		case 2: return "Female";
		case 3: return "Other";
		default: return "Not Identify";
		}
	}

	String getMajor() //Property 3
	{
		switch(properties[MAJOR])
		{
		case 0: return "Undeclared";
		default: return major;
		}
	}

	String getYear() //Property 4
	{
		switch(properties[YEAR])
		{
		case 1: return "Freshman";
		case 2: return "Sophomore";
		case 3: return "Junior";
		case 4: return "Senior";
		case 5: return "Graduate student";
		default: return "Freshman";
		}
	}

	String getSleep() //Property 5
	{	
		switch(properties[SLEEP])
		{
		case 1: return "Early";
		case 2: return "Late";
		default: return "No preference";
		}
	}

	String getWake() //Property 6
	{
		switch(properties[WAKE])
		{
		case 1: return "Early";
		case 2: return "Late";
		default: return "No preference";
		}
	}

	String getPreferences() //Property 7
	{
		switch(properties[PREFERENCES])
		{
		case 1: return "Quiet";
		case 2: return "Lively";
		default: return "No preference";
		}
	}

	String getPrice() //Property 8
	{
		switch(properties[PREFERENCES])
		{
		case 1: return "Low";
		case 2: return "High";
		default: return "No preference";
		}
	}

	String getKitchen() //Property 9
	{
		switch(properties[KITCHEN])
		{
		case 1: return "Yes";
		case 2: return "No";
		default: return "No preference";
		}
	}

	String getShower() //Property 10
	{
		switch(properties[SHOWER])
		{
		case 1: return "Yes";
		case 2: return "No";
		default: return "No preference";
		}
	}

	String getWash_Dry() //Property 11
	{
		switch(properties[WASH_DRY])
		{
		case 1: return "Yes";
		case 2: return "No";
		default: return "No preference";
		}
	}

	String getFloor() //Property 12
	{
		switch(properties[FLOOR])
		{
		case 1: return "Upper";
		case 2: return "Lower";
		default: return "No preference";
		}
	}

	String getLight() //Property 13
	{
		switch(properties[LIGHT])
		{
		case 1: return "Dark";
		case 2: return "Light";
		default: return "No preference";
		}
	}
	String getBunk() //Property 14
	{
		switch(properties[BUNK])
		{
		case 1: return "Upper";
		case 2: return "Lower";
		default: return "No preference";
		}
	}

	private void setProp(int i, String v)
	{
		switch(i)
		{
		case 0 : setLanguage(v); break;
		case 1 : setGender(v); break;
		case 2 : setMajor(v); break;
		case 3 : setYear(v); break;
		case 4 : setSleep(v); break;
		case 5 : setWake(v); break;
		case 6 : setPreferences(v); break;
		case 7 : setPrice(v); break;
		case 8 : setKitchen(v); break;
		case 9 : setShower(v); break;
		case 10 : setWash_Dry(v); break;
		case 11 : setFloor(v); break;
		case 12 : setLight(v); break;
		case 13 : setBunk(v); break;
		}
	}

	void setLanguage(String l) //Property 1
	{
		switch(l)
		{
		case "English" : properties[LANGUAGE] = 1; break;
		case "Farsi" : properties[LANGUAGE] = 2; break;
		case "Japanese" : properties[LANGUAGE] = 3; break;
		case "Chinese" : properties[LANGUAGE] = 4; break;
		case "Vietnamese" : properties[LANGUAGE] = 5; break;
		case "Russian" : properties[LANGUAGE] = 6; break;
		default : properties[LANGUAGE] = 0; break;
		}
	}

	void setGender(String g) //Property 2
	{
		switch(g)
		{
		case "Male": properties[GENDER] = 1; break;
		case "Female": properties[GENDER] = 2; break;
		case "Other": properties[GENDER] = 3; break;
		case "Not Identify": properties[GENDER] = 4; break;
		default: properties[GENDER] = 0; break;
		}
	}

	void setMajor(String m) //Property 3
	{
		switch(m)
		{
		case "Undeclared" : properties[MAJOR] = 0; break;
		default : major = m; properties[MAJOR] = 1; break;
		}	
	}

	void setYear(String y) //Property 4
	{
		switch(y)
		{
		case "Freshman": properties[YEAR] = 1; break;
		case "Sophomore": properties[YEAR] = 2; break;
		case "Junior": properties[YEAR] = 3; break;
		case "Senior": properties[YEAR] = 4; break;
		case "Graduate student": properties[YEAR] = 5; break;
		default: properties[YEAR] = 0; break;
		}
	}

	void setSleep(String s) //Property 5
	{
		switch(s)
		{
		case "Early": properties[SLEEP] = 1; break;
		case "Late": properties[SLEEP] = 2; break;
		default : properties[SLEEP] = 0; break;
		}
	}

	void setWake(String w) //Property 6
	{
		switch(w)
		{
		case "Early": properties[WAKE] = 1; break;
		case "Late": properties[WAKE] = 2; break;
		default: properties[WAKE] = 0; break;			
		}
	}

	void setPreferences(String p) //Property 7
	{
		switch(p)
		{
		case "Lively": properties[WAKE] = 1; break;
		case "Quiet": properties[WAKE] = 2; break;
		default: properties[WAKE] = 0; break;			
		}
	}

	void setPrice(String p) //Property 8
	{
		switch(p)
		{
		case "Low" : properties[PRICE] = 1; break;
		case "High" : properties[PRICE] = 2; break;
		default : properties[PRICE] = 0; break;
		}
	}

	void setKitchen(String k) //Property 9
	{
		switch(k)
		{
		case "Yes": properties[KITCHEN] = 1; break;
		case "No" : properties[KITCHEN] = 2; break;
		default: properties[KITCHEN] = 0; break;
		}
	}

	void setShower(String s) //Property 10
	{
		switch(s)
		{
		case "Yes": properties[SHOWER] = 1; break;
		case "No" : properties[SHOWER] = 2; break;
		default: properties[SHOWER] = 0; break;
		}
	}

	void setWash_Dry(String w) //Property 11
	{
		switch(w)
		{
		case "Yes": properties[WASH_DRY] = 1; break;
		case "No" : properties[WASH_DRY] = 2; break;
		default: properties[WASH_DRY] = 0; break;
		}
	}

	void setFloor(String f) //Property 12
	{
		switch(f)
		{
		case "Upper": properties[FLOOR] = 1; break;
		case "Lower": properties[FLOOR] = 2; break;
		default: properties[FLOOR] = 0; break;
		}
	}

	void setLight(String l) //Property 13
	{
		switch(l)
		{
		case "Dark": properties[LIGHT] = 1; break;
		case "Light" : properties[LIGHT] = 2; break;
		default: properties[FLOOR] = 0; break;
		}
	}

	void setBunk(String b) //Property 14
	{
		switch(b)
		{
		case "Upper": properties[BUNK] = 1; break;
		case "Lower" : properties[BUNK] = 2; break;
		default: properties[BUNK] = 0; break;
		}
	}

	/**
	 * Compares one student to another, in order to determine
	 * the ones with the highest matches.
	 * @param other the other student
	 * @return the number of matches between a student and the user
     */
	@Override
	public int compareTo(Student other)
	{
		int c = 0;
		for(int i = 0; i < PROPCOUNT; i = (i == 3) ? i+2 : i+1)
		{
			if(properties[i] == other.properties[i]) c++;
		}
		if(major.equals(other.major)) c++;
		return c;
	}

	/**
	 * Reads the list of saved students from the StudentInfo.txt file,
	 * which is where a student and a new user both get saved.
	 * Only looks within one school in order to not return
	 * students that can not room together.
	 * @return a complete list of students inside a school.
     */
	static List<Student> readFile()
	{
		List<Student> fromFile = new ArrayList<>();

		try(Scanner br = new Scanner(new File("StudentInfo.txt")))
		{
			while(br.hasNext())
			{
				String name = ""; String schoolName = null;
				ArrayList<String> props = new ArrayList<>();

				if(br.hasNextLine()) name = br.nextLine();
				if(br.hasNextLine()) schoolName = br.nextLine();
				
				while(br.hasNextLine())
				{
					String line = br.nextLine();
					if (!line.equals(""))
					{
						props.add(line);
					}
					else break;
				}
				Student temp = new Student(name, new int[PROPCOUNT]);
				temp.school = new School(schoolName);
				
				for(int s = 0; s < PROPCOUNT; s++)
				{
					temp.setProp(s, props.get(s));
				}
				fromFile.add(temp);
			}
		}
		catch (IOException e)
		{
			System.out.println("File not found.");
			e.printStackTrace();
		}
		return fromFile;
	}
}
