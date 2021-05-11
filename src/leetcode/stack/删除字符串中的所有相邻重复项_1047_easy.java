package leetcode.stack;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 提示：
 *
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 */
public class 删除字符串中的所有相邻重复项_1047_easy {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates("abbaca"));
    }
    static class Solution {
        public String removeDuplicates(String S) {
            StringBuilder sb = new StringBuilder();
            sb.append(S.charAt(0));
            for (int i = 1; i < S.length(); i++) {
                char ch = S.charAt(i);
                int lastIndex = sb.length() - 1;
                if (lastIndex >= 0 && sb.charAt(lastIndex) == ch){
                    sb.deleteCharAt(lastIndex);
                }else{
                    sb.append(ch);
                }
            }
            return sb.toString();
        }
    }
}
