import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @Test
    void basicTest(){
        assertTrue(Anagram.isAnagram("arc", "rac"));
        assertTrue(Anagram.isAnagram("ACT", "tac"));

        assertTrue(Anagram.isAnagram("aTC", "CtA"));

        assertFalse(Anagram.isAnagram("anagramm", "marganaa"));
        assertFalse(Anagram.isAnagram("aTC", "CtAa"));

        assertTrue(Anagram.isAnagram("anagram", "margana"));

    }

}