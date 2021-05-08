package leetcode; /**
 * @author zhangyizhang01
 * @date 2021-03-02
 */
//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// Related Topics 树 深度优先搜索 数组
// 👍 448 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import leetcode.data.TreeNode;

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
class Q106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];

        int index = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }

        //不管中序还是后序左子树的长度相同
        int leftSize = index - inStart;
        TreeNode treeNode = new TreeNode(rootVal);
        treeNode.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        treeNode.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        return treeNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

