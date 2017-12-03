package strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static strings.LongestPalindromicSubstring.longestPalindrome;

public class TestLongestPalindromicSubstring {
    @Test
    public void testLongestPalindromicSubstring() {
        assertEquals("bab", longestPalindrome("babad"));
        assertEquals("bb", longestPalindrome("cbbd"));
    }
}
