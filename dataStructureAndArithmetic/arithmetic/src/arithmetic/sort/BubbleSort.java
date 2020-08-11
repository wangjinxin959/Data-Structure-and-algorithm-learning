package arithmetic.sort;

import java.util.Arrays;

/**
 * 冒泡排序 时间复杂度O(n^2)
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空！");
            return;
        }
        int temp = 0;
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]){
                    flag = false;
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
            if(flag){
                break;
            }
        }
    }


    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        //int[] arr = {6,5,2,8,7,4,3};
        int[] arr = new int[8000];
        for (int i = 0; i < 8000; i++) {
            arr[i] = (int)(Math.random() * 8000);
        }
        bubbleSort(arr); //420 505 311 335 288
        //System.out.println(Arrays.toString(arr));
        System.out.println("共耗时: "+(System.currentTimeMillis() - time) + "ms");
    }

}
