package stack;

import java.util.*;

/**
 * 简单题。利用堆栈进行操作。
 */
public class SimplifyPath {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] fields = path.split("/");

        for (String value : fields) {
            if (value.equals("") || value.equals(".")) {
                continue;
            } else if (value.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(value);
            }
        }
        String ret = "";
        while (!stack.isEmpty()) {
            ret = "/" + stack.pop() + ret;
        }
        return ret.isEmpty() ? "/" : ret;
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath(""));
    }
}
