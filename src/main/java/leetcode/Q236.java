package leetcode;

import leetcode.data.TreeNode;

/**
 * @author drone
 * @date 2021/5/17
 */
public class Q236 {
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

    /**
     * 表示 x节点的子树中是否包含 p节点或 q节点，如果包含为 true，否则为 false
     */
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);

        if ((lson && rson) || ((root == p || root == q) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root == p || root == q);
    }
}
