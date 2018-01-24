package array;

import java.util.*;

/**
 * StackOverFlow了。看来是递归层级调用太深了。
 */
class PowXN {
	public static double divide(double x, int n, HashMap<Integer, Double> cur) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		if(cur.containsKey(n)){
			return cur.get(n);
		}
		double left = divide(x, n / 2, cur);
		double right = divide(x, n - n /2 , cur);
		double ret = left * right;
		cur.put(n, ret);

		return ret;
	}

    public static double myPow(double x, int n) {
        HashMap<Integer, Double> cur = new HashMap<Integer, Double>();
        return divide(x, n, cur);
    }
}
