/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 *
 */
public class Longest_Increasing_Subsequence_300_mid {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));
    }


    /**
     * @param nums O(n^2)
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        //保存 nums 中 以索引 i 为结尾时 子序列最大的长度
        int[] dp = new int[nums.length];
        //nums[0]为结尾 子序列最大的长度 1
        dp[0] = 1;
        int maxLength = 1;
        // i 以 1开始 ，dp[0] = 1     =>   dp[i] 之前，我们已经计算出 dp[0…i−1] 的值
        for(int i = 1; i < nums.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++ ){
                //如果 nums[i] > nums[j] , 则 dp[i]的值是 dp[0~j]中最大值 + 1
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxLength = Math.max(maxLength,dp[i]);
        }

        return maxLength;
    }

    //todo 贪心 + 二分 实现
}
