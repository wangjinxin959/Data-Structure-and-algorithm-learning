package datastructures.queue;

import java.util.Scanner;

public class QueueMain {

    public static void main(String[] args) {

        MyArrayQueue2 queue = new MyArrayQueue2(3);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        boolean loop = true;

        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列中取数据");
            System.out.println("p(peek):显示队列头数据");
            System.out.println("e(exit):退出程序");

            String next = scanner.next();
            key = next.charAt(0);

            switch (key){
                case 's':
                    try{
                        //queue.get();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("请输入一个数:");
                    int value = scanner.nextInt();
                    try{
                        queue.addElement(value);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try{
                        int element = queue.getElement();
                        System.out.println("取出的数据是:"+element);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try{
                        int element = queue.peek();
                        System.out.println("头数据是:"+element);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;

            }

        }

        System.out.println("程序退出!");


    }

}
