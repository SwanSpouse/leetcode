package array;

/**
 * 简单题。这里有个问题就是在
 *      ret = ret + count +input.charAt(i)
 *      ret += count + input.charAt(i) 就错了。这里注意一下，找一下问题的原因。
 */
class CountAndSay {

    public static String nextStr(String input) {
        String ret = "";
        int count = 1;
        for(int i=0; i < input.length(); i ++ ) {
            if( i + 1 < input.length() && input.charAt(i) == input.charAt(i+1) ) {
                count += 1;
            } else {
                ret = ret + count + input.charAt(i);
                count = 1;
            }
        }
        return ret;
    }

    public static String countAndSay(int n) {
        String start = "1";
        for(int i= 1; i < n; i ++ ) {
            start = nextStr(start);
        }
        return start;
    }
}