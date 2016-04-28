import javax.swing.JFrame;
public class Driver
{
    /**
     * Main entry for the Application.
     * Choose this file as your Manifest if testing as a jar in Eclipse.
     * Automatically builds in other IED's. 
     */
    public static void main( String[]args )
    {
        JFrame frame = new JFrame( "Roommate Finder" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setLocation( 50,50 );
        MainMenuGUI ui = new MainMenuGUI();
        frame.add( ui );
        frame.pack();
        frame.setVisible( true );
    }
}
