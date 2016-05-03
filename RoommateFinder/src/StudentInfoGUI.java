import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ray on 4/27/2016.
 */

public class StudentInfoGUI {
    private JPanel studentInfoPanel;
    private JLabel studentInfoLabel;
    private JLabel nameLabel;
    private JLabel schoolLabel;
    private JLabel sidLabel;
    private JLabel languageLabel;
    private JTextField nameField;
    private JTextField sidField;
    private JComboBox languageBox;
    private JButton nextButton;
    private JButton previousButton;
    private JComboBox schoolComboBox;
    private JLabel errorLabel;
    private List<String> studentInfo;

    public static void main(String[] args) {
        StudentInfoGUI.createFrame();
    }

    public static void createFrame() {
        JFrame frame = new JFrame("Student Information");
        frame.setContentPane(new StudentInfoGUI().studentInfoPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public StudentInfoGUI() {
        studentInfo = new ArrayList<>();
        nextButton.addActionListener(e -> {

            studentInfo.add(getNameEntry());
            studentInfo.add(getLanguageEntry());
            studentInfo.add(getSidEntry());
            studentInfo.add(getSchoolEntry());

            if (getSidEntry() != null && getNameEntry() != null) {
                PasswordSetupGUI.createFrame();
                ((JFrame) studentInfoPanel.getTopLevelAncestor()).dispose();
            } else {
                errorLabel.setVisible(true);
            }
        });

        previousButton.addActionListener(e -> {
            LogInGUI.createFrame();
            ((JFrame) studentInfoPanel.getTopLevelAncestor()).dispose();
        });
    }

    private String getNameEntry() {
        String nameEntry = nameField.getText();
        if (legitNameEntry()) {
            return nameEntry;
        } else return null;
    }

    private boolean legitNameEntry() {
        String nameEntry = nameField.getText();
        if (nameEntry != null && nameEntry.matches("[a-zA-Z ]+")) {
            return true;
        } else {
            return false;
        }
    }

    private String getSidEntry() {
        String sidEntry = sidField.getText();
        if (sidField.getText().matches("[a-zA-Z]+")) {
            return null;
        }
        else return sidEntry;
    }

    private String getSchoolEntry() {
        return (String) schoolComboBox.getSelectedItem();
    }

    private String getLanguageEntry() {
        return (String) languageBox.getSelectedItem();
    }

}
