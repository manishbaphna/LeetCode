import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MaximumUnitsOnATruckTest {

    MaximumUnitsOnATruck DUT = new MaximumUnitsOnATruck();

    @Test
    void basicTests1(){
        int[][] boxtypes= {{1,3},{2,2},{3,1}};
        int truckSize = 4;
        assertEquals(8, DUT.maximumUnits(boxtypes, truckSize));
    }

    @Test
    void basicTests2(){
        int boxtypes[][] = {{5,10},{2,5},{4,7},{3,9}};
        int truckSize = 10;
        assertEquals(91, DUT.maximumUnits(boxtypes, truckSize));
    }

}