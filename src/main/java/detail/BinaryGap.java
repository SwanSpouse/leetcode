package detail;

public class BinaryGap {

    public String covertToBinary(int N) {
        StringBuffer ret = new StringBuffer();
        while (N != 0) {
            ret = ret.insert(0, N % 2);
            N = N / 2;
        }
        return ret.toString();
    }

    public int binaryGap(int N) {
        int maxGap = 0, lastOnePos = -1;
        boolean isInConsecutiveOnes = false;
        String input = covertToBinary(N);
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1') {
                if (!isInConsecutiveOnes) {
                    if (lastOnePos != -1) {
                        maxGap = Math.max(maxGap, i - lastOnePos);
                    }
                } else {
                    maxGap = Math.max(maxGap, 1);
                }
                isInConsecutiveOnes = true;
                lastOnePos = i;
            } else if (input.charAt(i) == '0') {
                isInConsecutiveOnes = false;
            }
        }
        return maxGap;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryGap().binaryGap(22));
        System.out.println(new BinaryGap().binaryGap(5));
        System.out.println(new BinaryGap().binaryGap(6));
        System.out.println(new BinaryGap().binaryGap(8));
    }
}
