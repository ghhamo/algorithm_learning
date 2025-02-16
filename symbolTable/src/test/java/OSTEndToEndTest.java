import job.OST;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OSTEndToEndTest {

    private OST<Integer, String> ost;

    @BeforeAll
    void setup() {
        ost = new OST<>(5);
    }

    @Test
    void testInsertAndRetrieve() {
        ost.insert(3, "Three");
        ost.insert(1, "One");
        ost.insert(2, "Two");
        assertEquals("One", ost.scan(1));
        assertEquals("Two", ost.scan(2));
        assertEquals("Three", ost.scan(3));
    }

    @Test
    void testUpdateValue() {
        ost.insert(1, "Initial");
        assertEquals("Initial", ost.scan(1));
        ost.insert(1, "Updated");
        assertEquals("Updated", ost.scan(1));
    }

    @Test
    void testSearchNonExistentKey() {
        assertNull(ost.scan(99));
    }

    @Test
    void testResizeFunctionality() {
        ost.insert(1, "One");
        ost.insert(2, "Two");
        ost.insert(3, "Three");
        ost.insert(4, "Four");
        ost.insert(5, "Five");
        ost.insert(6, "Six");
        assertEquals("Six", ost.scan(6));
    }

    @Test
    void testInsertionOrder() {
        ost.insert(10, "Ten");
        ost.insert(5, "Five");
        ost.insert(15, "Fifteen");
        assertEquals("Five", ost.scan(5));
        assertEquals("Ten", ost.scan(10));
        assertEquals("Fifteen", ost.scan(15));
    }

    @Test
    void testEmptyOST() {
        OST<Integer, String> emptyOst = new OST<>(5);
        assertThrows(IllegalArgumentException.class, () -> emptyOst.scan(1));
    }

    @AfterAll
    void teardown() {
        System.out.println("E2E tests finished.");
    }

}
