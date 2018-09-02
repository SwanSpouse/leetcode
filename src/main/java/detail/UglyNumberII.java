package detail;

public class UglyNumberII {
    public int min(int num2, int num3, int num5) {
        int minNum = num2 > num3 ? num3 : num2;
        return minNum > num5 ? num5 : minNum;
    }

    public int nthUglyNumber(int n) {
        int factor2 = 2, factor3 = 3, factor5 = 5;
        int index2 = 0, index3 = 0, index5 = 0;

        int[] ugly = new int[n];
        ugly[0] = 1;

        for (int i = 1; i < n; i++) {
            int num2 = factor2 * ugly[index2];
            int num3 = factor3 * ugly[index3];
            int num5 = factor5 * ugly[index5];

            int minNum = min(num2, num3, num5);
            ugly[i] = minNum;
            if (minNum == num2) {
                index2 += 1;
            }
            if (minNum == num3) {
                index3 += 1;
            }
            if (minNum == num5) {
                index5 += 1;
            }
        }
        return ugly[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumberII().nthUglyNumber(10));
    }
}
