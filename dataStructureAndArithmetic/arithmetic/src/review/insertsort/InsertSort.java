package review.insertsort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {6,5,2,8,7,4,3};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //{6,5,2,8,7,4,3}
    public static void insertSort (int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex --;
            }

            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertValue;
            }
        }
    }

}
