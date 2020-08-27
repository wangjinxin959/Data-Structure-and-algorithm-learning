package arithmetic.tencommonlyused;

/**
 * 弗洛伊德算法
 */
public class Floyd {

    private Graph graph;

    public Floyd (Graph graph) {
        this.graph = graph;
    }

    public void floyd () {

        //中间顶点
        for (int k = 0; k < graph.data.length; k++) {
            //开始顶点
            for (int i = 0; i < graph.data.length; i++) {
                //到达顶点
                for (int j = 0; j < graph.data.length; j++) {
                    if (graph.weight[i][j] > graph.weight[i][k] +  graph.weight[k][j]) {
                        graph.weight[i][j] =  graph.weight[i][k] +  graph.weight[k][j];
                        graph.pre[i][j] = graph.pre[k][j];
                    }
                }
            }
        }

    }

    public void show() {

        //为了显示便于阅读，我们优化一下输出
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        for (int k = 0; k < graph.weight.length; k++) {
            // 先将pre数组输出的一行
            for (int i = 0; i < graph.weight.length; i++) {
                System.out.print(vertex[graph.pre[k][i]] + " ");
            }
            System.out.println();
            // 输出dis数组的一行数据
            for (int i = 0; i < graph.weight.length; i++) {
                System.out.print("("+vertex[k]+"到"+vertex[i]+"的最短路径是" + graph.weight[k][i] + ") ");
            }
            System.out.println();
            System.out.println();

        }

    }

    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        //创建邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[] { 0, 5, 7, N, N, N, 2 };
        matrix[1] = new int[] { 5, 0, N, 9, N, N, 3 };
        matrix[2] = new int[] { 7, N, 0, N, 8, N, N };
        matrix[3] = new int[] { N, 9, N, 0, N, 4, N };
        matrix[4] = new int[] { N, N, 8, N, 0, 5, 4 };
        matrix[5] = new int[] { N, N, N, 4, 5, 0, 6 };
        matrix[6] = new int[] { 2, 3, N, N, 4, 6, 0 };
        Graph graph = new Graph(vertex.length,vertex,matrix);
        Floyd floyd = new Floyd(graph);
        floyd.floyd();
        floyd.show();

    }

}
