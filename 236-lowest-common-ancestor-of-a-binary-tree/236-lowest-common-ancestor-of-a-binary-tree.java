/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode L,R;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        L=p;
        R=q;
        return getLCA(root);
    }
    public TreeNode getLCA(TreeNode curr){
        if(curr==null)
            return null;
        if(curr==L || curr==R)
            return curr;
        
        TreeNode le,ri;

        le=getLCA(curr.left);
        ri=getLCA(curr.right);
       
        if(le!=null && ri!=null)
            return curr;
        
        return le==null?ri:le;
    }
}