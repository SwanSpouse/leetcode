package strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static strings.ZigZagConversion.convert;

public class TestZigZagConversion {

    @Test
    public void TestConvert() {
        assertEquals("PAHNAPLSIIGYIR", convert("PAYPALISHIRING", 3));
        assertEquals("ACEBDF", convert("ABCDEF", 2));
    }
}
