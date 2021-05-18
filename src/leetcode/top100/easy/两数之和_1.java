package leetcode.top100.easy;

import utils.Utils;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums  和一个整数目标值 target，请你在该数组中找出 和为目标值 的那  两个  整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 */
public class 两数之和_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr ={2,7,11,15};
        Utils.printArr(solution.twoSum(arr,9));

    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (map.containsKey(target - num)) {
                    return new int[]{map.get(target - num), i};
                }
                map.put(num, i);
            }
            return null;
        }
    }
}
