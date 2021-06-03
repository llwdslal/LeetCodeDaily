package study;

import utils.Utils;

import java.util.Arrays;

public class 归并排序 {
    public static void main(String[] args) {
        int[] arr = {6,4,5,2,3,1,9,7,8};
        归并排序.mergeSort(arr);
        Utils.printArr(arr);
    }
    public static void mergeSort(int[] arr) {
        mergeSort(arr,0,arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int middle = l + (r -  l) / 2;

        mergeSort(arr, l, middle);
        mergeSort(arr, middle + 1, r);

        merge(arr, l, middle, r);
    }

    private static void merge(int[] arr, int start, int middle, int end) {

        int[] tempArr = Arrays.copyOfRange(arr, start, end + 1);
        // left、right 是 tempArr 中的指针， tempArr 索引从 0 开始
        int left = 0;
        //right 指向 arr 中 middle + 1 的位置  ，对应 tempArr middle - start + 1
        int right = middle - start + 1;
        for (int i = start; i <= end; i++) {
            if (left > middle - start) {
                arr[i] = tempArr[right];
                right++;
            } else if (right > end - start) {
                arr[i] = tempArr[left];
                left++;
            } else if (tempArr[left] > tempArr[right]) {
                arr[i] = tempArr[right];
                right++;
            } else {
                arr[i] = tempArr[left];
                left++;
            }
        }
    }
}
