package leetcode.data;

/**
 * @author zhangyizhang01
 * @date 2021-03-01
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int val) {
        val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        val = val;
        left = left;
        right = right;
        next = next;
    }
};
