package arithmetic.recursion;

public class RecursionTest {

    public static void main(String[] args) {

        test(4);
        /*int jiecheng = jiecheng(3);
        System.out.println(jiecheng);*/

    }


    public static void test(int n){
        if(n > 2){
            test(n-1);
        }else{
            System.out.println("n = "+n);
        }
    }

    public static int jiecheng(int n){
        if(n == 1){
            return 1;
        }

        return jiecheng(n - 1) * n;
    }

}
