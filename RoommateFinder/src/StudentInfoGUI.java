import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Creates the GUI for the student information entry screen.
 */
public class StudentInfoGUI {
    private JPanel studentInfoPanel;
    private JLabel schoolLabel;
    private JLabel sidLabel;
    private JLabel languageLabel;
    private JTextField sidField;
    private JComboBox languageBox;
    private JButton nextButton;
    private JButton previousButton;
    private JComboBox schoolComboBox;
    private JLabel errorLabel;
    private JComboBox genderBox;
    private List<String> studentInfoList;
    private final Charset UTF8 = StandardCharsets.UTF_8;

    /**
     * Creates the main frame of the student information screen.
     */
    public static void createFrame() {
        JFrame frame = new JFrame("Student Information");
        frame.setContentPane(new StudentInfoGUI().studentInfoPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Creates the student information entry fields, buttons, and the action listeners.
     * Writes out the student info to the StudentInfo text file.
     */
    private StudentInfoGUI() {
        $$$setupUI$$$();
        studentInfoList = new ArrayList<>();

        nextButton.addActionListener(e -> {
            studentInfoList.add(getSchoolEntry());
            studentInfoList.add(getLanguageEntry());
            studentInfoList.add(getGenderEntry());

            try {
                Files.write(Paths.get("StudentInfo.txt"), studentInfoList, UTF8,
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException exc) {
                exc.printStackTrace();
            }

            if (getSidEntry() != null) {
                PersonalInfoGUI.createFrame();
                ((JFrame) studentInfoPanel.getTopLevelAncestor()).dispose();
            } else {
                errorLabel.setVisible(true);
            }
        });

        previousButton.addActionListener(e -> {
            PasswordSetupGUI.createFrame();
            ((JFrame) studentInfoPanel.getTopLevelAncestor()).dispose();
        });
    }

    /**
     * Gets the gender selected by the user.
     * @return the gender selected by the user in a string
     */
    private String getGenderEntry() {
        return genderBox.getSelectedItem().toString();
    }

    /**
     * Gets the student ID number
     * @return the student ID number inputted by the student
     */
    private String getSidEntry() {
        String sidEntry = sidField.getText();
        if (legitSidEntry()) {
            return sidEntry;
        } else return null;
    }

    /**
     * Checks if the student ID number is legitimate.
     * For our purposes we will consider student ID's with only digits, no letters.
     * @return true if the student ID is legitimate
     */
    private boolean legitSidEntry() {
        String sidEntry = sidField.getText();
        if (sidEntry != null && sidEntry.matches("^\\d+$")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the school selected by a user.
     * @return the user's selected school, in a string.
     */
    private String getSchoolEntry() {
        return (String) schoolComboBox.getSelectedItem();
    }

    /**
     * Gets the language selected by a user.
     * For our purposes we will only consider a few languages as valid selections.
     * @return the user's selected language, in a string.
     */
    private String getLanguageEntry() {
        return (String) languageBox.getSelectedItem();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        studentInfoPanel = new JPanel();
        studentInfoPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(7, 6, new Insets(0, 25, 25, 25), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setFont(new Font(label1.getFont().getName(), label1.getFont().getStyle(), 36));
        label1.setText("Student");
        studentInfoPanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), -1, -1));
        studentInfoPanel.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        schoolLabel = new JLabel();
        schoolLabel.setFont(new Font(schoolLabel.getFont().getName(), schoolLabel.getFont().getStyle(), 20));
        schoolLabel.setText("School:");
        panel1.add(schoolLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        languageLabel = new JLabel();
        languageLabel.setFont(new Font(languageLabel.getFont().getName(), languageLabel.getFont().getStyle(), 20));
        languageLabel.setText("Language:");
        panel1.add(languageLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sidLabel = new JLabel();
        sidLabel.setFont(new Font(sidLabel.getFont().getName(), sidLabel.getFont().getStyle(), 20));
        sidLabel.setText("Student ID:");
        panel1.add(sidLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        schoolComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("SJSU");
        schoolComboBox.setModel(defaultComboBoxModel1);
        panel1.add(schoolComboBox, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sidField = new JTextField();
        panel1.add(sidField, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        languageBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("English");
        defaultComboBoxModel2.addElement("Farsi");
        defaultComboBoxModel2.addElement("Japanese");
        defaultComboBoxModel2.addElement("Chinese");
        defaultComboBoxModel2.addElement("Vietnamese");
        defaultComboBoxModel2.addElement("Russian");
        languageBox.setModel(defaultComboBoxModel2);
        languageBox.setToolTipText("");
        panel1.add(languageBox, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        errorLabel = new JLabel();
        errorLabel.setBackground(new Color(-65536));
        errorLabel.setEnabled(true);
        errorLabel.setFont(new Font(errorLabel.getFont().getName(), errorLabel.getFont().getStyle(), 12));
        errorLabel.setForeground(new Color(-65536));
        errorLabel.setText("Error! Validate input!");
        errorLabel.setVisible(false);
        studentInfoPanel.add(errorLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setFont(new Font(label2.getFont().getName(), label2.getFont().getStyle(), 36));
        label2.setText("Information");
        studentInfoPanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        studentInfoPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 5, 7, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        studentInfoPanel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 7, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        previousButton = new JButton();
        previousButton.setText("Previous");
        studentInfoPanel.add(previousButton, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setFont(new Font(label3.getFont().getName(), label3.getFont().getStyle(), 20));
        label3.setText("Gender:");
        studentInfoPanel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        genderBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        defaultComboBoxModel3.addElement("Male");
        defaultComboBoxModel3.addElement("Female");
        defaultComboBoxModel3.addElement("Other");
        defaultComboBoxModel3.addElement("Not Identify");
        genderBox.setModel(defaultComboBoxModel3);
        genderBox.setToolTipText("");
        studentInfoPanel.add(genderBox, new com.intellij.uiDesigner.core.GridConstraints(5, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nextButton = new JButton();
        nextButton.setText("   Next   ");
        studentInfoPanel.add(nextButton, new com.intellij.uiDesigner.core.GridConstraints(6, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     *
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return studentInfoPanel;
    }
}
