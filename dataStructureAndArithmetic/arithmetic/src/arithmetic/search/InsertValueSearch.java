package arithmetic.search;

public class InsertValueSearch {
    //数据量大，关键字分布均匀
    public static int insertValueSearch(int[] arr,int key){
        int low = 0;
        int high = arr.length - 1;
        if(key < arr[low] || key > arr[high]){
            return -1;
        }
        int mid = 0;
        while (low <= high){
            System.out.println("插值查找的次数！");
            mid = low + (high-low)*(key-arr[low])/(arr[high]-arr[low]);
            if(arr[mid] < key){
                low = mid + 1;
            }else if(arr[mid] > key){
                low = mid - 1;
            }else{
                return mid;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }

        int i = insertValueSearch(arr, 66);
        System.out.println(i);
    }


}
