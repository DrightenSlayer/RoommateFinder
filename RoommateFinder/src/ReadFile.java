import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.util.ArrayList;

public class ReadFile {

    static ArrayList<String> usernames = new ArrayList<>();
    static ArrayList<String> passwords = new ArrayList<>();
    static String str;

    public static void main(String[] args) {
        read();
    }

    static void read()
    {
        ArrayList<String> accountInfo = new ArrayList<>();
        File accounts = new File("NewAccounts.txt");
        try (BufferedReader br = Files.newBufferedReader(Paths.get("NewAccounts.txt"))){
            while( (str = br.readLine()) != null)
                accountInfo.add(str);

            for (int i = 0; i < accountInfo.size() - 1; i += 2) {
                usernames.add(accountInfo.get(i));
                passwords.add(accountInfo.get(i + 1));
            }


            System.out.println(accountInfo);
            System.out.println(usernames);
            System.out.println(passwords);

        } catch (IOException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }

    static boolean validate(String user, String pass)
    {
        //call decrypt here, then validate.
        int index = usernames.indexOf(user);
        if(index == -1) return false;

        return (usernames.get(index).equals(user) && passwords.get(index).equals(pass));
//        if(usernames.get(index).equals(user) && passwords.get(index).equals(pass))
//        {
//            return true;
//        }
//        else return false;
    }

}

