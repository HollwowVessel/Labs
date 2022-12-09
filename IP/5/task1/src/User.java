import java.util.ArrayList;

public abstract class User{
    boolean authStatus = false;
     ArrayList<Group> groups = new ArrayList<>();
    public abstract void printGroups();

    public abstract void printGroupMembers(String name);
}
