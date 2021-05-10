package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class 有效的括号_20_easy {

    public static void main(String[] args) {
        String str = "()()(())";
        Solution solution = new Solution();
        System.out.println(solution.isValid(str));
    }

    static class Solution {
        public boolean isValid(String s) {
            int strLength = s.length();
            if (strLength % 2 == 1) {
                return false;
            }
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < strLength; i++) {
                char ch = s.charAt(i);
                switch (ch){
                    case '(':
                        stack.push(')');
                        continue;
                    case '{':
                        stack.push('}');
                        continue;
                    case '[':
                        stack.push(']');
                        continue;
                }
                if (stack.isEmpty() || stack.pop() != ch){
                    return false;
                }
            }

            return stack.isEmpty();
        }
    }
}
