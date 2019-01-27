package strings;

public class CountBinarySubstrings {

    public boolean getSubstring(String s, int position) {
        if (position >= s.length() - 1) {
            return false;
        }
        int oneCount = s.charAt(position) == '1' ? 1 : 0;
        int zeroCount = s.charAt(position) == '0' ? 1 : 0;
        boolean zeroFirst = s.charAt(position) == '0';
        boolean inSecondPhase = false;
        for (int i = position + 1; i < s.length(); i++) {
            if (zeroFirst && inSecondPhase && s.charAt(i) == '0') {
                break;
            }
            if (!zeroFirst && inSecondPhase && s.charAt(i) == '1') {
                break;
            }
            if (zeroFirst && s.charAt(i) == '0') {
                zeroCount += 1;
            } else if (zeroFirst && s.charAt(i) == '1') {
                oneCount += 1;
                inSecondPhase = true;
            }
            if (!zeroFirst && s.charAt(i) == '1') {
                oneCount += 1;
            } else if (!zeroFirst && s.charAt(i) == '0') {
                zeroCount += 1;
                inSecondPhase = true;
            }
            if (inSecondPhase && oneCount == zeroCount) {
                return true;
            }
        }
        return oneCount == zeroCount;
    }

    public int countBinarySubstrings(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (getSubstring(s, i)) {
                sum += 1;
            }
        }
        return sum;
    }

    public int countBinarySubstrings2(String s) {
        int prevRunLength = 0, curRunLength = 1, res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) curRunLength++;
            else {
                prevRunLength = curRunLength;
                curRunLength = 1;
            }
            if (prevRunLength >= curRunLength) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CountBinarySubstrings().getSubstring("00110", 1));
    }
}
