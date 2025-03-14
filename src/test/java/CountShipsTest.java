import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountShipsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void basic_test1_countShips() {
        CountShips dut = new CountShips();
        CountShips.Point BL = new CountShips.Point(4,8);
        CountShips.Point TR = new CountShips.Point(5,9);


        int count = dut.countShips(BL, TR);
        assertEquals(1,count);
    }

    @Test
    void basic_test2_countShips() {
        CountShips dut = new CountShips();
        CountShips.Point BL = new CountShips.Point(2,6);
        CountShips.Point TR = new CountShips.Point(8,10);


        int count = dut.countShips(BL, TR);
        assertEquals(2,count);
    }

    @Test
    void basic_test3_countShips() {
        CountShips dut = new CountShips();
        CountShips.Point BL = new CountShips.Point(7,7);
        CountShips.Point TR = new CountShips.Point(8,9);


        int count = dut.countShips(BL, TR);
        assertEquals(1,count);
    }

}