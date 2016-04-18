import java.util.Scanner;





public class SignUp 
{
	private Student student;
	private School university;
	private String name;
	private int key;
	private School school;
	private int age;
	
	private String major;
	private String language;
	private String gender;
	private String sleepTime;
	private String wakeTime;
	private String schoolName;
	
	public SignUp()
	{
		student = new Student();
		
	}
	public void readIn()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter name: ");
		name= input.next();
		
		System.out.println("Enter gender: ");
		gender= input.next();
		
		System.out.println("Enter age: ");
		gender= input.next();
		
		System.out.println("Major: ");
		major=input.next();
		
		System.out.println("Language: ");
		language = input.next();
		
		System.out.println("Sleep time: ");
		sleepTime = input.next();
		
		System.out.println("Wake time: ");
		wakeTime = input.next();
		
		System.out.println("School: ");
		schoolName = input.next();
		
		student.setAge(age);
		student.setGender(gender);
		student.setLanguage(language);
		student.setMajor(major);
		student.setName(name);
		
		university = new School(schoolName);
		student.setSchool(university);
		
		student.setSleep(sleepTime);
		student.setWake(wakeTime);
		
	
	
		//idk ask for help from matthew
		School.Building tempDorm =new School.Building("temporary dorm");
		School.Building.Room h1= new School.Building.Room(2);
		tempDorm.add(h1, student);
		
	
		
	}
}
