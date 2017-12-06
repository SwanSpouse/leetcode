package strings;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static strings.RegularExpressionMatching.isMatch;
import static strings.RegularExpressionMatching.simplyExpression;

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
        assertEquals(true, isMatch("aaa", "a*a"));
        assertEquals(true, isMatch("", "c*c*"));
        assertEquals(false, isMatch("cacbcacbacbccac", ".*c*c*bb*c*..*a*a"));
        assertEquals(false, isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
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


    @Test
    public void testSimplyExpression(){
        assertEquals("babaa*c", simplyExpression("babaa*a*a*a*a*a*a*a*a*a*c"));
        assertEquals("abcd", simplyExpression("abcd"));
        assertEquals("", simplyExpression(""));
        assertEquals("a*", simplyExpression("a*"));
        assertEquals("c*", simplyExpression("c*c*"));
        assertEquals("a*a", simplyExpression("a*a"));
    }
}
