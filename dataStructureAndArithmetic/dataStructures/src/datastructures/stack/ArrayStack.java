package datastructures.stack;

public class ArrayStack {

    private int capacity;

    private Object[] ele;

    private int top = -1;

    public ArrayStack(int capacity){
        this.capacity = capacity;
        ele = new Object[this.capacity];
    }

    public boolean isFull(){
        return top == capacity-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(Object o){
        if(isFull()){
            System.out.println("栈满！");
            return;
        }
        ele[++top] = o;
    }

    public Object pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空！");
        }
        return ele[top--];
    }

    public Object peek(){
        if(isEmpty()){
            throw new RuntimeException("栈空！");
        }
        return ele[top];
    }

    public void list(){

        if(isEmpty()){
            System.out.println("栈空！");
            return;
        }
        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d]=%d\n",i,ele[i]);
        }
    }

    //判断是否为运算符
    public boolean isOper(char oper){
        if(oper == '+' || oper == '-' || oper == '*' || oper == '/'){
            return true;
        }
        return false;
    }

    public int calculator(int num1,int num2,char oper){
        int result = 0;
        switch (oper){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
        }
        return result;
    }

    public int priority(char oper){
        if(oper == '+' || oper == '-'){
            return 0;
        }
        if(oper == '*' || oper == '/'){
            return 1;
        }
        return -1;
    }

}
