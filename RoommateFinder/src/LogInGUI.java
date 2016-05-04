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

    /**
     * Main method of the LogInGUI. Calls for the creation of the frame containing the log in window.
     * Also, it reads in the account file to later be validated against.
     */
    public static void main(String... args) {
        LogInGUI.createFrame();
        ReadFile.read();
    }

    /**
     * Creates the frame containing the log in window.
     */
    public static void createFrame() {
        JFrame frame = new JFrame("Roomie Finder Log In");
        frame.setContentPane(new LogInGUI().loginPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack(); //condensing contents of window to be as packed as possible.
        frame.setLocationRelativeTo(null); //setting location to middle of user's screen.
        frame.setVisible(true);
    }

    /**
     * Constructor for the LogInGUI.
     * Initializes a new ArrayList to monitor the inputted account information [username, password].
     * Initializes action listeners and JButtons. A user is only logged in if the input is valid.
     */
    public LogInGUI() {
        logInEntryInfo = new ArrayList<>();
        logInButton.addActionListener(e -> {
            logInEntryInfo.add(getUsername());
            logInEntryInfo.add(getPassword());

            //System.out.println(modifyPassword());
            if (validateInput()) {
                ((JFrame) loginPanel.getTopLevelAncestor()).dispose(); //closing the current screen.
            }
            else {
                errorLabel.setVisible(true); //displaying an error when the given input is incorrect.
            }
        });

        signUpButton.addActionListener(e -> {
            StudentInfoGUI.createFrame(); //calling for the creation of the sign up frame.
            ((JFrame) loginPanel.getTopLevelAncestor()).dispose(); //closing the current screen.
        });
    }

    /**
     * Method to return the inputted username one is attempting to log in with.
     * @return usernameField.getText - the inputted username in the log in window.
     */
    private String getUsername()
    {
        return usernameField.getText();
    }

    /**
     * Method to return the inputted password one is attempting to log in with.
     * @return passwordField.getText - the inputted password in the log in window.
     */
    private String getPassword()
    {
        return passwordField.getText();
    }

    /**
     * Method to modify the password into its' encrypted state.
     * @return Password.createPassword - the encrypted password by Huffman Tree.
     */
    private int modifyPassword() { return Password.createPassword(getPassword(), getPassword());}

    /**
     * Method to check the validity of the password.
     * Encrypts the password first, then compares against the encrypted password.
     * @return ReadFile.validate - true or false on whether or not the password is correct.
     */
    private boolean validateInput()
    {
        String parsePassCheck = Integer.toString(modifyPassword());
        return ReadFile.validate(getUsername(), parsePassCheck);
    }

    /**
     * Method to return the logInEntryInfo that one used to log in with.
     * @return logInEntryInfo - a List of the username and password.
     */
    private List<String> getLoginInfo()
    {
        return logInEntryInfo;
    }
}
