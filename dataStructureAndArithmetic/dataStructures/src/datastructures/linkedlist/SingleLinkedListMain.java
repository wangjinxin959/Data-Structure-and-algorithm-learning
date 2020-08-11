package datastructures.linkedlist;


import java.util.prefs.NodeChangeEvent;

public class SingleLinkedListMain {

    public static void main(String[] args) {

        SingleLinkedList list = new SingleLinkedList();

        HeroNode node1 = new HeroNode(1,"宋江","及时雨");
        HeroNode node2 = new HeroNode(5,"卢俊义","玉麒麟");
        HeroNode node3 = new HeroNode(8,"吴用","智多星");

        list.addByOrder(node1);
        list.addByOrder(node2);
        list.addByOrder(node3);

        SingleLinkedList list2 = new SingleLinkedList();

        HeroNode node4 = new HeroNode(2,"宋江4","及时雨4");
        HeroNode node5 = new HeroNode(7,"卢俊义5","玉麒麟5");
        HeroNode node6 = new HeroNode(9,"吴用6","智多星6");
        list2.addByOrder(node4);
        list2.addByOrder(node5);
        list2.addByOrder(node6);
        list.list();
        System.out.println(">>>");
        /*SingleLinkedList newList = SingleLinkedList.mergeList(list, list2);
        newList.list();
        System.out.println("List:");
        list.list();
        System.out.println("List2:");
        list2.list();*/
        // list2.list();


        //list.list();

        //list.reverSetPrint();

        /*System.out.println("反转前:");
        list.list();
        list.reversetList();
        System.out.println("反转后：");
        list.list();*/

       /* System.out.println("修改前：");
        list.list();

        list.updateNode(new HeroNode(1,"宋江2","及时雨2"));
        System.out.println("修改后：");
        list.list();*/
        /*System.out.println("删除前：");
        list.list();

        list.deleteNode(1);
        list.deleteNode(2);
        System.out.println("删除后：");
        System.out.println("有效个数:"+list.size());
*/
        /*System.out.println(list.lastIndex(1));
        System.out.println(list.lastIndex(2));
        System.out.println(list.lastIndex(3));
        System.out.println(list.lastIndex(4));
        System.out.println(list.lastIndex(0));*/


    }

}
