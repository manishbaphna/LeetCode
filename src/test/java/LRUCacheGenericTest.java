import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheGenericTest {

    @Test
    void test_basicFunctionality(){
        int capacity = 2;
        LRUCacheGeneric<Integer, Integer> DUT = new LRUCacheGeneric(capacity);

        DUT.put(1,1);
        DUT.put(2,2);
        assertEquals(1, DUT.get(1));
        DUT.put(3,3);
        assertEquals(null, DUT.get(2));
        DUT.put(4,4);
        assertEquals(null, DUT.get(1));
        assertEquals(3, DUT.get(3));
        assertEquals(4, DUT.get(4));
    }

    @Test
    void test_repeatValuesForAKey(){
        int capacity = 2;
        LRUCacheGeneric<Integer, Integer> DUT = new LRUCacheGeneric(capacity);


        DUT.put(1,1);
        DUT.put(2,2);
        assertEquals(1, DUT.get(1));
        DUT.put(2,22);
        DUT.put(3,3);
        assertEquals(22, DUT.get(2));
        assertEquals(null, DUT.get(1));
        DUT.put(4,4);
        assertEquals(22, DUT.get(2));
        assertEquals(null, DUT.get(3));
        assertEquals(4, DUT.get(4));
    }

    @Test
    void test_basicFunctionality_double_int(){
        int capacity = 2;
        LRUCacheGeneric<Double, Integer> DUT = new LRUCacheGeneric(capacity);

        DUT.put(1d,1);
        DUT.put(2d,2);
        assertEquals(1, DUT.get(1d));
        DUT.put(3d,3);
        assertEquals(null, DUT.get(2d));
        DUT.put(4.4,4);
        assertEquals(null, DUT.get(1d));
        assertEquals(3, DUT.get(3d));
        assertEquals(4, DUT.get(4.4));
    }

    @Test
    void test_basicFunctionality_nullKeys(){
        int capacity = 2;
        LRUCacheGeneric<Double, Integer> DUT = new LRUCacheGeneric(capacity);

        DUT.put(null,1);
        DUT.put(null,2);
        assertEquals(2, DUT.get(null));
        assertThrows(NullPointerException.class, () -> {DUT.put(null,null);});

    }

}