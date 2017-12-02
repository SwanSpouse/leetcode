package others_test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static others.ReverseInteger.reverse;

public class TestReverseInteger {

    @Test
    public void TestReverse (){
        assertEquals(123, reverse(321));
        assertEquals(-123, reverse(-321));
        assertEquals(21, reverse(120));
        assertEquals(0, reverse(1534236469));
        assertEquals(0, reverse(-2147483648));
        assertEquals(-2143847412, reverse(-2147483412));
    }
}
