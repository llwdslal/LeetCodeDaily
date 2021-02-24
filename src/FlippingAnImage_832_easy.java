/***
 * 给定一个二进制矩阵A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转[1, 1, 0]的结果是[0, 1, 1]。
 *
 * 反转图片的意思是图片中的 0 全部被 1替换，1全部被0替换。例如，反转[0, 1, 1]的结果是[1, 0, 0]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flipping-an-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class FlippingAnImage_832_easy {
    public static void main(String[] args) {
        int[][] origin = {{1,1,0},{1,0,1},{0,0,0}};
        printArr(origin);
        printArr(flipAndInvertImage(origin));
    }
    public static int[][] flipAndInvertImage(int[][] A) {
        // row
        // start = i , end = row.length - 1 - i
        // {1,0,1,1,0,0}  length 偶数
        //  0         1  逆序
        //  1         0  反转
        //    0     0    逆序
        //    1     1    反转
        //      1 1      逆序
        //      0 0      反转

        // row[start] != row[end] 逆序反转后  ，  row[start] row[end] 都不用变
        // row[start] == row[end] 逆序反转后  ，  row[start] row[end] 都取反  ^1

        // {1,0,1,0,1,0,0} length 奇数
        //        0      逆序
        //        1      反转

        // length 奇数时 中间的元素 需要取反
        // 奇数时 start ==  end   , 所以满足 row[start] == row[end]
        for (int i = 0; i < A.length; i++) {
            int[] row = A[i];
            int start = 0;
            int end = row.length - 1 - start;
            do {
                if (row[start] == row[end]){
                    row[start] = row[start] ^ 1;
                    row[end] = row[start];
                }
                start++;
                end = row.length - 1 - start;
            }while (start <= end);
        }

        return A;
    }

//    /***
//     * 逆序 再 反转
//     * @param A
//     * @return
//     */
//    public static int[][] flipAndInvertImage(int[][] A) {
//        for (int i = 0; i < A.length; i++) {
//            int[] row = A[i];
//            //逆序
//            int middle = row.length / 2;
//            for (int j = 0; j < middle; j++) {
//                int temp = row[j];
//                row[j] = row[row.length - 1 - j];
//                row[row.length - 1 - j] = temp;
//            }
//            //反转
//            for (int j = 0; j < row.length; j++) {
//                row[j] = row[j] ^ 1;
//            }
//        }
//
//        return A;
//    }

    static void printArr(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            int[] row = arr[i];
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.print('\t');
        }
        System.out.println();
    }
}
