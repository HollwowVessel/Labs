import java.util.Comparator;

public class StringCompatator implements Comparator<String> {
    public int compare(String s1, String s2) {
        return Main.count("ro", s1) - Main.count("ro", s2);
    }
}
