package dfs;

import utils.Print;

import java.util.*;

/**
 * dfs问题，其实在剪枝的问题上还可以继续优化。
 *      本次取1~3位数字后，剩下的长度会有要求。
 */
public class RestoreIPAddresses {

    public static List<String> restoreIpAddresses(String s) {
        ArrayList<String> ret = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();
        dfs(ret, set, s, "", 0);
        return ret;
    }

    public static void dfs(ArrayList<String>ret, HashSet<String>set, String input, String curIP, int count) {
        if (count > 3 ) {
            return;
        }
        // 前面已经切了三段了，就看剩下这段合不合法就好了。
        if (count == 3 && !set.contains(curIP+"."+ input) && isValidIPAddrSplit(input)) {
            set.add(curIP+"."+ input);
            ret.add(curIP+"."+ input);
            return ;
        }
        // 如果分段的次数没有到三次，本次可以取input的1位、2位、3位 三种选择
        for(int i=1; i <= 3; i ++ ) {
            if (i+1 > input.length()) {
                break;
            }
            String header = input.substring(0, i);
            String tail   = input.substring(i);
            if (isValidIPAddrSplit(header)) {
                String temp = curIP.equals("") ? header : curIP+"."+ header;
                dfs(ret, set, tail, temp, count + 1);
            }
        }
    }

    public static boolean isValidIPAddrSplit(String input) {
        try{
            int addr = Integer.parseInt(input);
            if (addr < 0 || addr > 255) {
                return false;
            } else if (addr == 0 && input.length() != 1 ) {
                return false;
            } else if (addr >0 && input.startsWith("0")) {
                return false ;
            }
            return true ;
        }catch (Exception e ) {
            return false;
        }
    }

    public static void main(String[] args) {
//        Print.printList(restoreIpAddresses("25525511135"));
        Print.printList(restoreIpAddresses("127001"));
    }
}
