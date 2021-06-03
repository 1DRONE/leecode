package leetcode;

import leetcode.data.TreeNode;

/**
 * @author drone
 * @date 2021/6/3
 */
public class Q101 {
    public boolean isSymmetric(TreeNode root) {
        //一个树的左子树与右子树镜像对称，那么这个树是对称的。
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        }

        if (null == p || null == q) {
            return false;
        }
        //它们的两个根结点具有相同的值
        //每个树的右子树都与另一个树的左子树镜像对称
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
