package arithmetic.tencommonlyused;

import java.util.Arrays;

/**
 * 普利姆算法(prim算法)
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}};
        Graph graph = new Graph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(graph,data,weight);
        //minTree.showGraph(graph);
        minTree.prim(graph,0);
    }
}

class MinTree {

    public void createGraph (Graph graph,char[] data,int[][] weight) {
        for (int i = 0; i < data.length; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < data.length; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph (Graph graph) {
        for (int[] arr : graph.weight) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public void prim (Graph graph, int v) {
        boolean[] visited = new boolean[graph.verxs];
        visited[v] = true;
        int min = 10000;
        int h1 = -1;
        int h2 = -1;
        for (int k = 1; k < graph.verxs; k++) {

            for (int i = 0; i < graph.verxs; i++) {
                for (int j = 0; j < graph.verxs; j++) {
                    if (visited[i] && !visited[j] && graph.weight[i][j] < min) {
                            min = graph.weight[i][j];
                            h1 = i;
                            h2 = j;
                    }
                }
            }

            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + ">权值:" + min);
            visited[h2] = true;
            min = 10000;
        }
    }

}


class Graph {
    int verxs; //顶点的个数
    char[] data; //顶点的值
    int[][] weight; //边的权值

    public Graph (int n) {
        verxs = n;
        data = new char[n];
        weight = new int[n][n];
    }

}
