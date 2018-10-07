package strings;

public class RotateString {

    public boolean rotateString(String A, String B) {
        HashSet<String> ret = new HashSet<String>();
        for(int i=0; i < B.length(); i ++) {
            String left = B.substring(0, i);
            String right = B.substring(i);
            ret.add(right + left);
        }
        return A.equals(B) || ret.contains(A);
    }
}
