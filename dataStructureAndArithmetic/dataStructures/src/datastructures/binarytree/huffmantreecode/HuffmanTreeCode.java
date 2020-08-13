package datastructures.binarytree.huffmantreecode;


import org.junit.Test;

import java.util.*;

/**
 * 哈夫曼编码
 */
public class HuffmanTreeCode {


    Map<Byte,String> huffmanCode = new HashMap<>();
    StringBuilder stringBuilder = new StringBuilder();

    @Test
    public void test () {
        String str = "I must must must hard to lear";
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes)); //[73, 32, 109, 109, 117, 117, 117, 32, 109, 117]
        byte[] bytes1 = huffmanZip(bytes);
        System.out.println(Arrays.toString(bytes1)); //[-34, -121, 4]
        System.out.println(huffmanCode);
        byte[] bytes2 = huffmanDecode(bytes1, huffmanCode);
        System.out.println(new String(bytes2));
        //101101111 10100100 00101111 10100100 00101111 10100100 00101111 01010110 10001001 01110101 10011111 10001001 10110100 00111101 11011110 100
        //101101111 10100100 00101111 10100100 00101111 10100100 00101111 01010110 10001001 01110101 10011111 10001001 10110100 00111101 11011111 00
    }

    public byte[] huffmanDecode (byte[] huffmanCodeByte,Map<Byte,String> huffmanCode) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanCodeByte.length; i++) {
            byte b = huffmanCodeByte[i];
            boolean flag = (i == huffmanCodeByte.length -1);
            stringBuilder.append(byteToBitString(b,!flag));
        }
        System.out.println("stringBuilder!!!" + stringBuilder);
        Map<String,Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCode.entrySet()) {
            map.put(entry.getValue(),entry.getKey());
        }
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length();) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {
                String key = stringBuilder.substring(i,i+count);
                b = map.get(key);
                if (b == null) {
                    count ++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    //将一个byte转换为一个二进制字符串
    public String byteToBitString (byte b,boolean flag) {
        int temp = b;
        if (flag) {
            temp |= 256;  //按位与 256 1 0000 0000    |  0000 0001 ==》1 0000 0001
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    /**
     *
     * @param bytes 原始字节数组
     * @return       哈夫曼编码处理后的字节数组
     */
    public byte[] huffmanZip(byte[] bytes){

        List<Node> nodes = getNodes(bytes);
        //根据nodes创建哈夫曼树
        Node huffmanTreeRoot = createHuffmanTree(nodes);
        //根据哈夫曼树创建哈夫曼编码
        Map<Byte,String> huffmanCode = getCode(huffmanTreeRoot);
        //根据哈夫曼编码得到压缩后的哈夫曼编码字节数组  [73, 32, 109, 109, 117, 117, 117, 32, 109, 117]
        byte[] huffmanCodeByte = zip(bytes,huffmanCode);
        return huffmanCodeByte;

    }

    public byte[] zip(byte[] bytes, Map<Byte, String> huffmanCode) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte aByte : bytes) {
            stringBuilder.append(huffmanCode.get(aByte));
        }
        System.out.println("stringBuilder~~" + stringBuilder);
        int len = (stringBuilder.length() + 7) /8;
        byte[] huffmanCodeByte = new byte[len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i+=8) {
            String strByte = "";
            if (i + 8 > stringBuilder.length()) {
               strByte =  stringBuilder.substring(i);
            } else {
                strByte = stringBuilder.substring(i,i+8);
            }
            huffmanCodeByte[index] = (byte) Integer.parseInt(strByte,2);
            index ++;
        }
        return huffmanCodeByte;
    }

    private Map<Byte, String> getCode(Node huffmanTreeRoot) {
        if (huffmanTreeRoot == null) {
            return null;
        } else {
            getCode(huffmanTreeRoot.left,"0",stringBuilder);

            getCode(huffmanTreeRoot.right,"1",stringBuilder);
        }
        return huffmanCode;
    }

    private void getCode(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node != null) {
            if (node.date == null) {
              getCode(node.left,"0",stringBuilder2);
              getCode(node.right,"1",stringBuilder2);
            } else {
                huffmanCode.put(node.date,stringBuilder2.toString());
            }
        }

    }

    private Node createHuffmanTree(List<Node> nodes) {

        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null,leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    public List<Node> getNodes (byte[] bytes) {
        Map<Byte,Integer> map = new HashMap<>();
        List<Node> nodes  = new ArrayList<>();
        for (byte aByte : bytes) {
            Integer count = map.get(aByte);
            if (count == null) {
                map.put(aByte,1);
            }else {
                map.put(aByte,++count);
            }
        }

        for (Byte aByte : map.keySet()) {
            Node node = new Node(aByte, map.get(aByte));
            nodes.add(node);
        }
        return nodes;
    }


}

class Node implements Comparable<Node>{
    Byte date;
    Integer weight;//权值
    Node left;
    Node right;

    public Node(Byte date, Integer weight) {
        this.date = date;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "date=" + date +
                ", weight=" + weight +
                '}';
    }

    public void preOrder () {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }

    }
}
