package leetcode.array;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 提示：
 *
 * 1 <= nums.length <= 3 * 10^4
 * -10^5 <= nums[i] <= 10^5
 */
public class 最大子序和_53_easy {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        solution.maxSubArray(arr);
    }

   static class Solution {
        public int maxSubArray(int[] nums) {
            //设 max 是数组索引为 i 时，以 i 为结尾最大子序列的和
            //默认 i = 1
            int max = nums[0];
            //maxAns 是分别以数组中所有元素为结尾的最大子序列和中的最大值，即 返回答案
            int maxAns = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                // 如果 num 比 max + mum 大 ，则以 i 结尾 最大子序列合是 num
                // (子序列就是 num 自己 ， 丢弃前面的 max)
                max = Math.max(num,max+num);
                maxAns = Math.max(maxAns,max);
            }
            return maxAns;
        }
    }
}
