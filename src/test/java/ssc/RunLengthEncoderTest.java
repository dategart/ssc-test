package ssc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @auther David.Tegart
 */
public class RunLengthEncoderTest {
    
    private RunLengthEncoder runLengthEncoder;
    
    @BeforeEach
    void setUp() {
        runLengthEncoder = new RunLengthEncoder();
    }

    @Test
    void testEncodeEmptyString() {
        assertEquals("", runLengthEncoder.encode(""), "Empty string should return empty string");
    }

    @Test
    void testEncodeNullString() {
        assertEquals("", runLengthEncoder.encode(null), "Null string should return null");
    }

    @Test
    void testEncodeSingleCharacter() {
        assertEquals("a1", runLengthEncoder.encode("a"), "Single character should be encoded as char1");
    }

    @Test
    void testEncodeBasicWithWhitespace() {
        assertEquals("a4 2b3c3", runLengthEncoder.encode("aaaa  bbbccc"), "Basic run length encoding should count whitespace as a legal");
    }

    @Test
    void testEncodeBasic1() {
        assertEquals("a4b3c3", runLengthEncoder.encode("aaaabbbccc"), "Basic run length encoding should work correctly");
    }

    @Test
    void testEncodeBasic2() {
        assertEquals("a1b3c1d4", runLengthEncoder.encode("abbbcdddd"), "Basic run length encoding should work correctly");
    }

    @Test
    void testEncodeBasic3() {
        assertEquals("f3d1f3d1", runLengthEncoder.encode("fffdfffd"), "Basic run length encoding should work correctly");
    }

    @Test
    void testEncodeBasic4() {
        assertEquals("w4a3d1e1x6", runLengthEncoder.encode("wwwwaaadexxxxxx"), "Basic run length encoding should work correctly");
    }

    @Test
    void testEncodeBasicNonAlphaNumeric1() {
        assertEquals("w3!2{3*3", runLengthEncoder.encode("www!!{{{***"), "Non-Alpha Numeric encoding should work correctly");
    }

    @Test
    void testEncodeBasicNonAlphaNumeric2() {
        assertEquals(" 3a4&2{3:3", runLengthEncoder.encode("   aaaa&&{{{:::"), "Non-Alpha Numeric encoding should work correctly");
    }

    @Test
    void testEncodeAllSameChar() {
        assertEquals("99", runLengthEncoder.encode("999999999"), "Encoding should work correctly with all the same chacrters");
    }

    @Test
    void testEncodeAllDifferentChar() {
        assertEquals("k1j1u1e1v1a1w1", runLengthEncoder.encode("kjuevaw"), "Encoding should work correctly with all the same chacrters");
    }
}
