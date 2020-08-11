package arithmetic.sort;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr,int left,int right){
        int i = left;
        int j = right;
        int pivot = arr[(i+j)/2];
        int temp = 0;
        while(i < j){
            while(arr[i] < pivot){
                i++;
            }

            while(arr[j] > pivot){
                j--;
            }
            if(arr[i] == arr[j] && i < j){
                i++;
            }
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        if(i-1>left) quickSort(arr,left,i-1);
        if(j+1<right) quickSort(arr,j+1,right);
    }

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        //int[] arr = {6,5,2,8,7,4,3}; // 3
        int[] arr = new int[8000];
        for (int i = 0; i < 8000; i++) {
            arr[i] = (int)(Math.random() * 8000);
        }
        quickSort(arr,0,arr.length-1);//14 20
        System.out.println("共耗时: "+(System.currentTimeMillis() - time) + "ms");
    }

}
