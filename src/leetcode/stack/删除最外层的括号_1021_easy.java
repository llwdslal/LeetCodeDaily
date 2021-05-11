package leetcode.stack;

/**
 * 有效括号字符串为空  ("")、"(" + A + ")"  或  A + B，其中  A 和  B  都是有效的括号字符串，+  代表字符串的连接。例如，""，"()"，"(())()"  和  "(()(()))"  都是有效的括号字符串。
 *
 * 如果有效字符串  S  非空，且不存在将其拆分为  S = A+B  的方法，我们称其为原语（primitive），其中  A 和  B  都是非空有效括号字符串。
 *
 * 给出一个非空有效字符串  S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中  P_i  是有效括号字符串原语。
 *
 * 对  S  进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S  。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-outermost-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 提示：
 *
 * S.length <= 10000
 * S[i] 为 "(" 或 ")"
 * S 是一个有效括号字符串
 */
public class 删除最外层的括号_1021_easy {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeOuterParentheses("()()"));
    }

    /**
     * 遇到左括号，我们的计数器 +1，遇到右括号，我们的计数器 -1。
     * 保留 技术器 大于等于 1 时的值
     */
    static class Solution {
        public String removeOuterParentheses(String S) {
            StringBuilder sb = new StringBuilder();
            int level = 0;
            for (int i = 0; i < S.length(); i++) {
               char ch = S.charAt(i);
               if (ch == ')') level--;
               if (level > 0) sb.append(ch);
               if (ch == '(') level ++;
            }
            return sb.toString();
        }
    }

}
