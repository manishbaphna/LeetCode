import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosOfFirstAndLastTest {

    @Test
    void basicTest(){
        PosOfFirstAndLast DUT = new PosOfFirstAndLast();
        int[] result = DUT.searchRange(new int[]{5,7,7,8,8,10}, 8);
        int[] expected = {3,4};
        assertArrayEquals (expected, result);
    }

    @Test
    void basicTest2(){
        PosOfFirstAndLast DUT = new PosOfFirstAndLast();
        int[] result = DUT.searchRange(new int[]{5,7,7,8,8,10}, 6);
        int[] expected = {-1,-1};
        assertArrayEquals (expected, result);
    }

    @Test
    void basicTestNull(){
        PosOfFirstAndLast DUT = new PosOfFirstAndLast();
        int[] result = DUT.searchRange(null, 6);
        int[] expected = {-1,-1};
        assertArrayEquals (expected, result);
    }

    @Test
    void basicTest3(){
        PosOfFirstAndLast DUT = new PosOfFirstAndLast();
        int[] result = DUT.searchRange(new int[]{5}, 5);
        int[] expected = {0,0};
        assertArrayEquals (expected, result);
    }

    @Test
    void basicTest4(){
        PosOfFirstAndLast DUT = new PosOfFirstAndLast();
        int[] result = DUT.searchRange(new int[]{1,3}, 1);
        int[] expected = {0,0};
        assertArrayEquals (expected, result);
    }

    @Test
    void basicTest5(){
        PosOfFirstAndLast DUT = new PosOfFirstAndLast();
        int[] result = DUT.searchRange(new int[]{1,1,1}, 1);
        int[] expected = {0,2};
        assertArrayEquals (expected, result);
    }
}