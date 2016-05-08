/**
 * Created by William Vagharfard on 5/7/16.
 */
public class RoommateFinder {
    public static void main(String[] args) {

//        LogInGUI.createFrame();  //TODO: start here

        School sjsu = new School("SJSU");
        School.Building cvb = new School.Building("CVB", 10);


        sjsu.add(cvb);


        Student you = new Student("Bob", new int[]{1, 1, 1, 1, 1, 1});
        Student wu = new Student("Wu Zetan", new int[]{5, 5, 5, 5, 5, 5});
        Student nap = new Student("Napolean Bonaparte", new int[]{1, 2, 3, 4, 5, 6});
        Student cptc = new Student("Captain Crunch", new int[]{6, 3, 1, 6, 3, 2});

        Student stc = new Student("Steve Chen", new int[] {3, 2, 1, 4, 6, 4});
        Student mno = new Student("Miki Nomura", new int[] {1, 3, 2, 4, 6, 5 });
        Student wc = new Student("Winston Churchill", new int[] {4, 6, 4, 4, 3, 1});

        while(you.getKey() == 0) you.setKey(Password.createPassword("pass", "pass"));

        sjsu.add(you, cvb);
        sjsu.add(wu, cvb);
        sjsu.add(cptc, cvb);
        sjsu.add(nap, cvb);

        sjsu.add(stc, cvb);
        sjsu.add(mno, cvb);
        sjsu.add(wc, cvb);




    }
}
