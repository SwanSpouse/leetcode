package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ReconstructOriginalDigitsFromEnglish {

    HashMap<Integer, int[]> map;

    public void initMap() {
        map = new HashMap<>();
        String[] all = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < all.length; i++) {
            int[] cur = new int[26];
            for (int index = 0; index < all[i].length(); index++) {
                cur[all[i].charAt(index) - 'a'] += 1;
            }
            map.put(i, cur);
        }
    }

    public boolean isEmpty(int[] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean sub(int[] input, int[] num) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] < num[i]) {
                return false;
            }
            input[i] = input[i] - num[i];
        }
        return true;
    }

    public void dfs(int[] input, int cur, ArrayList<Integer> ret, ArrayList<Integer> curArr) {
        if (ret.size() != 0) {
            return;
        }
        if (isEmpty(input)) {
            ret.addAll(curArr);
            return;
        }
        for (int i = cur; i < 10; i++) {
            int[] copy = Arrays.copyOfRange(input, 0, input.length);
            if (sub(copy, map.get(i))) {
                curArr.add(i);
                dfs(copy, i, ret, curArr);
                curArr.remove(curArr.size() - 1);
            } else {
                dfs(input, i + 1, ret, curArr);
            }
        }
    }

    public String originalDigits(String s) {
        initMap();
        int[] sArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i) - 'a'] += 1;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        dfs(sArr, 0, ret, new ArrayList<>());

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ret.size(); i++) {
            sb.append(ret.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReconstructOriginalDigitsFromEnglish().originalDigits("zeroonetwothreefourfivesixseveneightnine"));
//        System.out.println(new ReconstructOriginalDigitsFromEnglish().originalDigits("fviefuro"));
//        System.out.println(new ReconstructOriginalDigitsFromEnglish().originalDigits("ninetwo"));
    }
}
