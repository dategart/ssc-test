package ssc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @auther David.Tegart
 */
public class CharCounterTest {
    
    private CharCounter charCounter;
    
    @BeforeEach
    void setUp() {
        charCounter = new CharCounter();
    }

    @Test
    void testEncodeEmptyString() {
        assertEquals("", charCounter.encode(""), "Empty string should return empty string");
    }

    @Test
    void testEncodeNullString() {
        assertEquals("", charCounter.encode(null), "Null string should return null");
    }

    @Test
    void testEncodeSingleCharacter() {
        assertEquals("a1", charCounter.encode("a"), "Single character should be encoded as char1");
    }

    @Test
    void testEncodeBasicWithWhitespace() {
        assertEquals("a4 2b3c3", charCounter.encode("aaaa  bbbccc"), "Basic char count encoding should count whitespace as a legal");
    }

    @Test
    void testEncodeBasic1() {
        assertEquals("a4b3c3", charCounter.encode("aaaabbbccc"), "Basic char count encoding should work correctly");
    }

    @Test
    void testEncodeBasic2() {
        assertEquals("a1b3c1d4", charCounter.encode("abbbcdddd"), "Basic char count encoding should work correctly");
    }

    @Test
    void testEncodeBasic3() {
        assertEquals("f3d1f3d1", charCounter.encode("fffdfffd"), "Basic char count encoding should work correctly");
    }

    @Test
    void testEncodeBasic4() {
        assertEquals("w4a3d1e1x6", charCounter.encode("wwwwaaadexxxxxx"), "Basic char count encoding should work correctly");
    }

    @Test
    void testEncodeBasicNonAlphaNumeric1() {
        assertEquals("w3!2{3*3", charCounter.encode("www!!{{{***"), "Non-Alpha Numeric encoding should work correctly");
    }

    @Test
    void testEncodeBasicNonAlphaNumeric2() {
        assertEquals(" 3a4&2{3:3", charCounter.encode("   aaaa&&{{{:::"), "Non-Alpha Numeric encoding should work correctly");
    }

    @Test
    void testEncodeAllSameChar() {
        assertEquals("99", charCounter.encode("999999999"), "Encoding should work correctly with all the same chacrters");
    }

    @Test
    void testEncodeAllDifferentChar() {
        assertEquals("k1j1u1e1v1a1w1", charCounter.encode("kjuevaw"), "Encoding should work correctly with all the same chacrters");
    }
}
