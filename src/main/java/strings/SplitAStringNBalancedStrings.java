package strings;

public class SplitAStringNBalancedStrings {
    public int balancedStringSplit(String s) {
        int countL = 0, countR = 0;
        int ret = 0 ;
        for(int i =0 ; i < s.length(); i ++ ) {
            countL += s.charAt(i) == 'L' ? 1:0;
            countR += s.charAt(i) == 'R' ? 1:0;
            if (countL != 0 && countL == countR) {
                ret +=1;
                countL = 0;
                countR = 0;
            }
        }
        return ret;
    }
}