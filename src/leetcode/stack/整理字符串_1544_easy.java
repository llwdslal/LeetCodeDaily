package leetcode.stack;

/**
 * 给你一个由大小写英文字母组成的字符串 s 。
 *
 * 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:
 *
 * 若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。
 * 若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。
 * 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
 *
 * 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
 *
 * 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/make-the-string-great
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 1 <= s.length <= 100
 * s 只包含小写和大写英文字母
 */
public class 整理字符串_1544_easy {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.makeGood("abBAcC"));
    }
   static class Solution {
        public String makeGood(String s) {
            if (s == null || s.length() < 2){
                return s;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                char ch = s.charAt(i)
                int lastIndex = sb.length() - 1;
                // 大小写字符 ascii 码相差  32
                if (lastIndex >= 0 && Math.abs(ch - sb.charAt(lastIndex)) == 32){
                    sb.deleteCharAt(lastIndex);
                }else{
                    sb.append(ch);
                }
            }
            return sb.toString();
        }
    }
}
