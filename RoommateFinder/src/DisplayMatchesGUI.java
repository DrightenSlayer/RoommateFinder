import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by William Vagharfard on 5/6/16.
 */
public class DisplayMatchesGUI {

    private JPanel matchesPanel;
    private JList studentList;
    private JButton getInfoButton;
    private JButton returnButton;


    public DisplayMatchesGUI() {

        //TODO: This doesn't work right now!!

        //TODO: need to bring in the list of students in this ↓ array list
        ArrayList<String> stu = new ArrayList<>();
        stu.add("Khoi");
        stu.add("Matt");
        stu.add("Ray");
        stu.add("William");

        DefaultListModel listModel = new DefaultListModel<>();

        for(String s : stu)
            listModel.addElement(s);

        studentList.setListData(listModel.toArray());

        getInfoButton.addActionListener(e -> {
            studentList.getSelectedValue(); // gets selected student
            StudentMatch.createFrame();  //TODO: here, how to create frame from the selected student???
        });

        returnButton.addActionListener(e -> {
            ((JFrame) matchesPanel.getTopLevelAncestor()).dispose();
            MainMenuGUI.createFrame();

        });
    }

    static void createFrame() {
        JFrame frame = new JFrame();
        frame.setContentPane(new DisplayMatchesGUI().matchesPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        createFrame();
    }
}