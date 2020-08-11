package datastructures.hashtab;

public class EmpLinkedList {

    private Employee head;

    public void add(Employee emp){
        if(head == null){
            head = emp;
        }else{
            Employee cur = head;
            while (cur.getNext() != null){
                cur = cur.getNext();
            }
            cur.setNext(emp);
        }
    }

    public void addByOrder(Employee emp){
        if(head == null){
            head = emp;
        }else{
            Employee cur = head;
            while(cur.getNext() != null && cur.getNext().getId() < emp.getId()){
                cur = cur.getNext();
            }
            emp.setNext(cur.getNext());
            cur.setNext(emp);
        }
    }

    public void deleteById(int id){
        if(head == null){
            System.out.println("没有找到id为"+id+"的员工,删除失败！");
        }else if (head !=null && head.getId() == id){
            head = head.getNext();
            System.out.println("id为"+id+"的员工,删除成功！");
        }else{
            boolean flag = false;
            Employee cur = head;
            while(cur.getNext() != null){
                if(cur.getNext().getId() == id){
                    flag = true;
                    break;
                }
                cur = cur.getNext();
            }

            if(flag){
                cur.setNext(cur.getNext().getNext());
                System.out.println("id为"+id+"的员工,删除成功！");
            }else{
                System.out.println("没有找到id为"+id+"的员工,删除失败！");
            }
        }
    }

    public void list(int no){
        if (head == null) {
            System.out.println("第"+(no+1)+"员工链表为空");
        }else{
            System.out.print("第"+(no+1)+"条员工链表为==>");
            Employee cur = head;
            while (cur != null){
                System.out.printf("id:%d name:%s\t",cur.getId(),cur.getName());
                cur = cur.getNext();
            }
            System.out.println();
        }

    }


    public void findById(int id,int no){
        if(head == null){
            System.out.println("没有找到员工id为："+id+"的员工");
        }else{
            Employee cur = head;
            while (cur != null && cur.getId() != id){
                cur = cur.getNext();
            }

            if(cur == null){
                System.out.println("没有找到员工id为："+id+"的员工");
            }else{
                System.out.println("在第"+(no+1)+"条链表中"+"找到了员工id为："+id+"的员工");
            }
        }

    }

    public void reverset(){
        EmpLinkedList newEmpLinkedList = new EmpLinkedList();
        if (head == null || size() == 1){
            return;
        }
        Employee cur = head;
        Employee newHead = newEmpLinkedList.head;
        Employee next = null;
        while (cur != null){
            next = cur.getNext();
            cur.setNext(newHead);
            newHead = cur;
            cur = next;
        }
        head = newHead;

    }

    public int size(){
        int length = 0;
        Employee cur = head;
        while (cur != null){
            length ++;
            cur = cur.getNext();
        }
        return length;
    }

}
