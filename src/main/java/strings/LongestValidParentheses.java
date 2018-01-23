package strings;

import java.util.*;
/**
 * 		最初的想法是o(n^3)的算法，先进行一个简单的实现。
 *   做法是选取两个点，i, j作为子串。判断子串是不是有效的。再和现有的进行比较长度。
 * 
 *		第二种方法巧妙的利用了栈。可以的。
 *
 *   估计是一个动态规划的问题：
 *		确实有动态规划的解法：http://bangbingsyb.blogspot.jp/2014/11/leetcode-longest-valid-parentheses.html
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

	// 超时了。
	public static int longestValidParentheses2(String s) {
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

    public static int longestValidParentheses(String s) {
    	Stack<Integer> stack = new Stack<Integer>();
    	int ret = 0; 
    	int start = 0;
    	for(int i=0; i < s.length(); i ++ ) {
    		if( s.charAt(i) == '(') {
    			stack.push(i);
    		} else {
    			if(stack.empty()) {
    				start = i + 1;
    				continue;
    			}
    			stack.pop();
    			ret = !stack.empty() && i - stack.peek() > ret ? i - stack.peek() : ret;
    			ret = stack.empty() && i - start + 1 > ret ? i - start + 1 : ret;
    		}
    	}
    	return ret;
    }
}
