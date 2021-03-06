import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * Creates the GUI for the grade calculator
 */
public class GradeCalc {
    private static double grade = 0.00;
    private JPanel myGpaPanel;
    private JTextField grade1Text;
    private JButton calculateGradeButton;
    private JTextField grade2Text;
    private JTextField grade3Text;
    private JTextField grade4Text;
    private JTextField grade5Text;
    private JTextField input1Field;
    private JTextField input2Field;
    private JTextField input3Field;
    private JTextField input4Field;
    private JTextField input5Field;
    private JTextField grade6Text;
    private JTextField input6Field;
    private JTextField input7Field;
    private JButton returnButton;
    private JTextField gradeField;
    private JButton clearButton;
    private JTextField neededNumber;
    private JTextField weight1Field;
    private JTextField weight2Field;
    private JTextField weight3Field;
    private JTextField weight4Field;
    private JTextField weight5Field;
    private JTextField weight6Field;
    private JTextField weight7Field;
    private JPanel calcPanel;
    private JTextField grade7Text;
    private JTextField desiredLetterGrade;

    DecimalFormat df = new DecimalFormat("#.##");

    /**
     * Creates the main frame of the grade calculator.
     */
    static void createFrame() {
        JFrame frame = new JFrame();
        frame.setContentPane(new GradeCalc().calcPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Creates the GPA calculator fields, buttons, and the action listeners.
     */
    public GradeCalc() {
        $$$setupUI$$$();

        calculateGradeButton.addActionListener(e -> {
            gradeField.setText(stringParse(getCurrentGrade()));
            neededNumber.setText(
                    stringParse(number4DesiredGrade(getCurrentGrade(),
                            desiredLetterGrade.getText().toUpperCase())));
        });

        returnButton.addActionListener(e -> {
            ((JFrame) myGpaPanel.getTopLevelAncestor()).dispose();
        });

        clearButton.addActionListener(e -> {
            clear();
        });
    }

    /**
     * Gets the current grade of the user, as inputted by the user.
     * @return the user's inputted current grade
     */
    public double getCurrentGrade() {
        grade = (helper()) / (currentPercent());

        if (!Double.isNaN(grade)) {
            return Double.parseDouble(df.format(grade));
        } else
            return 0.0;
    }

    /**
     * Clears all field so the user can start a new calculation.
     */
    private void clear() {
        grade1Text.setText("( Assignment )");
        grade2Text.setText("( Assignment )");
        grade3Text.setText("( Assignment )");
        grade4Text.setText("( Assignment )");
        grade5Text.setText("( Assignment )");
        grade6Text.setText("( Assignment )");
        grade7Text.setText("( Assignment )");

        input1Field.setText("");
        input2Field.setText("");
        input3Field.setText("");
        input4Field.setText("");
        input5Field.setText("");
        input6Field.setText("");
        input7Field.setText("");

        weight1Field.setText("");
        weight2Field.setText("");
        weight3Field.setText("");
        weight4Field.setText("");
        weight5Field.setText("");
        weight6Field.setText("");
        weight7Field.setText("");

        gradeField.setText("");
        neededNumber.setText("");
        desiredLetterGrade.setText("");
    }

    /**
     * Parses a string from the double that is entered by the user.
     * @param val the value of the double
     * @return the parsed string
     */
    private String stringParse(double val) {
        return Double.toString(val);
    }

    /**
     * Calculates the grade needed to achieve the user's desired grade.
     * @param currentGrade the current grade of the user
     * @param desiredGrade the user's desired grade
     * @return the grade needed to achieve the desired grade
     */
    private double number4DesiredGrade(double currentGrade, String desiredGrade) {
        double val = neededGradeForLetter(desiredGrade);
        double curr = currentGrade;
        double pointsEarned = curr * currentPercent();

        double step = (val - pointsEarned);
        double pointsOnExam = (1 - currentPercent());

        double wantGrade = (step / pointsOnExam);

        if (!Double.isNaN(wantGrade))
            return Double.parseDouble(df.format(wantGrade));
        else
            return 0.0;
    }

    /**
     * The method which adds the total score that has been entered by the user.
     * @return the total score
     */
    private double helper() {
        double totalScore = 0.0;

        if (input1Field.getText().length() != 0 && weight1Field.getText().length() != 0) {
            totalScore +=
                    Double.parseDouble(input1Field.getText()) * Double.parseDouble(weight1Field.getText());
        }
        if (input2Field.getText().length() != 0 && weight2Field.getText().length() != 0) {
            totalScore +=
                    Double.parseDouble(input2Field.getText()) * Double.parseDouble(weight2Field.getText());
        }
        if (input3Field.getText().length() != 0 && weight3Field.getText().length() != 0) {
            totalScore +=
                    Double.parseDouble(input3Field.getText()) * Double.parseDouble(weight3Field.getText());
        }
        if (input4Field.getText().length() != 0 && weight4Field.getText().length() != 0) {
            totalScore +=
                    Double.parseDouble(input4Field.getText()) * Double.parseDouble(weight4Field.getText());
        }
        if (input5Field.getText().length() != 0 && weight5Field.getText().length() != 0) {
            totalScore +=
                    Double.parseDouble(input5Field.getText()) * Double.parseDouble(weight5Field.getText());
        }
        if (input6Field.getText().length() != 0 && weight6Field.getText().length() != 0) {
            totalScore +=
                    Double.parseDouble(input6Field.getText()) * Double.parseDouble(weight6Field.getText());
        }
        if (input7Field.getText().length() != 0 && weight7Field.getText().length() != 0) {
            totalScore +=
                    Double.parseDouble(input7Field.getText()) * Double.parseDouble(weight7Field.getText());
        }
        return totalScore;
    }

    /**
     * Gets the current percent of weighted assignments
     * @return the current percent.
     */
    private double currentPercent() {
        double totalPercent = 0.0;
        if (weight1Field.getText().length() != 0) {
            totalPercent += Double.parseDouble(weight1Field.getText());
        }
        if (weight2Field.getText().length() != 0) {
            totalPercent += Double.parseDouble(weight2Field.getText());
        }
        if (weight3Field.getText().length() != 0) {
            totalPercent += Double.parseDouble(weight3Field.getText());
        }
        if (weight4Field.getText().length() != 0) {
            totalPercent += Double.parseDouble(weight4Field.getText());
        }
        if (weight5Field.getText().length() != 0) {
            totalPercent += Double.parseDouble(weight5Field.getText());
        }
        if (weight6Field.getText().length() != 0) {
            totalPercent += Double.parseDouble(weight6Field.getText());
        }
        if (weight7Field.getText().length() != 0) {
            totalPercent += Double.parseDouble(weight7Field.getText());
        }

        if (totalPercent >= 1) {
            totalPercent = 0.99;
        }

        return totalPercent;
    }

    /**
     * Determines what letter grades correspond to what percentage, based
     * on standard university grading scales.
     * @param desiredGrade the letter grade desired by the user
     * @return the minimum grade percentage needed for such a letter grade
     */
    private double neededGradeForLetter(String desiredGrade) {
        if (desiredGrade.equals("A")) {
            return 94;
        }
        if (desiredGrade.equals("A-")) {
            return 93;
        }
        if (desiredGrade.equals("B+")) {
            return 87;
        }
        if (desiredGrade.equals("B")) {
            return 83;
        }
        if (desiredGrade.equals("B-")) {
            return 80;
        }
        if (desiredGrade.equals("C+")) {
            return 77;
        }
        if (desiredGrade.equals("C")) {
            return 73;
        }
        if (desiredGrade.equals("C-")) {
            return 70;
        }
        if (desiredGrade.equals("D+")) {
            return 67;
        }
        if (desiredGrade.equals("D")) {
            return 64;
        }
        if (desiredGrade.equals("D-")) {
            return 60;
        }
        if (desiredGrade.equals("F")) {
            return 59;
        }
        return 0;
    }

    /**
     * Gets the current letter grade of the student. This method can be
     * implemented at a later date if desired.  Right now we are happy
     * with the current functionality of the program.
     * @param currentGrade the current percent grade of the student
     * @return the letter grade that corresponds to the user's current percent grade
     */
    public String getCurrentLetter(double currentGrade) {
        if (currentGrade >= 94 && currentGrade <= 100) {
            return "A";
        }
        if (currentGrade >= 90 && currentGrade <= 94) {
            return "A-";
        }
        if (currentGrade >= 87 && currentGrade <= 90) {
            return "B+";
        }
        if (currentGrade >= 83 && currentGrade <= 87) {
            return "B";
        }
        if (currentGrade >= 80 && currentGrade <= 83) {
            return "B-";
        }
        if (currentGrade >= 77 && currentGrade <= 80) {
            return "C+";
        }
        if (currentGrade >= 73 && currentGrade <= 77) {
            return "C";
        }
        if (currentGrade >= 70 && currentGrade <= 73) {
            return "C-";
        }
        if (currentGrade >= 67 && currentGrade <= 70) {
            return "D+";
        }
        if (currentGrade >= 63 && currentGrade <= 67) {
            return "D";
        }
        if (currentGrade >= 60 && currentGrade <= 63) {
            return "D-";
        }
        if (currentGrade >= 59) {
            return "F";
        }
        return "";
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        calcPanel = new JPanel();
        calcPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        calcPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        myGpaPanel = new JPanel();
        myGpaPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(11, 7, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(myGpaPanel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        grade1Text = new JTextField();
        grade1Text.setText("( Assignment )");
        myGpaPanel.add(grade1Text, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        myGpaPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        calculateGradeButton = new JButton();
        calculateGradeButton.setText("Calculate Grade");
        myGpaPanel.add(calculateGradeButton, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        grade2Text = new JTextField();
        grade2Text.setText("( Assignment )");
        myGpaPanel.add(grade2Text, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        grade3Text = new JTextField();
        grade3Text.setText("( Assignment )");
        myGpaPanel.add(grade3Text, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        grade5Text = new JTextField();
        grade5Text.setText("( Assignment )");
        myGpaPanel.add(grade5Text, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Assignment Name:");
        myGpaPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        input1Field = new JTextField();
        myGpaPanel.add(input1Field, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Grade");
        myGpaPanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        input2Field = new JTextField();
        myGpaPanel.add(input2Field, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        input3Field = new JTextField();
        input3Field.setText("");
        myGpaPanel.add(input3Field, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        input4Field = new JTextField();
        input4Field.setText("");
        myGpaPanel.add(input4Field, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        input5Field = new JTextField();
        input5Field.setText("");
        myGpaPanel.add(input5Field, new com.intellij.uiDesigner.core.GridConstraints(5, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Weight");
        myGpaPanel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(0, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        grade6Text = new JTextField();
        grade6Text.setText("( Assignment )");
        myGpaPanel.add(grade6Text, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        grade7Text = new JTextField();
        grade7Text.setText("( Assignment )");
        myGpaPanel.add(grade7Text, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        input6Field = new JTextField();
        input6Field.setText("");
        myGpaPanel.add(input6Field, new com.intellij.uiDesigner.core.GridConstraints(6, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        input7Field = new JTextField();
        input7Field.setText("");
        myGpaPanel.add(input7Field, new com.intellij.uiDesigner.core.GridConstraints(7, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        returnButton = new JButton();
        returnButton.setText("Return");
        myGpaPanel.add(returnButton, new com.intellij.uiDesigner.core.GridConstraints(10, 5, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Your Grade is:");
        myGpaPanel.add(label4, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gradeField = new JTextField();
        gradeField.setEditable(false);
        myGpaPanel.add(gradeField, new com.intellij.uiDesigner.core.GridConstraints(8, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("You will need a : ");
        myGpaPanel.add(label5, new com.intellij.uiDesigner.core.GridConstraints(9, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        clearButton = new JButton();
        clearButton.setText("Clear");
        myGpaPanel.add(clearButton, new com.intellij.uiDesigner.core.GridConstraints(9, 5, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        weight7Field = new JTextField();
        weight7Field.setText("");
        myGpaPanel.add(weight7Field, new com.intellij.uiDesigner.core.GridConstraints(7, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        weight6Field = new JTextField();
        weight6Field.setText("");
        myGpaPanel.add(weight6Field, new com.intellij.uiDesigner.core.GridConstraints(6, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        weight5Field = new JTextField();
        weight5Field.setText("");
        myGpaPanel.add(weight5Field, new com.intellij.uiDesigner.core.GridConstraints(5, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        weight4Field = new JTextField();
        weight4Field.setText("");
        myGpaPanel.add(weight4Field, new com.intellij.uiDesigner.core.GridConstraints(4, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        weight3Field = new JTextField();
        weight3Field.setText("");
        myGpaPanel.add(weight3Field, new com.intellij.uiDesigner.core.GridConstraints(3, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        weight2Field = new JTextField();
        weight2Field.setText("");
        myGpaPanel.add(weight2Field, new com.intellij.uiDesigner.core.GridConstraints(2, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        weight1Field = new JTextField();
        weight1Field.setText("");
        myGpaPanel.add(weight1Field, new com.intellij.uiDesigner.core.GridConstraints(1, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        neededNumber = new JTextField();
        neededNumber.setEditable(false);
        myGpaPanel.add(neededNumber, new com.intellij.uiDesigner.core.GridConstraints(9, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        desiredLetterGrade = new JTextField();
        desiredLetterGrade.setText("Enter desired letter grade...");
        myGpaPanel.add(desiredLetterGrade, new com.intellij.uiDesigner.core.GridConstraints(8, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        grade4Text = new JTextField();
        grade4Text.setText("( Assignment )");
        myGpaPanel.add(grade4Text, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Enter your grade as a whole number i.e. \"20\" for 20% on an assignment.");
        panel1.add(label6, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("Enter your weight (the % that a grade carries with respect to the class) i.e. \".15\" = 15%");
        panel1.add(label7, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return calcPanel;
    }
}

