import java.io.BufferedReader;
import java.io.File;
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


	public void setKey(int key){this.key = key;}
	public int getKey(){return key;}



		public static Student generate()
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
	public void setName(String name) {this.name = name;}
	public School getSchool(){return school;}
	public void setSchool(School school)
	{
		if(this.school != null) this.school.remove(this);
		this.school = school;
	}

	/*
	 * PROPERTIES SWITCH STATEMENTS
	 */
	public String getLanguage() //prop1
	{
		switch(properties[LANGUAGE])
		{
		case 1: return "english";
		case 2: return "farsi";
		case 3: return "japanese";
		case 4: return "chinese";
		case 5: return "vietnamese";
		case 6: return "russian";
		default: return "no preference";
		}
	}

	public String getGender() //prop 2
	{
		switch(properties[GENDER])
		{
		case 1: return "male";
		case 2: return "female";
		case 3: return "other";
		default: return "choose not to identify";
		}
	}

	public String getMajor() // prop 3
	{
		switch(properties[MAJOR])
		{
		case 1: return "computer Science";
		case 2: return "engineering";
		case 3: return "art";
		case 4: return "underwater Basket Weaving";
		case 5: return "undeclared";
		default: return "";
		}
	}

	public String getYear() //prop 4
	{
		switch(properties[YEAR])
		{
		case 1: return "freshman";
		case 2: return "sophomore";
		case 3: return "junior";
		default: return "senior";
		}
	}

	public String getSleep() //prop5
	{	
		switch(properties[SLEEP])
		{
		case 1: return "early";
		case 2: return "late";
		default: return "no preference";
		}
	}

	public String getWake() //prop6
	{
		switch(properties[WAKE])
		{
		case 1: return "early";
		case 2: return "late";
		default: return "no preference";
		}
	}

	public String getPreferences() //prop7
	{
		switch(properties[PREFERENCES])
		{
		case 1: return "quiet";
		case 2: return "lively";
		default: return "no preference";
		}
	}

	public String getPrice() //prop8
	{
		switch(properties[PREFERENCES])
		{
		case 1: return "low";
		case 2: return "high";
		case 3: return "> 9000!";
		default: return "mid";
		}
	}

	public String getKitchen() //prop9
	{
		switch(properties[KITCHEN])
		{
		case 1: return "yes";
		case 2: return "no";
		default: return "no preference";
		}
	}

	public String getShower() //prop10
	{
		switch(properties[SHOWER])
		{
		case 1: return "yes";
		default: return "no";
		}
	}

	public String getWash_Dry() //prop11
	{
		switch(properties[WASH_DRY])
		{
		case 1: return "yes";
		default: return "no";
		}
	}

	public String getFloor() //prop12
	{
		switch(properties[FLOOR])
		{
		case 1: return "upper";
		case 2: return "lower";
		default: return "mid";
		}
	}
	public String getLight() //prop13
	{
		switch(properties[LIGHT])
		{
		case 1: return "dark";
		case 2: return "light";
		default: return "no preference";
		}
	}
	public String getBunk() //prop14
	{
		switch(properties[BUNK])
		{
		case 1: return "upper";
		case 2: return "lower";
		case 3: return "Wu Zetian";
		default: return "no";
		}
	}

	public void setProp(int i, String v)
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

	public void setLanguage(String l) //prop1
	{
		switch(l)
		{
		case "english" : properties[LANGUAGE] = 1; break;
		case "farsi" : properties[LANGUAGE] = 2; break;
		case "japanese" : properties[LANGUAGE] = 3; break;
		case "chinese" : properties[LANGUAGE] = 4; break;
		case "vietnamese" : properties[LANGUAGE] = 5; break;
		case "russian" : properties[LANGUAGE] = 6; break;
		default : properties[LANGUAGE] = 0; break;
		}
	}

	public void setGender(String g) //prop2
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

	public void setMajor(String m) //prop3
	{
		switch(m)
		{
		case "computer Science" : properties[MAJOR] = 1; break;
		case "engineering" : properties[MAJOR] = 2; break;
		case "art" : properties[MAJOR] = 3; break;
		case "underwater Basket Weaving" : properties[MAJOR] = 4; break;
		case "undeclared" : properties[MAJOR] = 5; break;
		default : properties[MAJOR] = 0; break;
		}	
	}

	public void setYear(String y) //prop 4
	{
		switch(y)
		{
		case "freshman": properties[YEAR] = 1; break;
		case "sophomore": properties[YEAR] = 2; break;
		case "junior": properties[YEAR] = 3; break;
		default: properties[YEAR] = 0; break;
		}
	}

	public void setSleep(String s) //prop5
	{
		switch(s)
		{
		case "early": properties[SLEEP] = 1; break;
		case "late": properties[SLEEP] = 2; break;
		default : properties[SLEEP] = 0; break;
		}
	}

	public void setWake(String w) //prop6
	{
		switch(w)
		{
		case "early": properties[WAKE] = 1; break;
		case "late": properties[WAKE] = 2; break;
		default: properties[WAKE] = 0; break;			
		}
	}

	public void setPreferences(String p) //prop7
	{
		switch(p)
		{
		case "lively": properties[WAKE] = 1; break;
		case "quiet": properties[WAKE] = 2; break;
		default: properties[WAKE] = 0; break;			
		}
	}

	public void setPrice(String p) //prop8
	{
		switch(p)
		{
		case "low" : properties[PRICE] = 1; break;
		case "high" : properties[PRICE] = 2; break;
		case "< 9000!" : properties[PRICE] = 3; break;
		default : properties[PRICE] = 0; break;
		}
	}

	public void setKitchen(String k) //prop9
	{
		switch(k)
		{
		case "yes": properties[KITCHEN] = 1; break;
		case "no" : properties[KITCHEN] = 2; break;
		default: properties[KITCHEN] = 0; break;
		}
	}

	public void setShower(String s) //prop10
	{
		switch(s)
		{
		case "yes": properties[SHOWER] = 1; break;
		default: properties[SHOWER] = 0; break;
		}
	}

	public void setWash_Dry(String w) //prop11
	{
		switch(w)
		{
		case "yes": properties[WASH_DRY] = 1; break;
		default: properties[WASH_DRY] = 0; break;
		}
	}

	public void setFloor(String f) //prop12
	{
		switch(f)
		{
		case "upper": properties[FLOOR] = 1; break;
		case "lower": properties[FLOOR] = 2; break;
		default: properties[FLOOR] = 0; break;
		}
	}

	public void setLight(String l) //prop13
	{
		switch(l)
		{
		case "dark": properties[LIGHT] = 1; break;
		case "light" : properties[LIGHT] = 2; break;
		default: properties[FLOOR] = 0; break;
		}
	}

	public void setBunk(String b) //prop14
	{
		switch(b)
		{
		case "upper": properties[BUNK] = 1; break;
		case "lower" : properties[BUNK] = 2; break;
		case "Wu Zetian": properties[BUNK] = 3; break;
		default: properties[BUNK] = 0; break;
		}
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

	public static List<Student> readFile()
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
						props.add(line.toLowerCase());
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

	public static void main(String[] args)
	{
		Student me = null;
		String username = "Wu Zetian";
		List<Student> students = Student.readFile();
		for(Student student : students)
		{
			System.out.println(student.getName() + "\t" + student.getLanguage() + "\t" + student.getGender());
			if(student.getName().equals(username)) me = student;
		}
		System.out.println(me.getName() + "\t" + me.getLanguage() + "\t" + me.getGender());
	}
}
