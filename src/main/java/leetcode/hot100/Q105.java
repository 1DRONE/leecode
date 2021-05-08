package leetcode.hot100; /**
 * @author zhangyizhang01
 * @date 2021-03-02
 */
//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组
// 👍 896 👎 0


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
class Q105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];

        int index = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }

        //不管前序还是中序左子树的长度相同
        int leftSize = index - inStart;
        TreeNode treeNode = new TreeNode(rootVal);
        treeNode.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        treeNode.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);

        return treeNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
