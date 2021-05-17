package leetcode.array;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
public class 杨辉三角_118_esay {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 1; i < numRows + 1; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 1; j <=i ; j++) {
                    if (j == 1 || j == i){
                        row.add(1);
                    }else{
                        List<Integer> prevRow = result.get(i - 2);
                        row.add(prevRow.get(j-2) + prevRow.get(j-1));
                    }
                }
                result.add(row);
            }
            return result;
        }
    }
}
