
public class Main {
    public static String delete(String s1){
        StringBuilder res = new StringBuilder(s1);
        int firstIndex = res.indexOf("/*");
        int secondIndex = res.indexOf("*/");
        while(firstIndex != -1 && secondIndex != -1){
            res.delete(firstIndex, secondIndex + 2);
            firstIndex = res.indexOf("/*");
            secondIndex = res.indexOf("*/");
        };
        return res.toString().trim();
    }
    public static void main(String[] args)
    {
        System.out.print(delete(args[0]));
    }
}