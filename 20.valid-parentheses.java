import java.util.EmptyStackException;
import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    // beats: 81%
    public boolean isValid(String s) {
        Stack<Character> chars = new Stack<>();

        for (char c : s.toCharArray()) {
            try {
                if (c == '(') {
                    chars.push('(');
                } else if (c == '{') {
                    chars.push('{');
                } else if (c == '[') {
                    chars.push('[');
                } else if (c == ']') {
                    if (chars.pop() != '[')
                        return false;
                } else if (c == '}') {
                    if (chars.pop() != '{')
                        return false;
                } else if (c == ')') {
                    if (chars.pop() != '(')
                        return false;
                }
            } catch (Exception ex) {
                return false;
            }
        }
        if (chars.isEmpty())
            return true;
        else
            return false;
    }
}
// @lc code=end
