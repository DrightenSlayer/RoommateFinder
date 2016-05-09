import java.util.List;
import java.util.Queue;

/**
 * Created by William Vagharfard on 5/7/16.
 */
public class RoommateFinder {
    static Queue<Student> matches;
    static List<Student> fromFile;

    public static void main(String[] args) {

//        LogInGUI.createFrame();  //TODO: start here

        School sjsu = new School("SJSU");
        sjsu.add(new School.Building("CVB", 400));

        String username = "Wu Zetian";
        Student me = null;
        fromFile = Student.readFile();
        for(Student student : fromFile)
        {
            if(student.getSchool().getName().equals(sjsu.getName())) sjsu.add(student);
            if(student.getName().equals(username)) me = student;
        }

        sjsu.add(Student.generate());

        matches = me.matches();

        System.out.println("Name\t\t\t" + "Number of similarities to You\t");
        for(Student match : matches)
        {
            System.out.println(match.getName() + "\t\t\t" + match.compareTo(me));
        }
    }




    Queue getMatchQueue(){
        return matches;
    }


}
