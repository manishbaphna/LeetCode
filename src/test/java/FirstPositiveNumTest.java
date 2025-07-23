import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstPositiveNumTest {

    @Test
    void basicTest1(){
        int [] arr = {2};
        FirstPositiveNum dut = new FirstPositiveNum();

        int res = dut.solution(arr);
        assertEquals(1, res);
    }

    @Test
    void basicTest2(){
        int [] arr = {1};
        FirstPositiveNum dut = new FirstPositiveNum();

        int res = dut.solution(arr);
        assertEquals(2, res);
    }


    @Test
    void basicTest3(){
        int [] arr = {2,3,4,1};
        FirstPositiveNum dut = new FirstPositiveNum();

        int res = dut.solution(arr);
        assertEquals(5, res);
    }


    @Test
    void basicTest4(){
        int [] arr = {2,3,5,1};
        FirstPositiveNum dut = new FirstPositiveNum();

        int res = dut.solution(arr);
        assertEquals(4, res);
    }

    @Test
    void basicTest5(){
        int [] arr = {2,3,5,1,1,1,1,2};
        FirstPositiveNum dut = new FirstPositiveNum();

        int res = dut.solution(arr);
        assertEquals(4, res);
    }


    @Test
    void basicTest6(){
        int [] arr = {-2,3,-5,1};
        FirstPositiveNum dut = new FirstPositiveNum();

        int res = dut.solution(arr);
        assertEquals(2, res);
    }

}