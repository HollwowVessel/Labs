import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void firstSort() {
        String[] arr = {"rororoad", "road", "road", "goroda", "helpro", "road", "word", "word"};
        String[] res = { "word", "word" ,"road", "road", "rororoad", "goroda" ,"helpro","road"};
        Main.firstSort("ro", res);
        assertArrayEquals(arr, res);
    }

    @Test
    void secondSort(){
        String[] arr = {"helpro", "goroda", "road", "rororoad", "road", "road", "word", "word"};
        String[] res = {"word", "word" ,"road", "road", "rororoad", "goroda" ,"helpro","road"};
        Main.secondSort("ro",res);
        assertArrayEquals(arr, res);
    }

    @Test
    void twoSorts() {
        String[] arr = {"helpro", "goroda", "road", "rororoad", "road", "road", "word", "word"};
        String[] res = {"word", "word" ,"road", "road", "rororoad", "goroda" ,"helpro","road"};
        Main.firstSort("ro", res);
        Main.secondSort("ro", res);
        assertArrayEquals(arr, res);
    }
}