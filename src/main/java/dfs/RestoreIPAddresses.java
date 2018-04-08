package dfs;

import java.util.*;

public class RestoreIPAddresses {

    public int getValidAddInt(String input) {
        // 位数超过3位或者为0，肯定不是有效的。
        if(input.length() > 3 || input.length() == 0) {
            return -1;
        }
        // 位数超过1位且第一位为0，肯定不是有效的
        if(input.length() > 1 && input.charAt(0) == '0') {
            return -1;
        }
        // 转换为int
        int intVal = Integer.parseInt(input);
        // 如果转换后的值为0，但是长度不为1，属于00这种情况的。肯定不对。
        if (intVal == 0 && input.length() > 1) {
            return -1;
        }
        // 剩下的应该都是有效情况。
        return intVal;
    }

    // 把数组中的Integer拼成IP地址
    public String getIPAddrFromString(List<Integer> input) {
        String ret = "";
        for(int i=0; i < input.size()-1; i ++ ){
            ret += input.get(i) + ".";
        }
        return ret + input.get(input.size()-1);
    }

    // 127.0.0.1 需要考虑的情况还是挺多的。有可能包含两个00。 这样的需要进行剪枝处理。
    public void dfs(List<String> ret, HashSet<String> set, String input, List<Integer> current, int parseCount) {
        if( parseCount == 2) {
            int inputVal = getValidAddInt(input);
            if(inputVal != -1) {

                return ;
            }
        }
        for(int i=1; i <= 3;  i ++ ) {
            String headPart = input.substring(0, i);
            String tailPart = input.substring(i+1);
            int headPartInt = getValidAddInt(headPart);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> ret = new ArrayList<String>();
        HashSet<String> set   = new HashSet<String>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        dfs(ret, set, s, current, 0);
        return ret;
    }
}