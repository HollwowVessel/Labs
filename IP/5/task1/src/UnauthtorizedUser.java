import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UnauthtorizedUser extends AnyUser{


    public AuthorizedUser auth(String userName, String pass){
        ArrayList<String> users = new ArrayList<>();
        this.authStatus.set = false;
        try
        {
            Scanner reader = new Scanner(new File("authedUsers.txt"));
            while(reader.hasNextLine()){
                users.add(reader.next());
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        for(String info : users){
            String authedName = info.split(" ")[0];
            String authedPass = info.split(" ")[1];
            String type = info.split(" ")[2];
            if(authedName.equals(userName) && authedPass.equals(pass)){
                this.authStatus = true;
                System.out.println("Logged");
                return new AuthorizedUser(type);
            }
        }
        if(!this.authStatus){
            System.out.println("Not found");
        }
        return null;
    }
}
