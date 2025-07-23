import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumGapTest {

    @Test
    void basicTest1(){
        MaximumGap DUT = new MaximumGap();
        assertEquals(0, DUT.maximumGap(new int[]{1}));
    }

    @Test
    void basicTest2(){
        MaximumGap DUT = new MaximumGap();
        assertEquals(3, DUT.maximumGap(new int[]{3,3,6,6}));
    }

    @Test
    void basicTest3(){
        MaximumGap DUT = new MaximumGap();
        assertEquals(3, DUT.maximumGap(new int[]{1,3,6,9}));
    }

    @Test
    void basicTest4(){
        MaximumGap DUT = new MaximumGap();
        assertEquals(91, DUT.maximumGap(new int[]{9,1,5,100}));
    }
}