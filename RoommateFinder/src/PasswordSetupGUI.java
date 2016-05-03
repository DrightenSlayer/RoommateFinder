import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Ray on 4/29/2016.
 */
public class PasswordSetupGUI {
    private JLabel passwordSetupLabel;
    private JLabel desiredNameLabel;
    private JLabel createPwdLabel;
    private JLabel pwdCheckLabel;
    private JTextField usernameEntryField;
    private JPasswordField pwdEntryField;
    private JPasswordField pwdCheckField;
    private JPanel accountSetupPanel;
    private JButton nextButton;
    private JButton prevButton;
    private List<String> accountSecurityInfo;

    public static void main(String[] args) {
        PasswordSetupGUI.createFrame();
    }

    public static void createFrame() {
        JFrame frame = new JFrame("Account Setup");
        frame.setContentPane(new PasswordSetupGUI().accountSetupPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public PasswordSetupGUI() {
        accountSecurityInfo = new ArrayList<>();
        accountSecurityInfo.add(getUsernameEntry());
        accountSecurityInfo.add(getPasswordEntry());
        nextButton.addActionListener(e -> {
            if (checkPasswords())
            {
                //link to William's GUI here.
                ((JFrame) accountSetupPanel.getTopLevelAncestor()).dispose();
            }
            else ;
        });
        prevButton.addActionListener(e -> {
            StudentInfoGUI.createFrame();
            ((JFrame) accountSetupPanel.getTopLevelAncestor()).dispose();
        });
    }

    private String getUsernameEntry()
    {
        return usernameEntryField.getText();
    }

    private String getPasswordEntry()
    {
        if(checkPasswords()) { return pwdEntryField.getText(); }
        else return null;
    }

    private boolean checkPasswords()
    {
        return pwdEntryField.getText().equals(pwdCheckField.getText());
    }

}
