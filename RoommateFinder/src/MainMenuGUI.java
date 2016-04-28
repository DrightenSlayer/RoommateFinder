import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * MainMenu of the Roomie Finder Application.
 * Launches the frame that acts as the log in screen.
 */
public class MainMenuGUI extends JPanel implements ActionListener
{
    ImageIcon background; //Sets background of the MainMenu
    JLabel MainMenu; //Text for the MainMenu (can be made into an Image Icon)

    JLabel user; //"USERNAME" text
    JLabel pass; //"PASSWORD" text

    JPasswordField password; //password entry
    JTextField username; //username entry

    ImageIcon loginIcon;
    JLabel loginLabel;
    JButton loginButton; //checks with password encoding to ensure password is correct.

    JLabel title; //can be an ImageIcon too.. if we want to make one.

    JButton signUp; //sign up button for new people.
    JLabel signUpText; //sign up text box.

    JLabel errorText; //error text if username or password is wrong.
    public MainMenuGUI()
    {
        ReadFile.read();
        /**
         * SOME API info:
         * setBounds(int x, int y, int width, int height)
         */
        this.setLayout( null );
        setPreferredSize( new Dimension( 1200, 800 ) );
        this.setFocusable(true);

        /**
         * Setting up the JLabel for the username.
         */

        user = new JLabel();
        this.add(user);
        user.setBounds(345, 350, 150, 22);
        user.setText( "USERNAME:" );
        user.setFont( new Font( "Arial", Font.BOLD, 25 ) );
        user.setVisible(true);

        /**
         * Setting up the JLabel for the password..
         */
        pass = new JLabel();
        this.add(pass);
        pass.setBounds(345, 375, 160, 22);
        pass.setText( "PASSWORD:" );
        pass.setFont( new Font( "Arial", Font.BOLD, 25 ) );
        pass.setVisible(true);

        /**
         * Setting up the login text field for username ( can be changed to formatted text field ).
         */
        username = new JTextField();
        this.add(username);
        username.setVisible(true);
        username.addActionListener(this); //Validate username...
        username.setBounds(505, 350, 150, 22);

        /**
         * Setting up password text field...
         */
        password = new JPasswordField();
        this.add(password);
        password.setVisible(true);
        password.addActionListener(this); //Validate password..
        password.setBounds(505, 375, 150, 22);

        /**
         * Setting up loginButton.
         * TODO: error checking with password here, validating username exists.
         */
        loginButton = new JButton( "Login" );
        this.add( loginButton );
        loginButton.setVisible( true );
        loginButton.addActionListener( this );  //--> Todo: Make this go to next window after checking password.
        loginButton.setBounds( 655, 350, 150, 48 );
        loginButton.setBackground( Color.RED ); //can change this to whatever.
        loginButton.setFont( new Font( "Arial", Font.BOLD, 23 ) ); //can change this to whatever, or we can make an image.
        loginButton.setOpaque( true );

        /**
         * Setting up the sign up label of the Main Menu.
         */

        signUpText = new JLabel();
        this.add(signUpText);
        signUpText.setBounds(415, 415, 360, 22);
        signUpText.setText( "New? Sign up here." );
        signUpText.setFont( new Font( "Arial", Font.BOLD, 18 ) );
        signUpText.setVisible(true);

        /**
         * Setting up the error text if a password is entered incorrectly.
         */

        errorText = new JLabel();
        this.add(errorText);
        errorText.setBounds(495, 320, 250, 22);
        errorText.setText(" Incorrect Password and or Username.");
        errorText.setFont(new Font( "Arial", Font.BOLD, 12));
        errorText.setVisible(false);

        /**
         * Setting up signUp Button of the Main Menu.
         */
        signUp = new JButton( "Sign Up." );
        this.add( signUp );
        signUp.setVisible( true );
        signUp.addActionListener( this );  //-->
        signUp.setBounds( 595, 415, 130, 50 );
        signUp.setBackground( Color.red ); //can change this to whatever.
        signUp.setFont( new Font( "Arial", Font.BOLD, 16 ) ); //can change this to whatever, or we can make an image.
        signUp.setOpaque( true );

        /**
         * Setting up title of Main Menu.
         */
        title = new JLabel();
        this.add( title );
        title.setText( "Roommate Finder" );
        title.setFont( new Font( "Arial", Font.BOLD, 70 ) );
        title.setBounds( 300,50,885,50 );
        title.setOpaque( true );
        title.setVisible( true );
    }

    public void actionPerformed( ActionEvent e ) //Maybe make a different UI class for each frame?
    {
        JButton button = ( JButton )e.getSource();

        String passwordEntry = password.getText();
        String usernameEntry = username.getText();

        boolean existingUsername = false;
        boolean correctPassword = false;

        //ReadFile.validate();

        System.out.println(usernameEntry); //to print to command line
        System.out.println(passwordEntry); //to print to command line

        //Profile profile = new Profile();
        //profile.isValid(passwordEntry);

        //--> do this, else, display error.
        //Error can be displayed by something like 'passwordDetails.setText("Incorrect password!");
        //if(ReadFile.usernames.contains(usernameEntry)) existingUsername = true;

        if(button == loginButton && ReadFile.validate(usernameEntry, passwordEntry) == false)
        {
            errorText.setVisible(true);
        }
        //System.out.print(ReadFile.usernames);
        //System.out.println(ReadFile.usernames.contains(usernameEntry));
        if( button == loginButton && ReadFile.validate(usernameEntry, passwordEntry) == true) //going to new screen, clear the current.
        {
            //Jframe newclass = new JFrame();
            //newclass.setVisible();
            errorText.setVisible(false);
            loginButton.setVisible(false);
            title.setVisible(false);
            password.setVisible(false);
            user.setVisible(false);
            username.setVisible(false);
            pass.setVisible(false);
            signUpText.setVisible(false);
            signUp.setVisible(false);
            this.repaint();
        }

        if ( button == signUp ) //going to new screen, clear the current.
        {
            //SignUpGUI.display();
            errorText.setVisible(false);
            loginButton.setVisible(false);
            title.setVisible(false);
            password.setVisible(false);
            user.setVisible(false);
            username.setVisible(false);
            pass.setVisible(false);
            signUpText.setVisible(false);
            signUp.setVisible(false);
            this.repaint();
        }
        this.requestFocusInWindow();
        this.setFocusable( true );
        this.repaint();
    }
}



