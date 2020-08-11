package datastructures.linkedlist;

public class CircleSingleLinkedList {

    private int size;

    private Boy first = null;

    public void yusephu2(Integer startNum,Integer countNum,Integer boyNum){
        if(startNum <= 0 || startNum > boyNum || boyNum < 2){
            System.out.println("请输入正确的参数!");
            return;
        }

        boolean[] arr = new boolean[boyNum];
        int alive = boyNum;
        int index = startNum-1;
        int num = 0;
        while (alive > 1){
            if(!arr[index]){
                num ++;
                if(num % countNum == 0){
                    arr[index] = true;
                    alive--;
                    num = 0;
                }
            }

            if(index == arr.length-1){
                index = 0;
            }else{
                index ++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(!arr[i]){
                System.out.printf("最后剩下的编号为：%d",i+1);
            }
        }


    }


    public void yusephu(Integer startNum,Integer countNum){
        if(startNum <= 0 || startNum > size || size < 2){
            System.out.println("请输入正确的参数!");
            return;
        }

        Boy helper = first;//指向循环链表最后一个元素
        while(helper.next != first ){
            helper = helper.next;
        }

        for (int i = 0; i < startNum - 1; i++) {
            first = first.next;
            helper = helper.next;
        }

        while(helper != first){
            for (int i = 0; i < countNum - 1; i++) {
                first = first.next;
                helper = helper.next;
                System.out.println("出圈的编号为："+first.no);
            }
            helper.next = first.next;
            first = helper.next;
        }

        System.out.println("最后剩下的编号为："+first.no);


    }

    //添加num个子节点
    public void addBoy(Integer num){

        if(num <= 1){
            System.out.println("链表中元素不能少于两个");
        }

        Boy temp = null;
        for (int i = 1; i <=num; i++) {
            Boy newBoy = new Boy(i);
            if(i == 1){
                first = newBoy;
                first.next = first;
                temp = first;
            }else{
                temp.next = newBoy;
                newBoy.next = first;
                temp = newBoy;
            }
            size ++;
        }
    }

    public void list(){
        if(first == null){
            System.out.println("链表为空!");
            return;
        }
        Boy temp = first;
        while(true){
            System.out.println(temp);
            if(temp.next == first){
                break;
            }
            temp = temp.next;
        }
    }

}

class Boy{

    public Integer no;
    public Boy next;

    public Boy(){

    }

    public Boy(Integer no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
