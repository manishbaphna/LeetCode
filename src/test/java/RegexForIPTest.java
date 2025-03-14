import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexForIPTest {

    @Test
    void basic_validIPsTest(){
        assertTrue(RegexForIP.isValidIP("000.12.12.034"));
        assertTrue(RegexForIP.isValidIP("121.234.12.12"));
        assertTrue(RegexForIP.isValidIP("23.45.12.56"));
        assertTrue(RegexForIP.isValidIP("255.0.0.1"));
    }

    @Test
    void basic_inValidIPsTest(){
        assertFalse(RegexForIP.isValidIP("000.12.234.23.23"));
        assertFalse(RegexForIP.isValidIP("666.666.23.23"));
        assertFalse(RegexForIP.isValidIP(".213.123.23.32"));
        assertFalse(RegexForIP.isValidIP("23.45.22.32."));
        assertFalse(RegexForIP.isValidIP("I.Am.not.an.ip"));


    }

}