package leetcode.array;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class 加一_66_easy {
    class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                int num = digits[i];
                //当前数位加 1
                digits[i] = ++ num ;
                //加 1 之后等于10 ， 当前数位 = 0 , 继续循环让前一个数位继续加 1
                if (num == 10){
                    digits[i] = 0;
                }else{
                    // 没有进位 直接返回
                    return digits;
                }
            }
            // 到此没有返回的话 所有数位都是 9 ， 循环时会 一直进位
            // 999 -> 1000
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }
    }
}
