import javax.swing.*;
import java.awt.*;

public class GradeCalc {
    private static double grade = 0.00;
    private JPanel myGpaPanel;
    private JTextField class1Text;
    private JButton calculateGradeButton;
    private JTextField class2Text;
    private JTextField class3Text;
    private JTextField class4Text;
    private JTextField class5Text;
    private JTextField input1Field;
    private JTextField input2Field;
    private JTextField input3Field;
    private JTextField input4Field;
    private JTextField input5Field;
    private JTextField class6Text;
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
    private JTextField class7Text;
    private JTextField desiredLetterGrade;

    public static void main(String... args) {
        GradeCalc.createFrame();
    }

    static void createFrame() {
        JFrame frame = new JFrame();
        frame.setContentPane(new GradeCalc().calcPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
<<<<<<< Updated upstream

=======

<<<<<<< HEAD
    private static double neededPercentage;

    public static void main(String[] args)
    {
        input1 = 00;
        input2 = 0;
        input3 = 10;
        
        weight1 = .10;
        weight2 = .20;
        weight3 = .20;
        
        //You can change inputs (grades on assignments) and weights (how much % each weight is worth). 
        //Input 1 correlates with Weight1 etc
        //You can then call what grade you want, in this case a B.
        System.out.println(getCurrentGrade() + " " + getCurrentLetter(getCurrentGrade()));

        neededPercentage = number4DesiredGrade(getCurrentGrade(), "A");

        if (neededPercentage > 100.00)
            System.out.println("Sorry, it is not possible to achieve your desired grade. (T_T) ");
        else
            System.out.println("You will need a " + number4DesiredGrade(getCurrentGrade(), "A") + " to achieve your desired grade. ");

=======
>>>>>>> Stashed changes
    public GradeCalc() {
        $$$setupUI$$$();

        calculateGradeButton.addActionListener(e -> {
            gradeField.setText(stringParse(getCurrentGrade()));
            neededNumber.setText(
                    stringParse(number4DesiredGrade(getCurrentGrade(), desiredLetterGrade.getText())));
        });


        returnButton.addActionListener(e -> {
            ((JFrame) myGpaPanel.getTopLevelAncestor()).dispose();
        });

        clearButton.addActionListener(e -> {
            clear();
        });
<<<<<<< Updated upstream
=======
>>>>>>> origin/master
>>>>>>> Stashed changes
    }

    public double getCurrentGrade() {
        grade = (helper()) / (currentPercent());
        return grade;
    }

    private void clear() {
        class1Text.setText("( class name )");
        class2Text.setText("( class name )");
        ;
        class3Text.setText("( class name )");
        class4Text.setText("( class name )");
        class5Text.setText("( class name )");
        class6Text.setText("( class name )");
        class7Text.setText("( class name )");

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

    public String stringParse(double val) {
        return Double.toString(val);
    }


    public double number4DesiredGrade(double currentGrade, String desiredGrade) {
        double val = neededGradeForLetter(desiredGrade);
        double curr = getCurrentGrade();
        double pointsEarned = curr * currentPercent();

        double step = (val - pointsEarned);
        double pointsOnExam = (1 - currentPercent());

        return (step / pointsOnExam);
    }

    public double helper() {
        return (Double.parseDouble(input1Field.getText()) * Double.parseDouble(weight1Field.getText()))
                + (Double.parseDouble(input2Field.getText()) * Double.parseDouble(weight2Field.getText()))
                + (Double.parseDouble(input3Field.getText()) * Double.parseDouble(weight3Field.getText())) +
                (Double.parseDouble(input4Field.getText()) * Double.parseDouble(weight4Field.getText())) +
                (Double.parseDouble(input5Field.getText()) * Double.parseDouble(weight5Field.getText()));
    }

    public double currentPercent() {
        return Double.parseDouble(weight1Field.getText()) + Double.parseDouble(weight2Field.getText()) +
                Double.parseDouble(weight3Field.getText()) + Double.parseDouble(weight4Field.getText()) +
                Double.parseDouble(weight5Field.getText());
    }

    public double neededGradeForLetter(String desiredGrade) {
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
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        calcPanel = new JPanel();
        calcPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        calcPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        myGpaPanel = new JPanel();
        myGpaPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(11, 6, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(myGpaPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        class1Text = new JTextField();
        class1Text.setText("( class name )");
        myGpaPanel.add(class1Text, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        myGpaPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        calculateGradeButton = new JButton();
        calculateGradeButton.setText("Calculate Grade");
        myGpaPanel.add(calculateGradeButton, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
        final JLabel label1 = new JLabel();
        label1.setText("Course Name");
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
        myGpaPanel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        class6Text = new JTextField();
        class6Text.setText("( class name )");
        myGpaPanel.add(class6Text, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        class7Text = new JTextField();
        class7Text.setText("( class name )");
        myGpaPanel.add(class7Text, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        input6Field = new JTextField();
        input6Field.setText("");
        myGpaPanel.add(input6Field, new com.intellij.uiDesigner.core.GridConstraints(6, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        input7Field = new JTextField();
        input7Field.setText("");
        myGpaPanel.add(input7Field, new com.intellij.uiDesigner.core.GridConstraints(7, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        returnButton = new JButton();
        returnButton.setText("Return");
        myGpaPanel.add(returnButton, new com.intellij.uiDesigner.core.GridConstraints(10, 4, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
        myGpaPanel.add(clearButton, new com.intellij.uiDesigner.core.GridConstraints(9, 4, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        weight7Field = new JTextField();
        weight7Field.setText("");
        myGpaPanel.add(weight7Field, new com.intellij.uiDesigner.core.GridConstraints(7, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        weight6Field = new JTextField();
        weight6Field.setText("");
        myGpaPanel.add(weight6Field, new com.intellij.uiDesigner.core.GridConstraints(6, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        weight5Field = new JTextField();
        weight5Field.setText("");
        myGpaPanel.add(weight5Field, new com.intellij.uiDesigner.core.GridConstraints(5, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        weight4Field = new JTextField();
        weight4Field.setText("");
        myGpaPanel.add(weight4Field, new com.intellij.uiDesigner.core.GridConstraints(4, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        weight3Field = new JTextField();
        weight3Field.setText("");
        myGpaPanel.add(weight3Field, new com.intellij.uiDesigner.core.GridConstraints(3, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        weight2Field = new JTextField();
        weight2Field.setText("");
        myGpaPanel.add(weight2Field, new com.intellij.uiDesigner.core.GridConstraints(2, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        weight1Field = new JTextField();
        weight1Field.setText("");
        myGpaPanel.add(weight1Field, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), new Dimension(60, -1), 0, false));
        neededNumber = new JTextField();
        neededNumber.setEditable(false);
        myGpaPanel.add(neededNumber, new com.intellij.uiDesigner.core.GridConstraints(9, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        desiredLetterGrade = new JTextField();
        desiredLetterGrade.setText("Enter desired letter grade...");
        myGpaPanel.add(desiredLetterGrade, new com.intellij.uiDesigner.core.GridConstraints(8, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        panel1.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return calcPanel;
    }
}

