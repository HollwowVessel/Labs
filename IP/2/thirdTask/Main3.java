
import by.vsu.mf.ai.ssd.strings.Manager;
import by.vsu.mf.ai.ssd.strings.Job;

public class Main3{
    public static void main(String[] args){
        StringBuilder string = new StringBuilder();
        JobImpl ji = new JobImpl();
        ji.perform(string);
        Manager.createWindow(ji);   
    }
}