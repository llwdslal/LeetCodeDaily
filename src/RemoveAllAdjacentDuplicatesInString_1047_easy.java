/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 */
public class RemoveAllAdjacentDuplicatesInString_1047_easy {
    public static void main(String[] args) {
        String S = "abbaca";
        System.out.println(removeDuplicates(S));
    }


    /**
     * 类似用 栈 匹配括号
     */
    public static String removeDuplicates(String S) {
        if (S == null || S.length() < 2){
            return S;
        }
        StringBuffer stack = new StringBuffer();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int stackLastIndex = stack.length() - 1;
            if (stackLastIndex >= 0 && ch == stack.charAt(stackLastIndex)){
                stack.deleteCharAt(stackLastIndex);
            }else{
                stack.append(S.charAt(i));
            }
            System.out.println(stack.toString());
        }
        return stack.toString();
    }

//    public static String removeDuplicates(String S) {
//        if (S == null || S.length() < 2){
//            return S;
//        }
//        int start = 0;
//        while (start < S.length() -1){
//            if (S.charAt(start) == S.charAt(start + 1)){
//                S = S.replace(S.substring(start,start+2),"");
//                start --;
//                start  = start < 0 ? 0 : start;
//            }else{
//                start ++;
//            }
//        }
//        return S;
//    }

}
