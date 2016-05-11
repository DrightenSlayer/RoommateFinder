import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * Creates the GUI for the GPA calculator
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

    /**
     * Creates the main frame of the GPA calculator.
     */
    static void createFrame() {
        JFrame frame = new JFrame("GPA Calculator");
        frame.setContentPane(new MyGPA().myGpaPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Creates the GPA calculator fields, buttons, and the action listeners.
     */
    public MyGPA() {
        $$$setupUI$$$();

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

    /**
     * Clears the fields when a user wants to re-calculate the GPA.
     */
    private void clear() {
        class1Grade.setSelectedIndex(0);
        class1Credit.setText("");
        class1Text.setText("( class name )");
        class2Grade.setSelectedIndex(0);
        class2Credit.setText("");
        class2Text.setText("( class name )");
        class3Grade.setSelectedIndex(0);
        class3Credit.setText("");
        class3Text.setText("( class name )");
        class4Grade.setSelectedIndex(0);
        class4Credit.setText("");
        class4Text.setText("( class name )");
        class5Grade.setSelectedIndex(0);
        class5Credit.setText("");
        class5Text.setText("( class name )");
        class6Grade.setSelectedIndex(0);
        class6Credit.setText("");
        class6Text.setText("( class name )");
        class7Grade.setSelectedIndex(0);
        class7Credit.setText("");
        class7Text.setText("( class name )");
        GpaField.setText("");
    }

    /**
     * Calculates the GPA based on the common GPA calculation algorithm
     * @return a formatted GPA in the #.## format
     */
    private String calculate() {
        double GPA;
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

    /**
     * Gets the number of credits for each class
     * @param s the number of credits, entered as a string
     * @return the credits, but parsed to an integer
     */
    private int getCredits(String s) {
        return Integer.parseInt(s);
    }

    /**
     * Gets the GPA score for the grade the user received in their course.
     * @param letterGrade the letter grade the user selects
     * @return the GPA value for that grade
     */
    private double getScore(String letterGrade) {
        switch (letterGrade) {
            case ("A+"):
                return 4.0;
            case ("A"):
                return 4.0;
            case ("A-"):
                return 3.7;
            case ("B+"):
                return 3.3;
            case ("B"):
                return 3.0;
            case ("B-"):
                return 2.7;
            case ("C+"):
                return 2.3;
            case ("C"):
                return 2.0;
            case ("C-"):
                return 1.7;
            case ("D+"):
                return 1.3;
            case ("D"):
                return 1.0;
            case ("D-"):
                return 0.7;
            case ("F"):
                return 0.0;
            default:
                return 0.0;
        }
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        myGpaPanel = new JPanel();
        myGpaPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(10, 7, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(myGpaPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        class1Text = new JTextField();
        class1Text.setText("( class name )");
        myGpaPanel.add(class1Text, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        myGpaPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        class1Grade = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("");
        defaultComboBoxModel1.addElement("A+");
        defaultComboBoxModel1.addElement("A");
        defaultComboBoxModel1.addElement("A-");
        defaultComboBoxModel1.addElement("B+");
        defaultComboBoxModel1.addElement("B");
        defaultComboBoxModel1.addElement("B-");
        defaultComboBoxModel1.addElement("C+");
        defaultComboBoxModel1.addElement("C");
        defaultComboBoxModel1.addElement("C-");
        defaultComboBoxModel1.addElement("D+");
        defaultComboBoxModel1.addElement("D");
        defaultComboBoxModel1.addElement("D-");
        defaultComboBoxModel1.addElement("F");
        class1Grade.setModel(defaultComboBoxModel1);
        myGpaPanel.add(class1Grade, new com.intellij.uiDesigner.core.GridConstraints(1, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        calculateGPAButton = new JButton();
        calculateGPAButton.setText("Calculate GPA");
        myGpaPanel.add(calculateGPAButton, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        class2Text = new JTextField();
        class2Text.setText("( class name )");
        myGpaPanel.add(class2Text, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        class3Text = new JTextField();
        class3Text.setText("( class name )");
        myGpaPanel.add(class3Text, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        class4Text = new JTextField();
        class4Text.setText("( class name )");
        myGpaPanel.add(class4Text, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        class5Text = new JTextField();
        class5Text.setText("( class name )");
        myGpaPanel.add(class5Text, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        class2Grade = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("");
        defaultComboBoxModel2.addElement("A+");
        defaultComboBoxModel2.addElement("A");
        defaultComboBoxModel2.addElement("A-");
        defaultComboBoxModel2.addElement("B+");
        defaultComboBoxModel2.addElement("B");
        defaultComboBoxModel2.addElement("B-");
        defaultComboBoxModel2.addElement("C+");
        defaultComboBoxModel2.addElement("C");
        defaultComboBoxModel2.addElement("C-");
        defaultComboBoxModel2.addElement("D+");
        defaultComboBoxModel2.addElement("D");
        defaultComboBoxModel2.addElement("D-");
        defaultComboBoxModel2.addElement("F");
        class2Grade.setModel(defaultComboBoxModel2);
        myGpaPanel.add(class2Grade, new com.intellij.uiDesigner.core.GridConstraints(2, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        class3Grade = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        defaultComboBoxModel3.addElement("");
        defaultComboBoxModel3.addElement("A+");
        defaultComboBoxModel3.addElement("A");
        defaultComboBoxModel3.addElement("A-");
        defaultComboBoxModel3.addElement("B+");
        defaultComboBoxModel3.addElement("B");
        defaultComboBoxModel3.addElement("B-");
        defaultComboBoxModel3.addElement("C+");
        defaultComboBoxModel3.addElement("C");
        defaultComboBoxModel3.addElement("C-");
        defaultComboBoxModel3.addElement("D+");
        defaultComboBoxModel3.addElement("D");
        defaultComboBoxModel3.addElement("D-");
        defaultComboBoxModel3.addElement("F");
        class3Grade.setModel(defaultComboBoxModel3);
        myGpaPanel.add(class3Grade, new com.intellij.uiDesigner.core.GridConstraints(3, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        class4Grade = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel4 = new DefaultComboBoxModel();
        defaultComboBoxModel4.addElement("");
        defaultComboBoxModel4.addElement("A+");
        defaultComboBoxModel4.addElement("A");
        defaultComboBoxModel4.addElement("A-");
        defaultComboBoxModel4.addElement("B+");
        defaultComboBoxModel4.addElement("B");
        defaultComboBoxModel4.addElement("B-");
        defaultComboBoxModel4.addElement("C+");
        defaultComboBoxModel4.addElement("C");
        defaultComboBoxModel4.addElement("C-");
        defaultComboBoxModel4.addElement("D+");
        defaultComboBoxModel4.addElement("D");
        defaultComboBoxModel4.addElement("D-");
        defaultComboBoxModel4.addElement("F");
        class4Grade.setModel(defaultComboBoxModel4);
        myGpaPanel.add(class4Grade, new com.intellij.uiDesigner.core.GridConstraints(4, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        class5Grade = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel5 = new DefaultComboBoxModel();
        defaultComboBoxModel5.addElement("");
        defaultComboBoxModel5.addElement("A+");
        defaultComboBoxModel5.addElement("A");
        defaultComboBoxModel5.addElement("A-");
        defaultComboBoxModel5.addElement("B+");
        defaultComboBoxModel5.addElement("B");
        defaultComboBoxModel5.addElement("B-");
        defaultComboBoxModel5.addElement("C+");
        defaultComboBoxModel5.addElement("C");
        defaultComboBoxModel5.addElement("C-");
        defaultComboBoxModel5.addElement("D+");
        defaultComboBoxModel5.addElement("D");
        defaultComboBoxModel5.addElement("D-");
        defaultComboBoxModel5.addElement("F");
        class5Grade.setModel(defaultComboBoxModel5);
        myGpaPanel.add(class5Grade, new com.intellij.uiDesigner.core.GridConstraints(5, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Course Name");
        myGpaPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        class1Credit = new JTextField();
        myGpaPanel.add(class1Credit, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Credits  ");
        myGpaPanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        class2Credit = new JTextField();
        myGpaPanel.add(class2Credit, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        class3Credit = new JTextField();
        class3Credit.setText("");
        myGpaPanel.add(class3Credit, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        class4Credit = new JTextField();
        class4Credit.setText("");
        myGpaPanel.add(class4Credit, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        class5Credit = new JTextField();
        class5Credit.setText("");
        myGpaPanel.add(class5Credit, new com.intellij.uiDesigner.core.GridConstraints(5, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Grade");
        myGpaPanel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(0, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        class6Text = new JTextField();
        class6Text.setText("( class name )");
        myGpaPanel.add(class6Text, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        class7Text = new JTextField();
        class7Text.setText("( class name )");
        myGpaPanel.add(class7Text, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        class6Credit = new JTextField();
        class6Credit.setText("");
        myGpaPanel.add(class6Credit, new com.intellij.uiDesigner.core.GridConstraints(6, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        class7Credit = new JTextField();
        class7Credit.setText("");
        myGpaPanel.add(class7Credit, new com.intellij.uiDesigner.core.GridConstraints(7, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        class6Grade = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel6 = new DefaultComboBoxModel();
        defaultComboBoxModel6.addElement("");
        defaultComboBoxModel6.addElement("A+");
        defaultComboBoxModel6.addElement("A");
        defaultComboBoxModel6.addElement("A-");
        defaultComboBoxModel6.addElement("B+");
        defaultComboBoxModel6.addElement("B");
        defaultComboBoxModel6.addElement("B-");
        defaultComboBoxModel6.addElement("C+");
        defaultComboBoxModel6.addElement("C");
        defaultComboBoxModel6.addElement("C-");
        defaultComboBoxModel6.addElement("D+");
        defaultComboBoxModel6.addElement("D");
        defaultComboBoxModel6.addElement("D-");
        defaultComboBoxModel6.addElement("F");
        class6Grade.setModel(defaultComboBoxModel6);
        myGpaPanel.add(class6Grade, new com.intellij.uiDesigner.core.GridConstraints(6, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        class7Grade = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel7 = new DefaultComboBoxModel();
        defaultComboBoxModel7.addElement("");
        defaultComboBoxModel7.addElement("A+");
        defaultComboBoxModel7.addElement("A");
        defaultComboBoxModel7.addElement("A-");
        defaultComboBoxModel7.addElement("B+");
        defaultComboBoxModel7.addElement("B");
        defaultComboBoxModel7.addElement("B-");
        defaultComboBoxModel7.addElement("C+");
        defaultComboBoxModel7.addElement("C");
        defaultComboBoxModel7.addElement("C-");
        defaultComboBoxModel7.addElement("D+");
        defaultComboBoxModel7.addElement("D");
        defaultComboBoxModel7.addElement("D-");
        defaultComboBoxModel7.addElement("F");
        class7Grade.setModel(defaultComboBoxModel7);
        myGpaPanel.add(class7Grade, new com.intellij.uiDesigner.core.GridConstraints(7, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        myGpaPanel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, new Dimension(40, -1), null, null, 0, false));
        returnButton = new JButton();
        returnButton.setText("Return");
        myGpaPanel.add(returnButton, new com.intellij.uiDesigner.core.GridConstraints(9, 5, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Your GPA is:");
        myGpaPanel.add(label4, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        GpaField = new JTextField();
        GpaField.setEditable(false);
        myGpaPanel.add(GpaField, new com.intellij.uiDesigner.core.GridConstraints(8, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        clearButton = new JButton();
        clearButton.setText("Clear");
        myGpaPanel.add(clearButton, new com.intellij.uiDesigner.core.GridConstraints(8, 5, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }
}
