/***
 * 给定一个整数数组   nums，求出数组从索引  i  到  j（i  ≤  j）范围内元素的总和，包含  i、j  两点。
 *
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引  i  到  j（i  ≤  j）范围内元素的总和，包含  i、j  两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *
 *
 *  0 <= nums.length <= 10^4
 *
 * -10^5  <= nums[i] <=  10^5
 *
 * 0 <= i <= j < nums.length
 *
 * 最多调用 10^4 次 sumRange 方法
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 */

public class RangeSumQuery_Immutable_303_easy {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray.sumRange(2,5));
        System.out.println(numArray.sumRange(0,5));
    }


    static class NumArray {

        int preSum[];

        public NumArray(int[] nums) {
            preSum = new int[nums.length + 1];
            // 计算前缀合
            for(int i = 0; i < nums.length; i++){
                preSum[i+1] = preSum[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            //包含 i、j 两点
            return preSum[j+1] - preSum[i];
        }
    }
}
