package strings;

/**
 * 		最初的想法是o(n^3)的算法，先进行一个简单的实现。
 *   做法是选取两个点，i, j作为子串。判断子串是不是有效的。再和现有的进行比较长度。
 * 
 *   估计是一个动态规划的问题：
 *		
 */
class LongestValidParentheses {
	public static boolean isValid(String s, int startPos, int endPos) {
		if((endPos - startPos) % 2 == 0) {
			return false;
		}
		int leftCount = 0;
		int rightCount = 0;
		for(int i=startPos; i <= endPos; i ++ ) {
			leftCount = s.charAt(i) == '(' ? leftCount + 1 : leftCount;
			rightCount = s.charAt(i) == ')' ? rightCount + 1 : rightCount;
			if (rightCount > leftCount) {
                return false;
            }
		}
		return leftCount == rightCount && leftCount != 0;
	}

	public static int longestValidParentheses(String s) {
		int maxLen = 0;
		for(int i=0; i < s.length(); i ++ ) {
			if(s.charAt(i) == ')') {
				continue;
			}
			for(int j= i +1; j < s.length(); j += 2) {
				if( j -i + 1> maxLen && isValid(s, i, j)) {
					maxLen = j -i +1 > maxLen ? j -i +1 : maxLen;
				}
			}
		}
		return maxLen;
    }
}