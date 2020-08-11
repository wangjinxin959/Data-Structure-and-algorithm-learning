package datastructures.sparsearray;

import java.io.*;
import java.util.Scanner;

/**
 * 数据结构之稀疏数组
 */
public class SparseArray {


    //将普通二维数组转换为稀疏数组
    public static int[][] regularArrToSparseArr(int[][] regularArr){

        //计算普通二维数组的有效值,初始化稀疏数组的大小
        int sum = 0;
        for (int[] ints : regularArr) {
            for (int anInt : ints) {
                if(anInt != 0){
                    sum++;
                }
            }
        }

        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = regularArr.length;
        sparseArr[0][1] = regularArr[0].length;
        sparseArr[0][2] = sum;
        
        //遍历二维数组给稀疏数组赋值
        int count = 0; //保存有效值的行数
        for (int i = 0; i < regularArr.length; i++) {
            for (int j = 0; j < regularArr[i].length; j++) {
                if(regularArr[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = regularArr[i][j];

                }

            }
        }
        
        return sparseArr;
    }

    //将稀疏数组转换为二维数组
    public static int[][] sparseArrToRegularArr(int[][] sparseArr){
        //初始化二维数组大小
        int[][] regularArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        //遍历稀疏数组 给二维数组赋值
        for (int i = 1; i < sparseArr.length; i++) {
            regularArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        return regularArr;
    }

    public static void saveSparseArrToDisk(int[][] sparseArr){

        /*Scanner sc = new Scanner(System.in);
        System.out.println("请输入保存数据的名称:");
        String fileName = sc.nextLine();*/

        File file = new File(System.getProperty("user.dir")+"\\"+"map.data");
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(file),true);
            for (int[] ints : sparseArr) {
                for (int anInt : ints) {
                    pw.print(anInt+"t");
                }
                pw.print("n");
            }
            pw.close();
            System.out.println("保存成功!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static int[][] readDatafromDisk(){
       /* Scanner sc = new Scanner(System.in);
        System.out.println("请输入要读取数据的名称:");
        String fileName = sc.nextLine();*/
        int[][] arr = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(System.getProperty("user.dir")+"\\"+"map.data")));
            String line;
            while ((line=br.readLine())!=null){
                String[] sp1 = line.split("n");
                arr = new int[sp1.length][3];
                int row = 0;
                for (String s : sp1) {
                    String[] sp2 = s.split("t");
                    arr[row][0] = Integer.parseInt(sp2[0]);
                    arr[row][1] = Integer.parseInt(sp2[1]);
                    arr[row][2] = Integer.parseInt(sp2[2]);
                    row++;
                }
            }

            return arr;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arr;
    }


    public static void main(String[] args) {
        int[][] regularArr = new int[110][110];
        regularArr[2][5] = 1;
        regularArr[3][6] = 2;
        regularArr[4][5] = 1;
        regularArr[5][6] = 2;
        /*long start = System.currentTimeMillis();
        saveSparseArrToDisk(regularArr);
        readDatafromDisk();
        System.out.println("耗时:"+(System.currentTimeMillis()-start)+"ms");//110ms*/

        long time = System.currentTimeMillis();
        int[][] sparseArr = regularArrToSparseArr(regularArr);
        saveSparseArrToDisk(sparseArr);
        int[][] ints = readDatafromDisk();
        sparseArrToRegularArr(ints);
        System.out.println("耗时:"+(System.currentTimeMillis()-time)+"ms");//10ms
      /*  System.out.println("原数组为:");
        for (int[] ints : regularArr) {
            for (int anInt : ints) {
                System.out.print(anInt+"  ");
            }
            System.out.println();
        }*/
        /*int[][] sparseArr = regularArrToSparseArr(regularArr);
        saveSparseArrToDisk(sparseArr);*/
       /* System.out.println("对应的稀疏数组为:");
        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
                System.out.print(anInt+"  ");
            }
            System.out.println();
        }*/

       /* System.out.println("转换为二维数组：");
        int[][] arr = sparseArrToRegularArr(sparseArr);
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+"  ");
            }
            System.out.println();
        }*/

        /*int[][] ints = readDatafromDisk();

        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i+" ");
            }
            System.out.println();
        }*/


    }

}
