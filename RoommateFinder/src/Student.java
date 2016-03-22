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
	private String name;
	public static final int PROPCOUNT = 8;
	
	/*
	 * I tried using Enums for this, but Java's enums apprently don't work like C++'s.
	 */
	public static final int SCHOOL = 1;
	public static final int AGE = 2;
	public static final int GENDER = 3;
	public static final int LANGUAGE = 4;
	public static final int MAJOR = 5;
	public static final int SLEEP = 6;
	public static final int WAKE = 7;
	
	private ArrayList<Student> matches;
	
	private int[] properties = new int[PROPCOUNT];
	
	public Student(){}
	
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
	public String getSchool()
	{
		switch (properties[SCHOOL])
		{
			case 1: return "San Jose State University";
			case 2: return "University of California Los Angeles";
			default: return "";
		}
			
	}
	
	public int getAge(){return properties[2];}
	
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
	
	public String getLanguage(){return null;}
	public String getMajor(){return null;}
	
	public int getSleep(){return properties[SLEEP];}
	public int getWake(){return properties[WAKE];}
	
	public void setName(String name) {this.name = name;}
	
	public void setSchool(String s)
	{
		switch (s)
		{
			case "San Jose State University": properties[SCHOOL] = 1; break;
			case "University of California Los Angeles": properties[SCHOOL] = 2; break;
			default: properties[SCHOOL] = 0; break;
		}
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
	
	public void setSleep(int s){properties[SLEEP] = s;}
	public void setWake(int w) {properties[WAKE] = w;}

	@Override
	public int compareTo(Student arg0)
	{
		return name.compareTo(arg0.getName());
	}
	
}
