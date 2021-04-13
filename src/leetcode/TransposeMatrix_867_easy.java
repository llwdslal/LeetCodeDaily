package leetcode;

import utils.Utils;

/***
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 *
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *[2,   4, -1]     [2 , -10, 18]
 *[-10, 5, 11]  => [4 ,   5, -7]
 *[18 ,-7, 6]      [-1,  11, 6]
 */
public class TransposeMatrix_867_easy {
    public static void main(String[] args) {
        int[][] matrix = {{1,2},{4,5},{7,8}};
        transpose(matrix);
    }

    public static int[][] transpose(int[][] matrix) {
        int rowNum = matrix.length;
        int cluNum = matrix[0].length;
        int [][] result = new int[cluNum][rowNum];
        for (int i = 0; i < rowNum; i++) { //第 i 行
            //将第 i 行 转成 第 j 列
            for (int j = 0; j < cluNum; j++) {
                result[j][i] = matrix[i][j];
            }
            System.out.println("第" + (i + 1) + "次");
            Utils.printArr(result);
        }
        return result;
    }
}
