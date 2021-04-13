package leetcode;

/***
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 *
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。

 * 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出：true
 *
 * [1,2,3,4]
 * [5,1,2,3]
 * [9,5,1,2]
 *
 * 解释：
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是 True 。
 *
 */

public class ToeplitzMatrix_766_easy {
    public static void main(String[] args) {
        int[][] matrix =  {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(isToeplitzMatrix(matrix));;
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length - 1; i++){//最后一行不需要比较
            int[] row = matrix[i];
            int[] nextRow = matrix[i+1];
            for (int j = 0; j < row.length - 1;j++){//每行的最后一个元素不需要比较
                //如果当前行索引为 j 的元素 与 下一行索引为 j+1 的元素（右下的元素）是否相等
                if (row[j] != nextRow[j+1]){
                    return false;
                }
            }
        }
        return true;
    }
}
