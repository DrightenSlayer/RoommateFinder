import javax.swing.*;
import java.text.DecimalFormat;

/**
 * Created by William Vagharfard on 5/6/16.
 */
public class MyGPA {

    private JTextField class1Text;
    private JComboBox class1Grade;
    private JButton calculateGPAButton;
    private JTextField class2Text;
    private JTextField class3Text;
    private JTextField class4Text;
    private JTextField class5Text;
    private JComboBox class2Grade;
    private JComboBox class3Grade;
    private JComboBox class4Grade;
    private JComboBox class5Grade;
    private JPanel myGpaPanel;
    private JTextField class1Credit;
    private JTextField class6Text;
    private JTextField class7Text;
    private JComboBox class6Grade;
    private JComboBox class7Grade;
    private JTextField class2Credit;
    private JTextField class3Credit;
    private JTextField class4Credit;
    private JTextField class5Credit;
    private JTextField class6Credit;
    private JTextField class7Credit;
    private JButton returnButton;
    private JTextField GpaField;
    private JButton clearButton;


    public MyGPA() {

        calculateGPAButton.addActionListener(e -> {
            GpaField.setText(calculate());
        });

        returnButton.addActionListener(e -> {
            ((JFrame) myGpaPanel.getTopLevelAncestor()).dispose();
        });

        clearButton.addActionListener(e -> {
            clear();
        });

    }

    private void clear(){
        class1Grade.setSelectedIndex(0);
        class1Credit.setText("");
        class2Grade.setSelectedIndex(0);
        class2Credit.setText("");
        class3Grade.setSelectedIndex(0);
        class3Credit.setText("");
        class4Grade.setSelectedIndex(0);
        class4Credit.setText("");
        class5Grade.setSelectedIndex(0);
        class5Credit.setText("");
        class6Grade.setSelectedIndex(0);
        class6Credit.setText("");
        class7Grade.setSelectedIndex(0);
        class7Credit.setText("");
        GpaField.setText("");
    }

    private String calculate() {
        double GPA = 0;
        double totalScore = 0;
        int totalCredits = 0;
        DecimalFormat df = new DecimalFormat("#.##");

        if (class1Grade.getSelectedItem() != "") {
            totalScore += getCredits(class1Credit.getText()) * getScore(class1Grade.getSelectedItem().toString());
            totalCredits += getCredits(class1Credit.getText());
        }
        if (class2Grade.getSelectedItem() != "") {
            totalScore += getCredits(class2Credit.getText()) * getScore(class2Grade.getSelectedItem().toString());
            totalCredits += getCredits(class2Credit.getText());
        }
        if (class3Grade.getSelectedItem() != "") {
            totalScore += getCredits(class3Credit.getText()) * getScore(class3Grade.getSelectedItem().toString());
            totalCredits += getCredits(class3Credit.getText());
        }
        if (class4Grade.getSelectedItem() != "") {
            totalScore += getCredits(class4Credit.getText()) * getScore(class4Grade.getSelectedItem().toString());
            totalCredits += getCredits(class4Credit.getText());
        }
        if (class5Grade.getSelectedItem() != "") {
            totalScore += getCredits(class5Credit.getText()) * getScore(class5Grade.getSelectedItem().toString());
            totalCredits += getCredits(class5Credit.getText());
        }
        if (class6Grade.getSelectedItem() != "") {
            totalScore += getCredits(class6Credit.getText()) * getScore(class6Grade.getSelectedItem().toString());
            totalCredits += getCredits(class6Credit.getText());
        }
        if (class7Grade.getSelectedItem() != "") {
            totalScore += getCredits(class7Credit.getText()) * getScore(class7Grade.getSelectedItem().toString());
            totalCredits += getCredits(class7Credit.getText());
        }

        GPA = totalScore / totalCredits;

        if (!Double.isNaN(GPA))
            return df.format(GPA);
        else
            return "0.0";
    }

    private int getCredits(String s) {
        return Integer.parseInt(s);
    }

    private double getScore(String letterGrade) {
        switch (letterGrade) {
            case ("A+") : return 4.0;
            case ("A")  : return 4.0;
            case ("A-") : return 3.7;
            case ("B+") : return 3.3;
            case ("B")  : return 3.0;
            case ("B-") : return 2.7;
            case ("C+") : return 2.3;
            case ("C")  : return 2.0;
            case ("C-") : return 1.7;
            case ("D+") : return 1.3;
            case ("D")  : return 1.0;
            case ("D-") : return 0.7;
            case ("F")  : return 0.0;
            default     : return 0.0;
        }
    }


    static void createFrame(){
        JFrame frame = new JFrame();
        frame.setContentPane(new MyGPA().myGpaPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        createFrame();
    }
}
