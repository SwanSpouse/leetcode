package dynamic_programing;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] matrix = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                int cur = text1.charAt(i) == text2.charAt(j) ? 1 : 0;
                int left = j - 1 >= 0 ? matrix[i][j - 1] : 0;
                int up = i - 1 >= 0 ? matrix[i - 1][j] : 0;
                int leftUp = i - 1 >= 0 && j - 1 >= 0 ? matrix[i - 1][j - 1] : 0;

                matrix[i][j] = Math.max(Math.max(left, up), leftUp + cur);
            }
        }
        return matrix[text1.length() - 1][text2.length() - 1];
    }
}
