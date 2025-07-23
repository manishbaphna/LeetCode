import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VersionCompareTest {

    @Test
    void basicTest1(){
        VersionCompare DUT = new VersionCompare();
        assertEquals(-1, DUT.compareVersion("1.2", "1.10"));
        assertEquals(0, DUT.compareVersion("1.01", "1.001"));
        assertEquals(1, DUT.compareVersion("1.0.1", "1"));
        assertEquals(0, DUT.compareVersion("1.0.0", "1.0.0.0.0.0"));
        assertEquals(1, DUT.compareVersion("1.0.1", "1.0"));
        assertEquals(-1, DUT.compareVersion("1.0", "1.0.1"));
    }

    @Test
    void basicTest2(){
        String version = "1.2.3.4";
        int start = 0;
        while( start < version.length()) {
            int k = version.indexOf('.', start);
            k = (k == -1) ? version.length() : k;
            String str = version.substring(start, k);
            System.out.println(str);
            start = 1 + k;
        }

    }

}