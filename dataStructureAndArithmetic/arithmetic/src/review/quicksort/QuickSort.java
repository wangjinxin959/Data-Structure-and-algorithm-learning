package review.quicksort;


import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3,1,5,4,8};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

        System.out.println(4 >>1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int pivot = arr[(i + j) >> 1];
        int temp = 0;
        while (i < j) {
            while (arr[i] < pivot) {
                i ++;
            }

            while (arr[j] > pivot) {
                j --;
            }

            if (i < j && arr[i] == arr[j]) {
                i++;
            }
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        if (i - 1 > left) quickSort(arr,left,i-1);
        if (j + 1 < right) quickSort(arr,j+1,right);

    }

}
