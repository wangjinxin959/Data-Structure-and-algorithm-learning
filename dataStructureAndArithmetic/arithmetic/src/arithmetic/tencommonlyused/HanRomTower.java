package arithmetic.tencommonlyused;

import org.junit.Test;

/**
 * 分治算法(divide-and-conquer algorithm)
 */
public class HanRomTower {
    private int count;

    @Test
    public void test () {
        hanRowTower(3,'A','B','C');
        System.out.println(count);
    }

    //汉罗塔案例
    public void hanRowTower (int num,char a,char b,char c) {
        if (num == 1) {
            System.out.println("把第"+num+"个盘"+a+"->"+c);
            count++;
        } else if (num >=2) {
            //把最上面的盘从A移动到B
            hanRowTower(num-1,a,c,b);
            //把最下面的盘从A移动到C
            System.out.println("把第"+num+"个盘"+a+"->"+c);
            count++;
            //把盘从B移动到C
            hanRowTower(num-1,b,a,c);
        } else {
            return;
        }
    }

}
