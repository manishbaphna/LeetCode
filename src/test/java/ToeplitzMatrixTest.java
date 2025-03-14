import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToeplitzMatrixTest {
    ToeplitzMatrix DUT = new ToeplitzMatrix();

    @Test
    void test1() {
        int[][] arr = {{1,2,3,4},
                       {5,1,2,3},
                       {6,5,1,2}};

        assertTrue(DUT.isToeplitz(arr));
    }

    @Test
    void test2() {
        int[][] arr = {{1,2,3,4},
                {5,1,9,3},
                {6,5,1,2}};

        assertFalse(DUT.isToeplitz(arr));
    }

    @Test
    void test3() {
        int[][] arr = {{4,0},{9,4}};

        assertTrue(DUT.isToeplitz(arr));
    }

    @Test
    void test4() {
        int[][] arr = {{6,4,4}};

        assertTrue(DUT.isToeplitz(arr));
    }

    @Test
    void test5() {
        int[][] arr = {{3},{5},{6}};

        assertTrue(DUT.isToeplitz(arr));
    }

    @Test
    void test6() {
        int[][] arr = {{3,9},{5,3},{6,5}};

        assertTrue(DUT.isToeplitz(arr));
    }

    @Test
    void test7() {
        int[][] arr = {{3,1,7},{4,1,1},{2,4,3}};

        assertFalse(DUT.isToeplitz(arr));
    }

    @Test
    void test8() {
        int[][] arr = {{8,8,8,8,8},{8,8,8,8,9},{8,8,8,8,8},{8,8,8,8,8},{8,8,8,8,8}};

        assertFalse(DUT.isToeplitz(arr));
    }

}