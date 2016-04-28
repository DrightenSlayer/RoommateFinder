import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class ReadFile {

    static ArrayList<String> usernames = new ArrayList<>();
    static ArrayList<String> passwords = new ArrayList<>();

    public static void main(String[] args) {

    }

    public static void read()
    {
        File accounts = new File("src/accounts");
        try {
            Scanner scan = new Scanner(accounts);
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                String[] accountInfo = s.split("\\|");
                usernames.add(accountInfo[0]);
                System.out.println(usernames);
                passwords.add(accountInfo[1]);
                //System.out.println(accountInfo[0] + " " + accountInfo[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean validate(String user, String pass)
    {
        //call decrypt here, then validate.
        int index = usernames.indexOf(user);
        if(index == -1) return false;
        if(usernames.get(index).equals(user) && passwords.get(index).equals(pass))
        {
            return true;
        }
        else return false;
    }
}

