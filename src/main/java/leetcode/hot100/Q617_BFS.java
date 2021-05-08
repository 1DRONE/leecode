package leetcode.hot100;

/**
 * 深度优先搜索 递归
 *
 * @author zhangyizhang01
 * @date 2021-02-28
 */
//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。
//
// 示例 1:
//
//
//输入:
//	Tree 1                     Tree 2
//          1                         2
//         / \                       / \
//        3   2                     1   3
//       /                           \   \
//      5                             4   7
//输出:
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \
//	 5   4   7
//
//
// 注意: 合并必须从两个树的根节点开始。
// Related Topics 树
// 👍 626 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import leetcode.data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Q617_BFS {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        if (null == root1) {
            return root2;
        }
        if (null == root2) {
            return root1;
        }

        TreeNode root = new TreeNode(root1.val + root2.val);
        queue.offer(root);
        queue1.offer(root1);
        queue2.offer(root2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            TreeNode left1 = node1.left;
            TreeNode left2 = node2.left;
            if (null != left1 && null != left2) {
                TreeNode newLeft = new TreeNode(left1.val + left2.val);

                queue.offer(newLeft);
                queue1.offer(left1);
                queue2.offer(left2);

                node.left = newLeft;
            } else if (null == left1) {
                node.left = left2;
            } else {
                node.left = left1;
            }

            TreeNode right1 = node1.right;
            TreeNode right2 = node2.right;
            if (null != right1 && null != right2) {
                TreeNode newRight = new TreeNode(right1.val + right2.val);

                queue.offer(newRight);
                queue1.offer(right1);
                queue2.offer(right2);

                node.right = newRight;
            } else if (null == right1) {
                node.right = right2;
            } else {
                node.right = right1;
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

