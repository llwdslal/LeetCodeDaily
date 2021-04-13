package study;

import utils.Utils;

/**
 * 选择排序
 */
public class SelectionSort {
    private SelectionSort(){}

    public static <E extends Comparable> void sort(E[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }

            Utils.swap(arr,i,minIndex);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {6,4,5,2,3,1};
        SelectionSort.sort(arr);
        Utils.printArr(arr);
    }
}
