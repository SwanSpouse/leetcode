package strings;

public class ShortestDistanceToACharacter {

    public void getDistance(String S, char C, int[] ret, int pos) {
        ret[pos] = 0;
        for(int i = pos - 1; i >=0 && S.charAt(i) != C; i --) {
            ret[i] = Math.min(ret[i], Math.abs(i - pos));
        }
        for(int i = pos + 1; i < S.length() && S.charAt(i) != C; i ++) {
            ret[i] = Math.min(ret[i], Math.abs(i - pos));
        }
    }

    public int[] shortestToChar(String S, char C) {
        ArrayList<Integer> indexs = new ArrayList<Integer>();
        int[] ret = new int[S.length()];
        for(int i =0; i < S.length(); i ++) {
            ret[i] = Integer.MAX_VALUE;
        }
        for(int i=0; i < S.length(); i ++) {
            if(S.charAt(i) == C) {
                indexs.add(i);
            }
        }
        for(int i=0; i < indexs.size(); i ++) {
            getDistance(S, C, ret, indexs.get(i));
        }
        return ret;
    }
}
