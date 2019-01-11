
package detail;

import java.util.*;

public PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> ret = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i =0; i <= bound; i ++ ) {
            if(Math.pow(x, i) > bound) {
                return ret;
            }
            for(int j =0; j <= bound; j ++) {
                int cur = (int)Math.pow(x, i) + (int)Math.pow(y, j);
                if(cur <= bound && !set.contains(cur)) {
                    ret.add(cur);
                    set.add(cur);
                }
                if(cur >= bound) {
                    break;
                }
            }
        }
        return ret;
    }
}
