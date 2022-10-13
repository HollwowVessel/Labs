import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

class MainTest {

    @org.junit.jupiter.api.Test
     void basicTest() {
        assertEquals(Main.delete("Hello /*World!*/"), "Hello");
    }
    @org.junit.jupiter.api.Test
    void testWithFewSlashes() {
        assertEquals(Main.delete("Hello /*World!*/ /*World!*/ /*Help*/"), "Hello");
    }
    @org.junit.jupiter.api.Test
    void testWithoutSlashes() {
        assertEquals(Main.delete("Hello World!"), "Hello World!");
    }
}