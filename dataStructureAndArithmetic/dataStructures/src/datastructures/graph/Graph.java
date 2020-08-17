package datastructures.graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        String[] strs = {"A","B","C","D","E"};
        for (String str : strs) {
            graph.insertVertex(str);
        }

        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.showGraph();
    }

    private List<String> vertexList; //存储顶点集合

    private int[][] arr; //存储图对应的矩阵

    private int numOfEdges; //图边的数量

    private boolean[] isVisited;


    public Graph () {

    }

    public Graph (int n) {
        vertexList = new ArrayList<>(n);
        arr = new int[n][n];
        numOfEdges = 0;
    }

    //对一个结点进行广度优先遍历的方法
    private void bfs(boolean[] isVisited, int i) {
        int u ; // 表示队列的头结点对应下标
        int w ; // 邻接结点w
        //队列，记录结点访问的顺序
        LinkedList queue = new LinkedList();
        //访问结点，输出结点信息
        System.out.print(getValueByIndex(i) + "=>");
        //标记为已访问
        isVisited[i] = true;
        //将结点加入队列
        queue.addLast(i);

        while( !queue.isEmpty()) {
            //取出队列的头结点下标
            u = (Integer)queue.removeFirst();
            //得到第一个邻接结点的下标 w
            w = getFirstNeborhod(u);
            while(w != -1) {//找到
                //是否访问过
                if(!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "=>");
                    //标记已经访问
                    isVisited[w] = true;
                    //入队
                    queue.addLast(w);
                }
                //以u为前驱点，找w后面的下一个邻结点
                w = getNextNeborhod(u, w); //体现出我们的广度优先
            }
        }

    }

    //遍历所有的结点，都进行广度优先搜索
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for(int i = 0; i < getNumOfVertex(); i++) {
            if(!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }


    public void dfs () {
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                dfs();
            }
        }
    }

    private void dfs (boolean[] isVisited, int i) {
        System.out.print(getValueByIndex(i) + "-->");
        isVisited[i] = true;
        int w = getFirstNeborhod(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited,w);
            }
            w = getNextNeborhod(i,w);
        }
    }

    public int getFirstNeborhod (int i) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (arr[i][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public int getNextNeborhod (int v1,int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (arr[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    public int getNumOfVertex () {
        return vertexList.size();
    }

    public int getNumOfEdges () {
        return numOfEdges;
    }

    //返回v1和v2的权值
    public int getWeight (int v1, int v2) {
        return arr[v1][v2];
    }

    //返回结点i(下标)对应的数据 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public void insertVertex (String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdge (int a,int b,int weight) {
        arr[a][b] = weight;
        arr[b][a] = weight;
        numOfEdges ++;
    }

    public void showGraph () {
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
