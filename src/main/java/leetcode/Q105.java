package leetcode; /**
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

import java.util.HashMap;
import java.util.Map;

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
    private Map<Integer,Integer> indexMap=new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder,int preLeft,int preRight,int inLeft,int inRight) {
        if(preRight<preLeft){
            return null;
        }

        //前序遍历中的第一个节点是根节点
        int preRoot=preLeft;
        //在map中定位中序根节点
        int inRoot=indexMap.get(preorder[preRoot]);

        //建立根节点
        TreeNode root=new TreeNode(preorder[preRoot]);

        //从中序遍历中获取左子树的节点数
        int leftSubTreeSize=inRoot-inLeft;
        //递归构造左子树
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left=myBuildTree(preorder, inorder, preLeft+1, preLeft+leftSubTreeSize, inLeft, inRoot-1);
        //从中序遍历中获取右子树的节点数
        int rightSubTreeSize=inRight-inRoot;
        // 递归地构造右子树
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right=myBuildTree(preorder, inorder,  preRight-rightSubTreeSize+1,preRight, inRoot+1, inRight);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
