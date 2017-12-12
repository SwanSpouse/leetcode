package strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static strings.IntegerToRoman.intToRoman;
import static strings.RomanToInteger.romanToInt;

public class TestRomanToInteger {

    @Test
    public void testRomanToInteger(){
        for(int i=1; i <=3999; i ++ ){
            assertEquals(i, romanToInt(intToRoman(i)));
        }
    }
}
