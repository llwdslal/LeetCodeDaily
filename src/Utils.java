public class Utils {
    public static void printArr(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            int[] row = arr[i];
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
