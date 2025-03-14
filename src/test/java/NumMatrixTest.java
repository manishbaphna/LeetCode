import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumMatrixTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void test_sumRegion() {
        int [][] matrix = {{-4, -5}};
        NumMatrix dut = new NumMatrix(matrix);
        int sum = dut.sumRegion(0,0,0,1);
        assertEquals(-9, sum);
        assertEquals(-5, dut.sumRegion(0,1,0,1));

    }
}