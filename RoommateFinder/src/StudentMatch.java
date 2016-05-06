import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by William Vagharfard on 5/6/16.
 */
public class StudentMatch {
    private JPanel studentPanel;
    private JTextField bunkText;
    private JTextField brightnessText;
    private JTextField floorText;
    private JTextField wdText;
    private JTextField priceText;
    private JTextField roommateText;
    private JTextField wakeText;
    private JTextField showerText;
    private JTextField kitchenText;
    private JTextField sleepText;
    private JTextField yearText;
    private JTextField majorText;
    private JTextField nameText;
    private JTextField ageText;
    private JTextField genderText;
    private JButton acceptButton;
    private JButton returnButton;
    private JButton declineButton;
    private List<String> studentMatch;

    public StudentMatch() {
        readFromFile();

        //TODO: I don't know if there's a better way to do this
        nameText.setText(studentMatch.get(0));
        ageText.setText(studentMatch.get(5));
        genderText.setText(studentMatch.get(1));
        majorText.setText(studentMatch.get(6));
        yearText.setText(studentMatch.get(7));
        sleepText.setText(studentMatch.get(8));
        wakeText.setText(studentMatch.get(9));
        roommateText.setText(studentMatch.get(10));
        priceText.setText(studentMatch.get(11));
        kitchenText.setText(studentMatch.get(12));
        showerText.setText(studentMatch.get(13));
        wdText.setText(studentMatch.get(14));
        floorText.setText(studentMatch.get(15));
        brightnessText.setText(studentMatch.get(16));
        bunkText.setText(studentMatch.get(17));


        acceptButton.addActionListener(e -> {
            //TODO: add this student to list of potential roommates for the user
        });

        returnButton.addActionListener(e -> {
            ((JFrame) studentPanel.getTopLevelAncestor()).dispose();
            DisplayMatchesGUI.createFrame();
        });

        declineButton.addActionListener(e -> {
            //TODO: add this student to list of roommated declined
            //or take away from list of potential roommates
        });

        studentMatch.clear();
    }

    void readFromFile(){
        studentMatch = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("StudentInfo.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                studentMatch.add(line);
            }
        } catch (IOException e) { System.out.println("File not found."); }

//        for (int i = 0; i < studentMatch.size(); i++){
//            System.out.println(i + ". " + studentMatch.get(i));
//        }
    }


    static void createFrame() {
        JFrame frame = new JFrame();
        frame.setContentPane(new StudentMatch().studentPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        createFrame();
    }
}
