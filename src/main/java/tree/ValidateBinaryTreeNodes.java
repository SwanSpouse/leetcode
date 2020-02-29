package tree;

import java.util.HashSet;
import java.util.Set;

public class ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> connected = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                if (!connected.add(leftChild[i])) return false;
            }
            if (rightChild[i] != -1) {
                if (!connected.add(rightChild[i])) return false;
            }
        }
        return connected.size() == n - 1;
    }
}
