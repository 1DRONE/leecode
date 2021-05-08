package so;

import leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author zhangyizhang01
 * @date 2021-05-06
 */
public class Q32_1 {
    public int[] levelOrder(TreeNode root) {
        if (null == root) {
            return new int[0];
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (null != node.left) {
                queue.add(node.left);
            }
            if (null != node.right) {
                queue.add(node.right);
            }
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}
