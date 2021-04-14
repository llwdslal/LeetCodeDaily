package study;

import utils.Utils;

/**
 * 插入排序
 */
public class InsertSort {
    private InsertSort(){}

    public static <E extends Comparable> void sort(E[] arr){
        if (arr == null || arr.length < 2) return;
        for (int i = 1; i < arr.length; i++) {
            E element = arr[i];
            int j = i;
            for (; j > 0 ; j--) {
                E prev = arr[j-1];
                if (element.compareTo(prev) < 0){
                    arr[j] = prev;
                }else{
                    break;
                }
            }
            arr[j] = element;
        }
    }
    public static void main(String[] args) {
        Integer[] arr = {6,4,5,2,3,1,9,7,8};
        InsertSort.sort(arr);
        Utils.printArr(arr);
    }

}
