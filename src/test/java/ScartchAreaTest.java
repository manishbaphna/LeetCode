import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScartchAreaTest {


    @Test
    void simpleTestsForValidCases(String s, Boolean result){

        Integer	nineC	=	9;
        Integer	nineD	=	9;
        System.out.println(nineC	==	nineD);//true
        System.out.println(nineC.equals(nineD));//true

        nineC.equals(nineD);

        Object x;
        x.toString();

    }
    boolean equals ( Object o){
        if ( o instanceof Integer i) {
            if ( i == this )
                return true;
        }
        return false;
    }
}

