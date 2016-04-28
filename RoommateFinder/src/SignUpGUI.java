import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
/**
 * Can make this look much more pretty in IntelliJ (wanted to wait to see how that's going to work for Eclipse).
 * Just some basic 'fluff' of the UI is here. 
 * Need to do this still, but want to wait until I discuss with William how we want to approach the organization
 * of the classes for the UI.
 */
public class SignUpGUI extends JPanel implements ActionListener 
{
    JLabel username;
    JLabel password;
    
    JLabel school;
    JLabel major;
    
    JLabel language;    
    JLabel name;
    JLabel gender;
    
    JTextField usernameEntry;
    JTextField passwordEntry;
    
    JTextField schoolOfChoice;
    JTextField majorOfChoice;
    
    JTextField languageEntry;
    JTextField nameEntry;
    JTextField genderEntry;
    
    public SignUpGUI()
    {              
        this.setLayout( null );
        setPreferredSize( new Dimension( 1200, 800 ) );
        this.setFocusable(true);
    }

    public void actionPerformed( ActionEvent e )
    {
        
    }
    
    public void display()
    {
        /**
        JFrame signUpFrame = new JFrame("Sign Up");
        signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signUpFrame.setLayout(new BorderLayout());
        */                
    }    
}
