package datastructures.linkedlist;

import java.util.Stack;

public class SingleLinkedList {

    private HeroNode head = new HeroNode();

    public void add(HeroNode node){
        HeroNode temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = node;
    }

    public void addByOrder(HeroNode node){
        HeroNode temp = head;
        boolean flag = false;
        while(true){

            if(temp.next == null){
                break;
            }
            if(temp.next.no > node.no){
                break;
            }else if(temp.next.no == node.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            System.out.printf("已存在%d节点\n",node.no);
        }else{
            node.next = temp.next;
            temp.next = node;
        }

    }

    public void deleteNode(int no){
        HeroNode temp = head;
        boolean flag = false;
        while(temp.next != null){
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.printf("删除失败！没有找到编号为%d的节点\n",no);
        }
    }

    public void updateNode(HeroNode newNode){
        HeroNode temp = head.next;
        boolean flag = false;
        while(temp != null){
            if(temp.no == newNode.no){
                flag = true;
                temp.name = newNode.name;
                temp.nickName = newNode.nickName;
                break;
            }else{
                temp = temp.next;
            }
        }

        if(!flag){
            System.out.printf("修改失败！没有找到编号为%d的节点\n",newNode.no);
        }
    }

    public void list(){
        HeroNode temp = head;
        while (temp.next!=null){
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

    //求单链表有效节点的个数
    public int size(){
        int length = 0;
        HeroNode cur = head.next;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    //查找单链表中的倒数第K个节点
    public HeroNode lastIndex(int k){
        if( k <= 0 || k > size() ){
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size()-k; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public void reversetList(){
        SingleLinkedList newList = new SingleLinkedList();
        if(head.next == null || size() == 1){
            return;
        }

        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode newHead = newList.head;
        while (cur != null){
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }

        head = newHead;
    }

    //从尾到头打印单链表节点
    public void reverSetPrint(){
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }

        while (stack.size()>0){
            System.out.println(stack.pop());
        }

    }

    public static SingleLinkedList mergeList(SingleLinkedList list1,SingleLinkedList list2){
        SingleLinkedList newList = new SingleLinkedList();
        HeroNode cur1 = list1.head.next;
        HeroNode cur2 = list2.head.next;
        HeroNode next1 = null;
        HeroNode next2 = null;
        while(cur1 !=null || cur2 != null){
            if(cur1 == null){
                next2 = cur2.next;
                cur2.next = null;
                newList.add(cur2);
                cur2 = next2;
                continue;
            }
            if(cur2 == null){
                next1 = cur1.next;
                cur1.next = null;
                newList.add(cur1);
                cur1 = next1;
                continue;
            }
            next1 = cur1.next;
            next2 = cur2.next;
            if(cur1.no <= cur2.no){
                cur1.next = null;
                newList.add(cur1);
                cur1 = next1;
            }else{
                cur2.next = null;
                newList.add(cur2);
                cur2 = next2;
            }
        }
        return newList;
    }

}
class HeroNode{
    public Integer no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(){

    }

    public HeroNode(Integer no,String name,String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode[" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ']';
    }
}