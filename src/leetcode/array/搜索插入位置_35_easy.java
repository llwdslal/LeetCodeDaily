package leetcode.array;

public class 搜索插入位置_35_easy {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(arr, 7));
    }

    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int middle = left + (right - left) / 2;
                if (nums[middle] < target) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            return left;
        }
    }
}
