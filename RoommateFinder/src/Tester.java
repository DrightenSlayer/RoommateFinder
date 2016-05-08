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
		School.Building cvb = new School.Building("CVB");
		School.Building.Room room101 = new School.Building.Room(4);
		School.Building.Room room102 = new School.Building.Room(4);
		
		sjsu.add(cvb); cvb.add(room101); cvb.add(room102);
		
		Student you = new Student("Bob", new int[]{1, 1, 1, 1, 1, 1});
		Student wu = new Student("Wu Zetan", new int[]{5, 5, 5, 5, 5, 5});
		Student nap = new Student("Napolean Bonaparte", new int[]{1, 2, 3, 4, 5, 6});
		Student cptc = new Student("Captain Crunch", new int[]{6, 3, 1, 6, 3, 2});
		
		while(you.getKey() == 0) you.setKey(Password.createPassword("pass", "pass"));
		
		sjsu.add(you, cvb, room101);
		sjsu.add(wu, cvb, room101);
		sjsu.add(cptc, cvb, room101);
		sjsu.add(nap, cvb, room101);
		
//		sjsu.add(Student.generate(), cvb, room101);
//		for(int i = 0; i < 6; i++){sjsu.add(Student.generate(), cvb, room102);}
		
		Queue<Student> matches = you.matches();
		
		System.out.println("Name\t\t\t\t" + "Number of similarities to You\t");
		for(Student match : matches)
		{
			System.out.println(match.getName() + "\t\t\t\t" + match.compareTo(you));
		}
	}
}
