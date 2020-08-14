package datastructures.binarytree.binarysorttree;

import org.junit.Test;

/**
 * 二叉排序树(BST)
 */
public class BinarySortTree {

    private  Node root;

    /**
     * 添加结点
     * @param node
     */
    public void add (Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }

    }

    /**
     * 删除结点
     * @param node
     */
    public void delNode (Node node) {
        if (node == null || root == null) return;
        Node targetNode = root.findNode(node);
        if (targetNode == null) return;
        Node parent = root.findParentNode(node);
        if (targetNode.left == null && targetNode.right == null) { // 删除结点为叶子结点
            if (parent == null) {
                root = null;
            } else {
                //判断此叶子结点是父结点的左子结点还是右子结点
                if (parent.left !=null && parent.left.value == targetNode.value) { //如果为左子结点 父结点左子结点置空
                    parent.left = null;
                } else { //如果为右子结点 父结点右子结点置空
                    parent.right = null;
                }
            }
        } else if (targetNode.left !=null && targetNode.right != null) { //删除结点为非叶子结点 并且有两个子结点
            int minVal = delRightTreeMin(targetNode.right);
            targetNode.value = minVal;

        } else { //删除结点为非叶子结点 只有一个子结点
            if (parent == null) {
                if (targetNode.left == null) {
                    root = targetNode.right;
                } else {
                    root = targetNode.right;
                }
            } else {
                if (targetNode.value < parent.value) { //如果删除的结点小于父结点的值 使父结点的左子结点指向删除结点的子结点
                    if (targetNode.left != null) {
                        parent.left = targetNode.left;
                    } else {
                        parent.left = targetNode.right;
                    }
                } else {                            //如果删除的结点大于等于父结点的值 使父结点的右子结点指向删除结点的子结点
                    if (targetNode.left != null) {
                        parent.right = targetNode.left;
                    } else {
                        parent.right = targetNode.right;
                    }
                }
            }

        }

    }

    private int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        delNode(target);
        return target.value;
    }

    public void infixOrder () {
        if (root == null)  return ;
        root.infixOrder();
    }

    @Test
    public void test () {
        int[] arr = {7,3,10,12,5,1,9,2};
        BinarySortTree bst = new BinarySortTree();
        for (int i : arr) {
            bst.add(new Node(i));
        }
        //bst.infixOrder();
        bst.delNode(new Node(2));
        bst.delNode(new Node(1));
        bst.delNode(new Node(7));
        bst.delNode(new Node(10));
        bst.infixOrder();
    }

}

class Node {
    int value;
    Node left;
    Node right;

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
