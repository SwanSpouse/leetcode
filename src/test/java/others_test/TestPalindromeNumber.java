package others_test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static detail.PalindromeNumber.isPalindrome;

public class TestPalindromeNumber {

    @Test
    public void TestIsPalindrome() {
        assertEquals(false, isPalindrome(123));
        assertEquals(false, isPalindrome(112));
        assertEquals(true, isPalindrome(121));
        assertEquals(true, isPalindrome(1));
        assertEquals(true, isPalindrome(11));
        assertEquals(false, isPalindrome(-2147483648));
        assertEquals(false, isPalindrome(-2147447412));
    }
}
