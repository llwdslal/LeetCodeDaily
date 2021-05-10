package leetcode.stack;

import utils.Utils;

import java.util.HashMap;
import java.util.Stack;

public class 下一个更大元素_496_easy {

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        Solution2 solution = new Solution2();

//        Utils.printArr(solution.nextGreaterElement(nums1,nums2));
    }

    static class Solution2 {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] resultArr = new int[nums1.length];
            Stack<Integer> stack = new Stack<>();
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = nums2.length -1; i >= 0; i--) {
                int num = nums2[i];
                while (!stack.isEmpty() && num > stack.peek()){
                    stack.pop();
                }
                map.put(num,stack.isEmpty() ? -1 : stack.peek());
                stack.push(num);
            }
            for (int i = 0; i < nums1.length; i++) {
                int num = nums1[i];
                resultArr[i]=map.get(num);
            }
            return resultArr;
        }
    }

    static class Solution {
        public Integer[] nextGreaterElement(int[] nums1, int[] nums2) {
            Integer[] resultArr = new Integer[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                int num1 = nums1[i];
                int index = -1;
                for (int j = 0; j < nums2.length; j++) {
                    if (num1 == nums2[j]) {
                        index = j;
                        break;
                    }
                }
                for (; index < nums2.length; index++) {
                    if (nums2[index] > num1) {
                        break;
                    }
                }
                resultArr[i] = index == nums2.length ? -1 : nums2[index];
            }
            return resultArr;
        }
    }


}
