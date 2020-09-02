package review.dynamic;

/**
 * 动态规划算法(背包问题)
 */
public class Dynamic {

    public static void main(String[] args) {
        // 手机 笔记本 平板
        int[] w = {1,4,3}; //物品的重量
        int[] val = {1500,3000,2000}; //物品的价值
        int m = 4; //背包的容量
        int[][] v = new int[w.length + 1][m + 1];
        int[][] path = new int[w.length + 1][m + 1];

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                if (w[i - 1] > j) {
                    v[i][j] = v[i-1][j];
                } else {
                    if (v[i-1][j] < val[i-1] + v[i-1][j-w[i-1]]) {
                        v[i][j] = val[i-1] + v[i-1][j-w[i-1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }

        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + "    ");
            }
            System.out.println();
        }

        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(path[i][j] + "    ");
            }
            System.out.println();
        }

        int i = path.length - 1;
        int j = path[i].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] != 0) {
                System.out.printf("把第%d个东西放入背包,放"+path[i][j]+"个\n",i);
                j -= w[i - 1];
            }
            i--;
        }
    }

}
