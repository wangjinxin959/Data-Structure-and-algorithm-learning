package arithmetic.tencommonlyused;

import java.util.Arrays;

/**
 * 迪杰斯特拉算法
 */
public class DijkstraAlgorithm {

    public static final Integer N = 65535;

    private VisitedVertex vv;

    private Graph graph;

    public DijkstraAlgorithm (Graph graph) {
        this.graph = graph;
    }

    public static void main(String[] args) {

        Graph graph = new Graph(7);
        graph.data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        graph.weight[0]=new int[]{N,5,7,N,N,N,2};
        graph.weight[1]=new int[]{5,N,N,9,N,N,3};
        graph.weight[2]=new int[]{7,N,N,N,8,N,N};
        graph.weight[3]=new int[]{N,9,N,N,N,4,N};
        graph.weight[4]=new int[]{N,N,8,N,N,5,4};
        graph.weight[5]=new int[]{N,N,N,4,5,N,6};
        graph.weight[6]=new int[]{2,3,N,N,4,6,N};

        DijkstraAlgorithm djs = new DijkstraAlgorithm(graph);
        djs.djs(graph.data.length,6);
        djs.show();

    }

    /**
     *
     * @param length 结点的个数
     * @param index  出发结点的下标
     */
    public void djs (int length,int index) {
        vv = new VisitedVertex(length,index);
        update(index);//更新出发顶点到index周围顶点的距离和周围顶点的前驱顶点
        for (int i = 1; i < graph.data.length; i++) {
            index = vv.updateArr();//返回下一个访问顶点
            update(index);
        }
    }

    private void update(int index) {
        int len = 0;
        for (int i = 0; i < graph.weight[index].length; i++) {
            //出发顶点到index的距离加上index到i的距离  等于出发顶点到i的距离
            len = vv.dis[index] + graph.weight[index][i];
            if (vv.already_arr[i] == 0 && len < vv.dis[i]) {
                vv.pre_visited[i] = index;
                vv.dis[i] = len;
            }
        }
        
    }

    public void show () {
        vv.show();
    }

}

//已访问顶点的集合
class VisitedVertex {

    int[] already_arr; //记录各个顶点是否被访问

    int[] pre_visited;//记录各个顶点的前驱顶点

    int[] dis; //记录出发顶点到各个顶点之间的距离

    public VisitedVertex (int length,int index) {
        already_arr = new int[length];
        pre_visited = new int[length];
        dis = new int[length];
        Arrays.fill(dis,65535);
        already_arr[index] = 1;
        dis[index] = 0;
    }

    public int updateArr() {
        int min = 65535;
        int index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && dis[i] < min) {
                index = i;
                min = dis[i];
            }
        }

        already_arr[index] = 1;
        return index;
    }

    //显示最后的结果
    //即将三个数组的情况输出
    public void show() {

        System.out.println("==========================");
        //输出already_arr
        for(int i : already_arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        //输出pre_visited
        for(int i : pre_visited) {
            System.out.print(i + " ");
        }
        System.out.println();
        //输出dis
        for(int i : dis) {
            System.out.print(i + " ");
        }
        System.out.println();
        //为了好看最后的最短距离，我们处理
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int count = 0;
        for (int i : dis) {
            if (i != 65535) {
                System.out.print(vertex[count] + "("+i+") ");
            } else {
                System.out.println("N ");
            }
            count++;
        }
        System.out.println();

    }

}

