package leetcode.top100.easy;

/**
 * @see{lettcode.array}
 */
public class 最大子序和_53_easy {

    static class Solution {
        public int maxSubArray(int[] nums) {
            int maxAns = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                max = Math.max(max + num, num);
                maxAns = Math.max(max,maxAns);
            }
            return maxAns;
        }
    }
}
