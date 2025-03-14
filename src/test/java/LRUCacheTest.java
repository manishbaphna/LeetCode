import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    @Test
    void test_basicFunctionality(){
        int capacity = 2;
        LRUCache DUT = new LRUCache(capacity);

        DUT.put(1,1);
        DUT.put(2,2);
        assertEquals(1, DUT.get(1));
        DUT.put(3,3);
        assertEquals(-1, DUT.get(2));
        DUT.put(4,4);
        assertEquals(-1, DUT.get(1));
        assertEquals(3, DUT.get(3));
        assertEquals(4, DUT.get(4));
    }

    @Test
    void test_repeatValuesForAKey(){
        int capacity = 2;
        LRUCache DUT = new LRUCache(capacity);

        DUT.put(1,1);
        DUT.put(2,2);
        assertEquals(1, DUT.get(1));
        DUT.put(2,22);
        DUT.put(3,3);
        assertEquals(22, DUT.get(2));
        assertEquals(-1, DUT.get(1));
        DUT.put(4,4);
        assertEquals(22, DUT.get(2));
        assertEquals(-1, DUT.get(3));
        assertEquals(4, DUT.get(4));
    }
}