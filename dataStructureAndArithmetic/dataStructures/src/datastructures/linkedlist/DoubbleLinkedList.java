package datastructures.linkedlist;

public class DoubbleLinkedList {

    private PeopleNode head = new PeopleNode();

    public void add(PeopleNode node){
        PeopleNode temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    public void addByOrder(PeopleNode node){
        PeopleNode cur = head;
        boolean flag = false;
        while(cur.next != null){
            if(cur.next.no > node.no){
                break;
            }else if(cur.next.no == node.no){
                flag = true;
                break;
            }
            cur = cur.next;
        }

        if(flag){
            System.out.println("需要增加的节点已存在!");
        }else{
            node.next = cur.next;
            node.pre = cur;
            cur.next = node;
            if(cur.next != null){
                cur.next.pre = node;
            }
        }
    }

    public void deleteNode(Integer no){
        PeopleNode cur = head.next;
        boolean flag = false;
        while(cur.next != null){
            if(cur.no == no){
                flag = true;
                break;
            }
            cur = cur.next;
        }

        if(flag){
            cur.pre.next = cur.next;
            if(cur.next != null){
                cur.next.pre = cur.pre;
            }
        }else{
            System.out.println("删除失败！没有要删除节点！");
        }
    }

    public void updateNode(PeopleNode newNode){
        PeopleNode cur = head.next;
        boolean flag = false;
        while (cur != null){
            if(cur.no == newNode.no){
                flag = true;
                cur.name = newNode.name;
                break;
            }
            cur = cur.next;
        }
        if(!flag){
            System.out.println("修改失败!找不到要修改的节点");
        }
    }

    public void list(){
        PeopleNode cur = head.next;
        while(cur != null){
            System.out.println(cur);
            cur = cur.next;
        }
    }


}

class PeopleNode{

    public PeopleNode pre;
    public PeopleNode next;
    public Integer no;
    public String name;

    public PeopleNode(){

    }

    public PeopleNode(Integer no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "PeopleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
