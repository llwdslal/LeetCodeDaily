package utils;

import java.util.Arrays;

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

    public static <E> void swap(E[] arr,int index1,int index2){
        E temp  = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static <E> void printArr(E[] arr){
        System.out.println("=================================");
        Arrays.stream(arr).forEach(item -> {
            System.out.print(item);
            System.out.print('\t');
        });
        System.out.println();
        System.out.println("=================================");
    }


}
