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
		School.Building Cvb = new School.Building("CVB");
		School.Building.Room room101 = new School.Building.Room(4);
		Student you = new Student("Bob", new int[]{20, 1, 1, 1, 10, 8});
		while(you.getKey() == 0) you.setKey(Password.createPassword("pass", "pass"));
		sjsu.add(Cvb); Cvb.add(room101);
		
		System.out.println(sjsu.add(you, Cvb, room101) + "" + you.getKey());
		//There's probably a better way to implement this student, room, building, school paradigm
	}
}
