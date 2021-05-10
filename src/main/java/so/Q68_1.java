package so;

import leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author drone
 * @date 2021/5/10
 */
public class Q68_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP=getPath(root, p);
        List<TreeNode> pathQ=getPath(root, q);

        TreeNode ancestor=null;
        for(int i=0;i<Math.min(pathP.size(),pathQ.size());i++){
            if(pathP.get(i)==pathQ.get(i)){
                ancestor=pathP.get(i);
            }
        }
        return ancestor;
    }

    private List<TreeNode> getPath(TreeNode root,TreeNode target){
        List<TreeNode> pathList=new ArrayList<>();
        TreeNode node=root;
        while(node != target){
            pathList.add(node);
            if(node.val>target.val){
                node=node.left;
            }else{
                node=node.right;
            }
        }
        pathList.add(node);
        return pathList;
    }
}
