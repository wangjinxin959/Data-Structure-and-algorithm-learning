package datastructures.binarytree.avltree;

import org.junit.Test;

/**
 * 平衡二叉树 (AVL树)
 */
public class AVLTree {

    private Node root;

    public void add (Node node) {
        if (node == null) return;
        if (root == null)
            root = node;
        else
            root.add(node);
    }

    public int treeHeight () {
        if (root == null) return 0;
        return root.treeHeight();
    }

    @Test
    public void test () {
        int[] arr = {7,3,10,12,5,1,9,2};
        AVLTree avlTree = new AVLTree();
        for (int i : arr) {
            avlTree.add(new Node(i));
        }
        //bst.infixOrder();
        System.out.println(avlTree.treeHeight());
    }
}


class Node {
    int value;
    Node left;
    Node right;

    public void rightRotate () {
        Node newNode = new Node(value); //创建新的结点 值为当前结点的值
        newNode.right = right;//新结点右子结点设置为当前结点的右子结点
        newNode.left = left.right;//新结点的左子结点设置为当前欠点左子结点的右子结点
        value = left.value;//把当前结点的值设置为左结点的值
        left = left.left;//把当前结点的左子结点设置为当前结点左子结点的左子结点
        right = newNode;//当前结点的右子结点设置为新结点
    }

    public void leftRotate () {
        Node newNode = new Node(value); //创建新的结点 值为当前结点的值
        newNode.left = left;//新结点的左子结点指向当前结点的左子结点
        newNode.right = right.left; //新结点的右子结点指向当前结点右子结点的左子结点
        value = right.value;//把当前结点的值设置为右结点的值
        right = right.right;//把当前结点的右子结设置为当前结点的右子结点的右子结点
        left = newNode; //把当前结点的左子结点设置为新结点
    }

    public int rightHeight () {
        if (right == null) return 0;
        return right.treeHeight();
    }

    //左子树高度
    public int leftHeight () {
        if (left == null) return 0;
        return left.treeHeight();
    }

    public int treeHeight () {
        return Math.max(left == null?0:left.treeHeight(),right == null?0:right.treeHeight()) + 1;
    }

    public void add (Node node) {
        if (node == null) return ;
        if (node.value < this.value) {
            if (this.left == null)
                this.left = node;
            else
                this.left.add(node);

        } else {
            if (this.right == null)
                this.right = node;
            else
                this.right.add(node);

        }

        if ((rightHeight() - leftHeight()) > 1) { //如果右子树高度 - 左子树高度 > 1 左旋转
            // 如果右子树的左子树高度大于右子树右子树的高度 先对右子树进行右旋转
            if (right != null && right.leftHeight() > right.rightHeight()) {
                right.rightRotate();
                leftRotate();
            }

            leftRotate();
            return;
        }

        if ((leftHeight() - rightHeight()) > 1) { //如果左子树高度 - 右子树高度 > 1 右旋转
            //如果左子树的右子树高度大于左子树的左子树高度 选对左子树进行左旋转
            if (left != null && left.rightHeight() > left.leftHeight()) {
                left.leftRotate();
                rightRotate();
            }
            rightRotate();
        }
    }

    public void infixOrder () {
        if (this.left != null) this.left.infixOrder();
        System.out.println(this);
        if (this.right != null) this.right.infixOrder();
    }


    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public Node findNode(Node node) {
        if (node.value < this.value) {
            if (this.left == null) {
                return null;
            }
            return  this.left.findNode(node);
        }
        else if (node.value > this.value) {
            if (this.right == null ) {
                return null;
            }
            return this.right.findNode(node);
        }else {
            return this;
        }
    }

    public Node findParentNode(Node node) {
        if ((this.left != null && this.left.value == node.value) || (this.right != null && this.right.value == node.value)) {
            return this;
        } else {
            if (node.value < this.value) {
                if (this.left == null) {
                    return null;
                }
                return this.left.findParentNode(node);
            } else {
                if (this.right == null) {
                    return null;
                }
                return this.right.findParentNode(node);
            }
        }
    }
}

