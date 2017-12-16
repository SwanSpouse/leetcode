package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 *  dfs
 *
 *  每次有两种选择，一个是( 一个是)
 *  合法性判断属于剪枝
 */

public class GenerateParentheses {

    public static void dfs(List<String> ret, String cur, int n, int countLeft) {
        if (countLeft < 0) {
            return;
        }
        if (cur.length() == n * 2) {
            if(countLeft == 0){
                ret.add(cur);
            }
            return;
        }
        dfs(ret, cur + "(", n, countLeft + 1);
        dfs(ret, cur + ")", n, countLeft - 1);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        dfs(ret, "", n, 0);
        return ret;
    }
}
