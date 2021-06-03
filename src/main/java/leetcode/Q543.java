package leetcode;

import leetcode.data.TreeNode;

/**
 * @author drone
 * @date 2021/6/4
 */
public class Q543 {
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    private int depth(TreeNode node) {
        if (null == node) {
            return 0;
        }
        //左子节点为根的子树的深度
        int left = depth(node.left);
        int right = depth(node.right);

        ans = Math.max(ans, left + right + 1);
        //返回该节点为根的子树的深度
        return Math.max(left, right) + 1;
    }
}
