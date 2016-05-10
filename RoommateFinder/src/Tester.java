import java.util.List;
import java.util.Queue;

/**
 * This is a tester in the stead of the GUI, which we are currently waiting on.
 * @author Matt
 *
 */
public class Tester
{
	public static void main(String args[])
	{
		School sjsu = new School("SJSU");
		sjsu.add(new School.Building("CVB", 400));

		String username = "Wu Zetian";
		Student me = null;
		List<Student> fromFile = Student.readFile();
		for(Student student : fromFile)
		{
			if(student.getSchool().getName().equals(sjsu.getName())) sjsu.add(student);
			if(student.getName().equals(username)) me = student;
		}

		sjsu.add(Student.generate());

		Queue<Student> matches = me.matches();

		System.out.println("Name\t\t\t" + "Number of similarities to You\t");
		for(Student match : matches)
		{
			System.out.println(match.getName() + "\t\t\t" + match.compareTo(me));
		}
	}
}
