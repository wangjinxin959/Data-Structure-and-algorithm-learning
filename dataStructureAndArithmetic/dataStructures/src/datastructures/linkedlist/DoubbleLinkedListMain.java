package datastructures.linkedlist;

public class DoubbleLinkedListMain {

    public static void main(String[] args) {

        DoubbleLinkedList list = new DoubbleLinkedList();

        list.addByOrder(new PeopleNode(4,"小王"));
        list.addByOrder(new PeopleNode(3,"小张"));
        list.addByOrder(new PeopleNode(6,"小欧"));
        list.addByOrder(new PeopleNode(5,"小佟"));

        list.list();
        /*System.out.println("删除前双向链表：");
        list.list();
        list.deleteNode(6);
        System.out.println("删除后双向链表：");
        list.list();*/
        /*System.out.println("修改前双向链表：");
        list.list();
        list.updateNode(new PeopleNode(3,"xiaoxiao"));
        System.out.println("修改后双向链表：");
        list.list();*/
    }

}
