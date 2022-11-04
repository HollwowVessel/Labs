

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

class Test {

    @org.junit.jupiter.api.Test
    void basicTestMax() {
        ArrayList<String[]> init = new ArrayList<>();
        init.add(new String[]{"1", "2", "3"});
        init.add(new String[]{"4", "5", "6"});
        init.add(new String[]{"7", "8", "9"});
        assertArrayEquals(Main.findMax(init), new int[]{9,2,2});
    }
    @org.junit.jupiter.api.Test
    void basicTestMin() {
        ArrayList<String[]> init = new ArrayList<>();
        init.add(new String[]{"1", "2", "3"});
        init.add(new String[]{"4", "5", "6"});
        init.add(new String[]{"7", "8", "9"});
        assertArrayEquals(Main.findMin(new int[]{2,2},init), new int[]{1,0,0});
    }
    @org.junit.jupiter.api.Test
    void testMaxWithFewMax() {
        ArrayList<String[]> init = new ArrayList<>();
        init.add(new String[]{"1", "2", "3", "9"});
        init.add(new String[]{"4", "5", "6", "9"});
        init.add(new String[]{"7", "8", "9", "9"});
        init.add(new String[]{"7", "8", "9", "9"});
        assertArrayEquals(Main.findMax(init), new int[]{9, 3, 3});
    }
    @org.junit.jupiter.api.Test
    void testMaxWithFewMin() {
        ArrayList<String[]> init = new ArrayList<>();
        init.add(new String[]{"1", "1", "1", "1"});
        init.add(new String[]{"4", "5", "6", "9"});
        init.add(new String[]{"7", "8", "9", "9"});
        init.add(new String[]{"7", "8", "9", "9"});
        assertArrayEquals(Main.findMin(new int[]{9,3,3},init), new int[]{1, 0, 0});
    }
}