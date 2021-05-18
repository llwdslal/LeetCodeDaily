package leetcode.top100.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class 有效的括号_20 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isValid("()[]{}"));
    }

    static class Solution {

        public boolean isValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    stack.push(')');
                } else if (ch == '[') {
                    stack.push(']');
                } else if (ch == '{') {
                    stack.push('}');
                } else {
                    if (stack.isEmpty() || stack.peek() != ch) {
                        return false;
                    }
                    stack.pop();
                }
            }
            return stack.isEmpty();
        }
    }
}
