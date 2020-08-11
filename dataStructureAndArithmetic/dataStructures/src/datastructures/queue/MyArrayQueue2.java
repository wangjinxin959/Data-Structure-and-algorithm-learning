package datastructures.queue;

public class MyArrayQueue2 {

    private int capacity;//最大容量

    private int[] queue;//存储数据

    private int rear;//尾指针，指向最后一个元素后一个位置

    private int front;//头指正，指向头元素

    public MyArrayQueue2(int capacity){
        this.capacity = capacity + 1;
        queue = new int[this.capacity];
    }

    public boolean isFull(){
        return ( rear + 1 ) % capacity == front;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    //增加元素
    public void addElement(int e) {
        if(isFull()){
            throw new RuntimeException("队列已满!");
        }
        queue[rear] = e;
        rear = (rear + 1) % capacity;
    }


    //取出元素
    public int getElement(){
        if(isEmpty()){
            throw new RuntimeException("队列为空!");
        }
        int value =  queue[front];
        front = (front + 1 ) % capacity;
        return value;
    }

    //显示头元素的值
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }

        return queue[front];
    }

    //获取有效数据的个数
    public int size(){
        int diff = rear - front;
        if (diff < 0)
            diff += capacity;
        return diff;
    }

    //显示所有数据
   /* public void get(){
        if(isEmpty()){
            throw new RuntimeException("队列为空！");
        }
        for (int i = 0; i < queue.length; i++) {
            System.out.printf("arr[%d] = %d\n",i,queue[i]);
        }
    }*/

}
