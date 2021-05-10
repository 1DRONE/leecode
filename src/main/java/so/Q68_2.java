package so;

import leetcode.data.TreeNode;

/**
 * @author drone
 * @date 2021/5/9
 */
public class Q68_2 {
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

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
