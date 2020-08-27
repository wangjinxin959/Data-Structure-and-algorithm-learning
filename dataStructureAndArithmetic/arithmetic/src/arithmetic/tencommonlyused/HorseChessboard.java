package arithmetic.tencommonlyused;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 马踏棋盘算法
 */
public class HorseChessboard {

    private static int X;//棋盘的列

    private static int Y;//棋盘的行
    //创建一个数组,标记各个点是否被访问
    private static boolean[] visited;
    //如果为true 表示成功
    private static boolean finished;

    public static void main(String[] args) {
        System.out.println("骑士周游算法，开始运行~~");
        //测试骑士周游算法是否正确
        X = 8;
        Y = 8;
        int row = 2; //马儿初始位置的行，从1开始编号
        int column = 2; //马儿初始位置的列，从1开始编号
        //创建棋盘
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X * Y];//初始值都是false
        //测试一下耗时
        long start = System.currentTimeMillis();
        traversalChessboard(chessboard, row - 1, column - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("共耗时: " + (end - start) + " 毫秒");

        //输出棋盘的最后情况
        for(int[] rows : chessboard) {
            for(int step: rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param chessboard  棋盘
     * @param row         马儿当前位置的行
     * @param cloumn      马儿当前位置的列
     * @param step        步数
     */
    private static void traversalChessboard(int[][] chessboard, int row, int cloumn, int step) {
        chessboard[row][cloumn] = step;
        visited[row * X + cloumn] = true;
        //获取当前位置可以走的下一个位置的集合
        List<Point> ps = next(new Point(cloumn,row));
        ps.sort(Comparator.comparingInt(o -> next(o).size()));
        while (!ps.isEmpty()) {
            Point p = ps.remove(0);
            if (!visited[p.y * X + p.x]) {
                traversalChessboard(chessboard,p.y,p.x,step + 1);
            }
        }

        if (step < X * Y && !finished) {
            chessboard[row][cloumn] = 0;
            visited[row * X + cloumn] = false;
        } else {
            finished = true;
        }
    }

    private static List<Point> next(Point curPoint) {
        //创建一个ArrayList
        ArrayList<Point> ps = new ArrayList<Point>();
        //创建一个Point
        Point p1 = new Point();
        //一个点最多有八个位置可以走
        if((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y -1) >= 0) {
            ps.add(new Point(p1));
        }
        if((p1.x = curPoint.x - 1) >=0 && (p1.y=curPoint.y-2)>=0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }

}
