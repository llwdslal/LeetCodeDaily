/**
 *给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
 * 示例:
 *
 * 给定 matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 *
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * 说明:
 *
 * 你可以假设矩阵不可变。
 * 会多次调用 sumRegion 方法。
 * 你可以假设 row1 ≤ row2 且 col1 ≤ col2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
 */
public class RangeSumQuery2D_Immutable_304_mid {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
        System.out.println("===========");
        NumMatrix2 numMatrix2 = new NumMatrix2(matrix);
        System.out.println(numMatrix2.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix2.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix2.sumRegion(1, 2, 2, 4));

    }

    /**
     * 一维前缀和
     *
     */
    public static class NumMatrix{
        //前缀合矩阵
        public int[][] preSumMatrix;

        public NumMatrix(int[][] matrix) {
            int rowNum = matrix.length;
            int colNum = rowNum > 0 ? matrix[0].length : 0;
            preSumMatrix = new int[rowNum][colNum + 1];
            for (int i = 0; i < rowNum; i++) {
                int[] matrixRow = matrix[i];
                //计算矩阵每一行的前缀合
                int[] preSumRow = preSumMatrix[i];
                for (int j = 0; j < colNum; j++) {
                    preSumRow[j+1] = preSumRow[j] + matrixRow[j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            //子矩阵每一行的和
            for (int i = row1; i <= row2 ; i++) {
                int[] preSumRow = preSumMatrix[i];
                sum += preSumRow[col2 + 1] - preSumRow[col1];
            }
            return sum;
        }
    }

    public static class NumMatrix2{
        //前缀合矩阵
        public int[][] preSumMatrix;

        public NumMatrix2(int[][] matrix) {
            int rowNum = matrix.length;
            int colNum = rowNum > 0 ? matrix[0].length : 0;
            preSumMatrix = new int[rowNum+1][colNum + 1];
            for (int i = 0; i < rowNum; i++) {
                for (int j = 0; j < colNum; j++) {
                    //二维前缀和公式 f(i,j)=f(i−1,j)+f(i,j−1)−f(i−1,j−1)+matrix[i][j]
                    preSumMatrix[i+1][j+1] = preSumMatrix[i][j+1] + preSumMatrix[i+1][j] - preSumMatrix[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            //右下 + 左上 - 右上 -左下
            return preSumMatrix[row2 + 1][col2 + 1] + preSumMatrix[row1][col1 ] - preSumMatrix[row1][col2 + 1] -preSumMatrix[row2+1][col1];
        }
    }
}


