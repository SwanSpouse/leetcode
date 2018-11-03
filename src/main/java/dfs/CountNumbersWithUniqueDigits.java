package dfs;

public class CountNumbersWithUniqueDigits {

//    public void countNumbersWithDuplicatedDigits(HashSet<Integer> duplicatedNumSet, boolean containsDup, StringBuffer curNum, int n) {
//        if (curNum.length() > n) {
//            return;
//        } else if (containsDup) {
//            int cur = Integer.parseInt(curNum.toString());
//            if (cur >= 10) {
//                duplicatedNumSet.add(cur);
//            }
//        }
//        for (int i = 0; i <= 9; i++) {
//            if (curNum.length() > 1 && curNum.charAt(0) == '0') {
//                continue;
//            }
//            boolean cur = containsDup || curNum.indexOf(i + "") != -1;
//            curNum.append(i);
//            countNumbersWithDuplicatedDigits(duplicatedNumSet, cur, curNum, n);
//            curNum.deleteCharAt(curNum.length() - 1);
//        }
//    }
//
//    public int countNumbersWithUniqueDigits(int n) {
//        if (n <= 0) {
//            return 0;
//        }
//        HashSet<Integer> duplicatedNumSet = new HashSet<>();
//        countNumbersWithDuplicatedDigits(duplicatedNumSet, false, new StringBuffer(), n);
//        return (int) Math.pow(10, n) - duplicatedNumSet.size();
//    }

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(3));
        for (int i = 1; i < 5; i++) {
            System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(i));
        }
    }
}
