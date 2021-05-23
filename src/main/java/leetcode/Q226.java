package leetcode;

/**
 * @author zhangyizhang01
 * @date 2021-02-22
 */
//翻转一棵二叉树。
//
// 示例：
//
// 输入：
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9
//
// 输出：
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1
//
// 备注:
//这个问题是受到 Max Howell 的 原问题 启发的 ：
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
// Related Topics 树
// 👍 762 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import leetcode.data.TreeNode;

import java.util.Stack;

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
class Q226 {
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.pop();
            if (node.left != null) {
                treeNodes.add(node.left);
            }
            if (node.right != null) {
                treeNodes.add(node.right);
            }

            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;


        }

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

