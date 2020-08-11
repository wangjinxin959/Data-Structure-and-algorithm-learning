package arithmetic.recursion;

public class MiGong {

    public static void main(String[] args) {

        //定义一个七行八列的地图
        int[][] map = new int[6][6];
        //把第一行和最后一行设置为墙 即值为1
        for (int i = 0; i < 6; i++) {
            map[0][i] = 1;
            map[5][i] = 1;
        }

        //把第一列和最后一列设置为墙 即值为1
        for (int i = 0; i < 6; i++) {
            map[i][0] = 1;
            map[i][5] = 1;
        }

        map[2][2] = 1;
        map[2][3] = 1;
        map[3][2] = 1;
        map[4][2] = 1;


        mapPrint(map);

        //从第二行第二列出发 到第六行第七列
        findWay(map,1,1);

        mapPrint(map);

    }

    /**
     *
     * @param map 二维数组地图
     * @param i   开始点坐标位置行号
     * @param j   开始点坐标位置列号
     */
    //最标点为2表示走过的点,可以走通 坐标点为3表示走过但是走不通的点
    public static boolean findWay(int[][] map,int i,int j){

        if(map[3][3] == 2){
            return true;
        }else{
            if(map[i][j] == 0){
                //按照策略：下->右->上->左
                map[i][j] = 2;
                if(findWay(map,i+1,j)){//向下走 2 1
                    return true;
                }else if(findWay(map,i,j+1)){//向右走
                    return true;
                }else if(findWay(map,i-1,j)){//向上走
                    return true;
                }else if(findWay(map,i,j-1)){//向左走
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }

            }else{
                return false;
            }
        }
    }

    public static void mapPrint(int[][] map){
        System.out.println("迷宫图:");
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
