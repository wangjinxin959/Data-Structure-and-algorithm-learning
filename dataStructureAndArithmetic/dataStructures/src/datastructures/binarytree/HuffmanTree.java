package datastructures.binarytree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 哈夫曼树
 */
public class HuffmanTree<T> {


    @Test
    public void test() {

        int[] arr = {8,5,7,4,6};

        Node<Integer> node = createHuffmanTree(arr);
        node.preOrder();

    }

    //创建哈夫曼树
    public Node<Integer> createHuffmanTree (int[] arr) {
        List<Node<Integer>> nodes = new ArrayList<>();
        for (int t : arr) {
            nodes.add(new Node(t));
        }

        while (nodes.size() > 1) {
            Collections.sort(nodes);

            Node<Integer> leftNode = nodes.get(0);

            Node<Integer> rightNode = nodes.get(1);

            Node parent = new Node(leftNode.getEle() + rightNode.getEle());
            parent.setLeft(leftNode);
            parent.setRight(rightNode);

            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parent);
        }
        return nodes.get(0);
    }


}



