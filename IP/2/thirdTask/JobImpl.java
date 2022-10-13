import by.vsu.mf.ai.ssd.strings.Job;

public class JobImpl implements Job{
    public void perform(StringBuilder string){
        int firstIndex = string.indexOf("/*");
        int secondIndex = string.indexOf("*/");
        while(firstIndex != -1 && secondIndex != -1){
            string.delete(firstIndex, secondIndex + 2);
            firstIndex = string.indexOf("/*");
            secondIndex = string.indexOf("*/");
        };

    }
}