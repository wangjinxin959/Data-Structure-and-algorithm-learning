package datastructures.binarytree;

import java.util.Comparator;

public class BinaryTree {

    private Node root;

    private Node pre;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void preOrder() {
        if (root != null) {
            root.preOrder();
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        }
    }

    public void postOrder() {
        if (root != null) {
            root.postOrder();
        }
    }

    public Node preOrderSearch(Node node) {
        if (root != null) {
            return root.preOrderSearch(node);
        }
        return null;
    }

    public Node infixOrderSearch(Node node) {
        if (root != null) {
            return root.infixOrderSearch(node);
        }
        return null;
    }

    public Node postOrderSearch(Node node) {
        if (root != null) {
            return root.postOrderSearch(node);
        }
        return null;
    }

    //中序线索化二叉树
    private void infixThreadNodes(Node node) {
        if (node == null) {
            return;
        }
        //先线索化左子树
        infixThreadNodes(node.getLeft());
        //线索化
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }

        pre = node;
        //线索化右子树
        infixThreadNodes(node.getRight());
    }

    public void infixThreadNodes() {
        infixThreadNodes(root);
    }

    private void infixThreadList(Node node) {
        while (node != null) {

            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }

            System.out.println(node);

            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }

            node = node.getRight();

        }
    }

    public void infixThreadList() {
        infixThreadList(root);
    }

    //前序线索化二叉树
    private void preThreadNodes (Node node) {

        if (node == null) {
            return;
        }

        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null) {
           pre.setRight(node);
           pre.setRightType(1);
        }

        pre = node;

        //线索化左子树
        if (node.getLeftType() == 0) {
            preThreadNodes(node.getLeft());
        }
        //线索化右子树
            preThreadNodes(node.getRight());
    }

    public void preThreadNodes () {
        preThreadNodes(root);
    }

    //后序线索化二叉树
    private void postThreadNodes(Node node) {
        if (node == null) {
            return;
        }

        postThreadNodes(node.getLeft());

        postThreadNodes(node.getRight());

        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }

        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }

        pre = node;

    }

    public void postThreadNodes () {
        postThreadNodes(root);
    }

    //遍历后序线索化二叉树
    private void postThreadList (Node node) {
        //1、找后序遍历方式开始的节点
        while(node != null && node.getLeftType() == 0) {
            node = node.getLeft();
        }

        Node preNode = null;
        while(node != null) {
            //右节点是线索
            if(node.getRightType() == 0) {
                System.out.println(node);
                preNode = node;
                node = node.getRight();

            } else {
                //如果上个处理的节点是当前节点的右节点
                if(node.getRight() == preNode) {
                    System.out.println(node);
                    if(node == root) {
                        return;
                    }

                    preNode = node;
                    node = node.getParent();

                } else {    //如果从左节点的进入则找到有子树的最左节点
                    node = node.getRight();
                    while(node != null && node.getLeftType() == 0) {
                        node = node.getLeft();
                    }
                }
            }
        }
    }

    public void postThreadList () {
        postThreadList(root);
    }

    //前序遍历线索化二叉树
    private void preThreadList (Node node) {
        while(node != null) {

            while(node.getLeftType() == 0) {
                System.out.println(node);
                node = node.getLeft();
            }

            System.out.println(node);
            node = node.getRight();
        }

    }

    public void preThreadList () {
        preThreadList(root);
    }

}


class Node<T> implements Comparable<Node> {

    private T ele;
    private Node<T> left;
    private Node<T> right;
    private int leftType = 0; //0指向左节点 1代表指向前驱节点
    private int rightType = 0;//0代表指向又节点 1代表指向后继节点
    private Node<T> parent;

    public Node(T ele) {
        this.ele = ele;
    }

    public void preOrder() {
        System.out.print(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.print(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }

        System.out.print(this);
    }

    public Node preOrderSearch(Node node) {
        System.out.println("进入前序遍历查找~");
        if (this.ele.equals(node.ele)) {
            return this;
        }
        Node resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(node);
        }

        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.preOrderSearch(node);
        }

        return resNode;

    }


    public Node infixOrderSearch(Node node) {
        Node resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(node);
        }

        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入中序遍历查找~~");
        if (this.ele.equals(node.ele)) {
            return this;
        }

        if (this.right != null) {
            resNode = this.right.infixOrderSearch(node);
        }

        return resNode;
    }

    public Node postOrderSearch(Node node) {
        Node resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(node);
        }

        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.postOrderSearch(node);
        }

        if (resNode != null) {
            return resNode;
        }
        System.out.println("进入后序遍历查找~~");
        if (this.ele.equals(node.ele)) {
            return this;
        }
        return resNode;
    }

    public T getEle() {
        return ele;
    }

    public void setEle(T ele) {
        this.ele = ele;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Node[" +
                "ele=" + ele +
                ']' + " ";
    }

    @Override
    public int compareTo(Node o) {
        return (Integer)this.ele-(Integer)o.ele;
    }
}
