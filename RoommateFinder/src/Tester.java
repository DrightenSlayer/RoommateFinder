
public class Tester
{
	public static void main(String args[])
	{
		School Sjsu = new School("San Jose State University");
		School.Building CVB = new School.Building("Campus Village B");
		Sjsu.add(CVB);
		Sjsu.add(new School.Building("Joe West Hall"));
	}
}
