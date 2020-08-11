package arithmetic.recursion;

import java.util.Arrays;

public class Queen8 {

    private int max = 8;

    private int[] array = new int[max];

    private static int count = 0;


    public static void main(String[] args) {

        Queen8 queen = new Queen8();
        queen.check(0);
        System.out.printf("一共有%d种摆法",count);

    }

    //放置第n个皇后
    public void check(int n){

        if(n == max){
            System.out.println(Arrays.toString(array));
            count++;
            return;
        }

        for (int i = 0; i < max; i++) {
            array[n] = i;//array[1] = 1;
            if(judge(n)){ //如果不冲突
                check(n + 1);
            }
        }

    }

    //判断摆放的位置是否和其他皇后位置冲突 返回true表示不冲突
    public boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if(array[n] == array[i] || Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }

        return true;
    }

}
