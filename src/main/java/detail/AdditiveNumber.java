package detail;

import java.math.BigInteger;

public class AdditiveNumber {


    public boolean isValidNumber(int startIndex, int firstIndex, int secIndex, String num) {
        if (secIndex >= num.length()) {
            return true;
        }
        if ((firstIndex - startIndex > 1 && num.charAt(startIndex) == '0') ||
                (secIndex - firstIndex > 1 && num.charAt(firstIndex) == '0')) {
            return false;
        }
        BigInteger a = new BigInteger(num.substring(startIndex, firstIndex));
        BigInteger b = new BigInteger(num.substring(firstIndex, secIndex));

        BigInteger sum = a.add(b);
        if (!num.substring(secIndex).startsWith(sum.toString())) {
            return false;
        }
        return isValidNumber(firstIndex, secIndex, secIndex + sum.toString().length(), num);
    }

    public boolean isAdditiveNumber(String num) {
        if (num.length() < 2) {
            return false;
        }
        for (int i = 1; i < num.length(); i++) {
            for (int j = 1; i + j < num.length(); j++) {
                if (isValidNumber(0, i, i + j, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new AdditiveNumber().isValidNumber(0, 1, 2, "112358"));
//        System.out.println(new AdditiveNumber().isAdditiveNumber("112358"));
//        System.out.println(new AdditiveNumber().isAdditiveNumber("199100199"));
        System.out.println(new AdditiveNumber().isAdditiveNumber("1023"));
        System.out.println(new AdditiveNumber().isAdditiveNumber("101"));
        System.out.println(new AdditiveNumber().isAdditiveNumber("000"));
    }
}
