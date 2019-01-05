package array;

import utils.Print;

import java.util.HashSet;

public class FairCandySwap {

    public int[] fairCandySwap(int[] A, int[] B) {
        int[] ret = new int[2];

        int sumA = 0, sumB = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < B.length; i++) {
            sumB += B[i];
            set.add(B[i]);
        }

        for (int i = 0; i < A.length; i++) {
            int target = 0;
            if (sumA > sumB) {
                target = A[i] - (sumA - sumB) / 2;
            } else if (sumA < sumB) {
                target = (sumB - sumA) / 2 + A[i];
            }
            if (!set.contains(target)) {
                continue;
            }
            ret[0] = A[i];
            ret[1] = target;
        }
        return ret;
    }

    public static void main(String[] args) {
        Print.printArr(new FairCandySwap().fairCandySwap(new int[]{21, 89, 90, 88, 54, 45, 67, 41, 57, 7}, new int[]{55, 57, 22, 19, 44, 91, 100, 71, 33, 33}));
    }
}

