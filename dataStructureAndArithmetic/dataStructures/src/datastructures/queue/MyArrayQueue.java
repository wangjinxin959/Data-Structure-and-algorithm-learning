package datastructures.queue;

/**
 * 数据结构值数组队列
 */
public class MyArrayQueue {

    private int capacity;//最大容量

    private int[] queue;//存储数据

    private int rear;//尾指针，指向最后一个元素位置

    private int front;//头指正，指向头元素的前一个位置

    public MyArrayQueue(int capactity) {
        this.capacity = capactity;
        queue = new int[capactity];
        rear = -1;
        front = -1;
    }


    //判断队列是否为空
    public boolean isEmpty() {

        return rear == front;
    }

    //判断队列是否满了
    public boolean isFull() {
        return rear == capacity - 1;
    }

    //增加元素
    public void addElement(int e) {

        if(isFull()){
            throw new RuntimeException("队列已满!");
        }

        queue[++rear] = e;

    }


    //取出元素
    public int getElement(){

        if(isEmpty()){
            throw new RuntimeException("队列为空!");
        }

        return queue[++front];

    }

    //显示头元素的值
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }

        return queue[front+1];
    }

    //显示所有数据
    public void get(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        for (int i = 0; i < queue.length; i++) {
            System.out.printf("arr[%d] = %d\n",i,queue[i]);
        }
    }


}
