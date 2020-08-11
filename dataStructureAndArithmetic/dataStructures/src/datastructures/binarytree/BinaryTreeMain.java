package datastructures.binarytree;

public class BinaryTreeMain {

    public static void main(String[] args) {

        Node<String> root = new Node<>("A");
        Node<String> nodeB = new Node<>("B");
        Node<String> nodeC = new Node<>("C");
        Node<String> nodeD = new Node<>("D");
        Node<String> nodeE = new Node<>("E");
        Node<String> nodeF = new Node<>("F");

        root.setLeft(nodeB);
        root.setRight(nodeC);

        nodeB.setLeft(nodeD);
        nodeB.setRight(nodeE);

        nodeC.setRight(nodeF);

        BinaryTree tree = new BinaryTree(root);

        /*tree.preThreadNodes();
        tree.preThreadList();*/

        //tree.postThreadNodes();
        //tree.postThreadList();

        /*tree.preThreadNodes();

        System.out.println(nodeD.getLeft());
        System.out.println(nodeD.getRight());

        System.out.println(nodeE.getLeft());
        System.out.println(nodeE.getRight());

        System.out.println(nodeF.getLeft());
        System.out.println(nodeF.getRight());
        System.out.println(nodeF.getRightType());

        System.out.println(nodeC.getLeft());
        System.out.println(nodeC.getRight());*/

        /*tree.preOrder();

        System.out.println();

        tree.infixOrder();

        System.out.println();

        tree.postOrder();*/

        /*Node e = tree.postOrderSearch(new Node("G"));
        if(e != null){
            System.out.println("找到了");
        }else{
            System.out.println("没找到");
        }*/

        /*// 中序线索化二叉树
        tree.infixThreadNodes();

        //中序线索二叉树遍历
        tree.infixThreadList();*/

    }

}
