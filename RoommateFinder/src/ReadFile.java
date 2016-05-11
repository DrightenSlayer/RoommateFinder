import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Reads the username and password file to determine if a
 * user can log in.
 */
public class ReadFile {
    private static ArrayList<String> userNames = new ArrayList<>();
    private static ArrayList<String> passwords = new ArrayList<>();
    private static String str;

    /**
     * Reads the file in and generates the user name array and password array.
     * userNames adds all names in lower case in order for the log in name
     * to not be case-sensitive.
     */
    static void read()
    {
        ArrayList<String> accountInfo = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get("NewAccounts.txt"))){
            while( (str = br.readLine()) != null)
                accountInfo.add(str);

            for (int i = 0; i < accountInfo.size() - 1; i += 2) {
                userNames.add(accountInfo.get(i).toLowerCase());
                passwords.add(accountInfo.get(i + 1));
            }
        } catch (IOException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }

    /**
     * Decrypts the file, and then validates it.
     * The user field is changed to lower case in order for the log in
     * name to not be case-sensitive.
     * @param user the user name
     * @param pass the password
     * @return true if the user/password combination is legal
     */
    static boolean validate(String user, String pass)
    {
        user = user.toLowerCase();
        int index = userNames.indexOf(user);
        if(index == -1) return false;

        return (userNames.get(index).equals(user) && passwords.get(index).equals(pass));
    }
}

