package arithmetic.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 堆排序
 * 时间复杂度 O(nlogn)
 */
public class HeapSort {

    @Test
    public void test() {
        int[] arr = {4,6,8,5,9};
        heapSort(arr);
        //System.out.println(Arrays.toString(arr));
    }


    public void heapSort(int[] arr) {
        int temp = 0;
        for (int i = arr.length/2 - 1; i >=0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }
        System.out.println(Arrays.toString(arr));
        for (int j = arr.length-1; j >0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j); //[0,6,8,,5,4,3,7,9]
        }

    }

    public void adjustHeap(int[] arr,int i,int length) {
        int temp = arr[i];
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
                if (j+1 < length && arr[j] < arr[j+1]) {
                        j++;
                }
                if (arr[j] > temp) {
                    arr[i] = arr[j];
                    i = j;
                }else {
                    break;
                }
        }

        arr[i] = temp;

    }

}
