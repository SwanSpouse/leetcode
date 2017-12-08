package strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static strings.IntegerToRoman.appendChar;
import static strings.IntegerToRoman.intToRoman;

public class TestIntegerToRoman {

    @Test
    public void testAppendChar() {
        assertEquals("aaa", appendChar("", 3, 'a'));
        assertEquals("aaaaa", appendChar("", 5, 'a'));
        assertEquals("a", appendChar("", 1, 'a'));
    }

    @Test
    public void testIntToRoman(){
        assertEquals("I", intToRoman(1));
        assertEquals("II", intToRoman(4));
        assertEquals("IV", intToRoman(5));
        assertEquals("IX", intToRoman(9));
        assertEquals("XIX", intToRoman(19));
        assertEquals("XLVIII", intToRoman(48));
        assertEquals("MMMDCCCLXXI", intToRoman(3871));
        assertEquals("MI", intToRoman(1001));
    }

}
