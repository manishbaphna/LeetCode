import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeStringTest {

    DecodeString dut = new DecodeString();

    @Test
    void basicTest1() {
        String res = dut.decodeString("3[a]2[bc]");
        assertEquals("aaabcbc", res);
    }

    @Test
    void basicTest2() {
        String res = dut.decodeString("3[a2[c]]");
        assertEquals("accaccacc", res);
    }

    @Test
    void basicTest3() {
        String res = dut.decodeString("2[abc]3[cd]ef");
        assertEquals("abcabccdcdcdef", res);
    }

}