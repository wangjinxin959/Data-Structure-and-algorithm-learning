package review.bubblesort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    @Test
    public void test () {
        int[] arr = {4,5,8,7,1,3,2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public void bubbleSort (int[] arr) {
        int temp = 0;
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    flag = false;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

            if (flag) {
                break;
            }

        }

    }

}
