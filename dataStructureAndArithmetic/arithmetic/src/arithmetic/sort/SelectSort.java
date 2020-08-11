package arithmetic.sort;

import java.util.Arrays;

public class SelectSort {

    public static void selectSort(int[] arr){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }
        for (int j = 0; j < arr.length - 1; j++) {
            int minIndex = j;
            int min = arr[j];
            for (int i = j + 1; i < arr.length; i++) {
                if(arr[i] < min){
                    min = arr[i]; //2
                    minIndex = i; //2
                }
            }

            if(minIndex != j){
                arr[minIndex] = arr[j];
                arr[j] = min;
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
        selectSort(arr); //119 110 120
        //System.out.println(Arrays.toString(arr));
        System.out.println("共耗时: "+(System.currentTimeMillis() - time) + "ms");
    }

}
