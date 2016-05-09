import java.util.Scanner;

public class SignUp 
{
	public static void main (String args[])
	{
		Student student = new Student();
		String name= "";
		int age=0;
		String major="";
		String language="";
		String gender="";
		String sleepTime="";
		String wakeTime="";
		String schoolName="";




		Scanner input = new Scanner(System.in);

		System.out.print("Enter name: ");
		name= input.next();


		System.out.print("Enter gender: ");
		gender= input.next();


		System.out.print("Enter age: ");
		age= input.nextInt();



		System.out.print("Major: ");
		major=input.next();


		System.out.print("Language: ");
		language = input.next();


		System.out.print("Sleep time: ");
		sleepTime = input.next();


		System.out.print("Wake time: ");
		wakeTime = input.next();


		System.out.print("School: ");
		schoolName = input.next();

		input.close();


//		student.setAge(age);
		student.setGender(gender);
		student.setLanguage(language);
		student.setMajor(major);
		student.setName(name);

		School university = new School(schoolName);
		student.setSchool(university);

		student.setSleep(sleepTime);
		student.setWake(wakeTime);

		School.Building tempDorm =new School.Building("temporary dorm", 2);
		if(tempDorm.getName().equals("temporary dorm"))//test
		{
			System.out.println("true");
		}

		tempDorm.add(student);
		university.add(tempDorm);

		System.out.println(tempDorm.contains(student));//test
		System.out.println("2" +tempDorm.contains(student));//test
	}
}
