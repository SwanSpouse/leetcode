package strings_test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static strings_test.LongestPalindromicSubstring.longestPalindrome;

public class TestLongestPalindromicSubstring {
    @Test
    public void TestLongestPalindromicSubstring() {
        assertEquals("bab", longestPalindrome("babad"));
        assertEquals("bb", longestPalindrome("cbbd"));
    }
}
