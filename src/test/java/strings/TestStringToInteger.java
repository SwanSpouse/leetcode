package strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static strings.StringToInteger.myAtoi;

public class TestStringToInteger {

    @Test
    public void TestConvert() {
        assertEquals(103, myAtoi("103"));
        assertEquals(-5467, myAtoi("-5467"));
        assertEquals(0, myAtoi("+-2"));
        assertEquals(-12, myAtoi("  -0012a42"));
        assertEquals(2147483647, myAtoi("9223372036854775809"));
        assertEquals(1095502006, myAtoi("1095502006p8"));
        assertEquals(-2147483648, myAtoi("-2147483649"));
    }
}
