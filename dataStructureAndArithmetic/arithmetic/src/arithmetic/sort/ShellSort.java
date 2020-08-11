package arithmetic.sort;

import java.util.Arrays;

public class ShellSort {

    public static void changeShellSort(int[] arr){
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >=0 ; j -= gap) {
                    if(arr[j+gap] < arr[j]){
                        temp = arr[j+gap];
                        arr[j+gap] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }

    public static void moveShellSort(int[] arr){
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            for (int i = gap; i <arr.length ; i++) {
                int j = i;
                temp = arr[j];
                if(arr[j] < arr[j-gap]){
                    while(j - gap >= 0 && temp<arr[j - gap]){
                        arr[j] = arr[j-gap];
                        j-=gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        int[] arr = {6,5,2,8,7,4,3}; // 3
        /*int[] arr = new int[8000];
        for (int i = 0; i < 8000; i++) {
            arr[i] = (int)(Math.random() * 8000);
        }*/
       // changeShellSort(arr);//251 250 246
        moveShellSort(arr);// 30 49 56 17 37
        //System.out.println(Arrays.toString(arr));
        System.out.println("共耗时: "+(System.currentTimeMillis() - time) + "ms");
    }

}
