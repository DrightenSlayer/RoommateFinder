import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * The student class is the backbone of the roommate finder.
 * It hosts all the properties and methods required
 * of a single user's profile.
 * 
 * @author Matt
 *
 */
public class Student implements Comparable<Student>
{
	/*properties that will be static in nature can be enumerate (e. g. "English == 0"
	 * properties that are changing, e. g. a student's school (which is an object itself)
	 * should be stored herein as a pointer.*/
	/*
	 * Additionally, name and key (password decryption) are stored outside the properties field,
	 * although we could change this.
	 */
	private String name;
	private int key;
	private School school;

	private String major;
	private String language;


	private static final int PROPCOUNT = 6;

	/*
	 * I tried using Enums for this, but Java's enums apparently don't work like C++'s.
	 */
	private static final int AGE = 0;
	private static final int GENDER = 1;
	private static final int LANGUAGE = 2;
	private static final int MAJOR = 3;
	private static final int SLEEP = 4;
	private static final int WAKE = 5;

	private int[] properties = new int[PROPCOUNT];
	private ArrayList<String> propFromFile;

	public Student(){}


	public void setKey(int key){this.key = key;}
	public int getKey(){return key;}



//	public static Student generate()
//	{
//		int nameLength = (int) ((100 * Math.random()) % 11) + 4;
//		String name = "";
//		name += (char) (65 + ((int)(10*Math.random())%25));
//		for(int i = 0; i < nameLength; i++)
//		{
//			name += (char) (97 + (((int)((100*Math.random())))%25));
//		}
//		String name2 = ""; String name3 = "";
//		if((int)(Math.random()*10) >= 3)
//		{
//			int index = ((int) (Math.random()*10) % name.length());
//			if(index == 0) index = name.length()/2;
//			name2 = name.substring(0, index);
//			name3 = name.substring(index);
//			name = name2 + " " + name3;
//		}
//		int[] p = new int[PROPCOUNT];
//		for(int i = 0; i < PROPCOUNT; i++)
//		{
//				p[i] = (int) (10*Math.random());
//		};
//		return new Student(name, p);
//	}
	
	public Queue<Student> matches(){return matches(this.school);}

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
	 * @param p
	 */
	public Student(String name, int[] p)
	{
		this.name = name;
		if(p.length != PROPCOUNT) throw new IllegalArgumentException();
		for(int i = 0; i < PROPCOUNT; i++) properties[i] = p[i];
	}

	public boolean completeProfile()
	{
		for(int i = 0; i != PROPCOUNT; ++i) if(properties[i] == 0) return false;
		return name != null;
	}

	public String getName() {return name;}
	public School getSchool(){return school;}

	public int getAge(){return properties[AGE];}

	public String getGender()
	{
		switch(properties[GENDER])
		{
		case 1: return "male";
		case 2: return "female";
		case 3: return "other";
		case 4: return "choose not to identify";
		default: return "";
		}
	}

	public String getLanguage()
	{
		switch(properties[LANGUAGE])
		{
		case 0: return "no preference";
		case 1: return language;
		default: return "";
		}
	}

	public String getMajor()
	{
		switch(properties[MAJOR])
		{
		case 0: return "un-declared";
		case 1: return major;
		default: return "";
		}
	}

	public String getSleep()
	{	
		switch(properties[SLEEP])
		{
		case 1: return "early";
		case 2: return "late";
		case 3: return "no preference";
		default: return "";
		}
	}

	public String getWake()
	{
		switch(properties[WAKE])
		{
		case 1: return "early";
		case 2: return "late";
		case 3: return "no preference";
		default: return "";
		}
	}

	public void setName(String name) {this.name = name;}

	public void setSchool(School school)
	{
		if(this.school != null) this.school.remove(this);
		this.school = school;
	}

	public void setAge(int a) {properties[AGE] = a;}

	public void setGender(String g)
	{
		switch(g)
		{
		case "male": properties[GENDER] = 1; break;
		case "female": properties[GENDER] = 2; break;
		case "other": properties[GENDER] = 3; break;
		case "choose not to identify": properties[GENDER] = 4; break;
		default: properties[GENDER] = 0; break;
		}
	}

	public void setLanguage(String l)
	{
		language = l;

		if (language.equals("none"))
			properties[LANGUAGE] = 0;
		else
			properties[LANGUAGE] = 1;
	}

	public void setMajor(String m)
	{
		major = m;

		if (major.equals("none"))
			properties[MAJOR] = 0;
		else
			properties[MAJOR] = 1;		
	}

	public void setSleep(String s)
	{
		switch(s)
		{
		case "early": properties[SLEEP] = 1; break;
		case "late": properties[SLEEP] = 2; break;
		case "no preference": properties[SLEEP] = 3; break;
		default: properties[SLEEP] = 0; break;
		}
		//		properties[SLEEP] = s;
	}

	public void setWake(String w) 
	{
		switch(w)
		{
		case "early": properties[WAKE] = 1; break;
		case "late": properties[WAKE] = 2; break;
		case "no preference": properties[WAKE] = 3; break;
		default: properties[WAKE] = 0; break;			
		}
		//		properties[WAKE] = w;
	}

	@Override
	public int compareTo(Student other)
	{
		int c = 0;
		for(int i = 0; i < PROPCOUNT; i++)
		{
			if(properties[i] == other.properties[i]) c++;
		}
		return c;
	}

	private void readFromFile() {
		propFromFile = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("StudentInfo.txt"))) {

			String line;
			while ((line = br.readLine()) != null) {
				propFromFile.add(line);
			}
		} catch (IOException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}

		for (int i = 0; i < propFromFile.size(); i++){
			System.out.println(i + ". " + propFromFile.get(i));
		}
	}

	public static void main(String[] args){
		Student x = new Student();
		x.readFromFile();
	}
}
