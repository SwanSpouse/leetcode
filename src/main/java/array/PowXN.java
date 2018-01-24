package array;

import java.util.*;

/**
 *  StackOverFlow了。看来是递归层级调用太深了。这个是因为没有考虑到Integer.MIN_VALUE
 *
 *  这题真恶心。开始是没有考虑到负数，x为负，n为负
 *
 *  后来是因为没考虑到n可以等于Integer.MIN_VALUE
 */
class PowXN {

    // 超时直观解法
    public double myPowTE(double x, int n) {
        double ret = 1;
        for (int i = 0; i < Math.abs(n); i++) {
            ret = ret * x;
        }
        ret = Math.abs(n % 2) == 0 ? Math.abs(ret) : ret;
        return n > 0 ? ret : 1 / ret;
    }

    public static double divide(double x, int n, HashMap<Integer, Double> cur) {
        if (cur.containsKey(n)) {
            return cur.get(n);
        }
        double left = divide(x, n / 2, cur);
        cur.put(n / 2, left);
        double right = divide(x, n - n / 2, cur);
        cur.put(n - n / 2, right);
        double ret = left * right;
        cur.put(n, ret);
        return ret;
    }

    public static double myPow(double x, int n) {
        HashMap<Integer, Double> cur = new HashMap<Integer, Double>();
        boolean isPositive = true;
        if (n < 0) {
            isPositive = false;
        }
        boolean isMinValue = false;
        if( n == Integer.MIN_VALUE) {
            isMinValue = true;
        }
        cur.put(0, 1.0);
        cur.put(1, x);
        cur.put(2, x * x);
        double ret;
        if (isMinValue) {
            ret = divide(x, Math.abs(Integer.MAX_VALUE), cur);
            ret = ret * x;
        } else {
            ret = divide(x, Math.abs(n), cur);
        }
        ret = isPositive ? ret : 1 / ret;
        ret = Math.abs(n) % 2 == 0 ? Math.abs(ret) : ret;
        return ret;
    }

    public static void main(String[] args) {
//        System.out.println(myPow(1.023, 100));
        System.out.println(myPow(0.00001, 2147483647));
    }
}
