package leetcode.array;

import utils.Utils;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * [9 11, 12  1 2 7]
 */
public class 合并两个有序数组_88_easy {
    public static void main(String[] args) {
        int[] arr1 = {4, 0, 0, 0, 0, 0};
        int[] arr2 = {1, 2, 3, 5, 6};
        Solution solution = new Solution();
        solution.merge(arr1, 1, arr2, 5);
        Utils.printArr(arr1);
    }

    static class Solution2 {
        // TODO: 2021/5/17
        public void merge(int[] nums1, int m, int[] nums2, int n) {
           int lastLength = m + n - 1;
            for (int i = n - 1; i >= 0 ; i--) {
                int lastNum2 = nums2[i];
                for (int j = m - 1; j >= 0 ; j--) {
                    int lastNum1 = nums2[j];
                    if (lastNum2 > lastNum1){
                        nums1[lastLength] = lastNum2;
                        lastLength--;
                        break;
                    }else{
//                        swap(nums1,);
                    }
                }
            }
        }

        public void swap(int[] arr, int index1, int index2) {
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
    }

    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int i = 0; i < n; i++) {
                nums1[m + i] = nums2[i];
            }

            for (int i = m; i < m + n; i++) {
                for (int j = i; j >= 1; j--) {
                    if (nums1[j] < nums1[j - 1]) {
                        swap(nums1, j, j - 1);
                    } else {
                        break;
                    }
                }
            }
        }

        public void swap(int[] arr, int index1, int index2) {
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
    }
}
