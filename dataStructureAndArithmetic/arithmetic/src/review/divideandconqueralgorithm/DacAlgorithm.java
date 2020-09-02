package review.divideandconqueralgorithm;


import org.junit.Test;

/**
 * 分治算法
 */
public class DacAlgorithm {

    @Test
    public void test () {
        hanRowTower(3,'A','B','C');
    }

    private void hanRowTower(int num, char a, char b, char c) {
        if (num < 2) {
            System.out.println("把第"+num+"个盘从"+a+"移动到"+c);
        } else {
            //把第一个盘从a移动到b
            hanRowTower(num-1,a,c,b);
            System.out.println("把第"+num+"个盘从"+a+"移动到"+c);
            //把下一个盘从b移动到c
            hanRowTower(num-1,b,a,c);
        }
    }

}
