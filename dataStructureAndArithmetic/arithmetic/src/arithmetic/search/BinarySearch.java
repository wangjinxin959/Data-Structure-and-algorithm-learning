package arithmetic.search;


import java.util.ArrayList;
import java.util.List;

public class BinarySearch {


    public static List<Integer> binarySearch(int[] arr, int val){
            int left = 0;
            int right = arr.length-1;
            int mid = 0;
            int midVal = 0;
            List<Integer> list = new ArrayList<>();
            while (left <= right){
                mid = (left+right) >> 1;
                midVal = arr[mid];
                if(midVal < val){
                    left = mid + 1;
                }else if(midVal > val){
                    right = mid - 1;
                }else{
                    list.add(mid);
                    int temp = mid;
                    while (temp >= 0 && arr[temp--] == val){
                        list.add(temp);
                    }
                    temp = mid;
                    while (temp < arr.length && arr[temp++] == val){
                        list.add(temp);
                    }
                    break;
                }
            }

            return list;

    }

    public static List<Integer> binarySearch2(int[] arr,int key,int left,int right){
            if(left > right){
                return new ArrayList<Integer>();
            }

            int mid = (left + right) >> 1;
            int midVal = arr[mid];
            if (midVal < key){
                left = mid + 1;
                return binarySearch2(arr,key,left,right);
            }else if (midVal > key){
                right = mid - 1;
                return binarySearch2(arr,key,left,right);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(mid);
                int temp = mid;
                while(temp >= 0 && arr[--temp] == key){
                    list.add(temp);
                }

                temp = mid;
                while(temp < arr.length && arr[++temp] == key){
                    list.add(temp);
                }

                return list;

            }
    }

    public static void main(String[] args) {
        int[] arr = {2,4,8,8,10,15,30,34};
        //List<Integer> list = binarySearch(arr, 30);
        List<Integer> list = binarySearch2(arr, 8,0,7);
        System.out.println(list);
    }


}
