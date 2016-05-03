import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Launches the Log-in screen of the Roomie Finder application.
 * Created by Raymond Gevorkian on 4/26/2016
 */
public class LogInGUI {
    private JLabel titleLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton logInButton;
    private JButton signUpButton;
    private JLabel errorLabel;
    private JPanel loginPanel;
    private List<String> logInEntryInfo;

    public static void main(String[] args) {
        LogInGUI.createFrame();
        ReadFile.read();
    }

    public static void createFrame() {
        JFrame frame = new JFrame("Roomie Finder Log In");
        frame.setContentPane(new LogInGUI().loginPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public LogInGUI() {
        logInEntryInfo = new ArrayList<>();

        logInButton.addActionListener(e -> {
            logInEntryInfo.add(getUsername());
            logInEntryInfo.add(getPassword());

            if (validateInput())
            {
                ((JFrame) loginPanel.getTopLevelAncestor()).dispose();
                //call new GUI here.
            }
            else { errorLabel.setVisible(true); }
        });

        signUpButton.addActionListener(e -> {
            StudentInfoGUI.createFrame();
            ((JFrame) loginPanel.getTopLevelAncestor()).dispose();
        });
    }

    private String getUsername()
    {
        return usernameField.getText();
    }

    private String getPassword()
    {
        return passwordField.getText();
    }

    private boolean validateInput()
    {
        return ReadFile.validate(getUsername(), getPassword());
    }

    private List<String> getLoginInfo()
    {
        return logInEntryInfo;
    }
}
