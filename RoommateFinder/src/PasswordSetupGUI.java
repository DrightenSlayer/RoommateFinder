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
 * Creates the GUI for the password set up
 */
public class PasswordSetupGUI {
    private JLabel nameLabel;
    private JLabel createPwdLabel;
    private JLabel pwdCheckLabel;
    private JTextField nameEntryField;
    private JPasswordField pwdEntryField;
    private JPasswordField pwdCheckField;
    private JPanel accountSetupPanel;
    private JButton nextButton;
    private JButton prevButton;
    private JLabel passwordSetupLabel;
    private JLabel errorLabel;
    private List<String> accountSecurityInfo;
    private List<String> userName;
    private final Charset UTF8 = StandardCharsets.UTF_8;
    Password pClass;
    static String name;

    /**
     * Creates the main frame of the password creation.
     */
    public static void createFrame() {
        JFrame frame = new JFrame("Account Setup");
        frame.setContentPane(new PasswordSetupGUI().accountSetupPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Creates the password setup fields, buttons, and the action listeners.
     * Writes the student's name into a StudentInfo text file to be saved, and
     * the student's name and encrypted password into a NewAccounts file to be
     * validated later at login.
     */
    PasswordSetupGUI() {
        $$$setupUI$$$();
        accountSecurityInfo = new ArrayList<>();
        userName = new ArrayList<>();

        nextButton.addActionListener(e -> {
            accountSecurityInfo.add(getNameEntry());
            accountSecurityInfo.add("" + getHashedPassword());
            userName.add(getNameEntry());

            if (checkPasswords() && !noInput()) {
                try {
                    Files.write(Paths.get("NewAccounts.txt"), accountSecurityInfo, UTF8,
                            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    Files.write(Paths.get("StudentInfo.txt"), userName, UTF8,
                            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                } catch (IOException exc) {
                    exc.printStackTrace();
                }
                ((JFrame) accountSetupPanel.getTopLevelAncestor()).dispose();
                StudentInfoGUI.createFrame();
            } else errorLabel.setVisible(true);
        });

        prevButton.addActionListener(e -> {
            LogInGUI.createFrame();
            ((JFrame) accountSetupPanel.getTopLevelAncestor()).dispose();
        });
    }

    /**
     * Gets the name of the user that was inputted
     * @return the user's inputted name
     */
    private String getNameEntry() {
        return nameEntryField.getText();
    }

    /**
     * Gets the hashed password, to be written into the NewAccounts text file.
     * @return the hashed password
     */
    private int getHashedPassword() {
        if (checkPasswords())
            return pClass.createPassword(pwdEntryField.getText(), pwdCheckField.getText());
        return 0;
    }

    /**
     * Checks to see whether both the password and the re-entered password
     * are equal, to make sure the user enters the correct password.
     * @return true if they are equal
     */
    private boolean checkPasswords() {
        return pwdEntryField.getText().equals(pwdCheckField.getText());
    }

    /**
     * Checks if any of the fields are empty.
     * @return true if any fields are empty.
     */
    private boolean noInput() {
        return pwdEntryField.getText().isEmpty();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        accountSetupPanel = new JPanel();
        accountSetupPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(7, 6, new Insets(10, 25, 25, 25), -1, -1));
        nameEntryField = new JTextField();
        accountSetupPanel.add(nameEntryField, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pwdEntryField = new JPasswordField();
        accountSetupPanel.add(pwdEntryField, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pwdCheckField = new JPasswordField();
        pwdCheckField.setText("");
        accountSetupPanel.add(pwdCheckField, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        createPwdLabel = new JLabel();
        createPwdLabel.setFont(new Font(createPwdLabel.getFont().getName(), createPwdLabel.getFont().getStyle(), 20));
        createPwdLabel.setText("Password :");
        accountSetupPanel.add(createPwdLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameLabel = new JLabel();
        nameLabel.setFont(new Font(nameLabel.getFont().getName(), nameLabel.getFont().getStyle(), 20));
        nameLabel.setText("Name :");
        accountSetupPanel.add(nameLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pwdCheckLabel = new JLabel();
        pwdCheckLabel.setFont(new Font(pwdCheckLabel.getFont().getName(), pwdCheckLabel.getFont().getStyle(), 20));
        pwdCheckLabel.setText("Confirm Password :");
        accountSetupPanel.add(pwdCheckLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_EAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        accountSetupPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 5, 7, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        accountSetupPanel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 7, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        accountSetupPanel.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        passwordSetupLabel = new JLabel();
        passwordSetupLabel.setFont(new Font(passwordSetupLabel.getFont().getName(), passwordSetupLabel.getFont().getStyle(), 36));
        passwordSetupLabel.setText("Account Setup");
        accountSetupPanel.add(passwordSetupLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        accountSetupPanel.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        nextButton = new JButton();
        nextButton.setText("Next");
        accountSetupPanel.add(nextButton, new com.intellij.uiDesigner.core.GridConstraints(5, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        prevButton = new JButton();
        prevButton.setText("Prev");
        accountSetupPanel.add(prevButton, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        errorLabel = new JLabel();
        errorLabel.setFont(new Font(errorLabel.getFont().getName(), errorLabel.getFont().getStyle(), 12));
        errorLabel.setForeground(new Color(-65536));
        errorLabel.setText("Error! Please validate input.");
        errorLabel.setVisible(false);
        accountSetupPanel.add(errorLabel, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     *
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return accountSetupPanel;
    }
}
