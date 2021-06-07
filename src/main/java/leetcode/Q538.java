package leetcode;

import leetcode.data.TreeNode;

/**
 * @author drone
 * @date 2021/6/8
 */
public class Q538 {
    //逆中序遍历
    public TreeNode convertBST(TreeNode root) {
        dfs(root,0);
        return root;
    }

    public int dfs(TreeNode root,int sumRecord) {
        if(null == root){
            return sumRecord;
        }
        root.val += dfs(root.right,sumRecord);
        return dfs(root.left,root.val);
    }
}
