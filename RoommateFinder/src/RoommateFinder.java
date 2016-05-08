/**
 * Created by William Vagharfard on 5/7/16.
 */
public class RoommateFinder {
    public static void main(String[] args) {

        School sjsu = new School("SJSU");
        School.Building cvb = new School.Building("CVB");
        School.Building.Room room101 = new School.Building.Room(4);
        School.Building.Room room102 = new School.Building.Room(4);

        sjsu.add(cvb);
        cvb.add(room101);
        cvb.add(room102);


        Student you = new Student("Bob", new int[]{1, 1, 1, 1, 1, 1});
        Student wu = new Student("Wu Zetan", new int[]{5, 5, 5, 5, 5, 5});
        Student nap = new Student("Napolean Bonaparte", new int[]{1, 2, 3, 4, 5, 6});
        Student cptc = new Student("Captain Crunch", new int[]{6, 3, 1, 6, 3, 2});

        Student stc = new Student("Steve Chen", new int[] {3, 2, 1, 4, 6, 4});
        Student mno = new Student("Miki Nomura", new int[] {1, 3, 2, 4, 6, 5 });
        Student wc = new Student("Winston Churchill", new int[] {4, 6, 4, 4, 3, 1});

        while(you.getKey() == 0) you.setKey(Password.createPassword("pass", "pass"));

        sjsu.add(you, cvb, room101);
        sjsu.add(wu, cvb, room101);
        sjsu.add(cptc, cvb, room101);
        sjsu.add(nap, cvb, room101);

        sjsu.add(stc, cvb, room102);
        sjsu.add(mno, cvb, room102);
        sjsu.add(wc, cvb, room102);




    }
}
