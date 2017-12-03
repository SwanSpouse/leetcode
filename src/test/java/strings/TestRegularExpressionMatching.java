package strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static strings.RegularExpressionMatching.isMatch;

public class TestRegularExpressionMatching {

    @Test
    public void testIisMatch() {
        assertEquals(false, isMatch("aa", "a"));
        assertEquals(true, isMatch("aa", "aa"));
        assertEquals(false, isMatch("aaa", "aa"));
        assertEquals(true, isMatch("aa", "a*"));
        assertEquals(true, isMatch("aa", ".*"));
        assertEquals(true, isMatch("ab", ".*"));
        assertEquals(true, isMatch("aab", "c*a*b"));
        assertEquals(true, isMatch("a", "."));
    }

    @Test
    public void testSubstring(){
        String s= new String("abcd");
        System.out.println(s.substring(0,s.length()-1));
        System.out.println(s.substring(0,s.length()));
        System.out.println(s.substring(3,s.length()));
        System.out.println(s.substring(4,s.length()));
        System.out.println("[END]");
    }
}
