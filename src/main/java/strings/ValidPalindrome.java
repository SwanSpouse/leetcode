package strings;

/**
 *  简单题。
 */
public class ValidPalindrome {

    public static boolean isValidChar(char ch) {
        return (ch >= 'a' && ch <= 'z') || ( ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }

    public static char getLowerCase(char ch) {
        if(( ch >= 'a' && ch <= 'z')|| (ch >= '0' && ch <= '9')){
            return ch;
        }
        return (char)('a' - 'A' + ch);
    }

    public static boolean isPalindrome(String s) {
        int left = 0 ;
        int right = s.length()-1;
        while(left < right) {
            if(!isValidChar(s.charAt(left))) {
                left += 1;
                continue;
            }  
            if(!isValidChar(s.charAt(right))) {
                right -=1;
                continue;
            }
            if(getLowerCase(s.charAt(left)) != getLowerCase(s.charAt(right))) {
                return false;
            }
            left += 1;
            right -=1;
        }
        return true;
    }
}