package arithmetic.sort;

import java.util.Arrays;

public class InsertSort {

    public static void insertSort(int[] arr){
        if(arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;

            while(insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1 ] = arr[insertIndex];
                insertIndex --;
            }
            if(insertIndex + 1 != i){
                arr[insertIndex + 1] = insertVal;
            }
        }

    }

    public static void add(int a ){
        a++;
    }


    public static void main(String[] args) {
        //long time = System.currentTimeMillis();
        //int[] arr = {6,5,2,8,7,4,3}; // {2,4,5,6,7,8,3}
        /*int[] arr = new int[8000];
        for (int i = 0; i < 8000; i++) {
            arr[i] = (int)(Math.random() * 8000);
        }*/
        //insertSort(arr); // 71 65 122 58
        //System.out.println(Arrays.toString(arr));
        //System.out.println("共耗时: "+(System.currentTimeMillis() - time) + "ms");
        int i = 0;
        add(i);
        i = i++;
        System.out.println(i);
    }

}
