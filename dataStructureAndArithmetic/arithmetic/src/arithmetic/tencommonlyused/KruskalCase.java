package arithmetic.tencommonlyused;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 克鲁斯卡尔算法
 */
public class KruskalCase {

    private int edgeNum; //边的个数
    private char[] vertexs; //顶点数组
    private int[][] matrix; //邻接矩阵
    //使用 INF 表示两个顶点不能连通
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
        kruskalCase.kruskal();
    }

    public KruskalCase (char[] vertexs,int[][] matrix) {
        this.vertexs = vertexs;
        this.matrix = matrix;
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                    if (matrix[i][j] != INF) {
                        edgeNum ++;
                    }
            }
        }
    }

    public void kruskal () {

        int[] ends = new int[edgeNum]; //用于保存"已有最小生成树" 中的每个顶点在最小生成树中的终点
        Edata[] edges =  getEdges();//获取边
        Edata[] result = new Edata[edgeNum];
        int index = 0;
        Arrays.parallelSort(edges, Comparator.comparingInt(o -> o.weight));

        for (int i = 0; i < edges.length; i++) {
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);

            int m = getEnd(ends,p1);
            int n = getEnd(ends,p2);

            if (m != n) {
                result[index++] = edges[i];
                ends[m] = n;
            }

        }
        System.out.println("最小生成树为");
        for(int i = 0; i < index; i++) {
            System.out.println(result[i]);
        }
    }

    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    private int getPosition(char start) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == start) return  i;
        }
        return -1;
    }


    public Edata[] getEdges () {
        Edata[] edges = new Edata[edgeNum];
        int index = 0;
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new Edata(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        }
        return edges;
    }



}

//边对象
class Edata {

    char start;//起点
    char end;//终点
    int weight;//

    public Edata (char start,char end,int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData [<" + start + ", " + end + ">= " + weight + "]";
    }

}
