package datastructures.binarytree;


/**
 * 顺序存储二叉树
 * 特点:
 * 1.第n个元素的左子节点的索引为 2 * n + 1
 * 2.第n个元素的又子节点的索引为 2 * n + 2
 * 3.第n个元素的父节点索引为 (n-1)/2
 */
public class ArrayBinaryTree {

    private int[] arr;

    public ArrayBinaryTree (int[] arr) {
        this.arr = arr;
    }

    /**
     * 顺序存储二叉树前序遍历
     * @param index
     */
    public void preOrder (int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，无法遍历");
            return;
        }

        System.out.println(arr[index]);

        if((2 * index + 1) < arr.length){
            preOrder(2 * index + 1);
        }

        if((2 * index + 2) < arr.length){
            preOrder(2 * index + 2);
        }

    }

    public void preOrder () {
        preOrder(0);
    }

    /**
     * 顺序二叉树中序遍历
     * @param index
     */
    public void infixOrder (int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，无法遍历");
            return;
        }

        if ((2 * index + 1) < arr.length){
            infixOrder(2 * index + 1);
        }

        System.out.println(arr[index]);

        if ((2 * index + 2) < arr.length){
            infixOrder(2 * index + 2);
        }
    }

    public void infixOrder () {
        infixOrder(0);
    }

    /**
     * 顺序二叉树后序遍历
     * @param index
     */
    public void postOrder (int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，无法遍历");
            return;
        }

        if ((2 * index + 1) < arr.length) {
            postOrder(2 * index +1);
        }

        if ((2 * index) + 2 < arr.length)  {
            postOrder(2 * index + 2);
        }

        System.out.println(arr[index]);
    }

    public void postOrder () {
        postOrder(0);
    }

}
